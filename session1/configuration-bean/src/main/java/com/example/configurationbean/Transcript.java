package com.example.configurationbean;

import java.util.ArrayList;
import java.util.List;

public class Transcript {
    private List<String> lines;
    private int transcriptSize;
    private boolean cyclic;

    public Transcript(int transcriptSize, boolean cyclic) {
        this.lines = new ArrayList<>();
        this.transcriptSize = transcriptSize;
        this.cyclic = cyclic;
    }

    public void log(String text) {
        System.out.println("LOG: " + text);
        this.lines.add(text);
        this.printSize();
        if (this.cyclic && this.lines.size() == this.transcriptSize) this.clear();
    }

    private void clear() {
        System.out.println("Log is full... Start cleaning!");
        this.lines = new ArrayList<>();
        this.printSize();
        System.out.println("Log is empty... ");
    }

    private void printSize() {
        System.out.println("Lines " + this.lines.size() + "/" + this.transcriptSize);
    }
}
