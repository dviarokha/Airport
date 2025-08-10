package ConnectionPool;

import javax.management.ServiceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class AirportSupportService {
    public static final int CAPACITY = 10;
    private volatile static AirportSupportService instance;
    private final ArrayBlockingQueue<Runnable> queue;
    private final ExecutorService executor;
    private final List<Future<String>> futures;

    private AirportSupportService(int capacity) {
        queue = new ArrayBlockingQueue<>(capacity);
        executor = Executors.newFixedThreadPool(10);
        futures = new ArrayList<>();
    }

    public static AirportSupportService getInstance() {
        if (instance == null) {
            synchronized (AirportSupportService.class) {
                if (instance == null) {
                    instance = new AirportSupportService(CAPACITY);
                }
            }
        }
        return instance;
    }

    public boolean addTask(Runnable task) {
        boolean added = queue.offer(task);
        if (added) {
            System.out.println("Added task to queue: " + task);
        } else  {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.err.println(task + " is rejected.");
        }
        return added;
    }

    public Runnable processTask() throws ServiceNotFoundException {
        Runnable task = queue.poll();
        if (task == null) {
            throw new ServiceNotFoundException("No tasks available.");
        }


        Future<String> future = executor.submit(() -> {
            System.out.println(task + " is started.");
            task.run();
            System.out.println(task + " is done.");
            return "done";
        });
        futures.add(future);
        return task;
    }

    public void waitForAllTasks() {
        for (Future<String> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                System.err.println("Task failed: " + e.getMessage());
            }

        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}





