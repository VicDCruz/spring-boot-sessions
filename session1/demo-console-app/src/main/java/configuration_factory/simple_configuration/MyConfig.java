package configuration_factory.simple_configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyConfig {
    @Bean
    public MyBean myBean() {
        MyBean b = new MyBean();
        b.setField1(42);
        b.setField2("wibble");
        return b;
    }
}
