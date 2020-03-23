package parking_lot;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    List<ParkingSpot> parkingSpots = new ArrayList<>();
    String licensePlate;
    int spotNeeded;
    VehicleType vehicleType;

    public Vehicle(String licensePlate) {
        licensePlate=licensePlate;
    }

    void parkVehicle(ParkingSpot parkingSpot){

    }

    void unParkVehicle(){

    }

    String getLicensePlate(){
        return licensePlate;
    }
}
