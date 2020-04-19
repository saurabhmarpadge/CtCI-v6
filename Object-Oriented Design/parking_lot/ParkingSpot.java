package parking_lot;

public class ParkingSpot {
    Vehicle vehicle;
    VehicleType vehicleType;
    int row;
    Level level;
    int spotNumber

    ParkingSpot(int rowNo, Level lvl, int spotNumber, VehicleType vType){
        row = rowNo;
        level = lvl;
        spotNumber = spotNumber;
        vehicleType = vType;
    }

    public boolean isAvailable(){
        return vehicle==null;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    public boolean parkVehicle(Vehicle vehicle){
        if(!canFitVehicle(vehicle)){
            return false;
        }
        vehicle = vehicle;
        vehicle.parkInSpot(this);
        return true;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getRow() {
        return row;
    }

    public Level getLevel() {
        return level;
    }

    public void removeVehicle(){
        level.spotFreed();
        vehicle = null;
    }

    public void print(){
        if(vehicle==null){
            if(vehicleType==vehicleType.MOTORBIKE){
                System.out.println("m");
            } else if(vehicleType==vehicleType.COMPACT){
                System.out.println("c");
            } else if(vehicleType==vehicleType.LARGE){
                System.out.println("l");
            }
        } else {
            vehicle.print();
        }
    }
}
