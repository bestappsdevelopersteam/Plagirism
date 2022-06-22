import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class plagirismDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter first text and press ENTER : ");
        String textOne = sc.nextLine();
        textOne = textOne.toLowerCase();
        List<String> firstTextWords = new ArrayList<>(Arrays.asList(textOne.split("([,.!?_;=+-:\\s]+)")));
        for (int i = 0; i < firstTextWords.size(); i++) {
//            System.out.println(firstTextWords.get(i));
        }
        int firstTextWordsCount = firstTextWords.size();
//        System.out.println(firstTextWordsCount);
        List<String> firstTextSentence = new ArrayList<>(Arrays.asList(textOne.split("([.!?;:]+)")));
        for (int i = 0; i < firstTextSentence.size(); i++) {
//            System.out.println(firstTextSentence.get(i));
        }
        int firstTextSentenceCount = firstTextSentence.size();
//        System.out.println(firstTextSentenceCount);

        System.out.println("Please enter second text and press ENTER : ");
        String textTwo = sc.nextLine();
        textTwo = textTwo.toLowerCase();
        List<String> secondTextWords = new ArrayList<>(Arrays.asList(textTwo.split("([,.!?_;=+-:\\s]+)")));
        for (int j = 0; j < secondTextWords.size(); j++) {
//            System.out.println(secondTextWords.get(j));
        }
        int secondTextWordsCount = secondTextWords.size();
//        System.out.println(secondTextWordsCount);
        List<String> secondTextSentence = new ArrayList<>(Arrays.asList(textTwo.split("([.!?;:]+)")));
        for (int j = 0; j < secondTextSentence.size(); j++) {
//            System.out.println(secondTextSentence.get(j));
        }
        int secondTextSentenceCount = secondTextSentence.size();
//        System.out.println(secondTextSentenceCount);
//        ..................................

        countAverageLengthElementOfText(firstTextWords);
        //    System.out.println(countAverageLengthElementOfText(firstTextWords)); // return averageLengthEachElement
    }


    public static double countAverageLengthElementOfText(List<String> array) {
        double arSize = array.size();
        double lengthEachElement = 0;
        double sumLengthEachElement = 0;
        double averageLengthEachElement = 0;
        for (int i = 0; i < arSize; i++) {               //for (String s : array) {
            lengthEachElement = array.get(i).length();   //lengthEachElement = s.length();
            sumLengthEachElement += lengthEachElement;
        }
        averageLengthEachElement = sumLengthEachElement / arSize;
        return averageLengthEachElement;

    }
    }


}
