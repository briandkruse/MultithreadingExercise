package matc.edu.multithreading.controller;

import matc.edu.multithreading.entity.Home;
import matc.edu.multithreading.entity.Riley;
import matc.edu.multithreading.utility.VisitorGenerator;
import org.apache.log4j.Logger;

public class ApplicationStart {

    public static void main() {
        Home home = new Home();
        Riley riley = new Riley(home);

        VisitorGenerator visitorGenerator = new VisitorGenerator(home);

        Thread rileyThread = new Thread(riley);
        Thread visitorThread = new Thread(visitorGenerator);
        rileyThread.start();
        visitorThread.start();
    }
}
