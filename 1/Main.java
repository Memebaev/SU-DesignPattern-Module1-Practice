import java.util.ArrayList;
import java.util.List;

class Vehicle {
    String marka;
    String model;
    int year;
    Vehicle(String marka, String model, int year){
        this.marka = marka;
        this.model = model;
        this.year = year;
    }
    void start(){
        System.out.println("engine start");
    }
    void stop(){
        System.out.println("engine stop");
    }
    public String getMarka(){
        return marka;
    }
    public String getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }
}

class Car extends Vehicle {
    int doors;
    String transmission;
    Car(String marka, String model, int year, int doors, String transmission) {
        super(marka, model, year);
        this.doors = doors;
        this.transmission = transmission;
    }
    public String toString() {
        return marka + " " + model + " " + year + " " + doors + " " + transmission;
    }
}

class Motorcycle extends Vehicle {
    String kuzov;
    boolean box;
    Motorcycle(String marka, String model, int year, String kuzov, boolean box) {
        super(marka, model, year);
        this.kuzov = kuzov;
        this.box = box;
    }
    public String toString() {
        return marka + " " + model + " " + year + " " + kuzov + " " + box;
    }
}

class Garage {
    List<Vehicle> vehicleList;
    Garage(){
        this.vehicleList = new ArrayList<>();
    }
    void addVehicle(Vehicle vehicle){
        vehicleList.add(vehicle);
    }
    void removeVehicle(Vehicle vehicle){
        vehicleList.remove(vehicle);
    }
    List<Vehicle> getVehicles() {
        return vehicleList;
    }
    public String toString() {
        return "Garage [Vehicles=" + vehicleList + "]";
    }
}

class Fleet {
    List<Garage> garageList;
    Fleet(){
        this.garageList = new ArrayList<>();
    }
    void addGarage(Garage garage){
        garageList.add(garage);
    }
    void removeGarage(Garage garage){
        garageList.remove(garage);
    }
    List<Garage> getGarages() {
        return garageList;
    }
    List<Vehicle> findVehicle(String marka, String model, int year){
        List<Vehicle> foundVehicles = new ArrayList<>();
        for (Garage garage : garageList){
            for (Vehicle vehicle : garage.getVehicles()){
                if (vehicle.getMarka().equals(marka) && vehicle.getModel().equals(model) && vehicle.getYear() == year) {
                    foundVehicles.add(vehicle);
                }
            }
        }
        return foundVehicles;
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Chevrolet", "Onyx", 2222, 4, "type1");
        System.out.println(car1);
        Car car2 = new Car("Opel", "Vectra", 1998, 4, "type2");
        System.out.println(car2);
        Motorcycle motor1 = new Motorcycle("marka3", "model3", 3333, "idk", true);
        System.out.println(motor1);

        Garage garage1 = new Garage();
        garage1.addVehicle(car1);
        garage1.addVehicle(car2);
        System.out.println("Garage 1: " + garage1.getVehicles());

        Garage garage2 = new Garage();
        garage2.addVehicle(motor1);
        System.out.println("Garage 2: " + garage2.getVehicles());

        garage1.removeVehicle(car2);
        System.out.println("Garage 1: " + garage1.getVehicles());

        Fleet fleet1 = new Fleet();
        fleet1.addGarage(garage1);
        fleet1.addGarage(garage2);
        System.out.println("Fleet 1: " + fleet1.getGarages());

        fleet1.removeGarage(garage2);
        System.out.println("Fleet 1: " + fleet1.getGarages());
    }
}