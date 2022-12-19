import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

//    private static final Logger log = LogManager.getLogger(Main.class);

    private static final Logger logStash
            = LoggerFactory.getLogger("stash");
    private static final Logger logConsole
            = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        logStash.info("Info Message");
        logConsole.info("Info Message");

        Thread.sleep(5000);

//        while (true) {
//
//        }

    }

}
