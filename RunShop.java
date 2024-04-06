import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class RunShop 
{
    // attributes
    private static final Scanner scan = new Scanner(System.in);
    private static final UserAuthentication authenticate;
    private static List<User> users;
    private static List<Car> cars;

    static
    {
        /** Loading all the users from the csv file */
        UserDataLoad loadU = new UserDataLoad();
        users = loadU.loadUsers("updated_user_data.csv");
        authenticate = new UserAuthentication(users);

        /** Loading all the cars from the csv file */
        CarDataLoad loadC = new CarDataLoad();
        cars = loadC.loadCars("updatedCarData.csv");
    }

    public static void main(String[] args)
    {  
        /** Login page */
        boolean inSystem = true;
        while(inSystem)
        {
            System.out.println("Welcome to MineCars!");
            System.out.println("Please choose one of the following:");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.println("Select either 1 or 2, please type it:");
            int choice = scan.nextInt();
            System.out.println();

            if(choice == 1)
            {
                login();
                inSystem = false;
            }
            else if(choice == 2)
            {
                System.exit(0);
                inSystem = false;
            }
            else
            {
                System.out.println("Invalid, please select 1 or 2.");
            }


        }


    }

    public static void login()
    {
        scan.nextLine();
        boolean verified = false;
        int attempts = 0;
        while(attempts < 10 && !verified)
        {
            System.out.println("Username: ");
            String usernameIN = scan.nextLine();
            System.out.println("Password: ");
            String passwordIn = scan.nextLine();
            if(authenticate.verifyCredentials(usernameIN, passwordIn))
            {
                System.out.println();
                System.out.println("Welcome " + usernameIN);
                verified = true;
                new UserMenu(cars, users, authenticate.getCurrentUser(), "updated_user_data.csv", "updatedCarData.csv").MenuDisplay();                
            }
            else
                System.out.println("Username or password is incorrect. Please try again.");
            attempts++;
        }
    }
    
}

