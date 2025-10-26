public class Car extends Vehicle implements Rentable {
    private double dailyRate;

    public Car(String brand, String model, int year, double dailyRate) {
        super(brand, model, year);
        this.dailyRate = dailyRate;
    }

    @Override
    public double rent(int days) {
        return days * dailyRate;
    }

    @Override
    public String getType() {
        return "Samochód";
    }

    public double getDailyRate() { return dailyRate; }
}
