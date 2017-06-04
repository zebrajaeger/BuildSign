package de.zebrajaeger.buildsign.config;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Lars Brandt
 */
public class Config {

    public static final String SERVER_CONFIG_FILE_NAME = "server.json";
    public static final String DISPLAY_CONFIG_FILE_NAME = "display.json";
    public static final String TRIGGER_CONFIG_FILE_NAME = "trigger.json";

    private ServerConfig serverConfig;
    private DisplayConfig displayConfig;
    private TriggerConfig triggerConfig;

    public Config(File folder) throws IOException, ConfigException {
        Gson gson = new Gson();

        // Server Config
        File serverFile = new File(folder, SERVER_CONFIG_FILE_NAME);
        if (!serverFile.exists()) {
            throw new ConfigException(String.format("Could not find server-config: '%s'", serverFile.getAbsolutePath()));
        }
        String displayServerString = FileUtils.readFileToString(serverFile, Charsets.UTF_8);
        try {
            serverConfig = gson.fromJson(displayServerString, ServerConfig.class);
        } catch (JsonSyntaxException e) {
            throw new ConfigException(String.format("While parsing server file: '%s'", serverFile.getAbsolutePath()), e);
        }

        // Display Config
        File displayFile = new File(folder, DISPLAY_CONFIG_FILE_NAME);
        if (!displayFile.exists()) {
            throw new ConfigException(String.format("Could not find display-config: '%s'", displayFile.getAbsolutePath()));
        }
        String displayJsonString = FileUtils.readFileToString(displayFile, Charsets.UTF_8);
        try {
            displayConfig = gson.fromJson(displayJsonString, DisplayConfig.class);
        } catch (JsonSyntaxException e) {
            throw new ConfigException(String.format("While parsing display file: '%s'", displayFile.getAbsolutePath()), e);
        }

        // Trigger Config
        File triggerFile = new File(folder, TRIGGER_CONFIG_FILE_NAME);
        if (!triggerFile.exists()) {
            throw new ConfigException(String.format("Could not find trigger-config: '%s'", triggerFile.getAbsolutePath()));
        }
        String displayProjectString = FileUtils.readFileToString(triggerFile, Charsets.UTF_8);
        try {
            triggerConfig = gson.fromJson(displayProjectString, TriggerConfig.class);
        } catch (JsonSyntaxException e) {
            throw new ConfigException(String.format("While parsing config file: '%s'", triggerFile.getAbsolutePath()), e);
        }
    }

    public ServerConfig getServerConfig() {
        return serverConfig;
    }

    public TriggerConfig getTriggerConfig() {
        return triggerConfig;
    }
}
