import java.util.Scanner;

public class ValidateCarInput
{
    private Scanner scan = new Scanner(System.in);

    public String carInput(String text, String request)
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
                case "capacity":
                    return validateCapacity(input);
                case "availability":
                    return validateAvailability(input);
                case "condition":
                    return validateCondition(input);
                case "ID":
                    return validateID(input);
                case "year":
                    return validateYear(input);
                case "price":
                    return validatePrice(input);
                case "transmission":
                    return validateTransmission(input);
                case "vin":
                    return validateVIN(input);
                case "fuel type":
                    return validateFuelType(input);
                case "turbo":
                    return validateTurbo(input);
                default:
                    return false;

            }    
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validateCapacity(String input)
    {
        try{
            int newInput = Integer.parseInt(input);
            if(newInput<1 || newInput>10)
                return false;
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    private boolean validateAvailability(String input)
    {
        
        try {
            int newInput = Integer.parseInt(input);
            if(newInput<0)
                return false;
            return true;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validateCondition(String input)
    {
        return (input.equalsIgnoreCase("used") || 
        input.equalsIgnoreCase("new"));
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

    private boolean validateYear(String input)
    {
        try{
            int newInput = Integer.parseInt(input);
            if (newInput<1960 || newInput>=2024)
                return false;
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    private boolean validatePrice(String input)
    {
        try{
            double newInput = Double.parseDouble(input);
            if(newInput<=1000)
                return false;
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    private boolean validateTransmission(String input)
    {
        return (input.equalsIgnoreCase("automatic") ||
        input.equalsIgnoreCase("manual"));
    }

    private boolean validateVIN(String input)
    {
        return input.length()>=15;
    }

    private boolean validateFuelType(String input)
    {
        return (input.equalsIgnoreCase("gasoline") ||
        input.equalsIgnoreCase("diesel") ||
        input.equalsIgnoreCase("hybrid") ||
        input.equalsIgnoreCase("electric"));
    }

    private boolean validateTurbo(String input)
    {
        return (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no"));
    }
}
