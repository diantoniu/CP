import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            if (s.equals("0")) {
                break;
            }
            HashSet<Character> ASet = new HashSet<>();
            ASet.add('K');
            ASet.add('A');
            ASet.add('C');
            ASet.add('E');
            HashSet<Character> aSet = new HashSet<>();
            aSet.add('p');
            aSet.add('q');
            aSet.add('r');
            aSet.add('s');
            aSet.add('t');
            String result = "";
            int B = 0;
            LinkedList<Character> A = new LinkedList<>();
            LinkedList<Character> a = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if (aSet.contains(s.charAt(i))) {
                    a.add(s.charAt(i));
                } else if (s.charAt(i) == 'N') {
                    B++;
                } else {
                    A.add(s.charAt(i));
                }
            }
            if (a.isEmpty()) {
                System.out.println("no WFF possible");
                continue;
            }
            result = a.poll() + result;
            while (!A.isEmpty()) {
                char firstChar = result.charAt(0);
                if (result.length() < 2 || ASet.contains(firstChar)) {
                    if (a.isEmpty()) break;
                    result = a.poll() + result;
                } else {
                    result = A.poll() + result;
                }
            }
            
            while (!result.isEmpty() && B > 0) {
                result = 'N' + result;
                B--;
            }
            System.out.println(result);
        }
    }
}
