import java.util.Scanner;

public class RomanToInt {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    sc.close();
    int result = romanToInt(s);
    System.out.print(result);
  }

  public static int romanToInt(String s) {
    int count1 = 0, count10 = 0, count100 = 0, count1000 = 0;
    boolean is4 = false, is5 = false, is9 = false, is40 = false, is50 = false,
            is90 = false, is400 = false, is500 = false, is900 = false;

    // ВАЛИДАЦИЯ ВХОДНЫХ ДАННЫХ
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'M') {
        count1000++;
      } else if (s.charAt(i) == 'D') {
        is500 = true;
      } else if (s.charAt(i) == 'C') {
        count100++;
      } else if (s.charAt(i) == 'L') {
        is50 = true;
      } else if (s.charAt(i) == 'X') {
        count10++;
      } else if (s.charAt(i) == 'V') {
        is5 = true;
      } else if (s.charAt(i) == 'I') {
        count1++;
      }
    }

    // ВЫВОД ЗНАЧЕНИЙ СЧЁТЧИКОВ
    System.out.printf(
        "count1 - %d\ncount10 - %d\ncount100 - %d\ncount1000 - %d\n", count1,
        count10, count100, count1000);

    int num1000 = count1000 * 1000;
    int num100 = count100 * 100;
    int num10 = count10 * 10;
    int num1 = count1;

    if (s.contains("CM")) {
      is900 = true;
      num1000 -= 1000;
      num100 -= 100;
    }

    
    if (s.contains("CD")) {
      is400 = true;
      is500 = false;
      num100 -= 100;
    }

    
    if (s.contains("XC")) {
      is90 = true;
      num100 -= 100;
      num10 -= 10;
    }

    if (s.contains("XL")) {
      is40 = true;
      is50 = false;
      num10 -= 10;
    }

    if (s.contains("IX")) {
      is9 = true;
      num10 -= 10;
      num1--;
    }

    if (s.contains("IV")) {
      is4 = true;
      is5 = false;
      num1--;
    }

    // ВЫВОД ОСОБЫХ ЗНАЧЕНИЙ
    System.out.printf(
        "\nis4 - %b\nis5 - %b\nis9 - %b\nis40 - %b\nis50 - %b\nis90 - "
            + "%b\nis400 - %b\nis900 - %b\nis500 - %b\n",
        is4, is5, is9, is40, is50, is90, is400, is900, is500);

  

    // ВЫВОД ПОСЧИТАННЫХ РАЗРЯДОВ
    System.out.printf("num1000 - %d\nnum100 - %d\nnum10 - %d\n", num1000,
                      num100, num10);
		
		int result = 0;
		
    result += num1000;

    if (is900) {
      result += 900;
    }
    if (is400) {
      result += 400;
    }
    if (is500) {
      result += 500;
    }

    result += num100;

    if (is90) {
      result += 90;
    }
    if (is40) {
      result += 40;
    }
    if (is50) {
      result += 50;
    }

    result += num10;

    if (is9) {
      result += 9;
    }
    if (is4) {
      result += 4;
    }
    if (is5) {
      result += 5;
    }

    result += num1;

    return result;
  }
}