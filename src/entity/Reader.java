package entity;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    private long id;
    private String name;
    private int totalBooks;

    public Reader(String name) {
        this.name = name;
    }

    public Reader(long id, int totalBooks, String name) {
        this.id = id;
        this.totalBooks = totalBooks;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTotalBooks() {
        return totalBooks;
    }
}
