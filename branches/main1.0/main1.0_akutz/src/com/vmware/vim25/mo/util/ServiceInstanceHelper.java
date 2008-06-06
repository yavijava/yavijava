/*================================================================================
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, 
this list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice, 
this list of conditions and the following disclaimer in the documentation 
and/or other materials provided with the distribution.

* Neither the name of VMware, Inc. nor the names of its contributors may be used
to endorse or promote products derived from this software without specific prior 
written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL VMWARE, INC. OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.
================================================================================*/

package com.vmware.vim25.mo.util;

import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.util.CommandLineParser.PasswordMask;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import com.vmware.vim25.*;
import org.apache.commons.cli.*;
import java.io.*;

/**
 * This class is used to create a session to and interact with a VI server.
 * 
 * @author Schley Andrew Kutz &lt;sakutz@gmail.com&gt;
 */
public class ServiceInstanceHelper
{

	// <region> Enums

	/**
	 * The format in which to save the session cookie.
	 * 
	 * @author Schley Andrew Kutz &lt;sakutz@gmail.com&gt;
	 */
	public enum SaveSessionCookieFormat
	{
		/**
		 * The resulting cookie file is the same as the cookie format Axis uses.
		 */
		AXIS,
		
		/**
		 * The resulting cookie file is the same as the one VI Perl creates.
		 */
		PERL,

		/**
		 * The resulting cookie file contains only the session token value.
		 */
		COOKIE_VALUE_ONLY,
	};

	/**
	 * The different types of VI entities.
	 * 
	 * @author Schley Andrew Kutz &lt;sakutz@gmail.com&gt;
	 */
	public enum EntityTypes
	{
		/**
		 * ComputeResource
		 */
		ComputeResource,

		/**
		 * ClusterComputeResource
		 */
		ClusterComputeResource,

		/**
		 * Datacenter
		 */
		Datacenter,

		/**
		 * Folder
		 */
		Folder,

		/**
		 * HostSystem
		 */
		HostSystem,

		/**
		 * ResourcePool
		 */
		ResourcePool,

		/**
		 * VirtualMachine
		 */
		VirtualMachine,
	};

	// </editor-fold>

	// </region>

	// <region> Semi-Constants

	// <editor-fold defaultstate="collapsed" desc="Semi-Constants">

	// If there are environment variables for options then
	// set the default values of those options to the value
	// of the environment variables.
	private String VI_PASSTHROUGHPACKAGE =
		System.getenv( "VI_PASSHTHROUGHPACKAGE" );
	private String VI_PASSWORD = System.getenv( "VI_PASSWORD" );
	private String VI_PORTNUMBER = System.getenv( "VI_PORTNUMBER" );
	private String VI_PROTOCOL = System.getenv( "VI_PROTOCOL" );
	private String VI_SAVESESSIONFILE = System.getenv( "VI_SAVESESSIONFILE" );
	private String VI_SERVER = System.getenv( "VI_SERVER" );
	private String VI_SERVICEPATH = System.getenv( "VI_SERVICEPATH" );
	private String VI_SESSIONFILE = System.getenv( "VI_SESSIONFILE" );
	private String VI_URL = System.getenv( "VI_URL" );
	private String VI_USERNAME = System.getenv( "VI_USERNAME" );

	// </editor-fold>

	// </region>

	// <region> Fields

	// <editor-fold defaultstate="collapsed" desc="Fields">

	/**
	 * The string to print out before the generated usage text.
	 */
	private String m_help_prefix = "Placeholder";

	/**
	 * The options for the program.
	 */
	private Options m_options = null;

	/**
	 * Command-line arguments.
	 */
	private String[] m_args = null;

	/**
	 * The parsed command line.
	 */
	private CommandLine m_cmdline = null;

	/**
	 * True if there is an open connection to the VI server; otherwise false.
	 */
	private boolean m_is_connected = false;

	/**
	 * The ServiceInstance class that holds a connection to the server.
	 */
	private ServiceInstance m_si = null;

	// </editor-fold>

	// </region>

	// <region> Properties

	// <editor-fold defaultstate="collapsed" desc="Properties">

	/**
	 * Gets the string to print out before the generated usage text.
	 * 
	 * @return The string to print out before the generated usage text.
	 */
	public String getHelpPrefix()
	{
		return (m_help_prefix);
	}

	/**
	 * Sets the string to print out before the generated usage text.
	 * 
	 * @param value The string to print out before the generated usage text.
	 */
	public void setHelpPrefix( String value )
	{
		m_help_prefix = value;
	}

	/**
	 * True if there is an open connection to the VI server; otherwise false.
	 * 
	 * @return The connection status.
	 */
	public boolean getIsConnected()
	{
		return (m_is_connected);
	}

	/**
	 * Returns the URL used to connect to the VI server.
	 * 
	 * @return The URL used to connect to the VI server.
	 */
	public String getVIUrl()
	{
		String url =
			hasOption( "url" ) ? getOptionValue( "url" ) : String.format(
				"%1$s://%2$s:%3$s%4$s", getOptionValue( "protocol" ),
				getOptionValue( "server" ), hasOption( "port" )
					? getOptionValue( "port" ) : getOptionValue( "protocol" )
						.equals( "http" ) ? "80" : "443", getOptionValue(
					"servicepath" ).startsWith( "/" )
					? getOptionValue( "servicepath" ) : "/"
						+ getOptionValue( "servicepath" ) );
		return (url);
	}
	
	/**
	 * Returns a this factory's service instance.
	 * @return This factory's service instance.
	 */
	public ServiceInstance getServiceInstance()
	{
		return (m_si);	
	}

	// </editor-fold>

	// </region>

	// <region> Constructors

	// <editor-fold defaultstate="collapsed" desc="Constructors">

	/**
	 * create a new ServiceInstanceHelperTest object.
	 * 
	 * @param args Command line arguments to pass to this ServiceInstanceHelperTest 
	 * object.
	 */
	public ServiceInstanceHelper( String[] args )
	{
		m_args = args;

		// Initialize the default options
		initDefaultOptions();
	}

	// </editor-fold>

	// </region>

	// <region> Methods

	// <editor-fold defaultstate="collapsed" desc="Methods">

	/**
	 * Initialize the default options.
	 */
	private void initDefaultOptions()
	{
		// create an options object.
		m_options = new Options();

		// Add a new option.
		m_options.addOption( OptionBuilder.withLongOpt( "help" )
			.withDescription( "Display usage information for the program " )
			.create() );

		m_options.addOption( OptionBuilder.withLongOpt( "ignoresslerrors" )
			.withDescription(
				"Ignore certificate mismatch errors "
					+ "(variable VI_IGNORESSLERRORS)" ).create() );

		/*
		 * TODO: Get passthrough authentication working.
		 * 
		 * m_options.addOption( OptionBuilder .withLongOpt( "passthroughauth" )
		 * .withDescription( "Attempt to use pass-through authentication" )
		 * .create() );
		 * 
		 * m_options.addOption( OptionBuilder .withLongOpt(
		 * "passthroughauthpackage" ) .hasArg() .withDescription( "Pass-through
		 * authentication negotiation package" ) .create() );
		 */

		m_options.addOption( OptionBuilder
			.withLongOpt( "password" )
			.hasArg()
			.withDescription( "Password (variable VI_PASSWORD)" )
			.create() );

		m_options.addOption( OptionBuilder
			.withLongOpt( "portnumber" )
			.hasArg()
			.withDescription(
				"Port used to connect to server (variable VI_PORTNUMBER)" )
			.create() );

		m_options.addOption( OptionBuilder
			.withLongOpt( "protocol" )
			.hasArg()
			.withDescription(
				"Protocol used to connect to server "
				+ "(variable VI_PROTOCOL, default 'https')" )
			.create() );

		m_options.addOption( OptionBuilder
			.withLongOpt( "server" )
			.hasArg()
			.withDescription(
				"VI server to connect to. Required if url is not present "
				+ "(variable, VI_SERVER, default 'localhost')" )
			.create() );

		m_options.addOption( OptionBuilder
			.withLongOpt( "savesessionfile" )
			.hasArg()
			.withDescription(
				"File to save session ID/cookie to utilize "
				+ "(variable, VI_SAVESESSIONFILE)" )
			.withType( java.io.File.class )
			.create() );

		m_options.addOption( OptionBuilder
			.withLongOpt( "servicepath" )
			.hasArg()
			.withDescription(
				"Service path used to connect to server "
				+ "(variable, VI_SERVICEPATH, default '/sdk/webService')" )
			.create() );

		m_options.addOption( OptionBuilder
			.withLongOpt( "sessionfile" )
			.hasArg()
			.withDescription(
				"File containg session ID/cookie to utilize "
					+ "(variable, VI_SESSIONFILE)" )
			.withType( java.io.File.class )
			.create() );

		m_options.addOption( OptionBuilder
			.withLongOpt( "url" )
			.hasArg()
			.withDescription(
				"VI SDK URL to connect to. Required if server is not "
				+ "present (variable, VI_URL)" )
			.withType( java.net.URI.class )
			.create() );

		m_options.addOption( OptionBuilder
			.withLongOpt( "username" )
			.hasArg()
			.withDescription( "Username (variable, VI_USERNAME)" )
			.create() );

		m_options.addOption( OptionBuilder
			.withLongOpt( "verbose" )
			.withDescription(
				"Display additional debugging information "
				+ "(variable, VI_VERBOSE)" )
			.create() );

		m_options.addOption( OptionBuilder
			.withLongOpt( "version" )
			.withDescription( "Display version information for the script" )
			.create() );
	}

	/**
	 * Validate the options and the given command line arguments.
	 * 
	 * @throws ParseException If there is an error parsing the given arguments.
	 */
	public void validateOptions() throws ParseException
	{
		org.apache.commons.cli.CommandLineParser parser = new PosixParser();

		m_cmdline = parser.parse( m_options, m_args );

		// If anywhere there is a help flag then show help
		// and exit the app.
		if ( m_cmdline.hasOption( "help" ) )
		{
			printUsage();
			System.exit( 0 );
		}

		// Get the username and password by prompting the user
		// if they were not specified in an argument or via
		// environment variables.
		if ( !hasOption( "sessionfile" )
			&& getOptionValue( "username" ) == null )
		{
			VI_USERNAME = this.getOnelineInput( "Username: " );
		}
		if ( !hasOption( "sessionfile" )
			&& getOptionValue( "password" ) == null )
		{
			VI_PASSWORD = this.readPassword( "Password: " );
		}
	}

	/**
	 * Print the help/usage statement.
	 * 
	 * @param prefix The text to print out before the generated usage prompt.
	 */
	public void printUsage( String prefix )
	{
		HelpFormatter hf = new HelpFormatter();
		hf.printHelp( prefix, m_options );
	}

	/**
	 * Print the help/usage statement.
	 */
	public void printUsage()
	{
		printUsage( m_help_prefix );
	}

	/**
	 * Add user-defined options.
	 * 
	 * @param options The options to add.
	 */
	@SuppressWarnings( "unchecked" )
	public void addOptions( Options options )
	{
		for ( Iterator<Option> i = options.getOptions().iterator(); 
			i.hasNext(); )
		{
			m_options.addOption( i.next() );

		}
	}

	/**
	 * Returns an options value. If the option was not set, but there is an
	 * environment variable set for it, it will return the value of the
	 * environment variable.
	 * 
	 * @param optionName The name of the option which to get the value for.
	 * @return The value of the option. A null value is returned if the option
	 *         is not found.
	 */
	public String getOptionValue( String optionName )
	{
		String value = null;
		if ( optionName.equals( "passthroughauthpackage" ) )
		{
			if ( m_cmdline.hasOption( "passthroughpackage" ) )
				value = m_cmdline.getOptionValue( "passthroughpackage" );
			else if ( VI_PASSTHROUGHPACKAGE == null )
				value = "Negotiate";
			else value = VI_PASSTHROUGHPACKAGE;
		}
		else if ( optionName.equals( "password" ) )
		{
			if ( m_cmdline.hasOption( "password" ) )
				value = m_cmdline.getOptionValue( "password" );
			else value = VI_PASSWORD;
		}
		else if ( optionName.equals( "portnumber" ) )
		{
			if ( m_cmdline.hasOption( "portnumber" ) )
				value = m_cmdline.getOptionValue( "portnumber" );
			else value = VI_PORTNUMBER;
		}
		else if ( optionName.equals( "protocol" ) )
		{
			if ( m_cmdline.hasOption( "protocol" ) )
				value = m_cmdline.getOptionValue( "protocol" );
			else if ( VI_PROTOCOL == null )
				value = "https";
			else value = VI_PROTOCOL;
		}
		else if ( optionName.equals( "savesessionfile" ) )
		{
			if ( m_cmdline.hasOption( "savesessionfile" ) )
				value = m_cmdline.getOptionValue( "savesessionfile" );
			else value = VI_SAVESESSIONFILE;
		}
		else if ( optionName.equals( "server" ) )
		{
			if ( m_cmdline.hasOption( "server" ) )
				value = m_cmdline.getOptionValue( "server" );
			else if ( VI_SERVER == null )
				value = "localhost";
			else value = VI_SERVER;
		}
		else if ( optionName.equals( "servicepath" ) )
		{
			if ( m_cmdline.hasOption( "servicepath" ) )
				value = m_cmdline.getOptionValue( "servicepath" );
			else if ( VI_SERVICEPATH == null )
				value = "/sdk/webService";
			else value = VI_SERVICEPATH;
		}
		else if ( optionName.equals( "sessionfile" ) )
		{
			if ( m_cmdline.hasOption( "sessionfile" ) )
				value = m_cmdline.getOptionValue( "sessionfile" );
			else value = VI_SESSIONFILE;
		}
		else if ( optionName.equals( "url" ) )
		{
			if ( m_cmdline.hasOption( "url" ) )
				value = m_cmdline.getOptionValue( "url" );
			else value = VI_URL;
		}
		else if ( optionName.equals( "username" ) )
		{
			if ( m_cmdline.hasOption( "username" ) )
				value = m_cmdline.getOptionValue( "username" );
			else value = VI_USERNAME;
		}

		return (value);
	}

	/**
	 * Determines if an option was present on the command line.
	 * 
	 * @param optionName The name of the option.
	 * @return True if the option was present; otherwise false.
	 */
	public boolean hasOption( String optionName )
	{
		assert optionName != null;

		boolean value = false;

		if ( optionName.equals( "ignoresslerrors" ) )
		{
			if ( m_cmdline.hasOption( "ignoresslerrors" ) )
				value = true;
			else if ( System.getenv( "VI_IGNORESSLERRORS" ) != null )
				value = true;
		}
		else if ( optionName.equals( "passthroughauth" ) )
		{
			if ( m_cmdline.hasOption( "passthroughauth" ) )
				value = true;
			else if ( System.getenv( "VI_PASSTHROUGH" ) != null ) value = true;
		}
		else if ( optionName.equals( "verbose" ) )
		{
			if ( m_cmdline.hasOption( "verbose" ) )
				value = true;
			else if ( System.getenv( "VI_VERBOSE" ) != null ) value = true;
		}
		else
		{
			value = m_cmdline.hasOption( optionName );
		}

		return (value);
	}

	/**
	 * Connects to a VI server.
	 * 
	 * @throws java.net.MalformedURLException If the {@code getVIUrl} is 
	 * invalid.
	 * @throws javax.xml.rpc.ServiceException If there is a problem 
	 * communicating with the VI server.
	 * @throws java.rmi.RemoteException If there is a problem communicating
	 * with the VI server.
	 * @throws FileNotFoundException If the session file is not found.
	 * @throws IOException If there is a problem reading the session
	 * file.
	 */
	public void connect() throws 
		java.net.MalformedURLException,
		javax.xml.rpc.ServiceException, 
		java.rmi.RemoteException, 
		FileNotFoundException,
		IOException
	{
		// Login with a session file
		if ( getOptionValue( "sessionfile" ) != null )
		{
			String session_file = getOptionValue( "sessionfile" );
			BufferedReader br = 
				new BufferedReader( new FileReader( session_file ) );
			String session_cookie = br.readLine();
			br.close();
			
			// Create the new service instance
			m_si = new ServiceInstance(
				new URL( getVIUrl() ),
				session_cookie,
				hasOption( "ignoresslerrors" ) );
		}
		// Login with a username and password
		else
		{
			// Create the new service instance
			m_si = new ServiceInstance(
				new URL( getVIUrl() ),
				getOptionValue( "username" ), getOptionValue( "password" ),
				hasOption( "ignoresslerrors" ) );
		}
		
		m_is_connected = true;
	}

	/**
	 * Disconnects from the VI server.
	 * 
	 * @throws RemoteException If there is an error disconnected from the
	 *         server.
	 */
	public void disconnect() throws RemoteException
	{
		if ( !m_is_connected ) return;
		m_si.getSessionManager().logout();
		m_is_connected = false;
	}

	/**
	 * Save the current session cookie in Axis format.
	 * 
	 * @throws java.io.IOException If error writing session file.
	 */
	public void saveSession() throws java.io.IOException
	{
		saveSession( getOptionValue( "savesessionfile" ) );
	}

	/**
	 * Save the current session cookie to the given file in Axis format.
	 * 
	 * @param sessionFile The file to save the session cookie to.
	 * @throws java.io.IOException If error writing session file.
	 */
	public void saveSession( String sessionFile ) throws java.io.IOException
	{
		saveSession( getOptionValue( "savesessionfile" ),
			SaveSessionCookieFormat.AXIS );
	}

	/**
	 * Save the current session cookie to the given file in the given format.
	 * 
	 * @param sessionFile The file to save the session cookie to.
	 * @param format The format to save the session cookie as.
	 * @throws java.io.IOException If error writing session file.
	 */
	public void saveSession( 
		String sessionFile, 
		SaveSessionCookieFormat format )
		throws java.io.IOException
	{
		VimPortType vpt = m_si.getServerConnection().getVimService();
		
		java.io.FileWriter fout = new java.io.FileWriter( sessionFile );
		Object ocookie = ( ( VimBindingStub ) vpt )._getCall()
			.getMessageContext().getProperty( 
			org.apache.axis.transport.http.HTTPConstants.HEADER_COOKIE );
		String socookie = String.valueOf( ocookie );
		
		// vmware_soap_session=\"F25551E7-D721-4992-8A24-B82A0E98A6AC\"
		String scookie = String.valueOf( socookie ).replaceAll( "\"", "" );
		scookie = scookie.replaceAll( "vmware_soap_session=", "" );

		switch (format)
		{
			case AXIS :
			{
				fout.write( socookie );
				break;
			}
			case COOKIE_VALUE_ONLY :
			{
				fout.write( scookie );
				break;
			}
			case PERL :
			{
				String s = String.format(
					"#LWP-Cookies-1.0\nSet-Cookie3: vmware_soap_session="
					+ "\"\\\"%1$b\\\"\"; path=\"/\"; domain={%2$b}; path_spec; "
					+ "discard; version=0", scookie,
					getOptionValue( "server" ) );
				fout.write( s );
				break;
			}
		}

		fout.close();
	}
	
	 public String getOnelineInput(String prompt)
	   {
		   System.out.print(prompt);
	       BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	       String pass = null;
	       try
	       {
	    	   pass = stdin.readLine();
	       } catch(IOException ioe)
	       {
	    	   System.out.println("Error in reading console input.");
	       }
	       return pass;
	   }
	
	private String readPassword (String prompt) 
	   {
	      try { 
	         PasswordMask consoleEraser = new PasswordMask();
	         System.out.print(prompt);
	         BufferedReader stdin = new BufferedReader(new
	                             InputStreamReader(System.in));
	         consoleEraser.start();                       
	         String pass = stdin.readLine();
	         consoleEraser.halt();
	         System.out.print("\b");
	         return pass;
	      }
	      catch(Exception e) {
	         return null;
	      }
	   }   
	   class PasswordMask extends Thread {
	      private boolean running = true;
	      public void run() {
	         while (running) {
	            System.out.print("\b ");
	         }
	      }
	      public synchronized void halt() {
	         running = false;
	      }
	   }

	// </editor-fold>

	// </region>
}
