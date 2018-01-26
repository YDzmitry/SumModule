import java.util.*;
import java.io.*;
import java.util.Scanner;

public class SumModule {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("INPUT.TXT"));
        PrintWriter pw = new PrintWriter(new File("OUTPUT.TXT"));
        HashMap<Integer, Integer> posMap = new HashMap<>();
        HashMap<Integer, Integer> negMap = new HashMap<>();
        int numberOfValue = scanner.nextInt();

        for (int i = 0; i < numberOfValue; i++) {
            int tempNumber =  scanner.nextInt();
            if (tempNumber >= 0) {
                posMap.put(i+1, tempNumber);
            } else {
                negMap.put(i+1, tempNumber);
            }
        }
        if (sumSeq(posMap) < sumSeq(negMap)) {
            numbMemberSeq(negMap,pw);
        } else {
            numbMemberSeq(posMap,pw);
        }
        pw.close();

    }

    /*подсчет суммы членов последовательности*/
    private static int sumSeq(HashMap<Integer, Integer> map) {
        int sumElem = 0;
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            sumElem += entry.getValue();
        }
        return Math.abs(sumElem);
    }

    /* вывод номеров членов последовательности и числа последовательности */
    private static void numbMemberSeq(HashMap<Integer, Integer> map, PrintWriter pw) {
        pw.println(map.size());
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            pw.print(entry.getKey() + " ");
        }
    }
}