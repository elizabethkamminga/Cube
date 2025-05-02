import java.util.ArrayList;
import java.util.Scanner;

public class ExampleCube {
    static char[][][] cube =    {
                                    {
                                        {'w','w','w'},
                                        {'w','w','w'},
                                        {'w','w','w'}
                                    },
                                    {
                                        {'b','b','b'},
                                        {'b','b','b'},
                                        {'b','b','b'}
                                    },
                                    {
                                        {'r','r','r'},
                                        {'r','r','r'},
                                        {'r','r','r'}
                                    },
                                    {
                                        {'g','g','g'},
                                        {'g','g','g'},
                                        {'g','g','g'}
                                    },
                                    {
                                        {'y','y','y'},
                                        {'y','y','y'},
                                        {'y','y','y'}
                                    },
                                    {
                                        {'o','o','o'},
                                        {'o','o','o'},
                                        {'o','o','o'}
                                    }
                                };

    static void solve(ArrayList<String> stack){
        System.out.print("Solution: ");
        for(int i = stack.size() - 1; i>=0; i--){
            System.out.print(stack.get(i));
            stack.remove(i);
        }
    }

    static void printCube(){
        System.out.println();
        for(int i = 0; i< cube.length; i++){
            for(int j = 0; j< cube[i].length; j++){
                for(int k = 0; k< cube[i][j].length; k++){
                    System.out.print(cube[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }


    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        ArrayList<String> stack = new ArrayList<>();

        ///
        boolean play = true;

        int argsCount = args.length;
        int argsCurrent = 0;

        boolean display = false;

        while(play){
            String move;

            if(argsCount > argsCurrent){
                move = args[argsCurrent];
                argsCurrent++;
            }else{
                display = true;
                move = scn.nextLine();
            }
            
        ///
            switch (move.toUpperCase()) {
                case "U":
                    stack.add("U'");
                    break;
                case "U'":
                    stack.add("U");
                    break;
                case "D":
                    stack.add("D'");

                    break;
                case "D'":
                    stack.add("D");
                    break;
                case "L":
                    stack.add("L'");
                    break;
                case "L'":
                    stack.add("L");
                    break;
                case "R":
                    stack.add("R'");
                    break;
                case "R'":
                    stack.add("R");
                    break;
                case "F":
                    stack.add("F'");
                    break;
                case "F'":
                    stack.add("F");
                    break;

                case "B":
                    stack.add("B'");
                    break;
                
                case "B'":
                    stack.add("B");
                    break;

                case "S":
                    solve(stack);
                    break;

                case "Q":
                    play = false;
                    break;
                default:
                    System.out.println("Bad! Very Bad!!");
                    break;
            }

            if(display) printCube();
        }

        scn.close();
    }
}





