import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * 
 */
public class AdminMenu 
{
    private List<Car> cars;
    private List<User> users;
    private Scanner scan;
    private String userFile;
    private String carFile;
    private Log logger = new Log();
    private int changesMade = 0;

    /**
     * 
     * @param cars
     * @param users
     * @param userFile
     * @param carFile
     */
    public AdminMenu(List<Car> cars, List<User> users, String userFile, String carFile)
    {
        this.cars = cars;
        this.users = users;
        this.userFile = userFile;
        this.carFile = carFile;
        this.scan = new Scanner(System.in);
    }

    /**
     * 
     */
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

    /**
     * 
     */
    private void addCar()
    {
        boolean addingCars = true;
        while(addingCars)
        {
            ArrayList<String> newInformation = new ArrayList<>();
            System.out.println("Please enter the information of the car. ");
            System.out.println();

            newInformation.add(userInput("Enter capacity:"));
            newInformation.add(userInput("Enter car type:"));
            newInformation.add(userInput("Enter availability:"));
            newInformation.add(userInput("Enter the condition:"));
            newInformation.add(userInput("Enter the color:"));
            newInformation.add(userInput("Enter the ID:"));
            newInformation.add(userInput("Enter the year:"));
            newInformation.add(userInput("Enter the price:"));
            newInformation.add(userInput("Enter the type of transmission:"));
            newInformation.add(userInput("Enter the vin:"));
            newInformation.add(userInput("Enter the type of fuel:"));
            newInformation.add(userInput("Enter the model:"));
            newInformation.add(userInput("Enter the if it has turbo: (Yes/No)"));

            Car newCar = CarFactory.createCar(newInformation);
            cars.add(newCar);

            System.out.println("Do you want to add another car (Y/N)");
            String answer = scan.next();

            if(answer.equalsIgnoreCase("N"))
                addingCars = false;
        }

        new CarDataLoad().updateData(cars, carFile);
    }

    /**
     * 
     * @param text
     * @return
     */
    private String userInput(String text)
    {
        String input;
        do
        {
            System.out.println(text);
            input = scan.nextLine().trim();

            if(input.isEmpty())
                System.out.println("Please enter a valid value.");
        }
        while(input.isEmpty());
        return input;
    }


    private void getRevenue()
    {

    }

    private void removeCar()
    {
        System.out.println("Enter the ID of the car you want to remove:");
        boolean stillInSystem = true;
        while(stillInSystem)
        {
            try
            {
                int carID  = scan.nextInt();
                System.out.println("How many do you want to delete?");
                int amount = scan.nextInt();

                boolean wasFound = false;
                for(Car car: cars)
                {
                    if(carID == car.getID())
                    {
                        if(car.getCarsAvailable() > amount)
                        {
                            car.setCarsAvailable(car.getCarsAvailable() - amount);
                        }
                        wasFound = true;
                        break;
                    }
                }

                if(!wasFound)
                {
                    System.out.println("Car not found");
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please enter a number.");
            }

            
            System.out.println("Do you want to delete another car? (Y/N)");
            String input = scan.nextLine();
            if(input.equalsIgnoreCase("N"))
                stillInSystem = false;
        }
        
    }

    /**
     * 
     */
    private void addMoreUsers()
    {
        boolean addingUser = true;
        while(addingUser)
        {
            ArrayList<String> userInformation = new ArrayList<>();
            System.out.println("Please enter the information of the user. ");
            System.out.println();

            userInformation.add(userInput("Enter money available:"));
            userInformation.add(userInput("Enter password:"));
            userInformation.add(userInput("Enter user last name:"));
            userInformation.add(userInput("Enter user ID:"));
            userInformation.add(userInput("Enter number of cars purchased:"));
            userInformation.add(userInput("Enter user first name:"));
            userInformation.add(userInput("Enter username:"));
            userInformation.add(userInput("Enter whether user has MinerCars membership: (TRUE/FALSE)"));

            User newUser = UserDataLoad.loadData(userFile);
            users.add(newUser);

            System.out.println("Do you want to add another user (Y/N)");
            String answer = scan.next();

            if(answer.equalsIgnoreCase("N"))
                addingUser = false;
        }

        new UserDataLoad().updateData(users, userFile);
    }
    

    private void signOut()
    {

    }


}
