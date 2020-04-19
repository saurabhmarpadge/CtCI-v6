package parking_lot;

public class Car extends Vehicle {
    public Car(){
        spotsNeeded = 1;
        vehicleType = VehicleType.COMPACT;
    }
    public boolean canFitInSpot(ParkingSpot spot){
        return spot.getSize()==VehicleType.LARGE || spot.getSize()==VehicleType.COMPACT;
    }

    public void print(){
        System.out.println("Car");
    }
}
