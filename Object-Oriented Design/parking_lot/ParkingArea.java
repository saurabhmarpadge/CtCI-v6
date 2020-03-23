package parking_lot;

public class ParkingArea {
    Level[] levels;
    ParkingArea(int maxLevels){
        levels = new Level[maxLevels];
        for(int idx=0;idx<levels.length;idx++){
            levels[idx] = new Level(idx,60);
        }
    }
    void parkVehicle(Vehicle vehicle){
        for(int idx=0;idx<levels.length;idx++){
            if(levels[idx].isParkingAvailable(vehicle)){
                levels[idx].parkVehicle();
                return;
            }
        }
    }

    void unParkVehicle(Vehicle vehicle){
        vehicle.unParkVehicle();
    }
}
