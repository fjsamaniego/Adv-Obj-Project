import java.util.ArrayList;

/**
 * 
 */
public class UserFactory {
    public static User createUser(String[] userInformation)
    {
        double moneyAvailable = Double.parseDouble(userInformation[0]);
        String pasword = userInformation[1];
        String lastname = userInformation[2];
        int id = Integer.parseInt(userInformation[3]);
        int carsPurchased = Integer.parseInt(userInformation[4]);
        String firstname = userInformation[5];
        String usernmae = userInformation[6];
        String minerCarsMembership = userInformation[6];

        // switch (username.toLowerCase())
        //  {
        //     case "sedan":
        //         return new Sedan(id,carType,model,condition,color,capacity,
        //         year,fuelType,transmission,vin,price,carsAvailable,hasTurbo);
        //     case "suv":
        //         return new SUV(id, carType, model, condition, color, capacity,
        //         year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
        //     case "hatchback":
        //         return new Hatchback(id, carType, model, condition, color, capacity,
        //         year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
        //     case "pickup":
        //         return new Hatchback(id, carType, model, condition, color, capacity,
        //         year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
        //     default:
        //         throw new IllegalArgumentException("Invalid car type");
        // }
    }

    public static User createUser(ArrayList<String> userInformation)
    {
        try
        {
            double moneyAvailable = Double.parseDouble(userInformation.get(0));
            String pasword = userInformation.get(1);
            String lastname = userInformation.get(2);
            int id = Integer.parseInt(userInformation.get(3));
            int carsPurchased = Integer.parseInt(userInformation.get(4));
            String firstname = userInformation.get(5);
            String usernmae = userInformation.get(6);
            String minerCarsMembership = userInformation.get(6);

        //     switch (carType.toLowerCase())
        //     {
        //         case "sedan":
        //             return new Sedan(id,carType,model,condition,color,capacity,
        //             year,fuelType,transmission,vin,price,carsAvailable,hasTurbo);
        //         case "suv":
        //             return new SUV(id, carType, model, condition, color, capacity,
        //             year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
        //         case "hatchback":
        //             return new Hatchback(id, carType, model, condition, color, capacity,
        //             year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
        //         case "pickup":
        //             return new Hatchback(id, carType, model, condition, color, capacity,
        //             year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
        //         default:
        //             throw new IllegalArgumentException("Invalid car type");
        // }
        }
        catch(NumberFormatException e)
        {
            throw new IllegalArgumentException("Error passing information", e);
        }
    }
}
