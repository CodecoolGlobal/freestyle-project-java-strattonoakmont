import java.util.*;
import com.codecool.currency.Currency;
import static com.codecool.selecter.DataSelecter.simple;
import static com.codecool.selecter.DataSelecter.detailed;
import static com.codecool.selecter.DataSelecter.converted;
import static com.codecool.display.showTable.printSimpleTable;
import static com.codecool.display.showTable.printDetailedTable;
import static com.codecool.display.showTable.printConvertedTable;
import static com.codecool.credits.Credits.credits;
import java.io.IOException;

public class MainMenu {

    private static final String URL_CRYPTOCURRENCY = "https://min-api.cryptocompare.com/data/top/totalvolfull?limit=10&tsym=USD";
    private static final String API_KEY_CRYPTOCURRENCY = "0081703480f82a60b595181a70323ac1065be2ed0aefa6ce538de6b8a24d6108";

    private static final Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.print("\033[H\033[2J");
        System.out.println("Stratton Oakmont CryptoCurrency Checker\n");
        System.out.println("Menu Options:");
        System.out.println("1. Top 10 Cryptocurrencies");
        System.out.println("2. Cryptocurreny Value to HUF");
        System.out.println("3. Credits");
        System.out.println("4. Exit the program\n");
        System.out.print("Please select an option from 1-4\n");

    }

    public static void handleMenu() {
        int input = scanner.nextInt();
        if (input < 0 || input > 5) {
            System.out.println("You have entered an invalid selection, please try again\n");
        } else if (input == 1) {
            // System.out.print("\033[H\033[2J");
            Currency cryptoCurrency = new Currency();
            List<Map<String, Object>> cryptos = cryptoCurrency.getCurrency(URL_CRYPTOCURRENCY, API_KEY_CRYPTOCURRENCY);

            String line = "";
            printSimpleTable(simple(cryptos));
            System.out.println("Choose a Cryptocurrency number to detailed view");
            System.out.println("Press 'q' to Main Menu");

            while (line.equalsIgnoreCase("q") == false) {

                if (line.equalsIgnoreCase("5") == true) {
                    printDetailedTable(detailed(cryptos), 5);
                }
                line = scanner.nextLine();
                // System.out.print("\033[H\033[2J");

            }

            printMenu();
            handleMenu();

        } else if (input == 2) {
            Currency cryptoCurrency = new Currency();
            List<Map<String, Object>> cryptos = cryptoCurrency.getCurrency(URL_CRYPTOCURRENCY, API_KEY_CRYPTOCURRENCY);
            printConvertedTable(converted(cryptos));
        } else if (input == 3) {
            System.out.print("\033[H\033[2J");
            credits();
        } else if (input == 4) {
            System.out.println("You have quit the program\n");
            System.exit(1);
        } else {
            System.out.println("You have entered " + input + "\n");
        }
    }

    public static void main(String[] args) throws IOException {

        printMenu();
        handleMenu();

    }
}
