package matc.edu.multithreading.utility;

import matc.edu.multithreading.entity.Home;
import matc.edu.multithreading.entity.Visitor;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class VisitorGenerator implements Runnable {

    private final Logger log = Logger.getLogger(this.getClass());

    Home home;

    public VisitorGenerator(Home home) {
        this.home = home;
    }

    public void run() {
        int childCount = 1;
        while(true) {
            Visitor visitor = new Visitor(home);
            Thread visitorThread = new Thread(visitor);
            visitor.setName("Costumed Candy Seeker " + childCount);
            childCount++;
            visitorThread.start();


            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()* 3.5 ));
            }
            catch(InterruptedException iex)
            {
                log.error("Interrupted Exception", iex);
            }
        }
    }

}