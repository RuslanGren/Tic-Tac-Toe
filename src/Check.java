public class Check {
    private boolean X;
    private boolean O;
    private boolean flag;

    public void check(char[][] arr) {
        int countVertical = 0, countHorizontal = 0;
        int countDiagonalLeft = 0, countDiagonalRight = 0;
        flag = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                countVertical += arr[i][j];
                countHorizontal += arr[j][i];
                if (arr[i][j] == ' ') {
                    flag = false;
                }
            }

            if (countVertical == 264 || countHorizontal == 264) {
                X = true;
            } else if (countVertical == 237 || countHorizontal == 237) {
                O = true;
            }
            countVertical = 0;
            countHorizontal = 0;
            countDiagonalLeft += arr[i][i];
            countDiagonalRight += arr[i][2-i];
        }

        X = X || countDiagonalLeft == 264 || countDiagonalRight == 264;
        O = O || countDiagonalLeft == 237 || countDiagonalRight == 237;
    }

    public boolean getX() {
        return X;
    }

    public boolean getO() {
        return O;
    }

    public boolean getFlag() {
        return flag;
    }
}

