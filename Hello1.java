public class Hello {
    public static void main(String[] args){
        String s = "10.0000001";

        // float f = Float.parseFloat(s);

        args[0] = args[0] + 10.001234f;

        System.out.println(args[0]);
    }
}