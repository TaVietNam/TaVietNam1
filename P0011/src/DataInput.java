import java.util.Scanner;
import java.util.regex.Pattern;

public class DataInput {
    static Scanner scanner = new Scanner(System.in);

    public static int inputChoice(int min, int max) {
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) {
                try {
                    int choice = Integer.parseInt(raw);
                    if (choice >= min && choice <= max) {
                        return choice;
                    } else {
                        System.out.print("Choice must in range [" + min + "-"
                                + max + "], enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Choice must be an integer, enter again: ");
                }
            } else {
                System.out.print("Choice can not empty, enter again: ");
            }
        }
    }

    public static int inputIntLimit(int min, int max) {
        // Loop until user input correct
        while (true) {
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number < min || number > max) {
                    throw new NumberFormatException();
                }
                return number;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! Enter input number in rage [" + min + ", " + max + "]");
                System.out.print("Please enter input again: ");
            }
        }
    }

    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String string = scanner.nextLine().trim();
            if (!string.isEmpty()) {
                return string.toUpperCase();
            } else {
                System.out.print("Number can not empty, enter again: ");
            }
        }
    }

    public static boolean checkBigInteger(String input) {
        Pattern p = Pattern.compile("^[0-9]+$");
        return p.matcher(input).find();
    }

    public static boolean checkBin(String input) {
        Pattern p = Pattern.compile("^[01]+$");
        return p.matcher(input).find();
    }

    public static boolean checkHex(String input) {
        Pattern p = Pattern.compile("^[0-9ABCDEFabcdef]+$");
        return p.matcher(input).find();
    }

    public static boolean checkYesNo() {
        Scanner in = new Scanner(System.in);
        System.out.println("Press \"Y\" if you want to keep taking action,"
                + " press \"N\" if you want to end the action.");
        System.out.print("Enter your choice: ");
        while (true) {
            String s = in.nextLine();
            if (!s.isEmpty()) {
                s = s.replaceAll(" ", "");
                if (s.compareToIgnoreCase("Y") == 0 || s.compareToIgnoreCase("y") == 0) {
                    return true;
                }
                if (s.compareToIgnoreCase("N") == 0 || s.compareToIgnoreCase("n") == 0) {
                    return false;
                }
                System.out.print("You must choose Yes(Y) or No(N)!\nEnter again: ");
            } else {
                System.out.print("Choice can not empty, enter again: ");
            }
        }
    }
}
