import java.math.BigInteger;
import java.util.*;

public class Main {
    public static BigInteger f(int s, int e, ArrayList<Long> a) {
        BigInteger res = BigInteger.ONE;
        BigInteger max = null;
        for (int i = s; i <= e ; i++) {
            res = res.multiply(BigInteger.valueOf(a.get(i)));
            if (max == null || BigInteger.valueOf(a.get(i)).compareTo(max) > 0) {
                max = BigInteger.valueOf(a.get(i));
            }
        }
        if (res.compareTo(BigInteger.ZERO) > 0) {
            return res;
        }
        BigInteger res1 = res, res2 = res;
        for (int i = s; i <= e; i++) {
            res1 = res1.divide(BigInteger.valueOf(a.get(i)));
            if (res1.compareTo(BigInteger.ZERO) > 0) {
                if (i == e) {
                    res1 = null;
                }
                break;
            }
        }

        for (int i = e; i >= s; i--) {
            res2 = res2.divide(BigInteger.valueOf(a.get(i)));
            if (res2.compareTo(BigInteger.ZERO) > 0) {
                if (i == s) {
                    res2 = null;
                }
                break;
            }
        }

        if (res1 != null && res1.compareTo(max) > 0) {
            max = res1;
        }
        if (res2 != null && res2.compareTo(max) > 0) {
            max = res2;
        }
        return max;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            ArrayList<Long> a = new ArrayList<>();
            while (true) {
                long v = sc.nextLong();
                if (v == -999999) {
                    break;
                }
                a.add(v);
            }
            int n = a.size();
            int start = 0, end = 0;
            BigInteger res = null;
            while (start < n) {
                while (start < n && a.get(start) == 0) {
                    if (res == null || BigInteger.ZERO.compareTo(res) > 0) {
                        res = BigInteger.ZERO;
                    }
                    start++;
                }
                if (start < n) {
                    end = start;
                    while (end < n && a.get(end) != 0) end++;
                    BigInteger localRes = f(start, end - 1, a);
                    if (res == null || localRes.compareTo(res) > 0) {
                        res = localRes;
                    }
                    start = end;
                }
            }
            System.out.println(res);
        }
    }
}
