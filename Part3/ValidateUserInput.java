import java.util.Scanner;

public class ValidateUserInput 
{
    private Scanner scan = new Scanner(System.in);

    public String userInput(String text, String request)
    {
        String input;
        do
        {
            System.out.println(text);
            input = scan.nextLine().trim();

            if(input.isEmpty())
            {
                System.out.println("Please enter a valid value.\n");
                continue;
            }
            if(!validateInput(input, request))
                System.out.println("Please enter a valid input.\n");
        }
        while(input.isEmpty() || !validateInput(input, request));
        return input;
    }

    private boolean validateInput(String input, String request)
    {
        try 
        {
            switch (request) 
            {
                case "money":
                    return validateMoney(input);
                case "password":
                    return validatePassword(input);
                case "ID":
                    return validateID(input);
                case "cars purchased":
                    return validateCarsPurchased(input);
                case "username":
                    return validateUsername(input);
                case "membership":
                    return validateMembership(input);
                default:    
                    return false;
            }    
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validateMoney(String input)
    {
        try{
            double newInput = Double.parseDouble(input);
            if(newInput<0)
                return false;
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    private boolean validatePassword(String input)
    {
        if(input.length()<6)
        {
            System.out.println("Password needs to be at least 6 characters long.");
            return false;
        }
        return true;
    }

    private boolean validateID(String input)
    {
        try{
            int newInput = Integer.parseInt(input);
            if(newInput<=0)
                return false;
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    private boolean validateCarsPurchased(String input)
    {
        try{
            int newInput = Integer.parseInt(input);
            if(newInput<0)
                return false;
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }

    private boolean validateUsername(String input)
    {
        if(input.length()<3)
        {
            System.out.println("Username has to be at least 3 characters long");
            return false;
        }
        return true;
    }

    private boolean validateMembership(String input)
    {
        return (input.equalsIgnoreCase("true") ||
        input.equalsIgnoreCase("false"));
    }
}
