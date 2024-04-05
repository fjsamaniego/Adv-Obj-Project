import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class RunShop 
{
    // attributes
    private static final Scanner scan = new Scanner(System.in);
    private static final UserAuthentication authenticate;
    private static List<User> users;

    static
    {
        /** Loading all the users fromt the csv file */
        UserDataLoad loadU = new UserDataLoad();
        users = loadU.loadUsers("user_data.csv");
        authenticate = new UserAuthentication(users);
    }

    public static void main(String[] args)
    {
        /** Loading all the cars from the csv file */
        CarDataLoad load = new CarDataLoad();
        List<Car> cars = load.loadCars("car_data.csv");

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
                System.out.println("Welcome " + usernameIN);
                verified = true;
                userMenu();
                
            }
            else
                System.out.println("Username or password is incorrect. Please try again.");
            attempts++;
        }
    }
    
}

