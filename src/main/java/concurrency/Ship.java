package concurrency;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ship {

    private int loading;
    private int unloading;
    private long shipID;
    Random random = new Random();

    Ship(int unloading, int loading) {

        this.loading = loading;
        this.unloading = unloading;
        this.shipID = Math.abs(random.nextLong());

    }

    Ship() {
        this.loading = random.nextInt(50);
        this.unloading = random.nextInt(50);
        this.shipID = Math.abs(random.nextLong());
    }

    int getLoading() {
        return this.loading;
    }

    int getUnloading() {
        return this.unloading;
    }

    public long getShipID() {
        return shipID;
    }
}
