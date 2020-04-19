package parking_lot;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    List<ParkingSpot> parkingSpots = new ArrayList<>();
    String licensePlate;
    int spotsNeeded;
    VehicleType vehicleType;

    void parkInSpot(ParkingSpot parkingSpot){
        parkingSpot.add(parkingSpot);
    }

    void clearSpot(){
        for(int idx=0;idx<parkingSpots.size();idx++){
            parkingSpots.get(idx).removeVehicle();
        }
        parkingSpots.clear();
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean canFitInSpot(ParkingSpot spot);

    public void print();

}
