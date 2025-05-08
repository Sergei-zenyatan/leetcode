import java.util.Arrays;

public class FindLongestCommonPrefix {
  public static void main(String[] args) {
    String[] strs = {"abc", "ab", "abcd"};
    String result = longestCommonPrefix(strs);
    System.out.print("Наибольший общий префикс: " + result);
  }

  public static String longestCommonPrefix(String[] strs) {
    int indSmallStr = findIndSmallStr(strs);
    String longestCommonPrefix = new String("");
    String smallStr = strs[indSmallStr];
    int lengthSmallStr = smallStr.length();
    String[] correctPrefixes = new String[200];
    Arrays.fill(correctPrefixes, "");
    int maxLengthFromAllPrefixes = 0;
    int indLongestCommonPrefix = 0;
    boolean isPresentPrefix = true;

    for (int i = 0; i < lengthSmallStr; i++) {
      isPresentPrefix = true;
      String currentPrefix = smallStr.substring(0, lengthSmallStr - i);
      int lengthCurrentPrefix = currentPrefix.length();
      System.out.printf("Текущий префикс - %s Длина - %d\n", currentPrefix,
                        lengthCurrentPrefix);

      // Проверяем, присутствует ли наш префикс во всех строках массива
      for (int k = 0; k < strs.length; k++) {
        // Если хотя бы в одной строке нет текущего префикса, то проверяем след.
        // префикс
        if (!isPresentPrefix) {
          break;
        }
        if (k == indSmallStr) {
          continue;
        } else {
          for (int z = 0; z < lengthCurrentPrefix; z++) {
            if (currentPrefix.charAt(z) == strs[k].charAt(z)) {
              continue;
            } else {
              isPresentPrefix = false;
            }
          }
        }
      }

      /* Если текущий префикс существует во всех строках исходного массива,
     то мы его запоминаем для дальнейшего сравнения по длине */
      if (isPresentPrefix) {
        correctPrefixes[i] = currentPrefix;
      }
    }
    System.out.println(Arrays.toString(correctPrefixes));
    for (int u = 0; u < correctPrefixes.length; u++) {
      int lengthCorrectPrefix = correctPrefixes[u].length();
      if (lengthCorrectPrefix > maxLengthFromAllPrefixes) {
        maxLengthFromAllPrefixes = lengthCorrectPrefix;
        indLongestCommonPrefix = u;
      }
    }
    longestCommonPrefix = correctPrefixes[indLongestCommonPrefix];
    return longestCommonPrefix;
  }

  public static int findIndSmallStr(String[] strs) {
    int indSmallStr = 0;
    int minLength = strs[0].length();
    for (int i = 1; i < strs.length; i++) {
      if (strs[i].length() < minLength) {
        indSmallStr = i;
        minLength = strs[i].length();
      }
    }
    return indSmallStr;
  }
}