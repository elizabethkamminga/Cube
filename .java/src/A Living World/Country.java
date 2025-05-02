import java.util.ArrayList;
import places.Zootropolis;

public class Country {

    static ArrayList<Zootropolis> network = new ArrayList<>();

    public static void main(String[] args) {
        Zootropolis zootopia = new Zootropolis("Zootopia", 20);

        network.add(zootopia);

        System.out.println("Welcome to " + zootopia.name + "!");
        System.out.println("Initial population: " + zootopia.getResidents().size() + " residents.\n");

        zootopia.runSim();

        System.out.println("Simulation complete.");
        System.out.println("Final population: " + zootopia.getResidents().size() + " residents.");
    }
}