package org.example.integration;

import org.apache.log4j.Logger;

public class ServerException  extends Exception{
    public ServerException(String message) {
        super(message);
        Logger LOG = Logger.getLogger(ServerException.class);
        LOG.error(message);
    }
}
