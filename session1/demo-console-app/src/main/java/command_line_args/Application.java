package command_line_args;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        MyBeanWithArgs beanWithArgs = context.getBean(MyBeanWithArgs.class);
        System.out.println(beanWithArgs);

        SpelBean spelBean = context.getBean(SpelBean.class);
        System.out.println(spelBean);
        spelBean.displayTimestampMode();
    }
}
