package tat.framework.loger;

import org.apache.log4j.Logger;

public class Log {

    public static Logger logger = Logger.getLogger("YandexLoger");

    public static void info(String info){
        logger.info(info);
    }

    public static void debug(String debug){
        logger.debug(debug);
    }

    public static void error(String error){
        logger.error(error);
    }
}
