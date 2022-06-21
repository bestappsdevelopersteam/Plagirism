import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
public class plagirismDetector {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter first text and press ENTER : ");
        String textOne = sc.nextLine();
        textOne = textOne.toLowerCase();
        List<String> firstSentenseWords = new ArrayList<String>(Arrays.asList(textOne.split("([,.!?_;=+-:\\s]+)")));
        for (int i = 0; i < firstSentenseWords.size(); i++) {
        //    System.out.println(firstSentenseWords.get(i));
        }
        List<String> firstSentense = new ArrayList<String>(Arrays.asList(textOne.split("([.!?;:]+)")));
        for (int i = 0; i < firstSentense.size(); i++) {
          //  System.out.println(firstSentense.get(i));
                    }

        System.out.println("Please enter second text and press ENTER : ");
        String textTwo = sc.nextLine();
        List<String> secondSentenseWords = new ArrayList<String>(Arrays.asList(textTwo.split("([,.!?_;=+-:\\s]+)")));
        for (int i = 0; i < secondSentenseWords.size(); i++) {
            System.out.println(secondSentenseWords.get(i));

        }
    }
}
