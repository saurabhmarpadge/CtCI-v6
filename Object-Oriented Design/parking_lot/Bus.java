package parking_lot;

public class Bus extends Vehicle {
    public Bus(){
        spotsNeeded = 5;
        vehicleType = VehicleType.LARGE;
    }
    public boolean canFitInSpot(ParkingSpot spot){
        return spot.getSize()==vehicleType;
    }

    public void print(){
        System.out.println("Bus");
    }
}
