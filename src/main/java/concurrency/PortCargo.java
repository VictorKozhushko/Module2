package concurrency;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PortCargo {

    public static void main(String[] args) {

        Dock dock = new Dock("Таганрог", 200);

        System.out.println(dock);

        List<Ship> shipArray = new CopyOnWriteArrayList<Ship>();

        for (int i = 0; i < 10; i++)
            shipArray.add(new Ship());

        Berth[] berths = {new Berth(dock, "Причал 1"),
                new Berth(dock, "Причал 2"),
                new Berth(dock, "Причал 3")};

        while (shipArray.size() != 0) {
            for (Berth berth : berths) {
                for (Ship ship : shipArray) {
                    if (berth.canShipping(ship)) {
                        berth.shipping(ship);
                        shipArray.remove(ship);
                        break;
                    } else {
                        continue;
                    }
                }
            }
        }

        try {
            berths[0].thread.join();
            berths[1].thread.join();
            berths[2].thread.join();
            System.out.println("Выполнены разгрузочно-погрузочные работы.");
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }

        System.out.println(dock);

    }
}
