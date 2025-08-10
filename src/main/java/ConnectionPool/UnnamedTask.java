package ConnectionPool;

public class UnnamedTask implements Runnable {
    private String name;
    private Runnable task;

    public UnnamedTask(String name, Runnable task) {
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
