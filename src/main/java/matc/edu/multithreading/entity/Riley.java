package matc.edu.multithreading.entity;


import org.apache.log4j.Logger;

public class Riley implements Runnable {

    private final Logger log = Logger.getLogger(this.getClass());

    Home home;

    public Riley(Home home) {
        this.home = home;
    }

    public void run() {

        log.info("The haunting hour begins");
        while(true)
        {
            home.giveCandy();
        }
    }
}
