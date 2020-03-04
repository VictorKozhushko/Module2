package taf.framework.runner;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import taf.framework.loger.Log;

public class TestRunner {
    public static void main(String[] args) {
        Log.info("Parse cli");
        parseCli(args);
    }

    private static void parseCli(String[] args) {
        Log.info("Pasre clis using JCommander");
        JCommander jCommander = new JCommander(Parameters.instance());
        try {
            jCommander.parse(args);
        } catch(ParameterException e) {
            Log.error(e.getMessage());
            System.exit(1);
        }
        if (Parameters.instance().isHelp()){
            jCommander.usage();
            System.exit(0);
        }
    }
}
