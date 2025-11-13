package Tasks;

public class RomanNum {
    private static final String[] THOUSANDS = {
            "", "M", "MM", "MMM", "MMMM", "MMMMM", "MMMMMM", "MMMMMMM", "MMMMMMMM", "MMMMMMMMM"
    };

    private static final String[] HUNDREDS = {
            "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"
    };

    private static final String[] TENS = {
            "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"
    };

    private static final String[] ONES = {
            "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
    };

    public static String convertToRoman(int number) {
        if (number < 1 || number > 9999) {
            throw new IllegalArgumentException("Number out of range (1–9999): " + number);
        }

        return THOUSANDS[number / 1000]
                + HUNDREDS[(number % 1000) / 100]
                + TENS[(number % 100) / 10]
                + ONES[number % 10];
    }

    public static void main(String[] args) {
        System.out.println("Roman Numerals from 1 to 9999:\n");
        for (int i = 1; i <= 9999; i++) {
            System.out.printf("%5d = %s%n", i, convertToRoman(i));
        }
    }
}
