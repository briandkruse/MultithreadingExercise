package edu.matc.multithreading.persistence;

import matc.edu.multithreading.controller.ApplicationStart;
import org.junit.Test;

import static org.junit.Assert.*;

public class HalloweenTest {

    @Test
    public void runHalloween() {
        ApplicationStart driver = new ApplicationStart();
        driver.main();
        assertEquals("Result","???");
    }

}
