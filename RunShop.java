import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class RunShop 
{
    // attributes
    public static void main(String[] args)
    {
        /** Loading all the cars from the csv file */
        CarDataLoad load = new CarDataLoad();
        List<Car> cars = load.loadCars("car_data.csv");

        /** Loading all the users fromt the csv file */
        UserDataLoad load2 = new UserDataLoad();
        List<User> users = load2.loadUsers("user_data.csv");

        boolean inSystem = true;
        Scanner scan = new Scanner(System.in);
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

    public static void runner2(){}
    public static void runner3(){}

    // setters & getters
}

