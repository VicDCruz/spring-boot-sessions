package configuration_factory.dependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TranscriptConfiguration {
    @Bean
    public Transcript transcript() {
        Transcript transcript = new Transcript(5, true);
        return transcript;
    }
}
