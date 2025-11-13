package Tasks;

public class Multiplication {
    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        // array will store partial results
        String[] partialResults = new String[len2];

        // Loop for digit of num2
        for (int i = len2 - 1; i >= 0; i--) {
            int digit2 = num2.charAt(i) - '0';  // get digit
            int carry = 0;
            String currentLine = "";            // stores  multiplication

            // Add zeros at end for place value
            for (int k = len2 - 1; k > i; k--) {
                currentLine += "0";
            }

            // Multiply digit2 with every digit of num1
            for (int j = len1 - 1; j >= 0; j--) {
                int digit1 = num1.charAt(j) - '0';
                int product = digit1 * digit2 + carry;
                currentLine = (product % 10) + currentLine; // store remainder
                carry = product / 10;                      // carry forward
            }

            // If carry remains after inner loop, add it
            if (carry > 0) {
                currentLine = carry + currentLine;
            }

            // Store this line in array
            partialResults[i] = currentLine;
        }

        // Now add all partial results
        String result = partialResults[0];
        for (int i = 1; i < len2; i++) {
            result = addStrings(result, partialResults[i]);
        }

        return result;
    }

    // This method adds two big numbers written as strings
    public static String addStrings(String n1, String n2) {
        String result = "";
        int i = n1.length() - 1;
        int j = n2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int d1 = (i >= 0) ? n1.charAt(i) - '0' : 0;
            int d2 = (j >= 0) ? n2.charAt(j) - '0' : 0;
            int sum = d1 + d2 + carry;

            result = (sum % 10) + result;
            carry = sum / 10;

            i--;
            j--;
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {
        String number1 = "12312312312312312312312348283828382138484852881133";
        String number2 = "484828384848585885823832838283828382838284828436842";

        String result = multiply(number1, number2);

        System.out.println("Multiplication of:");
        System.out.println(number1);
        System.out.println("and");
        System.out.println(number2);
        System.out.println("\nResult:\n" + result);
    }
}
