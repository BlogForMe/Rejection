import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/27.
 */
public class Thread {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 5, TimeUnit.SECONDS);

        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    int i = 0;
                    while (i < 5) {
                        java.lang.Thread.sleep(1000);
                        System.out.println(i);
                        i++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
