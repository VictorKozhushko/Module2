package concurrency;

public class Dock {
    private final int containersCapasity;
    private int containers;
    private String nameOfPort;

    Dock(String name, int containersCapasity) {
        this.nameOfPort = name;
        this.containersCapasity = containersCapasity;
        this.containers = containersCapasity-20;
    }

    public int getContainers() {
        return containers;
    }

    public int getContainersCapasity() {
        return containersCapasity;
    }

    public synchronized void loading(int containersLoading) throws InterruptedException {
        if (containers == 0) {
            System.out.println("Порт пуст");
        } else {
            containers-=containersLoading;
        }
    }

    public synchronized void unloading(int containersLoading) throws InterruptedException {
        if (containers == containersCapasity) {
            System.out.println("Порт загружен");
        }
        {
            containers+=containersLoading;
        }
    }

    @Override
    public synchronized String toString() {
        return "В порту " + nameOfPort + "  " + containers + " контейнеров";
    }
}
