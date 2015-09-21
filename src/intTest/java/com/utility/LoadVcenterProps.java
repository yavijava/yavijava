package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadVcenterProps {
    public static String url;
    public static String userName;
    public static String password;
    public static String secondUrl;
    public static String badUrl;
    public static String sslThumbprint;

    static {
        InputStream input = null;
        Properties prop = new Properties();

        try {

            input = new FileInputStream("src/intTest/java/VcenterInfo.properties");

            // load a properties file
            prop.load(input);

            url = prop.getProperty("url");
            userName = prop.getProperty("username");
            password = prop.getProperty("password");
            secondUrl = prop.getProperty("secondUrl");
            badUrl = prop.getProperty("badUrl");
            sslThumbprint = prop.getProperty("sslThumbprint");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
