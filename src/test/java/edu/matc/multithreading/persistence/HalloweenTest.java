package edu.matc.multithreading.persistence;

import matc.edu.multithreading.controller.ApplicationStart;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

public class HalloweenTest {

    private final Logger log = Logger.getLogger(this.getClass());
    @Test
    //at the current generation rate, max capacity hits roughly 20 seconds in
    public void runHalloween() {
        ApplicationStart driver = new ApplicationStart();
        driver.main();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            log.error("Interrupted Exception", e);
        }
        assertEquals("???","???");
    }

}
