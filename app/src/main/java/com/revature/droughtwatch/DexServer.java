package com.revature.droughtwatch;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class DexServer {
    private Tomcat server;

    public DexServer(DexService dexService) {
        this.server = new Tomcat();
        this.server.setBaseDir(System.getProperty("java.io.tmpdir"));
        this.server.getConnector();
        this.server.addContext("", null);
        this.server.addServlet("", "dexServlet", dexService).addMapping("/");
        try {
            server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}