import java.math.BigInteger;

public class ChangeBaseProgram {
    private static final int BIN_NUMBER = 2;
    private static final int HEX_NUMBER = 16;

    static void displayMenu() {
        System.out.println("========MAIN MENU========");
        System.out.println("1. Binary.");
        System.out.println("2. Decimal.");
        System.out.println("3. Hexadecimal.");
        System.out.println("4. Exit.");
        System.out.print("Enter your choice: ");
    }

    static void convertFormBinary() {
        do {
            int choice = displayConvert("binary", "decimal", "hexadecimal");
            switch (choice) {
                case 1:
                    ChangeBaseProgram.displayChangeBinToDec();
                    break;
                case 2:
                    ChangeBaseProgram.displayChangeBinToHex();
                    break;
            }

        } while (DataInput.checkYesNo());
    }

    static void convertFormDecimal() {
        do {

            int choice = displayConvert("decimal", "binary", "hexadecimal");
            switch (choice) {
                case 1:
                    ChangeBaseProgram.displayChangeDecToBin();
                    break;
                case 2:
                    ChangeBaseProgram.displayChangeDecToHex();
                    break;
            }
        } while (DataInput.checkYesNo());
    }

    static void convertFormHexadecimal() {
        do {
            int choice = displayConvert("hexadecimal", "binary", "decimal");
            switch (choice) {
                case 1:
                    ChangeBaseProgram.displayChangeHexToBin();
                    break;
                case 2:
                    ChangeBaseProgram.displayChangeHexToDec();
                    break;
            }
        } while (DataInput.checkYesNo());
    }


    public static void displayChangeDecToBin() {
        System.out.print("Enter number you want to convert: ");
        while (true) {
            String number = DataInput.inputString();
            if (DataInput.checkBigInteger(number)) {
                String output = changeFromDecToBase(number, BIN_NUMBER);
                System.out.println("Number " + number + " in decimal after convert to binary: " + output);
                break;
            }
            System.out.print("Number you entered isn't decimal number, enter again: ");
        }
    }

    public static void displayChangeBinToDec() {
        System.out.print("Enter number you want to convert: ");
        while (true) {
            String number = DataInput.inputString();
            if (DataInput.checkBin(number)) {
                String output = changeFromBaseToDec(number, BIN_NUMBER);
                System.out.println("Number " + number + " dataInput binary after convert to decimal: " + output);
                break;
            }
            System.out.print("Number you entered isn't binary number, enter again: ");
        }
    }

    public static void displayChangeDecToHex() {
        System.out.print("Enter number you want to convert: ");
        while (true) {
            String number = DataInput.inputString();
            if (DataInput.checkBigInteger(number)) {
                String output = changeFromDecToBase(number, HEX_NUMBER);
                System.out.println(output);
                break;
            }
            System.out.print("Number you entered isn't decimal number, enter again: ");
        }
    }

    public static void displayChangeHexToDec() {
        System.out.print("Enter number you want to convert: ");
        while (true) {
            String number = DataInput.inputString();
            if (DataInput.checkBin(number)) {
                String output = changeFromBaseToDec(number, HEX_NUMBER);
                System.out.println("Number " + number + " in hex after convert to decimal: " + output);
                break;
            }
            System.out.print("Number you entered isn't hex number, enter again: ");
        }
    }

    public static void displayChangeBinToHex() {
        System.out.print("Enter number you want to convert: ");
        while (true) {
            String number = DataInput.inputString();
            if (DataInput.checkBin(number)) {
                String output = changeFromBaseToDec(number, BIN_NUMBER);
                output = changeFromDecToBase(output, HEX_NUMBER);
                System.out.println("Number " + number + " in binary after convert to hex: " + output);
                break;
            }
            System.out.print("Number you entered isn't binary number, enter again: ");
        }
    }

    public static void displayChangeHexToBin() {
        System.out.print("Enter number you want to convert: ");
        while (true) {
            String number = DataInput.inputString();
            if (DataInput.checkHex(number)) {
                String output = changeFromBaseToDec(number, HEX_NUMBER);
                output = changeFromDecToBase(output, BIN_NUMBER);
                System.out.println("Number " + number + " in hex after convert to binary: " + output);
                break;
            }
            System.out.print("Number you entered isn't hex number, enter again: ");
        }
    }

    public static String changeFromDecToBase(String dec, int baseInput) {
        BigInteger DEC = new BigInteger(dec);
        BigInteger zero = new BigInteger("0");
        BigInteger base = new BigInteger(Integer.toString(baseInput));
        StringBuilder result = new StringBuilder();
        if (DEC.compareTo(zero) == 0) {
            result.append("0");
        } else {
            while (DEC.compareTo(zero) != 0) {
                BigInteger remainder = DEC.mod(base);
                if (remainder.intValue() < 10) {
                    result.append(remainder.intValue());
                } else {
                    switch (remainder.intValue()) {
                        case 10:
                            result.append("A");
                            break;
                        case 11:
                            result.append("B");
                            break;
                        case 12:
                            result.append("C");
                            break;
                        case 13:
                            result.append("D");
                            break;
                        case 14:
                            result.append("E");
                            break;
                        case 15:
                            result.append("F");
                            break;
                    }
                }
                DEC = DEC.divide(base);
            }
        }
        return result.reverse().toString();
    }

    public static String changeFromBaseToDec(String str, int base) {
        String Letters = "0123456789ABCDEF";
        str = str.toUpperCase();
        BigInteger BASE = new BigInteger(Integer.toString(base));
        BigInteger dec = new BigInteger("0");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int n = Letters.indexOf(ch);
            BigInteger a = new BigInteger(Integer.toString(n));
            dec = (dec.multiply(BASE)).add(a);
        }
        return dec.toString();
    }

    static int displayConvert(String form, String case1, String case2) {
        System.out.println("1.Convert form " + form + " to " + case1);
        System.out.println("2.Convert form " + form + " to " + case2);
        System.out.print("Enter your choice: ");
        return DataInput.inputIntLimit(1, 2);
    }
}
