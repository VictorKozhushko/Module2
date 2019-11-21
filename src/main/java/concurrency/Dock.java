package concurrency;

public class Dock {
    private long containers;

    Dock(long containers) {
        this.containers = containers;
    }

    public synchronized void loading() {
        containers--;
    }

    public synchronized void unloading() {
        containers++;
    }

    @Override
    public synchronized String toString() {
        return "В порту: " + containers + " контейнеров";
    }
}
