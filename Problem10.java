import java.sql.Timestamp;

public class Problem10 {

    public static void main(String[] args) {

        JobScheduler scheduler = new JobScheduler();

        System.out.println("[START] Synchronous Task Scheduler at " + time());
        scheduler.schedule(5000, () -> {
            System.out.println("[ RAN ] Synchronous Task Scheduler at " + time());
            return "success";
        });
        System.out.println("[ END ] Synchronous Task Scheduler at " + time());

        System.out.println("[START] A-Synchronous Task Scheduler at " + time());
        scheduler.scheduleAsync(5000, () -> {
            System.out.println("[ RAN ] A-Synchronous Task Scheduler at " + time());
            return null;
        });
        System.out.println("[ END ] A-Synchronous Task Scheduler at " + time());


        scheduler.scheduleAsyncRepeat(5000, ()->{
            System.out.println("This ran at " + time());
            return null;
        });

    }

    public static String time(){
        return new Timestamp(System.currentTimeMillis()).toString().split(" ")[1];
    }
}

class JobScheduler {

    interface Runnable<T> {
        T run();
    }

    public <T> T schedule(long durationMillis, Runnable<T> runnable) {
        long currentTime = System.currentTimeMillis();
        long targetTime = currentTime + durationMillis;
        while (currentTime < targetTime) currentTime = System.currentTimeMillis();
        return runnable.run();
    }

    public void scheduleAsync(long durationMillis, Runnable<Void> runnable) {
        Thread thread = new Thread(() -> {
            schedule(durationMillis, runnable);
        });
        thread.start();
    }

    public void scheduleAsyncRepeat(long durationMillis, Runnable<Void> runnable) {
        long currentTime = System.currentTimeMillis();
        long targetTime = currentTime + durationMillis;
        while (true){
            while (currentTime < targetTime) {
                currentTime = System.currentTimeMillis();
            }
            runnable.run();
            targetTime += durationMillis;
        }
    }

}
