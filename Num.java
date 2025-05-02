import java.util.Random;

Random rand = new Random(1234L);

public class Num {
    public static void main(String[] args){

        String[] moves = {"U", "U'", "D", "D'", "L", "L'", "R", "R'", "F", "F'", "B", "B'"};

        switch(moves[rand.nextInt(12)]) {
            case "U":
                System.out.println();
                break;
            case "U'":
                System.out.println();
                break;
            case "D":  
                System.out.println();          
                break;
            case "D'":
                System.out.println();
                break;
            case "L":
                System.out.println();
                break;
            case "L'":
                System.out.println();
                break;
            case "F":
                System.out.println();
                break;
            case "F'":
                System.out.println();
                break;
            case "B":
                System.out.println();
                break;
            case "B'":
                System.out.println();
                break;
            default:
                break;
        
        }
    }
}

public static void main(String[] args) {
    Random rand = new Random();

    System.out.println(rand.nextInt()); 
}

public int nextInt(int bound) {
    if (bound <= 0)
        throw new IllegalArgumentException("bound must be positive");
    
    if ((bound & -bound) == bound) 
        return (int)((bound * (long)next(31)) >> 31);

    int bits, val;
    do {
        bits = next(31);
        val = bits % bound;
    } while (bits - val + (bound-1) < 0);
    return val;
}