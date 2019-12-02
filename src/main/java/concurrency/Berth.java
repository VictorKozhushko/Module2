package concurrency;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Berth implements Runnable {

    private String name;
    private Dock dock;
    private boolean shipping;
    private Ship ship = null;

    private boolean started;
    Thread thread;
    Random random = new Random();

    public Berth(Dock dock, String name) {
        this.dock = dock;
        this.name = name;
        shipping = false;

        this.started = false;
    }

    public boolean canShipping(Ship ship) {
        if (!shipping) {
            return (dock.getContainersCapasity() - dock.getContainers()) > (ship.getUnloading() - ship.getLoading());
        } else return false;
    }

    public void shipping(Ship ship) {

        this.ship = ship;
        if (!shipping) {
            if (!started) {
                thread = new Thread(this, name);
                started = false;
                shipping = true;
                thread.start();
            }
        }
        shipping = true;
    }

    public void justShipping() {

        if (shipping) {
            try {
                dock.unloading(ship.getUnloading());
                TimeUnit.MILLISECONDS.sleep(10 * ship.getUnloading());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                dock.loading(ship.getLoading());
                TimeUnit.MILLISECONDS.sleep(12 * ship.getLoading());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " c корабля " + ship.getShipID() + " разгрузили " + ship.getUnloading() + " и на корабль погрузили " + ship.getLoading() + " контейнеров ");

            ship = null;
            shipping = false;
        }
    }

    @Override
    public void run() {

        justShipping();

    }

}
