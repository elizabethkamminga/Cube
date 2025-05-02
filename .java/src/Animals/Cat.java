package Animals;

public class Cat {
    String name;
    public Cat(){
        System.out.println("Cat was created");
    }
    public Cat(String name){
        this.name = name;
        System.out.println("Cat was created named: " + this.name);
    }
}

public static void main(String [] args){
    
    class Cat{
        private int mood;
        private int hungry;
        private int energy;
        private void meow() {
            System.out.println("meow");
        }

        public void feed(){
            mood++;
            hungry--;
            meow();
        }

        public void sleep(){
            energy++;
            hungry++;
            meow();
        }
    }
}