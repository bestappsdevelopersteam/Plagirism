import java.util.*;

public class plagirismDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter first text and press ENTER : ");
        String textOne = sc.nextLine();
        textOne = textOne.toLowerCase();
        List<String> firstTextWords = listWordsInText(textOne); //make list of words-use punctuation divider
        List<String> firstTextSentence = listSentenceInText(textOne); //make list of sentence -use punctuation divider

        System.out.println("Please enter second text and press ENTER : ");
        String textTwo = sc.nextLine();
        textTwo = textTwo.toLowerCase();
        List<String> secondTextWords = listWordsInText(textTwo);
        List<String> secondTextSentence = listSentenceInText(textTwo);

        calcPrintParameters(firstTextWords, firstTextSentence, secondTextWords, secondTextSentence);
        double[] weight;
        weight = returnWeight();
        similarityReturn(weight[0], weight[1], weight[2], weight[3], countAverageLengthElementOfText(firstTextWords), typeTokenRation(firstTextWords), HapaxLegomenaRatio(firstTextWords),
                calcAverageWordsInSentence(firstTextWords.size(), firstTextSentence.size()), countAverageLengthElementOfText(secondTextWords),
                typeTokenRation(secondTextWords), HapaxLegomenaRatio(secondTextWords),
                calcAverageWordsInSentence(secondTextWords.size(), secondTextSentence.size()));
    }

    private static List<String> listWordsInText(String text) {
        List<String> textWords = new ArrayList<>(Arrays.asList(text.split("([,.!?_;=+-:()\\s]+)"))); //read words in array -use punctuation divider
        return textWords;
    }

    private static List<String> listSentenceInText(String text) {
        List<String> textSentences = new ArrayList<>(Arrays.asList(text.split("([,.!?_;=+-:()\\s]+)"))); //read words in array -use punctuation divider
        return textSentences;
    }

    private static void calcPrintParameters(List<String> firstTextWords, List<String> firstTextSentence, List<String> secondTextWords, List<String> secondTextSentence) {
        System.out.println("........Calculated parameters for first text.........");
        System.out.format("1. Avg. word length :          %.2f%n", countAverageLengthElementOfText(firstTextWords)); // return averageLengthEachElement(in our case words)
        System.out.format("2. Type-Token Ratio :          %.2f%n", typeTokenRation(firstTextWords)); // return count of unique words divided on all words form inputted text.
        System.out.format("3. Hapax Legomena Ratio :      %.2f%n", HapaxLegomenaRatio(firstTextWords)); // return count of only one met word divided on all words form inputted text.
        System.out.format("4. Avg. sentence length :      %.2f%n", calcAverageWordsInSentence(firstTextWords.size(), firstTextSentence.size())); // return average number words in sentence.
        System.out.println();
        System.out.println("........Calculated parameters for second text........");
        System.out.format("1. Avg. word length :          %.2f%n", countAverageLengthElementOfText(secondTextWords)); // return averageLengthEachElement(in our case words)
        System.out.format("2. Type-Token Ratio :          %.2f%n", typeTokenRation(secondTextWords)); // return count of unique words divided on all words form inputted text.
        System.out.format("3. Hapax Legomena Ratio :      %.2f%n", HapaxLegomenaRatio(secondTextWords)); // return count of only one met word divided on all words form inputted text.
        System.out.format("4. Avg. sentence length :      %.2f%n", calcAverageWordsInSentence(secondTextWords.size(), secondTextSentence.size())); // return average number words in sentence.
        System.out.println();
    }
    private static double countAverageLengthElementOfText(List<String> array) {// method return averageLengthEachElement(in our case words)
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

    private static double typeTokenRation(List<String> array) { //the number of all different words used in the text divided by the number of all words
        double uniqueWordCount, allWordsArrayCount;            // for correct divide in return statement declare double variable.
        Set<String> uniqueWords = new LinkedHashSet<>();
        uniqueWords.addAll(array);
        uniqueWordCount = uniqueWords.size();
        allWordsArrayCount = array.size();
        return uniqueWordCount / allWordsArrayCount;
    }

    private static double HapaxLegomenaRatio(List<String> array) { //the number of words that occur only once in a text divided by the number of all words
        double oneMetWordCount = 0;
        double allWordsArrayCount;
        allWordsArrayCount = array.size();
    //    Set<String> oneMetWords = new HashSet<>(array);//get distinct elements in the list by inserting all elements in the set & then call static method frequency
        for (String s : array) {  //new short way to check list element
            if (Collections.frequency(array, s) == 1) {
                oneMetWordCount++;
            }
        }
        return oneMetWordCount / allWordsArrayCount;
    }

    private static double calcAverageWordsInSentence(double countedAllWords, double countedAllSentences) {// method return Average Words In Sentence
        return countedAllWords / countedAllSentences;
    }

    public static double[] returnWeight() {
        double aw = 11;
        double tt = 33;
        double hl = 50;
        double as = 0.4;
        System.out.println("..................Weight coef is :...................");
        System.out.println("1.Average words length :      " + aw);
        System.out.println("2.Type-Token Ratio :          " + tt);
        System.out.println("3.Hapax Legomena Ratio :      " + hl);
        System.out.println("4.Average words in sentence :  " + as);
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
                System.out.println("Next time check input parameter carefully! calculate with default parameters ....");

        }

        double[] arrWeight = {aw, tt, hl, as};
        return arrWeight;

    }

    private static void similarityReturn(double aw, double tt, double hl, double as, double a, double b, double c, double d, double e, double f, double g, double h) {
        double similarity = ((Math.abs(a - e)) * aw + (Math.abs(b - f)) * tt + (Math.abs(c - g)) * hl + (Math.abs(d - h)) * as); //var take value for similarity calculation
        if (similarity > 10) {// compare result for similarity with some number for more clearance to understand result.
            System.out.println("These two texts not have a lot of similarity - congratulations.");
        } else {
            System.out.println("This two texts is very similar - pay attention!");
        }

        System.out.format("Coefficient of similarity is : %.2f%n", similarity);
    }
}

