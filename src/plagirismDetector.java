import java.util.*;

public class plagirismDetector { //different name  with mistake (plagirism)for hard to find my project :)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter first text and press ENTER : ");
        String textOne = sc.nextLine();
        textOne = textOne.toLowerCase();
        List<String> firstTextWords = new ArrayList<>(Arrays.asList(textOne.split("([,.!?_;=+-:()\\s]+)"))); //read words in array -use punctuation divider
//        for (int i = 0; i < firstTextWords.size(); i++) {   //TEST . To check correction of read words.
//            System.out.print(firstTextWords.get(i) + " ");  //TEST . To check correction of read words.
//        }                                                  //TEST . To check correction of read words.
//            System.out.println();                              //TEST . To check correction of read words.
        double firstTextWordsCount = firstTextWords.size();     //declare var to be "double"
//            System.out.println(firstTextWordsCount);        //TEST . To check correction - > count words in text.
        List<String> firstTextSentence = new ArrayList<>(Arrays.asList(textOne.split("([.!?;:]+)")));//read sentence in array -use punctuation divider

//        for (int j = 0; j < firstTextSentence.size(); j++) { //TEST . To check correction - > count sentence in text.
//            System.out.println(firstTextSentence.get(i));    //TEST . To check correction - > count sentence in text.
//        }                                                    //TEST . To check correction - > count sentence in text.
        double firstTextSentenceCount = firstTextSentence.size();//declare var to be "double"
//        System.out.println(firstTextSentenceCount);       //TEST . To check correction.
//-----------------------Next is print statement features of first text on console ....................................................
        double F1T1 = countAverageLengthElementOfText(firstTextWords);
        double F2T1 = typeTokenRation(firstTextWords);
        double F3T1 = HapaxLegomenaRatio(firstTextWords);
        double F4T1 = calcAverageWordsInSentence(firstTextWordsCount, firstTextSentenceCount);
        System.out.format("1. Avg. word length:     %.2f%n", F1T1); // return averageLengthEachElement(in our case words)
        System.out.format("2. Type-Token Ratio:     %.2f%n", F2T1); // return count of unique words divided on all words form inputted text.
        System.out.format("3. Hapax Legomena Ratio: %.2f%n", F3T1); // return count of only one met word divided on all words form inputted text.
        System.out.format("4. Avg. sentence length: %.2f%n", F4T1); // return average number words in sentence.

        System.out.println("Please enter second text and press ENTER : ");
        String textTwo = sc.nextLine();
        textTwo = textTwo.toLowerCase();
        List<String> secondTextWords = new ArrayList<>(Arrays.asList(textTwo.split("([,.!?_;=+-:()\\s]+)")));
        for (int j = 0; j < secondTextWords.size(); j++) {
//            System.out.println(secondTextWords.get(j));     //TEST . To check correction.
        }
        double secondTextWordsCount = secondTextWords.size();
//        System.out.println(secondTextWordsCount);      //TEST . To check correction.
        List<String> secondTextSentence = new ArrayList<>(Arrays.asList(textTwo.split("([.!?;:]+)")));
        for (int j = 0; j < secondTextSentence.size(); j++) {
//            System.out.println(secondTextSentence.get(j));    //TEST . To check correction.
        }
        double secondTextSentenceCount = secondTextSentence.size();//declare var to be "double"
//        System.outT.println(firstTextSentenceCount);       //TEST . To check correction.
//-----------------------Next is print statement features of second text on console ....................................................
        double F1T2 = countAverageLengthElementOfText(secondTextWords);
        double F2T2 = typeTokenRation(secondTextWords);
        double F3T2 = HapaxLegomenaRatio(secondTextWords);
        double F4T2 = calcAverageWordsInSentence(secondTextWordsCount, secondTextSentenceCount);
        System.out.format("1. Avg. word length:     %.2f%n", F1T2); // return averageLengthEachElement(in our case words)
        System.out.format("2. Type-Token Ratio:     %.2f%n", F2T2); // return count of unique words divided on all words form inputted text.
        System.out.format("3. Hapax Legomena Ratio: %.2f%n", F3T2); // return count of only one met word divided on all words form inputted text.
        System.out.format("4. Avg. sentence length: %.2f%n", F4T2); // return average number words in sentence.
        System.out.format("Similarity of two text is : %.2f%n", calcSimilarity(F1T1, F2T1, F3T1, F4T1, F1T2, F2T2, F3T2, F4T2));
    }

    //        ..................................features methods below.......................................
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

    public static double calcSimilarity(double a, double b, double c, double d, double e, double f, double g, double h) {
        double aw = 11;
        double tt = 33;
        double hl = 50;
        double as = 0.4;
        System.out.println(".......Weight coef is :.........");
        System.out.println("1.Average words length :     " + aw);
        System.out.println("2.Type-Token Ratio :         " + tt);
        System.out.println("3.Hapax Legomena Ratio :     " + hl);
        System.out.println("4.Average words in sentence :" + as);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter some number [1, 2, 3 or 4] to change it weight coefficient : (or press \"0\" to  continue ) ");
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
            System.out.println("This two text not have a lot of similarity - congratulations.");
        else
            System.out.println("This two text is very similar - pay attention!");

        return similarity;
    }
}
