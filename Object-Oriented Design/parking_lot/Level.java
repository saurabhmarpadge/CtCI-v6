package parking_lot;

public class Level {
    int floorNumber;
    ParkingSpot[] parkingSpots;
    int availableSpot;
    private static final int MAX_ROW_SIZE = 10;

    public Level(int floorNo, int noOfSpots) {
        floorNumber=floorNo;
        parkingSpots = new ParkingSpot[noOfSpots];
        for(int idx=0;idx<noOfSpots;idx++){
            parkingSpots[idx] = new ParkingSpot();
        }
        availableSpot=noOfSpots;
    }

    public boolean isParkingAvailable(Vehicle vehicle) {
        return availableSpot>0;
    }

    public void parkVehicle() {

    }
}
