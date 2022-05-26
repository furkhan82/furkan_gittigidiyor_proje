package utilities;
import org.apache.log4j.Logger;
public class log4j {

    private static Logger logger = Logger.getLogger(log4j.class.getName());

    public static void baslangic (String testName){
        logger.info("*****Test Başladı****");
    }
    public static void bitis (String testName){

        logger.info("****Test Bitti****");
    }
    public static void info (String message) {
       logger.info(message);
    }
    public static void warn (String message) {
        logger.warn(message);
    }
    public static void error (String message) {
        logger.error(message);
    }
    public static void fatal (String message) {
        logger.fatal(message);
    }
    public static void debug (String message) {
        logger.debug(message);
    }
}

