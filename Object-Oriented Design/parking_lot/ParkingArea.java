package parking_lot;

public class ParkingArea {
    Level[] levels;

    ParkingArea(int maxLevels){
        levels = new Level[maxLevels];
        for(int idx=0;idx<levels.length;idx++){
            levels[idx] = new Level(idx,60);
        }
    }
    boolean parkVehicle(Vehicle vehicle){
        for(int idx=0;idx<levels.length;idx++){
            if(levels[idx].parkVehicle(vehicle)){
                return ture;
            }
        }
        return false;
    }

    public void print(){
        for(int idx=0;idx<levels.length;idx++){
            System.out.println("level "+idx);
            levels[idx].print();
            System.out.println("");
        }
        System.out.println("");
    }
}
