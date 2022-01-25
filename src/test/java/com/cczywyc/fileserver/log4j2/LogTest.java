package com.cczywyc.fileserver.log4j2;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * log test
 *
 * @author wangyc
 */
public class LogTest {

    /** log object */
    private Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void logTest() {
        logger.info("This is a info log");
        logger.error("This is an error log");
        logger.warn("Tis is a warn log");
        logger.debug("Tis is a debug log");
    }
}
