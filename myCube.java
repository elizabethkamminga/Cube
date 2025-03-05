//Elizabeth Kamminga
//CSCI 152
//Cube Project

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class TheCube {
    private static final int CUBE_SIZE = 3;
    private static char[][][] cube;
    private static final String[] VALID_MOVES = {
        "U", "D", "R", "L", "F", "B", "U'", "D'", "R'", "L'", "F'", "B'"
    };
    private static final String[] FACE_NAMES = {
        "Front", "Back", "Left", "Right", "Up", "Down"
    };
    private static int moveCount = 0;
    private static ArrayList<String> moveHistory = new ArrayList<>();

    // Constructor to initialize the cube
    public TheCube() {
        initializeCube();
    }

    // Method to initialize the cube with colors
    private static void initializeCube() {
        char[] colors = {'R', 'B', 'O', 'G', 'Y', 'W'};
        cube = new char[6][CUBE_SIZE][CUBE_SIZE];

        // Assign each face with its color
        for (int face = 0; face < 6; face++) {
            for (int row = 0; row < CUBE_SIZE; row++) {
                for (int col = 0; col < CUBE_SIZE; col++) {
                    cube[face][row][col] = colors[face];
                }
            }
        }
    }

    // Method to print the cube's current state
    private static void printCube() {
        for (int face = 0; face < 6; face++) {
            System.out.println("Face " + FACE_NAMES[face] + ":");

            for (int row = 0; row < CUBE_SIZE; row++) {
                for (int col = 0; col < CUBE_SIZE; col++) {
                    System.out.print(cube[face][row][col]);
                    if (col < CUBE_SIZE - 1) {
                        System.out.print("|");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Method to validate the move input
    private static boolean validateMove(String move) {
        for (String validMove : VALID_MOVES) {
            if (move.equals(validMove)) {
                return true;
            }
        }
        System.out.println("Invalid move. Enter one of: U, D, R, L, F, B, U', D', R', L', F', B'");
        return false;
    }

    // Method to solve the cube by reversing moves
    private static void solveCube() {
        System.out.println("Reversing moves to solve the cube...");

        for (int i = moveHistory.size() - 1; i >= 0; i--) {
            String move = moveHistory.get(i);
            String reversedMove = reverseMove(move);
            applyMove(reversedMove);
        }

        moveHistory.clear();
        moveCount = 0;
        System.out.println("Cube should now be in its solved state.");
    }

    // Method to reverse a move (i.e., change a move like U to U')
    private static String reverseMove(String move) {
        if (move.endsWith("'")) {
            return move.substring(0, 1);
        } else {
            return move + "'";
        }
    }

    // Method to check if the cube is solved
    private static boolean isCubeSolved() {
        for (int face = 0; face < 6; face++) {
            char color = cube[face][0][0];
            for (int row = 0; row < CUBE_SIZE; row++) {
                for (int col = 0; col < CUBE_SIZE; col++) {
                    if (cube[face][row][col] != color) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Method to shuffle the cube by applying random moves
    private static void shuffleCube() {
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            String move = VALID_MOVES[rand.nextInt(VALID_MOVES.length)];
            applyMove(move);
        }
        System.out.println("The cube has been scrambled with 20 random moves.");
    }

    // Method to apply a move to the cube
    private static void applyMove(String move) {
        if (!validateMove(move)) return;

        boolean clockwise = !move.endsWith("'");
        int faceIndex = "FBLRUD".indexOf(move.charAt(0));

        if (faceIndex != -1) {
            rotateFaceAndAdjacent(faceIndex, clockwise);
            moveHistory.add(move);
            moveCount++;
            printCube();
        } else {
            System.out.println("Invalid move detected in applyMove.");
        }
    }

    // Helper method to rotate a face and its adjacent faces
    private static void rotateFaceAndAdjacent(int face, boolean clockwise) {
        rotateFace(face, clockwise);
        // Implement adjacent face rotation logic here if needed
    }

    // Method to rotate a single face (clockwise or counter-clockwise)
    private static void rotateFace(int face, boolean clockwise) {
        char[][] tempArray = new char[CUBE_SIZE][CUBE_SIZE];

        for (int i = 0; i < CUBE_SIZE; i++) {
            for (int j = 0; j < CUBE_SIZE; j++) {
                tempArray[j][CUBE_SIZE - 1 - i] = (clockwise) ? cube[face][i][j] : cube[face][CUBE_SIZE - 1 - j][i];
            }
        }

        for (int i = 0; i < CUBE_SIZE; i++) {
            System.arraycopy(tempArray[i], 0, cube[face][i], 0, CUBE_SIZE);
        }
    }

    // Main game loop that interacts with the user
    private static void gameLoop(Scanner userInput) {
        initializeCube();
        printCube();
        moveCount = 0;

        while (true) {
            System.out.print("Enter move, 'shuffle' to scramble, 'solve' to reset, 'exit' to quit: ");
            String move = userInput.nextLine().trim();

            switch (move.toLowerCase()) {
                case "exit":
                    System.out.println("Thanks for playing!");
                    return;
                case "shuffle":
                    shuffleCube();
                    break;
                case "solve":
                    solveCube();
                    break;
                default:
                    if (validateMove(move)) {
                        applyMove(move);
                        if (isCubeSolved()) {
                            System.out.println("Congratulations! You solved the cube!");
                            return;
                        }
                    }
            }
        }
    }

    // The main method to start the program
    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("   Welcome to the Rubik's Cube Simulator!");
        System.out.println("  Solve the cube by entering valid moves.");
        System.out.println("  Commands: shuffle | solve | exit");
        System.out.println("===============================================");

        Scanner userInput = new Scanner(System.in);
        gameLoop(userInput);
        userInput.close();
    }
}