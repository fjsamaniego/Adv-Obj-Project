import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Class represents menu for managing cars and users from administrative perspective.
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
    private List<Car> purchasedCarsByUsers;

    /**
     * Constructs menu for managing cars and users. 
     * @param cars list of cars
     * @param users list of users
     * @param userFile path to file storing user data
     * @param carFile path to file storing car data
     */
    public AdminMenu(List<Car> cars, List<User> users, String userFile, String carFile, List<Car> purchasedCarsByUsers)
    {
        this.cars = cars;
        this.users = users;
        this.userFile = userFile;
        this.carFile = carFile;
        this.purchasedCarsByUsers = purchasedCarsByUsers;
        this.scan = new Scanner(System.in);

    }

    /**
     * Displays menu containing option admin can perform.
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
            System.out.println("5. Sign Out");

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
                        break;
                    default:
                        System.out.println("Please try again.");
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
     * Allows admin to all a car with all the fields required, to the 
     * updated car data file.
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
            
            logger.writeToLog("added a car of ID: "+ newCar.getID());
        }

        new CarDataLoad().updateData(cars, carFile);
    }

    /**
     * Takes user input from the console after displaying the specified text prompt.
     * @param text Prompt to display to user
     * @return returns user input
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

    /**
     * 
     */
    private void getRevenue()
    {
        System.out.println();
        System.out.println("Choose how you want to get revenue:");
        System.out.println("1. By ID");
        System.out.println("2. By Car Type");

        try {
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("Enter the ID for which you want to get revenue:");
                    int id = scan.nextInt();
                    new RegisterCarsPurchased(cars).showRevenue(id);
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Enter the car type for which you want to get revenue:");
                    String carType = scan.next().trim();
                    new RegisterCarsPurchased(cars).showRevenue(carType);
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please choose 1 or 2.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scan.nextLine(); 
        }
    }


    /**
     * Admin enters ID to remove car from the car dealership byt deleting it
     * from the carsAvailable amount.
     */
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

                scan.nextLine();

                boolean wasFound = false;
                for(Car car: cars)
                {
                    if(carID == car.getID())
                    {
                        if(car.getCarsAvailable() >= amount)
                        {
                            car.setCarsAvailable(car.getCarsAvailable() - amount);
                            wasFound = true;
                            break;
                        }
                        else
                        {
                            System.out.println("There are less cars than the specified.");
                            System.out.println("Please try again.");
                        }
                        
                    }
                }

                if(!wasFound)
                {
                    System.out.println("Car was not found");
                    logger.writeToLog("Failed to delete car.");
                    break;
                }

                new CarDataLoad().updateData(cars, carFile);
                logger.writeToLog("deleted " + amount + (amount > 1 ? " cars of ID: "+carID : "car of ID: "+carID));
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please enter a number.");
                scan.nextLine();
            }

            
            System.out.println("Do you want to delete another car? (Y/N)");
            String input;
            do
            {   System.out.println("Please input either Y or N.");
                input = scan.nextLine();
            }
            while(!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N"));

            if(input.equalsIgnoreCase("N"))
                stillInSystem = false;
            
        }    
    }

    /**
     * Admin can all new users by entering all the user fields, 
     * and updating the user file.
     */
    private void addMoreUsers()
    {
        boolean addingUser = true;
        while(addingUser)
        {
            ArrayList<String> newInfo = new ArrayList<>();
            System.out.println("Please enter all the information of the user. ");
            System.out.println();

            newInfo.add(userInput("Enter money available:"));
            newInfo.add(userInput("Enter password:"));
            newInfo.add(userInput("Enter user last name:"));
            newInfo.add(userInput("Enter user ID:"));
            newInfo.add(userInput("Enter number of cars purchased:"));
            newInfo.add(userInput("Enter user first name:"));
            newInfo.add(userInput("Enter username:"));
            newInfo.add(userInput("Enter whether user has MinerCars membership: (TRUE/FALSE)"));

            User newUser = UserFactory.createUser(newInfo);
            users.add(newUser);

            System.out.println("Do you want to add another user (Y/N)");
            String answer = scan.next();

            if(answer.equalsIgnoreCase("N"))
                addingUser = false;
        }

        new UserDataLoad().updateData(users, userFile); // updates user file
    }
}
