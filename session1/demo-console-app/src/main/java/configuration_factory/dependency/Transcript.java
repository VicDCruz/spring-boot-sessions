package configuration_factory.dependency;

import lombok.Setter;

import java.time.LocalDateTime;

@Setter
public class Transcript {
    private int size;
    private boolean cyclic;
    private String[] history;
    private int indexHistory;

    public Transcript(int size, boolean cyclic) {
        this.size = size;
        this.cyclic = cyclic;
        this.initializeHistory();
    }

    public void log(String line) {
        if (this.cyclic && this.indexHistory == this.size) {
            System.out.println("Log is full! Clearing it...");
            this.initializeHistory();
        }
        this.history[indexHistory++] = "[ " + LocalDateTime.now() + " ]: " + line;
    }

    public void printHistory() {
        System.out.println("==== Start print ====");
        for (int i = 0; i < this.indexHistory; i++) {
            System.out.println(this.history[i]);
        }
        System.out.println("==== End print ====");
    }

    private void initializeHistory() {
        this.history = new String[this.size];
        this.indexHistory = 0;
    }
}
