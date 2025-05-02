package Animals;

public class Dog {
    String name;
    public Dog(){
        System.out.println("Dog was created");
    }
    public Dog(String name){
        this.name = name;
        System.out.println("Dog was created named: " + this.name);
    }
}

public static void main(String [] args){
    
    class Dog{
        private int mood;
        private int hungry;
        private int energy;
        private void woof() {
            System.out.println("woof");
        }

        public void feed(){
            mood++;
            hungry--;
            woof();
        }

        public void sleep(){
            energy++;
            hungry++;
            woof();

        public void play() {
            mood++;
            energy--;
            makeSound();
        }
        }
    }
}