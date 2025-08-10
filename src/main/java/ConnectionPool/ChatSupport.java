package ConnectionPool;

public class ChatSupport extends Thread {
    private  String name;


    public ChatSupport(String name) {
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
