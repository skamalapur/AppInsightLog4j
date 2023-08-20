package com.mkyong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsoft.applicationinsights.attach.ApplicationInsights;

public class HelloWorld {

    private static final Logger logger = LogManager.getLogger(HelloWorld.class);

    public static void main(String[] args) {
    	
    	ApplicationInsights.attach();

        logger.debug("without appinsightsjson Hello from Log4j 2 MS ARS 123 ");

        logger.error("ERROR without App Insight ....MS ARS 123");

        logger.warn("WARN without App Insight ....MS ARS 123");
        
        try {
        	
        	int k = 100/0;
        	
        	
        }catch (Exception e) {
        	logger.error(e);
        }
        
        
        // in old days, we need to check the log level log to increase performance
        /*if (logger.isDebugEnabled()) {
            logger.debug("{}", getNumber());
        }*/

        // with Java 8, we can do this, no need to check the log level
    //    while (true)//test rolling file
            logger.debug("hello {}", () -> getNumber());
        

    }

    static int getNumber() {
        return 5;
    }

}
