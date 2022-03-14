package configuration_factory.simple_configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        MyBean bean = context.getBean("myBean", MyBean.class);
        System.out.println(bean);

        SomeComponent component = context.getBean(SomeComponent.class);
        component.someOperation();
    }
}
