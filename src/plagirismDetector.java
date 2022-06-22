import java.util.*;

public class plagirismDetector { //different name  with mistake (plagirism)for hard to find my project :)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter first text and press ENTER : ");
        String textOne = sc.nextLine();
        textOne = textOne.toLowerCase();
        List<String> firstTextWords = new ArrayList<>(Arrays.asList(textOne.split("([,.!?_;=+-:\\s]+)"))); //read words in array
        for (int i = 0; i < firstTextWords.size(); i++) {
//            System.out.println(firstTextWords.get(i));  //TEST . To check correction.
        }
        double firstTextWordsCount = firstTextWords.size();
//        System.out.println(firstTextWordsCount);        //TEST . To check correction.
        List<String> firstTextSentence = new ArrayList<>(Arrays.asList(textOne.split("([.!?;:]+)")));//read sentence in array
        for (int i = 0; i < firstTextSentence.size(); i++) {
//            System.out.println(firstTextSentence.get(i));    //TEST . To check correction.
        }
        double firstTextSentenceCount = firstTextSentence.size();
//        System.out.println(firstTextSentenceCount);       //TEST . To check correction.

        System.out.println("Please enter second text and press ENTER : ");
        String textTwo = sc.nextLine();
        textTwo = textTwo.toLowerCase();
        List<String> secondTextWords = new ArrayList<>(Arrays.asList(textTwo.split("([,.!?_;=+-:\\s]+)")));
        for (int j = 0; j < secondTextWords.size(); j++) {
//            System.out.println(secondTextWords.get(j));     //TEST . To check correction.
        }
        double secondTextWordsCount = secondTextWords.size();
//        System.out.println(secondTextWordsCount);      //TEST . To check correction.
        List<String> secondTextSentence = new ArrayList<>(Arrays.asList(textTwo.split("([.!?;:]+)")));
        for (int j = 0; j < secondTextSentence.size(); j++) {
//            System.out.println(secondTextSentence.get(j));    //TEST . To check correction.
        }
        double secondTextSentenceCount = secondTextSentence.size();
//        System.out.println(secondTextSentenceCount);    //TEST . To check correction.

        countAverageLengthElementOfText(firstTextWords);
//        System.out.println(countAverageLengthElementOfText(firstTextWords)); // return averageLengthEachElement(in our case words)
        countAverageLengthElementOfText(secondTextWords);

        typeTokenRation(firstTextWords);
//        System.out.println(typeTokenRation(firstTextWords)); // return count of unique words divided on all words form inputted text.
        typeTokenRation(secondTextWords);

        HapaxLegomenaRatio(firstTextWords);
        HapaxLegomenaRatio(secondTextWords);
        System.out.println(HapaxLegomenaRatio(firstTextWords)); // return count of only one met word divided on all words form inputted text.
        calcAverageWordsInSentence(firstTextWordsCount, firstTextSentenceCount);
        System.out.println(calcAverageWordsInSentence(firstTextWordsCount, firstTextSentenceCount)); // return average number words in sentence.
        calcAverageWordsInSentence(secondTextWordsCount, secondTextSentenceCount);
    }

    //        ..................................Some methods below.......................................
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
        double uniqueWordCount, allWordsArrayCount;            // for correct divide in return statement declare double variable.
        Set<String> uniqueWords = new LinkedHashSet<>();
        uniqueWords.addAll(array);
        uniqueWordCount = uniqueWords.size();
        allWordsArrayCount = array.size();
        // System.out.println(uniqueWords);
        return uniqueWordCount / allWordsArrayCount;
    }

    public static double HapaxLegomenaRatio(List<String> array) { //method to return unique words divided on all words form inputted text.
        double oneMetWordCount = 0;
        double allWordsArrayCount;
        allWordsArrayCount = array.size();
        Set<String> oneMetWords = new HashSet<>(array);   //    get distinct elements in the list by inserting all elements in the set & then call static method frequency
        for (String s : oneMetWords) {  //new short way to check list element
            if (Collections.frequency(array, s) == 1) {
                oneMetWordCount++;
            }
        }
        return oneMetWordCount / allWordsArrayCount;
    }

    public static double calcAverageWordsInSentence(double countedAllWords, double countedAllSentences) {// method return Average Words In Sentence
        return countedAllWords / countedAllSentences;
    }
}
