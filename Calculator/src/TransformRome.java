import java.util.TreeMap;

public class TransformRome {
    TreeMap<Character, Integer> romeKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabKeyMap = new TreeMap<>();


    public TransformRome() {
        romeKeyMap.put('I', 1);
        romeKeyMap.put('V', 5);
        romeKeyMap.put('X', 10);
        romeKeyMap.put('L', 50);
        romeKeyMap.put('C', 100);

        arabKeyMap.put(100, "C");
        arabKeyMap.put(90, "XC");
        arabKeyMap.put(50, "L");
        arabKeyMap.put(40, "XL");
        arabKeyMap.put(10, "X");
        arabKeyMap.put(9, "IX");
        arabKeyMap.put(5, "V");
        arabKeyMap.put(4, "IV");
        arabKeyMap.put(1, "I");

    }

    public boolean isRoman(String number) {
        return romeKeyMap.containsKey(number.charAt(0));
    }

    public String intToRoman(int number) {
        String roman = "";
        int arabKey;

        do {
            arabKey = arabKeyMap.floorKey(number);
            roman += arabKeyMap.get(arabKey);
            number -= arabKey;

        } while (number != 0);
        return roman;
    }

    public int romanToInt(String str) {
        int end = str.length() - 1;
        char[] array = str.toCharArray();
        int arab;
        int result = romeKeyMap.get(array[end]);
        for (int i = end - 1; i >= 0; i--) {
            arab = romeKeyMap.get(array[i]);

            if (arab < romeKeyMap.get(array[i + 1])) {
                result -= arab;
            } else {
                result += arab;
            }

        }
        return result;
    }
}



