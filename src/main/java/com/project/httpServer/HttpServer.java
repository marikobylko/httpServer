package com.project.httpServer;

import com.project.httpServer.config.Configuration;
import com.project.httpServer.config.ConfigurationManager;
import com.project.httpServer.core.ServerListenerThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);

    //driver class
    public static void main(String[] args) {

        LOGGER.info("Server starting...");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");

        Configuration conf = ConfigurationManager.getInstance().getCurrenConfiguration();

        LOGGER.info("Using port: " + conf.getPort());
        LOGGER.info("Using webRoot: " + conf.getWebroot());

        //listener port
        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
            //TODO handle
        }

    }

}
