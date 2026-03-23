import java.util.Scanner;

public class Input {
    
    public static void getAllPreferences(Search search) {
        getSoyPreference(search);
        getPeanutPreference(search);
        getKashrutPreference(search);
        getVegetarianPreference(search);
    }

    public static void editPreferences(Search search) {
        getAllPreferences(search);
    }

    private static void getSoyPreference(Search search) {
        // creates a scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // checks if the user wants to check for soy allergens
        System.out.println("Do you want to check for soy allergens? (y/n)");
        String soyInput = scanner.nextLine();
        if (soyInput.toLowerCase().equals("y")) {
            search.enableSoy();
        } else if (soyInput.toLowerCase().equals("n")) {
            search.disableSoy();
        } else {
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
            search.disableSoy();
            getSoyPreference(search);
        }
    } 

    private static void getPeanutPreference(Search search) {
        // creates a scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // checks if the user wants to check for peanut allergens
        System.out.println("Do you want to check for peanut allergens? (y/n)");
        String peanutInput = scanner.nextLine();
        if (peanutInput.toLowerCase().equals("y")) {
            search.enablePeanuts();
        } else if (peanutInput.toLowerCase().equals("n")) {
            search.disablePeanuts();
        } else {
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
            search.disablePeanuts();
            getPeanutPreference(search);
        }
    } 

    private static void getKashrutPreference(Search search) {
        // creates a scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // checks if the user wants to check for kashrut issues
        System.out.println("Do you want to check for kashrut issues? (y/n)");
        String kashrutInput = scanner.nextLine();
        if (kashrutInput.toLowerCase().equals("y")) {
            search.enableKosher();
        } else if (kashrutInput.toLowerCase().equals("n")) {
            search.disableKosher();
        } else {
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
            search.disableKosher();
            getKashrutPreference(search);
        }
    } 

    private static void getVegetarianPreference(Search search) {
        // creates a scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // checks if the user wants to check for vegetarian issues
        System.out.println("Do you want to check for vegetarian issues? (y/n)");
        String vegetarianInput = scanner.nextLine();
        if (vegetarianInput.toLowerCase().equals("y")) {
            search.enableVegetarian();
        } else if (vegetarianInput.toLowerCase().equals("n")) {
            search.disableVegetarian();
        } else {
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
            search.disableVegetarian();
            getVegetarianPreference(search);
        }
    }
    public static void options(Search search) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to edit your preferences? (y/n)");
        String input = scanner.nextLine();
        if (input.toLowerCase().equals("y")) {
            // edit preferences
            getAllPreferences(search);
        } else if (input.toLowerCase().equals("n")) {
            // do nothing
        } else {
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
            options(search);
        }
    }
    public static void close() {
        // closes the scanner object
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    } 
}
