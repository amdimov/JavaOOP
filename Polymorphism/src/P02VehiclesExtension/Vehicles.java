package P02VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicles {
    protected double fuel;
    protected double fuelConsumption;
    protected double tankCapacity;

    protected Vehicles(double fuel, double fuelConsumption, double tankCapacity){
        setFuelConsumption(fuelConsumption);
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }
    public abstract void refuel(double liters);
    protected abstract void setFuelConsumption(double fuelConsumption);

    public double getFuelQuantity() {
        return this.fuel;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public String drive(double km) {
        String result;
        DecimalFormat hashes = new DecimalFormat("#.##");
        double fuelToConsume = km*this.fuelConsumption;
        if (fuelToConsume <= this.fuel){
            if(this.fuel - fuelToConsume < 0){
                result = "Fuel must be a positive number";
                return result;
            }
            result = String.format("travelled %s km", hashes.format(km));
            this.fuel -= fuelToConsume;
        }else {
            result = "needs refueling";
        }
        return result;
    }
    protected boolean validateInput(double liters){
        if (this.fuel+liters > this.tankCapacity){
            System.out.println("Cannot fit fuel in tank");
            return false;
        }else if (liters <= 0){
            System.out.println("Fuel must be a positive number");
            return false;
        }
        return true;
    }
    protected double getFuel() {
        return fuel;
    }
    protected double getTankCapacity() {
        return tankCapacity;
    }
}
