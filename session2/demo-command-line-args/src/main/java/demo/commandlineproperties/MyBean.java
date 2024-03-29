package demo.commandlineproperties;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
public class MyBean {
    @Value("${name}")
    private String name;
}
