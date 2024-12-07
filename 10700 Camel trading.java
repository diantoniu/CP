import java.util.*;

public class Main {
    
    public static long min(String formula){
        long sumRes = 0;
        for (String sum: formula.split("\\+")) {
            long multRes = 1;
            for (String mult : sum.split("\\*")) {
                multRes *= Long.parseLong(mult);
            }
            sumRes += multRes;
        }
        return sumRes;
    }

    public static long max(String formula){
        long multRes = 1;
        for (String mult: formula.split("\\*")) {
            long sumRes = 0;
            for (String sum : mult.split("\\+")) {
                sumRes += Long.parseLong(sum);
            }
            multRes *= sumRes;
        }
        return multRes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            T--;
            String s = sc.next();
            System.out.println(String.format("The maximum and minimum are %d and %d.", max(s), min(s)));
        }
    }
}
