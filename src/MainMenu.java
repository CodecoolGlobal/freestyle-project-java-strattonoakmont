import java.util.*;
import com.codecool.currency.Currency;
import static com.codecool.display.Menu.scanner;
import static com.codecool.selecter.DataSelecter.*;
import static com.codecool.display.Table.*;
import static com.codecool.credits.Credits.showCredits;
import java.io.IOException;

public class MainMenu {

    public static final String URL_CRYPTOCURRENCY = "https://min-api.cryptocompare.com/data/top/totalvolfull?limit=10&tsym=USD";
    public static final String API_KEY_CRYPTOCURRENCY = "0081703480f82a60b595181a70323ac1065be2ed0aefa6ce538de6b8a24d6108";

    
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
        scanner.close();
    }
}
