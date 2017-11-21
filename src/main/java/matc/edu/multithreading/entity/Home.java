package matc.edu.multithreading.entity;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Home {

    private final Logger log = Logger.getLogger(this.getClass());

    int visitorCapacity;
    List<Visitor> visitorList;

    public Home() {
        visitorCapacity = 10;
        visitorList = new LinkedList<Visitor>();
    }

    public void giveCandy() {
        Visitor visitor;

        synchronized (visitorList) {

            while(visitorList.size()==0) {
                log.info("Riley is waiting for visitors.");
                try {
                    visitorList.wait();
                }
                catch(InterruptedException iex) {
                    iex.printStackTrace();
                }
            }
            log.info("Riley found a visitor at the door.");
            visitor = (Visitor)((LinkedList<?>)visitorList).poll();
        }
            try {
            log.info("Giving candy to visitor : " + visitor.getName());
            TimeUnit.SECONDS.sleep(3);
        }
        catch(InterruptedException iex) {
            iex.printStackTrace();
        }
        log.info("Finished giving candy to visitor : " + visitor.getName());
    }

    public void add(Visitor visitor) {
        log.info("Visitor : " + visitor.getName()+ " approaching the house ");

        synchronized (visitorList) {
            if(visitorList.size() == visitorCapacity)
            {
                log.info("Child passes the house by" + visitor.getName());
                log.info("Child " + visitor.getName() + "Exists...");
                return ;
            }

            ((LinkedList<Visitor>)visitorList).offer(visitor);
            log.info("Child : " + visitor.getName()+ " got some candy.");

            if(visitorList.size()==1)
                visitorList.notify();
        }
    }





}
