package com.codecool.display;

import java.util.*;
import com.codecool.credits.*;
import com.codecool.selecter.*;
import com.codecool.display.*;
import com.codecool.currency.*;
import com.codecool.currency.Currency;

public class Menu {

    public static final Scanner scanner = new Scanner(System.in);

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

    public static void startBasicTable(List<Map<String, Object>> cryptos) {

        while (true) {
            try {
                Table.printSimpleTable(DataSelecter.simple(cryptos));
                int input = scanner.nextInt();
                if (input >= 1 && input <= 10) {
                    Table.printDetailedTable(DataSelecter.detailed(cryptos), input - 1);
                } else if (input == 0) {
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

    public static void startConvertedTable(List<Map<String, Object>> cryptos) {
        Table.printConvertedTable(DataSelecter.converted(cryptos));
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input == 0) {
                    break;
                } else {
                    System.out.println("Press 0 to go Back");
                }

            } catch (InputMismatchException e) {
                System.out.println("Try a number please");
                scanner.nextLine();
            }
        }
    }

    public static void startCredits() {
        Credits.showCredits();
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input == 0) {
                    break;
                } else {
                    System.out.println("Press 0 to go Back");
                }
            } catch (InputMismatchException e) {
                System.out.println("Try a number please");
                scanner.nextLine();
            }
        }
    }

    public static void chooseMenu() {

        int input = scanner.nextInt();
        Currency CryptoCurrency = new Currency();
        List<Map<String, Object>> cryptos = CryptoCurrency.getCurrency(Currency.API_KEY_CRYPTOCURRENCY, Currency.API_KEY_CRYPTOCURRENCY );


        
        if (input < 0 || input > 5) {
            System.out.println("You have entered an invalid selection, please try again\n");
        } else if (input == 1) {
            startBasicTable(cryptos);
        } else if (input == 2) {
            startConvertedTable(cryptos);
        } else if (input == 3) {
            startCredits();
        } else if (input == 4) {
            System.out.println("You have quit the program\n");
            System.exit(1);
        } else {
            System.out.println("error");

            throw new InputMismatchException();
        }
    }
}