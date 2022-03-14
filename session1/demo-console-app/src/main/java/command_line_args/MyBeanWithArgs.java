package command_line_args;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@ToString
public class MyBeanWithArgs {

    @Autowired
    public MyBeanWithArgs(ApplicationArguments args) {
        System.out.println("Raw (unprocessed) args");
        Arrays.stream(args.getSourceArgs()).forEach(sourceArg -> System.out.println("   " + sourceArg));

        System.out.println("Option names");
        args.getOptionNames().forEach(optName -> System.out.println("   " + optName));

        System.out.println("Values for 'target' option");
        if (args.containsOption("target")) {
            args.getOptionValues("target").forEach(optValue -> System.out.println("   " + optValue));
        }
    }
}
