package ConnectionPool;

public class EmailSupport extends Thread {
    private String name;


    public EmailSupport(String name) {
        this.name = name;
    }

    @Override
    public void run() {
    }

    @Override
    public String toString() {
        return name;
    }
}
