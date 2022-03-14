package demo.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    public MyComponent() {
        System.out.println("MyComponent bean created");
    }

     @Override
     public String toString() {
         return "Hi from MyComponent bean";
     }
}
