package biz.aceresources.json.config;

import lombok.Getter;
import lombok.Setter;

import java.util.logging.Logger;

/**
 * Singleton class holding generic settings used in all application places
 */
public class ApplicationConfiguration {

    private static final Logger LOGGER = Logger.getLogger(ApplicationConfiguration.class.getName());

    /**
     * The Instance.
     */
    static ApplicationConfiguration instance;
    @Setter
    @Getter
    private boolean debug;
    @Getter
    @Setter
    private boolean printOutput;
    @Getter
    @Setter
    private boolean append;

    private ApplicationConfiguration() {
    }

    /**
     * Get instance application configuration.
     *
     * @return the application configuration
     */
    public static ApplicationConfiguration getInstance() {
        if (instance == null)
            instance = new ApplicationConfiguration();
        return instance;
    }

    /**
     * Show debug.
     *
     * @param s the message printed on screen if debug is enabled
     */
    public void showDebug(String s) {
        if (debug)
            LOGGER.info(s);
    }
}
