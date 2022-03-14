package main;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
public class MyBeanWithValues {
    @Value("${name}")
    private String name;

    @Value("${age}")
    private int myAge;

    @Value("#{5 * 7.5}")
    private double workingWeek;
}
