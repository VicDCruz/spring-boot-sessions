package configuration_factory.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentWithTranscript {
    @Autowired
    private Transcript transcript;

    public void logRandomNumber() {
        this.transcript.log("My random number is " + this.getRandomNumber());
        this.transcript.printHistory();
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 100);
    }
}
