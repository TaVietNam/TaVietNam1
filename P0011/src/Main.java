public class Main {
    public static void main(String[] args) {
        while (true) {
            ChangeBaseProgram.displayMenu();
            int choice = DataInput.inputChoice(1, 4);
            switch (choice) {
                case 1: {
                    ChangeBaseProgram.convertFormBinary();
                    break;
                }
                case 2: {
                    ChangeBaseProgram.convertFormDecimal();
                    break;
                }
                case 3: {
                    ChangeBaseProgram.convertFormHexadecimal();
                    break;
                }
                case 4: {
                   return;
                }
            }
        }
    }
}
