package com.project.httpServer;

import com.project.httpServer.config.Configuration;
import com.project.httpServer.config.ConfigurationManager;

public class HttpServer {
    //driver class
    public static void main(String[] args) {
        System.out.println("Server starting...");


        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");

        Configuration conf = ConfigurationManager.getInstance().getCurrenConfiguration();
        System.out.println("Using port: " + conf.getPort());
        System.out.println("Using webRoot: " + conf.getWebroot());

    }

}
