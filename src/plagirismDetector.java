import java.util.*;

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

//        countAverageLengthElementOfText(firstTextWords);
//        System.out.println(countAverageLengthElementOfText(firstTextWords)); // return averageLengthEachElement(in our case words)
//        typeTokenRation(firstTextWords);
        System.out.println(typeTokenRation(firstTextWords)); // return unique words divided on all words form inputted text.


    }


    public static double countAverageLengthElementOfText(List<String> array) {// method return averageLengthEachElement(in our case words)
        double arSize = array.size();
        double lengthEachElement = 0;
        double sumLengthEachElement = 0;
        double averageLengthEachElement = 0;
        for (int i = 0; i < arSize; i++) {               //for (String s : array) {             // iterate in string
            lengthEachElement = array.get(i).length();   //lengthEachElement = s.length();
            sumLengthEachElement += lengthEachElement;
        }
        averageLengthEachElement = sumLengthEachElement / arSize;
        return averageLengthEachElement;

    }
    public static double typeTokenRation(List<String> array) { //method to return unique words divided on all words form inputted text.
        double uniqueWordCount, allWordsArrayCount;
        Set<String> uniqueWords = new LinkedHashSet<>();
        uniqueWords.addAll(array);
        uniqueWordCount=uniqueWords.size();
        allWordsArrayCount= array.size();
        // System.out.println(uniqueWords);
        return uniqueWordCount / allWordsArrayCount;
    }
}

