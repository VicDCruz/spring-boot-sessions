package command_line_args;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class TimeStamp {
    public LocalDate createDate() {
        return LocalDate.now();
    }

    public LocalTime createTime() {
        return LocalTime.now();
    }
}
