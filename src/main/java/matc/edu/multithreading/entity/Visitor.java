package matc.edu.multithreading.entity;

import org.apache.log4j.Logger;

public class Visitor implements Runnable {

    private final Logger log = Logger.getLogger(this.getClass());

    String name;
    Home home;

    public Visitor(Home home) {
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        goGetCandy();
    }

    private synchronized void goGetCandy() {
        home.add(this);
    }
}