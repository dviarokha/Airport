package ConnectionPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TaskPool {
    public static final int CAPACITY = 10;
    private static TaskPool instance;
    private final BlockingQueue<Runnable> queue;


    private TaskPool(int capacity) {
        queue = new ArrayBlockingQueue<>(CAPACITY);
    }

    public static TaskPool getInstance() {
        if (instance == null) {
            synchronized (TaskPool.class) {
                if (instance == null) {
                    instance = new TaskPool(CAPACITY);
                }
            }
        }
        return instance;
    }

    public boolean submit(Runnable task) {
        boolean accepted = queue.offer(task);
        if (!accepted) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.err.println("Pool is full. " + task + " is rejected");
        } else {
            System.out.println("Submitted task: " + task);
        }
        return accepted;
    }

    public Runnable take() throws InterruptedException {
        return queue.take();
    }


    public void loadInitialTasks() {
        Runnable[] initialTasks = {
                new Task1("Lost Luggage"),
                new Task2("Validation Documents"),
                new Task3("Find Flight")
        };

        for (Runnable task : initialTasks) {
            submit(task);
        }
        for (int i = 4; i <= CAPACITY; i++) {
            submit(new UnnamedTask("Unnamed Task - " + i));
        }
        submit(new UnnamedTask("Unnamed Task - 11"));
    }

}





