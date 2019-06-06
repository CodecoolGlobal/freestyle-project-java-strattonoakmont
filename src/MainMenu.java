import java.util.*;
import com.codecool.currency.Currency;
import static com.codecool.selecter.DataSelecter.simple;
import static com.codecool.selecter.DataSelecter.detailed;
import static com.codecool.display.showTable.printSimpleTable;
import static com.codecool.display.showTable.printDetailedTable;

public class MainMenu {

    private static final String URL_CRYPTOCURRENCY = "https://min-api.cryptocompare.com/data/top/totalvolfull?limit=10&tsym=USD";
    private static final String API_KEY_CRYPTOCURRENCY = "0081703480f82a60b595181a70323ac1065be2ed0aefa6ce538de6b8a24d6108";
  public static void main (String[] args){

    System.out.print("\033[H\033[2J");
    System.out.println("Stratton Oakmont CryptoCurrency Checker\n");
    System.out.println("Menu Options:");
    System.out.println("1. Top 10 Cryptocurrencies");
    System.out.println("2. Cryptocurreny Value to HUF");
    System.out.println("3. Credits");
    System.out.println("4. Exit the program\n");
    System.out.print("Please select an option from 1-4\n");

    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();

    if(input < 0 || input > 5) {
        System.out.println("You have entered an invalid selection, please try again\n");
    } else if(input == 1) {
        System.out.print("\033[H\033[2J");
    Currency cryptoCurrency = new Currency();
    List<Map<String, Object>> cryptos = cryptoCurrency.getCurrency(URL_CRYPTOCURRENCY, API_KEY_CRYPTOCURRENCY);
    printSimpleTable(simple(cryptos));
    // System.out.flush();
    } else if (input == 2) {
	// printSimpleTable(simple(getCryptos()));
    } else if (input == 3) {
	// printDetailedTable(detailed(getCryptos()));
    } else if(input == 4) {
        System.out.println("You have quit the program\n");
        System.exit(1);
    } else {
        System.out.println("You have entered " + input + "\n");
    }
    }
  }
  