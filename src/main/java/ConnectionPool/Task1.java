package ConnectionPool;

public class Task1 implements Runnable {
    private String name;

    public Task1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " is completed");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
