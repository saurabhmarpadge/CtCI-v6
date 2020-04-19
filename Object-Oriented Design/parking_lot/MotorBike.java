package parking_lot;

public class MotorBike extends Vehicle {
    public MotorBike(){
        spotsNeeded = 1;
        vehicleType = VehicleType.MOTORBIKE;
    }
    public boolean canFitInSpot(ParkingSpot spot){
        return true;
    }

    public void print(){
        System.out.println("MotorBike");
    }
}