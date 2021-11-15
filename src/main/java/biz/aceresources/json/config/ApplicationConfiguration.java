package biz.aceresources.json.config;

import lombok.Getter;
import lombok.Setter;

/**
 * Singleton class holding generic settings used in all application places
 */
public class ApplicationConfiguration {

    /**
     * The Instance.
     */
    static ApplicationConfiguration instance;

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

    @Setter
    @Getter
    private boolean debug;

    @Getter
    @Setter
    private boolean printOutput;

    @Getter
    @Setter
    private boolean append;

    /**
     * Show debug.
     *
     * @param s the s
     */
    public void showDebug(String s) {
        if (debug)
            System.out.println(s);
    }
}
