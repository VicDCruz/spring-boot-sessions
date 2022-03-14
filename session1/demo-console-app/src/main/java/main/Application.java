package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        BankService bankService = context.getBean(BankService.class);
        bankService.depositIntoAccount(1, 2000);
        bankService.withdrawFromAccount(1, 25);

        MyBeanWithValues beanWithValues = context.getBean(MyBeanWithValues.class);
        System.out.println(beanWithValues);
    }

}
