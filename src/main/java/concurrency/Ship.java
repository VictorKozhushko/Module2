package concurrency;

import java.util.concurrent.TimeUnit;

public class Ship implements Runnable {

    private Dock dock;
    private int loading;
    private int unloading;

    Ship(Dock dock, int unloading, int loading) {
        this.dock = dock;
        this.loading = loading;
        this.unloading = unloading;
        new Thread(this, "Корабль в порту");
    }

    @Override
    public void run() {
        int unloaded = 0;
        int loaded = 0;
        while (unloading != unloaded) {
            dock.unloading();
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            unloaded++;
        }

        while (loading != loaded) {
            dock.loading();
            try {
                TimeUnit.MILLISECONDS.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            loaded++;
        }
        System.out.println("С корабля разгрузили " + unloading + " и на корабль погрузил " + loading + " контейнеров " + Thread.currentThread().getName());
    }
}
