import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * The class UserMenu display the main menu to the user, as well as
 * it allows the user to navigate through it. 
 * Allows the user to view all the cars and their information, filter them based
 * on if they are new or used, purchase a car, view the ticket of the purchase
 * and sign out
 */
public class UserMenu
{
    private List<Car> cars;
    private List<User> users;
    private User currentUser;
    private Scanner scan;
    private int purchasesMade = 0;
    private String userFile;
    private String carFile;
    private Log log = new Log();

    /**
     * Constructs a new object of UserMenu
     * 
     * @param cars list of cars in the dealership
     * @param users list of users in the dealership
     * @param currentUser the user that is currently logged in
     * @param userFile relative path to the user data file
     * @param carFile relative path to the car data file
     */
    public UserMenu(List<Car> cars, List<User> users,User currentUser, String userFile, String carFile)
    {
        this.cars = cars;
        this.users = users;
        this.currentUser = currentUser;
        this.userFile = userFile;
        this.carFile = carFile;
        this.scan = new Scanner(System.in);
    }

    /**
     * This method is in charged of displaying the main menu.
     * It has a loop so that the user stays logged even after using features of
     * the menu several times. The only way to stop the loop is to sign out 
     * <p>
     * Each actions has their own method implementation.
     * @throws InputMismatchException if the user inputs a string/char that cannot be
     *      converted to an int 
     */
    public void MenuDisplay()
    {
        boolean stillLoggedIn = true;
        while(stillLoggedIn)
        {   
            System.out.println();
            System.out.println("MENU");
            System.out.println("1. Display all cars.");
            System.out.println("2. Filter Cars (used/new)");
            System.out.println("3. Purchase a car.");
            System.out.println("4. View Tickets.");
            System.out.println("5. Sign out");
            System.out.println();
            System.out.print("Please select an option: ");
            System.out.println();

            try
            {
                int choice = scan.nextInt();
                switch(choice) 
                {
                    case 1:
                        displayCars();
                        log.writeToLog("Displayed all cars", currentUser); // updates action to dealership_log.txt
                        break;
                    case 2:
                        log.writeToLog("Filtered cars by conditon", currentUser); // updates action to dealership_log.txt
                        filterCars();
                        break;
                    case 3:
                        purchaseCar();
                        break;
                    case 4:
                        viewTickets();
                        break;
                    case 5:
                        stillLoggedIn = false;

                        signOut();
                        break;
                    default:
                        System.out.println("Please try again.");
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid, please enter a number.");
                scan.nextLine();
            }
            
        }
    }
    
    /**
     * This method prints the whole list of cars with their respective information
     */
    private void displayCars()
    {
        // formats attributes to be printed in an organized way
        System.out.println(String.format("%-5s %-15s %-15s %-12s %-8s %-9s %-15s %-10s %-12s %-8s %s",
        "ID",
            "Car Type", 
            "Model", 
            "Condition", 
            "Color", 
            "Capacity", 
            "Mileage", 
            "Fuel Type", 
            "Transmission", 
            "Price", 
            "Cars Available"));

        for(Car car : cars)
        {
            
            System.out.println(car);
            System.out.println("----");
            
        }
    }

    /**
     * An overloaded method of displayCars(), but in this case we only print
     * based on the filter that was given
     * @param option could be either "New" of "Used"
     */
    private void displayCars(String option)
    {
        System.out.println(String.format("%-5s %-15s %-15s %-12s %-8s %-9s %-15s %-10s %-12s %-8s %s",
            "ID", 
            "Car Type",
            "Model",
            "Condition",
            "Color", 
            "Capacity",
            "Mileage", 
            "Fuel Type", 
            "Transmission", 
            "Price",
            "Cars Available"));

        for(Car car : cars)
        {
            if(option.equals(car.getCondition()))
            {
                System.out.println(car);
                System.out.println("----");
            }
            
        }
    }

    /**
     * In this method we call displayCars(String) to filter the cars that the
     * user wants to see depending on the cars' condition
     * @throws InputMismatchException if the user inputs a string/char that cannot be
     *      converted to an int 
     */
    private void filterCars()
    {
        while(true)
        {
            System.out.println("1) New");
            System.out.println("2) Used");
            System.out.println("3) Go back");

            try
            {
                int choice = scan.nextInt();
                switch (choice)
                {
                    // if user chooses new car
                    case 1:
                        displayCars("New");
                        break;
                    // if user chooses used car
                    case 2:
                        displayCars("Used");
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Please try again.");
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid, please enter a number.");
                scan.nextLine();
            }
        } 
    }

    /**
     * This method first confirms the users has enough money to buy 
     * the desired car. Then the purchase is made, and changes to the availability of the car. 
     * user money are updated
     */
    private void purchaseCar()
    {
        System.out.println();
        System.out.println("Enter the ID of the car you would like to purchase:");

        System.out.println();
        displayCars();
        int choice = scan.nextInt();
        System.out.println();

        Car chosenCar = null; 
        for (Car car : cars){ // iterates through the cars
            if (car.getID() == choice) { // car ID they choosen become chosenCar
                chosenCar = car;
                break;
            }
        }

        if (chosenCar != null && chosenCar.getCarsAvailable() > 0) { // if chosenCar is in file and available
            System.out.println("You selected: " + chosenCar);

            if (currentUser.getMoneyAvailable() >= chosenCar.getPrice())  // checks if car is in users budget
            {
                
                Scanner scanner = new Scanner(System.in);
                System.out.println("Are you sure you would like to continue with this purchase? (Y/N)");
                String confirmation = scanner.next();
                boolean proceed = false;

                if (confirmation.equals("Y")){ // if user chooses to proceed with purchase
                    proceed = true;
                } else {
                    System.out.println("Transaction cancelled.");
                }

                if (proceed) {
                    System.out.println();
                    System.out.println("Congratulations! You have successfully purchased the:"); 

                    // display ticket once car is purchased
                    System.out.println("Car Type: " + chosenCar.getCarType());
                    System.out.println("Model: " + chosenCar.getModel());
                    System.out.println("Color: " + chosenCar.getColor());

                    currentUser.setMoneyAvailable(currentUser.getMoneyAvailable() - chosenCar.getPrice());
                    System.out.println();
                    System.out.println("You now currently have $" + currentUser.getMoneyAvailable() + " available.");
                    chosenCar.setCarsAvailable(chosenCar.getCarsAvailable() - 1);
                    currentUser.setCarsPurchased(currentUser.getCarsPurchased() + 1);
                    purchasesMade++;
                    log.writeToLog("Purchased a car", currentUser);
                }
            } 
            else{
                log.writeToLog("Failed to purchased a car", currentUser); // log action to dealership_log.txt
                System.out.println("Sorry, you currently do not have money available to purchase this car.");
            }

        } else {
            log.writeToLog("Failed to purchased a car", currentUser); // log action to dealership_log.txt
            System.out.println("Sorry, the chosen car is currently not available for purchase.");
        }
        
    }

    /**
     * Here we just show the ticket of the purchase by the given ID of the car
     */
    private void viewTickets()
    {

        System.out.println("Enter the ID of the car purchased:");
        int choice = scan.nextInt();
        
        System.out.println();

        Car boughtCar = null;
        for (Car car : cars){
            if (car.getID() == choice) {
                boughtCar = car;
                break;
            }
        }

        if (boughtCar != null){
            System.out.println("Tickets for purchased cars: ");
            System.out.println("Car Type: " + boughtCar.getCarType());
            System.out.println("Model: " + boughtCar.getModel());
            System.out.println("Color: " + boughtCar.getColor());
            System.out.println();
            log.writeToLog("Viewed tickets", currentUser);

        } else {
            System.out.println("Car with ID " + choice + " not purchased or found.");
        }
    }
    
    /**
     * If one or more purchases were made during the session of the user, then
     * the carData file and userData file are updated by calling their respective classes
     */
    private void signOut()
    {
        if(purchasesMade >= 1)
        {
            new UserDataLoad().updateData(users, userFile); // updates user data in updated_user_data.csv
            new CarDataLoad().updateData(cars, carFile); // updates car data in updatedCarData.csv
            log.writeToLog("Logged out", currentUser); // logs action to dealership_log.txt
        }
    }
}
