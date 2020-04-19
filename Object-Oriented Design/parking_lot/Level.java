package parking_lot;

public class Level {
    int floorNumber;
    ParkingSpot[] parkingSpots;
    int availableSpot;
    private static final int MAX_ROW_SIZE = 10;

    public Level(int floorNo, int  ) {
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

    public void parkVehicle(Vehicle vehicle) {
        if(availableSpot<vehicle.getSpotsNeeded()){
            return false;
        }
        int spotNumber = findAvailableSpot(vehicle);
        if(spotNumber<0){
            return false;
        }
        return parkStartingAtSpot(spotNumber,vehicle);
    }

    private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle){
        vehicle.clearSpots();
        boolean success = true;
        for(int idx=spotNumber;idx<spotNumber+vehicle.spotsNeeded;idx++){
            success&=parkingSpots[i].park(vehicle);
        }
        availableSpot-=vehicle.spotsNeeded;
        return success;
    }

    private int findAvailableSpot(Vehicle vehicle){
        int spotsNeeded = vehicle.getSpotsNeede();
        int lastRow = -1;
        int spotsFound = 0;
        for(int idx=0;idx<parkingSpots.length;idx++){
            ParkingSpot spot = parkingSpots[idx];
            if(lastRow!=spot.getRow()){
                sportsFound=0;
                lastRow = spot.getRow();
            }
            if(spot.canFitVehicle(vehicle)){
                spotsFound++;
            } else {
                spotsFound=0;
            }
            if(spotsFound==spotsNeeded){
                return idx - spotsFound + 1;
            }
        }
        return -1;
    }

    public void print(){
        int lastRow=-1;
        for(int idx=0;idx<parkingSpots.length;idx++){
            ParkingSpot spot = parkingSpots[idx];
            if(spot.getRow()!=lastRow){
                System.out.println(" ");
                lastRow = spot.getRow();
            }
            spot.print();
        }
    }

    public void spotFreed(){
        availableSpot++;
    }
}
