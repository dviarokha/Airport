package ConnectionPool;

public class LostLuggage implements Runnable {
    private String name;
    private Runnable task;

    public LostLuggage(String name, Runnable task) {
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
