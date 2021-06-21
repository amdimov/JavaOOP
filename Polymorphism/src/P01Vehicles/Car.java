package P01Vehicles;

public class Car extends Vehicles {

    public Car(double fuel, double fuelConsumption) {
        super(fuel, fuelConsumption);
    }

    @Override
    public void refuel(double liters) {
        super.fuel += liters;
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        fuelConsumption += 0.9;
        this.fuelConsumption = fuelConsumption;
    }
    public void test(){
        System.out.println("test");
    }
}
