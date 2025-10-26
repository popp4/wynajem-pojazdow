import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalSystem {
    private List<Rentable> vehicles = new ArrayList<>();

    public RentalSystem() {
        // przygotuj przykładowe pojazdy
        vehicles.add(new Car("Toyota", "Corolla", 2020, 150));
        vehicles.add(new Car("Honda", "Civic", 2018, 140));
        vehicles.add(new Truck("Volvo", "FH16", 2019, 300, 20));
        vehicles.add(new Motorcycle("Yamaha", "MT-07", 2021, 100));
        vehicles.add(new Bus("Mercedes", "Sprinter", 2017, 400, 20));
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- System wynajmu pojazdów ---");
        while (true) {
            System.out.println();
            System.out.println("Dostępne pojazdy:"); 
            for (int i = 0; i < vehicles.size(); i++) {
                Rentable r = vehicles.get(i);
                System.out.printf("%d) %s\n", i + 1, r.toString());
            }
            System.out.println("0) Wyjście");
            System.out.print("Wybierz pojazd (numer): ");
            String pick = sc.nextLine();
            int idx;
            try {
                idx = Integer.parseInt(pick);
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawny numer. Spróbuj ponownie.");
                continue;
            }
            if (idx == 0) {
                System.out.println("Do widzenia!"); 
                break;
            }
            if (idx < 1 || idx > vehicles.size()) {
                System.out.println("Wybrano nieistniejący pojazd. Spróbuj ponownie.");
                continue;
            }

            Rentable selected = vehicles.get(idx - 1);
            System.out.print("Podaj liczbę dni wynajmu: ");
            String daysStr = sc.nextLine();
            int days;
            try {
                days = Integer.parseInt(daysStr);
                if (days <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Liczba dni musi być dodatnią liczbą całkowitą."); 
                continue;
            }

            double cost = selected.rent(days);
            System.out.printf("Wybrano: %s\n", selected.toString());
            System.out.printf("Okres: %d dni\n", days);
            System.out.printf("Całkowity koszt wynajmu: %.2f zł\n", cost);
            System.out.println("Czy chcesz kontynuować? (t/n): ");
            String again = sc.nextLine().trim().toLowerCase();
            if (!again.equals("t") && !again.equals("tak")) {
                System.out.println("Kończenie programu. Dziękujemy!"); 
                break;
            }
        }
        sc.close();
    }
}
