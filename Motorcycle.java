public class Motorcycle extends Vehicle implements Rentable {
    private double dailyRate;

    public Motorcycle(String brand, String model, int year, double dailyRate) {
        super(brand, model, year);
        this.dailyRate = dailyRate;
    }

    @Override
    public double rent(int days) {
        // zniżka 10% dla motocykli
        return days * dailyRate * 0.9;
    }

    @Override
    public String getType() {
        return "Motocykl";
    }

    public double getDailyRate() { return dailyRate; }
}
