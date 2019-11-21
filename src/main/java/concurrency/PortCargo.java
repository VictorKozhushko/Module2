package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PortCargo {

    public static void main(String[] args) {

        Dock dock = new Dock(1000);

        System.out.println(dock);

        int[] unloadContainers = {20, 300, 50, 80, 40, 150, 20, 70, 90, 150};
        int[] loadContainers = {80, 250, 90, 100, 60, 180, 50, 100, 120, 170};

        int differenceContainers = 0;

        for (int i = 0; i < 10; i++)
            differenceContainers = differenceContainers + unloadContainers[i] - loadContainers[i];

        System.out.println("Разница в контейнерах: " + differenceContainers);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            Runnable ship = new Ship(dock, unloadContainers[i], loadContainers[i]);
            executorService.execute(ship);
        }
        executorService.shutdown();

        while (!executorService.isTerminated()) {
        }

        System.out.println("Выполнены разгрузочно-погрузочные работы.");

        System.out.println(dock);
    }
}
