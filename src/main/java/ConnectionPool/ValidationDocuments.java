package ConnectionPool;

import java.util.concurrent.RunnableFuture;

public class ValidationDocuments implements Runnable {
    private String name;
    private Runnable task;


    public ValidationDocuments(String name, Runnable task) {
        this.name = name;
        this.task = task;

    }

    @Override
    public void run() {
    }

    @Override
    public String toString() {
        return name;
    }

}
