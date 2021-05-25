package sk.kosickaakademia.matolak.tictactoce15x15;

public class Main {

    int[][] gameMap = new int[][]{
            {0, 1, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 2, 1, 2, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 2, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 2, 0, 0, 1, 1, 1, 2, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}

    };
    void printGameMap(){
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                System.out.print(gameMap[i][j]);
            }
            System.out.println();
        }
        System.out.println();
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


    public static void main(String[] args) {
        Main main = new Main();
        main.printGameMap();
        main.findWinnerInRow();
    }

}
