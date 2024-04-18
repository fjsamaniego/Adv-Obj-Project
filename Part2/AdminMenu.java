import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class AdminMenu 
{
    private List<Car> cars;
    private List<User> users;
    private Scanner scan;
    private String userFile;
    private String carFile;
    private Log logger = new Log();
    private int changesMade = 0;

    public AdminMenu(List<Car> cars, List<User> users, String userFile, String carFile)
    {
        this.cars = cars;
        this.users = users;
        this.userFile = userFile;
        this.carFile = carFile;
        this.scan = new Scanner(System.in);
    }

    public void MenuDisplay()
    {
        boolean stillLoggedIn = true;
        while(stillLoggedIn)
        {
            System.out.println();
            System.out.println("MENU");
            System.out.println("1. Add a car.");
            System.out.println("2. Get revenue.");
            System.out.println("3. Remove a car.");
            System.out.println("4. Add more users.");
            System.out.println("5. Sign out.");

            try
            {
                int choice = scan.nextInt();
                switch (choice) 
                {
                    case 1:
                        addCar();
                        break;
                    case 2:
                        getRevenue();
                        break;
                    case 3:
                        removeCar();
                    case 4:
                        addMoreUsers();
                        break;
                    case 5:
                        stillLoggedIn = false;
                        signOut();
                    default:
                        break;
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid, please enter a number.");
                scan.nextLine();
            }
            
            
            
        }
    }

    private void addCar()
    {
        ArrayList<String> newInformation = new ArrayList<>();
        System.out.println("Please enter the information of the car. ");
        System.out.println();

        System.out.println("Enter capacity:");
        String input =  scan.next();
        newInformation.add(input);

        System.out.println("Enter car type:");
        input =  scan.next();
        newInformation.add(input);
        
        System.out.println("Enter availability");
        input =  scan.next();
        newInformation.add(input);

        System.out.println("Enter the condition");
        input =  scan.next();
        newInformation.add(input);

        System.out.println("Enter the color");
        input =  scan.next();
        newInformation.add(input);

        System.out.println("Enter the ID");
        input =  scan.next();
        newInformation.add(input);

        System.out.println("Enter the year");
        input =  scan.next();
        newInformation.add(input);

        System.out.println("Enter the price");
        input =  scan.next();
        newInformation.add(input);

        System.out.println("Enter the type of transmission");
        input =  scan.next();
        newInformation.add(input);

        System.out.println("Enter the vin");
        input =  scan.next();
        newInformation.add(input);

        System.out.println("Enter the type of fuel");
        input =  scan.next();
        newInformation.add(input);

        System.out.println("Enter the model");
        String model = scan.nextLine();

        System.out.println("Enter the if has turbo (Yes/No)");
        input =  scan.next();
        newInformation.add(input);

        Car newCar = CarFactory.createCar(null)
        
        
        
    }

    private void getRevenue()
    {

    }

    private void removeCar()
    {

    }

    private void addMoreUsers()
    {

    }

    private void signOut()
    {

    }


}
