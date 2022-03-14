package configuration_factory.simple_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeComponent {
    private MyBean bean;

    public SomeComponent(MyBean bean) {
        this.bean = bean;
    }

    public void someOperation() {
        System.out.printf("In SomeComponent.someOperation() with MyBean: %s\n", bean);
    }
}
