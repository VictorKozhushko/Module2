package taf.framework.runner;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.Parameter;
import taf.framework.ui.BrowserType;

public final class Parameters {

    public static Parameters instance;

    @Parameter(names = "--help", help = true, description = "Help for description")
    private boolean help;

    @Parameter(names = {"--browser", "-b"}, description = "Select browser",
            converter = BrowserTypeConverter.class, required = true)
    private BrowserType browserType = BrowserType.CHROME;

    @Parameter(names = {"--gecko", "-g"}, description = "Geckodriver path")
    private String geckoPath = "";

    private Parameters() {
    }

    public static synchronized Parameters instance() {
        if (instance == null) {
            instance = new Parameters();
        }
        return instance;
    }

    public boolean isHelp() {return help;}

    public BrowserType getBrowserType() {return  browserType;}

    public String getGeckoPath() {return geckoPath;}

    public static class BrowserTypeConverter implements IStringConverter<BrowserType> {
        public BrowserType convert(String s) {
            return BrowserType.valueOf(s.toUpperCase());
        }
    }
}
