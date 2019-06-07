import java.util.*;
import com.codecool.currency.Currency;
import static com.codecool.selecter.DataSelecter.simple;
import static com.codecool.selecter.DataSelecter.detailed;
import static com.codecool.selecter.DataSelecter.converted;
import static com.codecool.display.Table.printSimpleTable;
import static com.codecool.display.Table.printDetailedTable;
import static com.codecool.display.Table.printConvertedTable;
import static com.codecool.credits.Credits.credits;
import java.io.IOException;

public class MainMenu {

    private static final String URL_CRYPTOCURRENCY = "https://min-api.cryptocompare.com/data/top/totalvolfull?limit=10&tsym=USD";
    private static final String API_KEY_CRYPTOCURRENCY = "0081703480f82a60b595181a70323ac1065be2ed0aefa6ce538de6b8a24d6108";

    private static final Scanner scanner = new Scanner(System.in);
    private static Currency cryptoCurrency = new Currency();
    private static List<Map<String, Object>> cryptos = cryptoCurrency.getCurrency(URL_CRYPTOCURRENCY,
            API_KEY_CRYPTOCURRENCY);

    public static void showMenu() {
        System.out.print("\033[H\033[2J");
        System.out.println("Stratton Oakmont CryptoCurrency Checker\n");
        System.out.println("Menu Options:");
        System.out.println("1. Top 10 Cryptocurrencies");
        System.out.println("2. Cryptocurreny Value to HUF");
        System.out.println("3. Credits");
        System.out.println("4. Exit the program\n");
        System.out.print("Please select an option from 1-4\n");

    }

    public static void startSimpleTable() {
        
        printSimpleTable(simple(cryptos));
        
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input >= 1 && input <= 10) {
                    printDetailedTable(detailed(cryptos), input -1);
                } else if (input ==0) {
                    break;
                } else {
                    System.out.println("Try a number between range [1 - 10]\nOr press 0 to go Back");
                }
            } catch (InputMismatchException e) {
                System.out.println("Try a number please");
                scanner.nextLine();
            }

        }
    }

    public static void startConvertedTable() {
        printConvertedTable(converted(cryptos));
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input == 0) {
                    break;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public static void chooseMenu() {
        
        int input = scanner.nextInt();
        if (input < 0 || input > 5) {
            System.out.println("You have entered an invalid selection, please try again\n");
        } else if (input == 1) {
            startSimpleTable();
        } else if (input == 2) {
            // System.out.print("\033[H\033[2J");
            // printConvertedTable(converted(cryptos));
            startConvertedTable();
        } else if (input == 3) {
            // System.out.print("\033[H\033[2J");
            credits();
        } else if (input == 4) {
            System.out.println("You have quit the program\n");
            System.exit(1);
        } else {
            System.out.println("error");
            
            throw new InputMismatchException();
        }
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            showMenu();
            try {
                chooseMenu();
            } catch (InputMismatchException e) {
                System.out.println("Try a number please");
                scanner.next();
            }

        }
    }
}
