public class magicMatrix {
    static int[][] matrix = {
            {
                    16, 3, 2, 13
            },
            {
                    5, 10, 11, 8
            },
            {
                    9, 6, 7, 12
            },
            {
                    4, 15, 14, 1
            },
    };

    public static boolean isRowMagic(int sum) {

        for (int i = 0; i < 4; i++) {
            int sumR = 0;
            for (int j = 0; j < 4; j++) {
                sumR = sumR + matrix[i][j];
            }
            if (sumR == sum) {

            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isColMagic(int sum) {

        for (int j = 0; j < 4; j++) {
            int sumR = 0;
            for (int i = 0; i < 4; i++) {
                sumR = sumR + matrix[i][j];
            }
            if (sumR == sum) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isMainDiagonalMagic(int sum) {
        int sumR = 0;
        for (int i = 0; i < 4; i++) {
            sumR = sumR + matrix[i][i];
        }
        if (sumR == sum) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSecondDiagonalMagic(int sum) {
        int sumR = 0;
        for (int i = 0; i < 4; i++) {
            sumR = sumR + matrix[i][3 - i];
        }
        if (sumR == sum) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int sum = matrix[0][0] + matrix[0][1] + matrix[0][2] + matrix[0][3];

        if (isRowMagic(sum) && isColMagic(sum) && isMainDiagonalMagic(sum) && isSecondDiagonalMagic(sum)) {
            System.out.println("The matrix is magic is MAGIC ...Bingo");
        } else {
            System.out.println("The matrix is NOT MAGIC !");
        }
    }
}
