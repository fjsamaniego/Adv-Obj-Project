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
        System.out.println("Choose how you want to get revenue:");
        System.out.println("1. By ID");
        System.out.println("2. By Car Type");

        try {
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    getRevenueById();
                    break;
                case 2:
                    getRevenueByCarType();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1 or 2.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scan.nextLine(); // Consume the invalid input
        }
    }

    private void getRevenueById() {
        System.out.println("Enter the car ID for which you want to get revenue:");
        int id = scan.nextInt();
        double revenue = 0.0;
    
        int carsSold = 0;
        for (Car car : cars) {
             if (car.getID() == id) {
                 revenue = car.getCarsAvailable();
                 break;
             }
        }
    
        System.out.println("Number of cars sold for ID " + id + ": " + carsSold);
        System.out.println("Revenue for ID " + id + ": $" + revenue);
    }

    private void getRevenueByCarType() {
        // System.out.println("Enter the car type for which you want to get revenue:");
        // String choice = scan.next().trim();
    
        // for(Car car : cars){
        //     if (car.getCarType() == "sedan"){
        //         System.out.println("Revenue for Sedan: $" + sedanRevenue);
        //     }
       
        // }
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
            ArrayList<String> newInfo = new ArrayList<>();
            System.out.println("Please enter the information of the user. ");
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

        new UserDataLoad().updateData(users, userFile);
    }
    


}
