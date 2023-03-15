import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] arr = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        draw(arr);
        play(arr);
    }

    static void draw(char[][] arr) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.print(" |\n");
        }
        System.out.println("---------");

    }

    static void play(char[][] arr) {
        Scanner scanner = new Scanner(System.in);
        Check Check = new Check();
        int total = 0;

        System.out.println("Enter the number of row and column:");
        while (true) {
            if (scanner.hasNextInt()) {
                int r = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    int c = scanner.nextInt();
                    if (r >= 1 && r <= 3 && c >= 1 && c <= 3) {
                        if (arr[r-1][c-1] != ' ') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            if (total % 2 == 0) {
                                arr[r-1][c-1] = 'X';
                            } else {
                                arr[r-1][c-1] = 'O';
                            }
                            total++;
                            draw(arr);
                            Check.check(arr);
                            if (Check.getX()) {
                                System.out.println("X wins");
                                break;
                            } else if (Check.getO()) {
                                System.out.println("O wins");
                                break;
                            } else if (Check.getFlag()) {
                                System.out.println("Draw");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                } else {
                    scanner.nextLine();
                    System.out.println("You should enter numbers!");
                }
            } else {
                scanner.nextLine();
                System.out.println("You should enter numbers!");
            }
        }
    }

}
