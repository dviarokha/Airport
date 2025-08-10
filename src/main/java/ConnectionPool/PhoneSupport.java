package ConnectionPool;

public class PhoneSupport extends Thread {
    private String name;

    public PhoneSupport(String name) {
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
