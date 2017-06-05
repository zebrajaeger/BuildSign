package de.zebrajaeger.buildsign;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lars Brandt
 */
public class RuntimeConfig {
    private static final Logger LOG = LoggerFactory.getLogger(RuntimeConfig.class);

    private static final String OPT_DRY_RUN_ID = "dryrun";
    private static final Option OPT_DRY_RUN =
            Option.builder(OPT_DRY_RUN_ID).argName("d").longOpt("dry-run").desc("No use of Hardware, only logging").build();

    private CommandLine cli;
    private static Options options;

    public static RuntimeConfig of(String[] args) throws ParseException {
        LOG.info("parse command-line-options: '{}'", args);
        options = new Options();
        options.addOption(OPT_DRY_RUN);
        CommandLineParser parser = new DefaultParser();
        CommandLine cli = parser.parse(options, args);

        return new RuntimeConfig(cli);
    }

    public RuntimeConfig(CommandLine cli) {
        this.cli = cli;
    }

    public boolean isDryRun() {
        return cli.hasOption(OPT_DRY_RUN_ID);
    }

    public void printHelpToCommandLine() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("ant", options);
    }
}
