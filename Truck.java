public class Truck extends Vehicle implements Rentable {
    private double dailyRate;
    private double cargoCapacity;

    public Truck(String brand, String model, int year, double dailyRate, double cargoCapacity) {
        super(brand, model, year);
        this.dailyRate = dailyRate;
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double rent(int days) {
        // dodatkowa opłata zależna od ładowności (przykładowo)
        return days * dailyRate + cargoCapacity * 5;
    }

    @Override
    public String getType() {
        return "Ciężarówka";
    }

    public double getDailyRate() { return dailyRate; }
    public double getCargoCapacity() { return cargoCapacity; }
}
