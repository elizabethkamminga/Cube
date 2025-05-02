package places;

import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import pets.*;
import species.*;

public class Zootropolis {
    ArrayList<Zootopian> residents = new ArrayList<>();
    ArrayList<Zootropolis> neighbors = new ArrayList<>();
    String name = "";
    Random random = new Random();
    List<String> namesList;

    public Zootropolis(String name, int resident_num){
        this.name = name;
        loadNames();

        for (int i=0; i < resident_num; i++){
            Zootopian creature = createCreature();
            if (creature instanceof Pet) {
                ((Pet) creature).name = getRandomName();
            }
            residents.add(creature);
        }
    }

    private void loadNames() {
        try {
            namesList = Files.readAllLines(Paths.get("names.txt"));
        }
        catch (IOException e) {
            e.printStackTrace();
            namesList = List.of("DefaultName");
        }
    }

    private String getRandomName() {
        return namesList.get(random.nextInt(namesList.size()));
    }

    public Zootopian createCreature() {

        Class<?>[] types = {Bellwether.class, Chief.class, Finnick.class, Gazelle.class, Judy.class, Nick.class, Yak.class};
        Class<?> type = types[random.nextInt(types.length)];

        try {
            return (Zootopian) type.getDeclaredConstructor().newInstance();
          
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Zootopian> getResidents(){
        return residents;
    }
//cannot get this to work lol
    public void runSim() {
        for (int day = 1; day <= 5; day++) {
            System.out.println("Day " + day + " begins with " + residents.size() + " residents.");
            ArrayList<Zootopian> newResidents = new ArrayList<>();
    
            for (Zootopian z : new ArrayList<>(residents)) {
                if (random.nextDouble() < 0.2) {
                    System.out.println(((Pet) z).name + " has died.");
                    residents.remove(z);
                }
                else if (random.nextDouble() < 0.3) {
                    Zootopian baby = createCreature();
                    if (baby != null && baby instanceof Pet) {
                        ((Pet) baby).name = getRandomName();
                        newResidents.add(baby);
                        System.out.println(((Pet) z).name + " has reproduced!");
                    }
                }
            }
            residents.addAll(newResidents);
            System.out.println("Day " + day + " ends with " + residents.size() + " residents.\n");
        }
    }
}
