import java.util.Arrays;
import java.util.Scanner;

public class multuMatrix {
    public static int[][] multiMatrix(int[][] array1, int[][] array2) {
        int[][] array3 = new int[array1.length][array1.length];
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                array3[i][j] = array1[i][j] * array2[j][i];
            }
        }
        return array3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input length of two Matrix : ");
        int l = sc.nextInt();
        int[][] array1 = new int[l][l];
        int[][] array2 = new int[l][l];
        System.out.println("Input numbers of first Matrix : ");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                array1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Input numbers of Matrix TWO : ");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                array2[i][j] = sc.nextInt();

            }
        }
        System.out.println(Arrays.deepToString(multiMatrix(array1, array2)));

    }
}
//ÒÀÇÈ ß ÏĞÅÁÎĞÈÕ



