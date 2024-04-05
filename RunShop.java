import java.util.Scanner;

public class RunShop 
{
    // attributes
    public static void main(String[] args)
    {
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

    public static void runner1(){}
    public static void runner2(){}
    public static void runner3(){}

    // setters & getters
}

