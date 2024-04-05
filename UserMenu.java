import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class UserMenu 
{
    private List<Car> cars;
    private Scanner scan;

    public UserMenu(List<Car> cars)
    {
        this.cars = cars;
        this.scan = new Scanner(System.in);
    }

    public void MenuDisplay()
    {
        boolean stillLoggedIn = true;
        while(stillLoggedIn)
        {   
            System.out.println("MENU");
            System.out.println("1. Display all cars.");
            System.out.println("2. Filter Cars (used/new)");
            System.out.println("3. Purchase a car.");
            System.out.println("4. View Tickets.");
            System.out.println("5. Sign out");
            System.out.println();
            System.out.print("Please select an option: ");

            int choice = scan.nextInt();
            switch(choice) 
            {
                case 1:
                    displayAllCars();
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
                default:
                    System.out.println("Please try again.");
            }
            stillLoggedIn = false;
        }
    }

    private void displayAllCars()
    {
        System.out.println(String.format("%-15s %-15s %-12s %-8s %-9s %-15s %-10s %-12s %-8s %s",
            "Car Type", "Model", "Condition", "Color", "Capacity", "Mileage", "Fuel Type", "Transmission", 
            "Price", "Cars Available"));

        for(Car car : cars)
        {
            System.out.println(car);
            System.out.println("----");
        }
    }

    private void filterCars()
    {

    }

    private void purchaseCar()
    {

    }

    private void viewTickets()
    {

    }
    
}
