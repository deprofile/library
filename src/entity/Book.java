package entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
@Getter
@Setter
public class Book {
    private long id;
    private String title;
    private LocalDate localDate;

    public Book(long id, String title, LocalDate localDate) {
        this.id = id;
        this.title = title;
        this.localDate = localDate;
    }

    public Book(String title, LocalDate localDate) {
        this.title = title;
        this.localDate = localDate;
    }


}
