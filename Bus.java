public class Bus extends Vehicle implements Rentable {
    private double dailyRate;
    private int seats;

    public Bus(String brand, String model, int year, double dailyRate, int seats) {
        super(brand, model, year);
        this.dailyRate = dailyRate;
        this.seats = seats;
    }

    @Override
    public double rent(int days) {
        // większa opłata za autobus, ale z rabatem przy dłuższych wynajmach
        double base = days * dailyRate;
        if (days >= 7) base *= 0.9; // 10% rabatu przy tygodniowym wynajmie
        return base;
    }

    @Override
    public String getType() {
        return "Autobus";
    }

    public int getSeats() { return seats; }
}
