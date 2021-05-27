package sk.kosickaakademia.matolak.tictactoce15x15;

import java.util.Scanner;

public class Main {

    int[][] gameMap = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}

    };

    boolean gameOver = false;
    int player = 1;

    void printGameMap(){
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                System.out.print(gameMap[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void playGame() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Player " + player + " choosing first coordinate: ");
        int x = scanner.nextInt() - 1;
        System.out.println();
        System.out.print("Player " + player + " choosing second coordinate: ");
        int y = scanner.nextInt() -1;
        System.out.println();
        if (gameMap[x][y] == 0) {
            gameMap[x][y] = player;
            if (player == 1){
                this.player = 2;
            }else{
                this.player = 1;
            }
        } else {
            System.out.println("Place is not empty");
        }


    }


    void findWinnerInRow(){
        int temp = 0;
        outerloop:
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length-4; j++) {
                if (gameMap[i][j]!=0&&gameMap[i][j] ==gameMap[i][j+1]&&temp != 5){
                    temp = 0;
                    int winner = gameMap[i][j];
                    int[]tempArray = new int[5];
                    int tempArrayPos = 0;
                    for (int k = j;k < j + 5;k++){
                        if(gameMap[i][k]==winner){
                            temp++;
                            tempArray[tempArrayPos] = gameMap[i][j];
                            tempArrayPos++;
                            if (temp == 5){
                                System.out.println("The winner is player number " + winner);
                                this.gameOver = true;


                                break outerloop;
                            }
                        }else{
                            break;
                        }
                    }
                }
            }
        }
    }

    void findWinnerInDiagonal(){
        int r = 15;
        int s = 15;
        int i,j;
        int winner;
        outerloop:
        for(i=0;i<r;i++){
            for(j=0;j<s;j++){
                if(j<=10 && i<=10 && gameMap[i][j]*gameMap[i+1][j+1]*gameMap[i+2][j+2]*gameMap[i+3][j+3]*gameMap[i+4][j+4]==1){
                    winner = 1;
                    System.out.println("The winner is player number " + winner);
                    this.gameOver = true;
                    break outerloop;
                }
                if(j<=10 && i<=10 && gameMap[i][j]*gameMap[i+1][j+1]*gameMap[i+2][j+2]*gameMap[i+3][j+3]*gameMap[i+4][j+4]==32){
                    winner = 2;
                    System.out.println("The winner is player number " + winner);
                    this.gameOver = true;
                    break outerloop;
                }
                if(j>=4 && i<=10 && gameMap[i][j]*gameMap[i+1][j-1]*gameMap[i+2][j-2]*gameMap[i+3][j-3]*gameMap[i+4][j-4]==1){
                    winner = 1;
                    System.out.println("The winner is player number " + winner);
                    this.gameOver = true;
                    break outerloop;
                }
                if(j>=4 && i<=10 && gameMap[i][j]*gameMap[i+1][j-1]*gameMap[i+2][j-2]*gameMap[i+3][j-3]*gameMap[i+4][j-4]==32){
                    winner = 2;
                    System.out.println("The winner is player number " + winner);
                    this.gameOver = true;
                    break outerloop;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        while (main.gameOver==false){
            main.playGame();
            main.printGameMap();
            main.findWinnerInRow();
            main.findWinnerInDiagonal();

        }
    }

}
