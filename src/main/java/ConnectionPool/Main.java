package ConnectionPool;

import javax.management.ServiceNotFoundException;

public class Main {
    public static void main(String[] args) {
        AirportSupportService service = AirportSupportService.getInstance();

        Runnable[] knownTasks = new Runnable[]{
                new EmailSupport("Email Support"),
                new PhoneSupport("Phone Support"),
                new ChatSupport("Chat Support"),
                new LostLuggage("Lost Luggage", () -> System.out.println("Lost Luggage")),
                new ValidationDocuments("Validation Documents", () -> System.out.println("Validation Documents")),
                new FlightDelay("Flight Delay", () -> System.out.println("Flight Delay")),
        };

        for (Runnable task : knownTasks) {
             service.addTask(task);

        }

        for (int i = 7; i <= 11; i++) {
            int taskNumber = i;
            service.addTask(new UnnamedTask("Unnamed task - " + taskNumber,
                    () -> System.out.println("Running " + taskNumber)));
        }

        System.out.println("\nProcessing tasks...\n");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                service.processTask();
                Thread.sleep(300);
            } catch (ServiceNotFoundException e) {
                System.out.println("\nNo more tasks in queue.");
                break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        service.waitForAllTasks();
        service.shutdown();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nAll tasks completed.");
    }
}







