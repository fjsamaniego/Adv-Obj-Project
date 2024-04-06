import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class UserMenu 
{
    private List<Car> cars;
    private User currentUser;
    private Scanner scan;

    public UserMenu(List<Car> cars, User currentUser)
    {
        this.cars = cars;
        this.currentUser = currentUser;
        this.scan = new Scanner(System.in);
    }

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

            int choice = scan.nextInt();
            switch(choice) 
            {
                case 1:
                    displayCars();
                    break;
                case 2:
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
                    break;
                default:
                    System.out.println("Please try again.");
            }
        }
    }

    private void displayCars()
    {
        System.out.println(String.format("%-5s %-15s %-15s %-12s %-8s %-9s %-15s %-10s %-12s %-8s %s",
            "ID", "Car Type", "Model", "Condition", "Color", "Capacity", "Mileage", "Fuel Type", "Transmission", 
            "Price", "Cars Available"));

        for(Car car : cars)
        {
            
            System.out.println(car);
            System.out.println("----");
            
        }
    }

    private void displayCars(String option)
    {
        System.out.println(String.format("%-5s %-15s %-15s %-12s %-8s %-9s %-15s %-10s %-12s %-8s %s",
            "ID", "Car Type", "Model", "Condition", "Color", "Capacity", "Mileage", "Fuel Type", "Transmission", 
            "Price", "Cars Available"));

        for(Car car : cars)
        {
            if(option.equals(car.getCondition()))
            {
                System.out.println(car);
                System.out.println("----");
            }
            
        }
    }

    private void filterCars()
    {
        while(true)
        {
            System.out.println("1) New");
            System.out.println("2) Used");
            System.out.println("3) Go back");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:
                    displayCars("New");
                    break;
                case 2:
                    displayCars("Used");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Please try again.");
            }
            
        } 
    }


    private void purchaseCar()
    {
        System.out.println("Enter the ID of the car you would like to purchase:");
        displayCars();
        int choice = scan.nextInt();
        System.out.println();

        Car chosenCar = null;
        for (Car car : cars){
            if (car.getID() == choice) {
                chosenCar = car;
                break;
            }
        }

        if (chosenCar != null && chosenCar.getCarsAvailable() > 0) {
            System.out.println("You selected: " + chosenCar);

            if (currentUser.getMoneyAvailable() >= chosenCar.getPrice()) 
            {
                
                Scanner scanner = new Scanner(System.in);
                System.out.println("Are you sure you would like to continue with this purchase? (Y/N)");
                String confirmation = scanner.next();
                boolean proceed = false;

                if (confirmation.equals("Y")){
                    proceed = true;
                } else {
                    System.out.println("Transaction cancelled.");
                }

                if (proceed) {
                    System.out.println("You have successfully purchased: " + chosenCar + ".");
                    currentUser.setMoneyAvailable(currentUser.getMoneyAvailable() - chosenCar.getPrice());
                    System.out.println("You now currently have $" + currentUser.getMoneyAvailable() + " available.");
                    chosenCar.setCarsAvailable(chosenCar.getCarsAvailable() - 1);
                    currentUser.setCarsPurchased(currentUser.getCarsPurchased() + 1);
                }

            } else {
                System.out.println("Sorry, you currently do not have money available to purchase this car.");
            }
        } else {
            System.out.println("Sorry, the chosen car is currently not available for purchase.");
        }
        
    }

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
        } else {
            System.out.println("Car with ID " + choice + " not purchased or found.");
        }
    }
    
}
