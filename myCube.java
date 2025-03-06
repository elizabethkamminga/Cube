//Elizabeth Kamminga
//CSCI 152
//Cube Project

import java.util.ArrayList;
import java.util.Scanner;

public class myCube {
    static char[][][] cube = {
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

    static void rotateFaceClockwise(char[][] face) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[j][2 - i] = face[i][j];
            }
        }
        // Copy the rotated values back
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                face[i][j] = temp[i][j];
            }
        }
    }

    static void rotateFaceCounterClockwise(char[][] face) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = face[j][i];
            }
        }
    
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                face[i][j] = temp[i][j];
            }
        }
    }

    static void moveU() {
        rotateFaceClockwise(cube[0]);
        char[] temp = cube[2][0];
        cube[2][0] = cube[3][0];
        cube[3][0] = cube[4][0];
        cube[4][0] = cube[5][0];
        cube[5][0] = temp;
    }

    static void moveD() {
        rotateFaceClockwise(cube[1]);
        char[] temp = cube[2][2];
        cube[2][2] = cube[5][2];
        cube[5][2] = cube[4][2];
        cube[4][2] = cube[3][2];
        cube[3][2] = temp;
    }

    static void moveL() {
        rotateFaceClockwise(cube[5]);
        for (int i = 0; i < 3; i++) {
            char temp = cube[0][i][0];
            cube[0][i][0] = cube[2][i][0];
            cube[2][i][0] = cube[1][2 - i][0];
            cube[1][2 - i][0] = cube[4][i][2];
            cube[4][i][2] = temp;
        }
    }

    static void moveR() {
        rotateFaceClockwise(cube[3]);
        for (int i = 0; i < 3; i++) {
            char temp = cube[0][i][2];
            cube[0][i][2] = cube[4][i][0];
            cube[4][i][0] = cube[1][2 - i][2];
            cube[1][2 - i][2] = cube[2][i][2];
            cube[2][i][2] = temp;
        }
    }

    static void moveF() {
        rotateFaceClockwise(cube[2]);
        char[] temp = cube[0][2];
        cube[0][2] = cube[5][0];
        cube[5][0] = cube[4][0];
        cube[4][0] = cube[1][2];
        cube[1][2] = temp;
    }

    static void moveB() {
        rotateFaceClockwise(cube[3]);
        char[] temp = cube[0][0];
        cube[0][0] = cube[1][0];
        cube[1][0] = cube[4][2];
        cube[4][2] = cube[5][2];
        cube[5][2] = temp;
    }

    static void printCube() {
        for (char[][] face : cube) {
            for (char[] row : face) {
                System.out.println(row[0] + "|" + row[1] + "|" + row[2]);
            }
            System.out.println();
        }
    }

    static void solve(ArrayList<String> moves) {
        System.out.println("Solving with moves: " + moves);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<String> stack = new ArrayList<>();
        int index = 0;
        boolean play = true;
        boolean display = true;

        while (play) {
            String move;
            if (index < args.length) {
                move = args[index++];
            } else {
                move = scn.nextLine();
                if (move.equalsIgnoreCase("Q")) {
                    play = false;
                    break;
                }
            }

            switch (move.toUpperCase()) {
                case "U":
                    stack.add("U'");
                    moveU();
                    break;
                case "U'":
                    stack.add("U");
                    moveU();
                    break;
                case "D":
                    stack.add("D'");
                    moveD();
                    break;
                case "D'":
                    stack.add("D");
                    moveD();
                    break;
                case "L":
                    stack.add("L'");
                    moveL();
                    break;
                case "L'":
                    stack.add("L");
                    moveL();
                    break;
                case "R":
                    stack.add("R'");
                    moveR();
                    break;
                case "R'":
                    stack.add("R");
                    moveR();
                    break;
                case "F":
                    stack.add("F'");
                    moveF();
                    break;
                case "F'":
                    stack.add("F");
                    moveF();
                    break;
                case "B":
                    stack.add("B'");
                    moveB();
                    break;
                case "B'":
                    stack.add("B");
                    moveB();
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

            if (display) printCube();
        }
        scn.close();
    }
}