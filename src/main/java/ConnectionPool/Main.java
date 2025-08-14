package ConnectionPool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TaskPool pool = TaskPool.getInstance();
        pool.loadInitialTasks();

        ExecutorService executor = Executors.newFixedThreadPool(TaskPool.CAPACITY);

        for (int i = 0; i < TaskPool.CAPACITY; i++) {
            executor.submit(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Runnable task = pool.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executor.shutdownNow();
    }
}
