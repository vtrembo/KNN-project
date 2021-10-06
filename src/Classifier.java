import java.util.Arrays;

public class Classifier {
    private String[][] trainData;

    public Classifier(String[][] trainData) {this.trainData = trainData;}

    public String Classify(int k, int lines, String[] vector ) {
        Flower[] flowers = new Flower[lines];
        String flower;
        for (int i = 0; i < lines; i++) {
            double res = 0.0;
            for (int j = 0; j <4; j++) {
                res += Math.pow((Double.parseDouble(trainData[i][j]) - Double.parseDouble(vector[j])), 2);
            }
            res = Math.sqrt(res);
            flowers[i] = new Flower(res, trainData[i][4]);
        }
        Arrays.sort(flowers, new Sorter());
        String [] toClassify = new String[k];
        for (int i = 0; i < k; i++) {
            toClassify[i] = flowers[i].getFlowerName();
        }
        flower = getMode(toClassify);
        return  flower;
    }
    public String getMode(String[] a) {
        int count = 1, tempCount;
        String mode = a[0];
        String temp = "";
        for (int i = 0; i < (a.length - 1); i++) {
            temp = a[i];
            tempCount = 0;
            for (int j = 1; j <a.length; j++) {
                if(temp == a[j]) tempCount++;
            }
            if (tempCount > count) {
                mode = temp;
                count = tempCount;
            }
        }
        return mode;
    }
}
