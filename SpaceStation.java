package places;
import java.util.ArrayList;
import java.util.Random;

import organism.*;
import type.*;

public class SpaceStation {
    ArrayList<Alien> residents = new ArrayList<>();
    ArrayList<SpaceStation> neighbors = new ArrayList<>();
    String name = "";
    Random random = new Random();

    public SpaceStation(String name, int resident_num){
        this.name = name;

        Class<?>[] types = {Alan.class, Belter.class, Klingon.class, Viltromite.class, FaceHugger.class, Vulcan.class};

        for(int i = 0; i<resident_num; i++){
            Class<?> type = types[random.nextInt(types.length)];
            try {
                residents.add((Alien) type.getDeclaredConstructor().newInstance());
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Alien> getResidents(){
        return residents;
    }

    public void runSim(){

    }
}
