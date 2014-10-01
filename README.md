Welcome to the YAVI Java API

## WHAT IS YAVI JAVA API?
It is a fork of the VI Java API which is a set of Java libraries that aim to ease the usage of VI 
SDK Web Services interfaces. It's now open-sourced under a mixed BSD license and Apache-2.0 license.

It provides the following benefits to the Java developers:
* Enables OO programming with a well defined managed object model
* Reduces the need to use ManagedObjectReference and makes possible 
  compile time type checking
* Hides the complexity of the PropertyCollector
* Provides necessary utility classes to simplify VI SDK web interfaces
* High performance with 4+ times faster than AXIS engine
* Adds the ability to provide your own HTTP Client
* Adds logging using log4j
* Adds gradle support for the build system

As a result, the application code using this API is much shorter (70% less) 
and much more readable than the equivalent using web service interfaces 
directly. The API itself is straight-forward and easy to learn and use. 

## WHO CREATED THE API?
To find out more about the original VI Java API see http://vijava.sf.net

As for who created this fork called YAVI Java that is Michael Rice.


## Whats with the name?

The name YAVI means simply Yet Another VI Java. I forked this project and moved it to 
github because the project seemd stale and I felt it needed new life. I wanted things 
like GitHub, custom http clients, and logging, and tests as well as other stuff so I decided to 
fork the project and do it.


## Do I have to change my code to use this?

No!! This is a drop in replacement and requires no code modification, but does introduce some new
dependencies:

    dependencies {
        compile 'org.apache.directory.studio:org.dom4j.dom4j:1.6.1'
        compile 'log4j:log4j:1.2.17'
        compile 'org.apache.httpcomponents:httpclient:4.3.5'
        testCompile 'org.mockito:mockito-all:1.9.5'
        testCompile group: 'junit', name: 'junit', version: '4.+'
    }

## WHERE CAN I GET HELP?
File a bug: https://github.com/michaelrice/yavijava/issues

IRC: Freenode IRC #vijava 

COPYRIGHT & LICENSE:
BSD. See the License.txt file for details


## What happened to the samples?!?!

Never fear. I removed them from the core of the project and made them their own project. They can be found here: https://github.com/michaelrice/yavijava-samples


