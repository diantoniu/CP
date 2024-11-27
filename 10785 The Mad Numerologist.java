import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      HashMap<Integer, ArrayList<int[]>> consonants = new HashMap<>();
      HashMap<Integer, ArrayList<int[]>> vowels = new HashMap<>();
      for (int i = 0, num = 0; i < 26; i++, num = (num + 1) % 9) {
        char c = (char) (i + 'A');
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
          if (!vowels.containsKey(num)) {
            vowels.put(num, new ArrayList<>());
          }
          vowels.get(num).add(new int[] {0, i});
        } else {
          if (!consonants.containsKey(num)) {
            consonants.put(num, new ArrayList<>());
          }
          consonants.get(num).add(new int[] {0, i});
        }
      }
      
      ArrayList<Integer> resVowels = new ArrayList<>();
      ArrayList<Integer> resConsonants = new ArrayList<>();
      int vowel = 0, vindex = 0, consonant = 0, cindex = 0;
      while ((resVowels.size() + resConsonants.size()) < N) {
        while (!vowels.containsKey(vowel)) vowel++;
        if (vowels.get(vowel).get(vindex)[0] >= 21) {
          if (vindex + 1 < vowels.get(vowel).size()) {
            vindex++;
          } else {
            vindex = 0;
            vowel++;
          }
        }
        if (consonants.get(consonant).get(cindex)[0] >= 5) {
          if (cindex + 1 < consonants.get(consonant).size()) {
            cindex++;
          } else {
            cindex = 0;
            consonant++;
          }
        }
        if ((resVowels.size() + resConsonants.size()) % 2 == 0) {
          resVowels.add(vowels.get(vowel).get(vindex)[1]);
          vowels.get(vowel).get(vindex)[0]++;
        } else {
          resConsonants.add(consonants.get(consonant).get(cindex)[1]);
          consonants.get(consonant).get(cindex)[0]++;
        }
      }

      Collections.sort(resVowels);
      Collections.sort(resConsonants);
      int v = 0, c = 0;
      String result = "";
      while (result.length() < N) {
        if (result.length() % 2 == 0) {
          result += (char) (resVowels.get(v) + 'A');
          v++;
        } else {
          result += (char) (resConsonants.get(c) + 'A');
          c++;
        }
      }
      System.out.println("Case " + (t + 1) + ": " + result);
    }
  }
}
