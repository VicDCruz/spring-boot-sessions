package configuration_factory.dependency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        ComponentWithTranscript component = context.getBean(ComponentWithTranscript.class, args);

        for (int i = 0; i < 13; i++) {
            component.logRandomNumber();
        }
    }
}
