import java.util.*;

public class MainMenu {

  public static menu (String[] args){


    System.out.println("Stratton Oakmont CryptoCurrency Checker");
    System.out.println("");
    System.out.println("Menu Options:");
    System.out.println("1. Top 10 Cryptocurrencies");
    System.out.println("2. Cryptocurreny Value to HUF");
    System.out.println("3. Cryptourrencies Graph");
    System.out.println("4. Credits");
    System.out.println("5. Exit the program");
    System.out.println("");
    System.out.print("Please select an option from 1-5\n");

    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();

    if(input < 0 || input > 5) {
        System.out.println("You have entered an invalid selection, please try again\n");
    } else if(input == 5) {
        System.out.println("You have quit the program\n");
        System.exit(1);
    } else {
        System.out.println("You have entered " + input + "\n");
    }
    }
  }
