import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the k parameter");
        int k = Integer.parseInt(sc.nextLine());
        System.out.println("Provide name of the train set");
        String trainSetName = sc.nextLine();
        System.out.println("Choose one of the following options:"
                + '\n' + "1: classify training set "
                + '\n' + "2: input and classify a vector" );
        int option = Integer.parseInt(sc.nextLine());
        Reader reader = new Reader(trainSetName);
        int amountOfLines = reader.getAmountOfLines();
        String[][] arr = new String[amountOfLines][5];
        reader.parse(arr);

        if (option == 1) {

            System.out.println("Provide a name of test set");
            String testSetName = sc.nextLine();
            Reader testSetReader = new Reader(testSetName);
            int testSetLines = testSetReader.getAmountOfLines();
            if (k > testSetLines) throw  new ArrayIndexOutOfBoundsException("K is higher then amount of lines");
            String[][] testSetArr = new String[testSetLines] [5];
            testSetReader.parse(testSetArr);
            int correct = 0;
            int total = 0;
            Classifier classifier = new Classifier(testSetArr);
            for (int i = 0; i < testSetLines; i++) {
                String[] tmp = testSetArr[i];
                if(classifier.Classify(k, testSetLines, tmp).equals(testSetArr[i][4])){
                    correct++;
                }
                total++;
            }
            System.out.println("Accuracy is: " + ((double)correct/(double)total)*100 + "%");
        } else if (option == 2) {
            System.out.println("Enter a vector");
            String vectorLine = sc.nextLine();
            String[] vector = vectorLine.split(",");
            Classifier classifier = new Classifier(arr);
            System.out.println(classifier.Classify(k, amountOfLines, vector));
         } else {
            System.out.println("Wrong input");
        }
    }
}
