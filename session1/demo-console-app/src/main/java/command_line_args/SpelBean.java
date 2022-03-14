package command_line_args;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@ToString
@Getter
public class SpelBean {
    @Value("#{ timeStamp.createDate }")
    private LocalDate date;
    @Value("#{ timeStamp.createTime }")
    private LocalTime time;
    private String mode;

    public SpelBean(ApplicationArguments args) {
        if (args.containsOption("displayTimestampMode")) {
            this.mode = args.getOptionValues("displayTimestampMode").get(0);
        } else {
            this.mode = "both";
        }
    }

    public void displayTimestampMode() {
        System.out.println("SpEL with command");
        String text = getText();
        System.out.println("For '" + this.mode + "': " + text);
    }

    private String getText() {
        String text;
        switch (this.mode) {
            case "date":
                text = this.date.toString();
                break;
            case "time":
                text = this.time.toString();
                break;
            default:
                text = this.toString();
                break;
        }
        return text;
    }
}
