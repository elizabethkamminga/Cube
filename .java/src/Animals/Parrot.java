package Animals;

public class Parrot {
    String name;
    public Parrot(){
        System.out.println("Parrot was created");
    }
    public Parrot(String name){
        this.name = name;
        System.out.println("Parrot was created named: " + this.name);
    }
}
public static void main(String [] args){
    
    class Parrot{
        private int mood;
        private int hungry;
        private int energy;
        private void kaw() {
            System.out.println("kaw");
        }

        public void feed(){
            mood++;
            hungry--;
            kaw();
        }

        public void sleep(){
            energy++;
            hungry++;
            kaw();
        }
    }
}