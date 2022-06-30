import java.util.*;

public class plagirismDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter first text and press ENTER : ");
        String textOne = sc.nextLine();
        textOne = textOne.toLowerCase();
        List<String> firstTextWords = new ArrayList<>(Arrays.asList(textOne.split("([,.!?_;=+-:()\\s]+)"))); //read words in array -use punctuation divider
        List<String> firstTextSentence = new ArrayList<>(Arrays.asList(textOne.split("([.!?;:]+)")));//read sentence in array -use punctuation divider

        System.out.println("Please enter second text and press ENTER : ");
        String textTwo = sc.nextLine();
        textTwo = textTwo.toLowerCase();
        List<String> secondTextWords = new ArrayList<>(Arrays.asList(textTwo.split("([,.!?_;=+-:()\\s]+)")));
        List<String> secondTextSentence = new ArrayList<>(Arrays.asList(textTwo.split("([.!?;:]+)")));
        printDefaultFeatures(firstTextWords, firstTextSentence, secondTextWords, secondTextSentence);
        calcPrintSimilarity(firstTextWords, firstTextSentence, secondTextWords, secondTextSentence);
    }

    private static void printDefaultFeatures(List<String> firstTextWords, List<String> firstTextSentence, List<String> secondTextWords, List<String> secondTextSentence) {
        System.out.println("........Calculated parameters for first text.........");
        System.out.format("1. Avg. word length :     %.2f%n", countAverageLengthElementOfText(firstTextWords)); // return averageLengthEachElement(in our case words)
        System.out.format("2. Type-Token Ratio :     %.2f%n", typeTokenRation(firstTextWords)); // return count of unique words divided on all words form inputted text.
        System.out.format("3. Hapax Legomena Ratio : %.2f%n", HapaxLegomenaRatio(firstTextWords)); // return count of only one met word divided on all words form inputted text.
        System.out.format("4. Avg. sentence length : %.2f%n", calcAverageWordsInSentence(firstTextWords.size(), firstTextSentence.size())); // return average number words in sentence.
        System.out.println();
        System.out.println("........Calculated parameters for second text........");
        System.out.format("1. Avg. word length :     %.2f%n", countAverageLengthElementOfText(secondTextWords)); // return averageLengthEachElement(in our case words)
        System.out.format("2. Type-Token Ratio :     %.2f%n", typeTokenRation(secondTextWords)); // return count of unique words divided on all words form inputted text.
        System.out.format("3. Hapax Legomena Ratio : %.2f%n", HapaxLegomenaRatio(secondTextWords)); // return count of only one met word divided on all words form inputted text.
        System.out.format("4. Avg. sentence length : %.2f%n", calcAverageWordsInSentence(secondTextWords.size(), secondTextSentence.size())); // return average number words in sentence.
        System.out.println();
    }

    private static void calcPrintSimilarity(List<String> firstTextWords, List<String> firstTextSentence, List<String> secondTextWords, List<String> secondTextSentence) {
        System.out.format("Coefficient of similarity between two text is : %.2f%n", calcSimilarity(countAverageLengthElementOfText(firstTextWords), typeTokenRation(firstTextWords), HapaxLegomenaRatio(firstTextWords),
                calcAverageWordsInSentence(firstTextWords.size(), firstTextSentence.size()), countAverageLengthElementOfText(secondTextWords),
                typeTokenRation(secondTextWords), HapaxLegomenaRatio(secondTextWords),
                calcAverageWordsInSentence(secondTextWords.size(), secondTextSentence.size())));
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
        double uniqueWordCount, allWordsArrayCount;            // for correct divide in return statement declare double variable.
        Set<String> uniqueWords = new LinkedHashSet<>();
        uniqueWords.addAll(array);
        uniqueWordCount = uniqueWords.size();
        allWordsArrayCount = array.size();
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

    public static double calcSimilarity(double a, double b, double c, double d, double e, double f, double g, double h) {
        double aw = 11;
        double tt = 33;
        double hl = 50;
        double as = 0.4;
        System.out.println("..................Weight coef is :....................");
        System.out.println("1.Average words length :     " + aw);
        System.out.println("2.Type-Token Ratio :         " + tt);
        System.out.println("3.Hapax Legomena Ratio :     " + hl);
        System.out.println("4.Average words in sentence :" + as);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter some number [1, 2, 3 or 4] to change it weight coefficient use comma for divider : (or press \"0\" to  continue ) ");
        int choose = sc.nextInt();
        switch (choose) {
            case 1:
                System.out.print("1.Average words length :     ");
                aw = sc.nextDouble();
            case 2:
                System.out.print("2.Type-Token Ratio :         ");
                tt = sc.nextDouble();
            case 3:
                System.out.print("3.Hapax Legomena Ratio :     ");
                hl = sc.nextDouble();
            case 4:
                System.out.print("4.Average words in sentence :");
                as = sc.nextDouble();
            case 0:
                System.out.println("0.Exiting .......and calculating");
                break;
            default:
                System.out.println("Please check again input parameter carefully!");
                break;
        }
        double similarity = ((Math.abs(a - e)) * aw + (Math.abs(b - f)) * tt + (Math.abs(c - g)) * hl + (Math.abs(d - h)) * as); //var take value for similarity calculation
        if (similarity > 10)   // compare result for similarity with some number for more clearance to understand result.
            System.out.println("These two texts not have a lot of similarity - congratulations.");
        else
            System.out.println("This two texts is very similar - pay attention!");

        return similarity;
    }

}

