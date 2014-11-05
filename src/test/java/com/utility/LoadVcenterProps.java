package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadVcenterProps {
    public static String url;
    public static String userName;
    public static String password;
    static {
        InputStream input = null;
        Properties prop = new Properties();

        try {

            input = new FileInputStream("src/test/java/VcenterInfo.properties");

            // load a properties file
            prop.load(input);

            url = prop.getProperty("url");
            userName = prop.getProperty("username");
            password = prop.getProperty("password");

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
