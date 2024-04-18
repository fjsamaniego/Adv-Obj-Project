import java.util.ArrayList;

public class CarFactory
{
    public static Car createCar(String[] carInformation)
    {
        int capacity = Integer.parseInt(carInformation[0]);
        String carType = carInformation[1];
        int carsAvailable = Integer.parseInt(carInformation[2]);
        String condition = carInformation[3];
        String color = carInformation[4];
        int id = Integer.parseInt(carInformation[5]);
        int year = Integer.parseInt(carInformation[6]);
        double price = Double.parseDouble(carInformation[7]);
        String transmission = carInformation[8];
        String vin = carInformation[9];
        String fuelType = carInformation[10];
        String model = carInformation[11];
        String hasTurbo = carInformation[12].isEmpty() ? "No" : carInformation[12];

        switch (carType.toLowerCase())
         {
            case "sedan":
                return new Sedan(id,carType,model,condition,color,capacity,
                year,fuelType,transmission,vin,price,carsAvailable,hasTurbo);
            case "suv":
                return new SUV(id, carType, model, condition, color, capacity,
                year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
            case "hatchback":
                return new Hatchback(id, carType, model, condition, color, capacity,
                year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
            case "pickup":
                return new Hatchback(id, carType, model, condition, color, capacity,
                year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
            default:
                throw new IllegalArgumentException("Invalid car type");
        }
    }

    public static Car createCar(ArrayList<String> carInformation)
    {
        int capacity = Integer.parseInt(carInformation.get(0));
        String carType = carInformation.get(0);
        int carsAvailable = Integer.parseInt(carInformation.get(0));
        String condition = carInformation.get(0);
        String color = carInformation.get(0);
        int id = Integer.parseInt(carInformation.get(0));
        int year = Integer.parseInt(carInformation.get(0));
        double price = Double.parseDouble(carInformation.get(0));
        String transmission = carInformation.get(0);
        String vin = carInformation.get(0);
        String fuelType = carInformation.get(0);
        String model = carInformation.get(0);
        String hasTurbo = carInformation.get(0);

        switch (carType.toLowerCase())
         {
            case "sedan":
                return new Sedan(id,carType,model,condition,color,capacity,
                year,fuelType,transmission,vin,price,carsAvailable,hasTurbo);
            case "suv":
                return new SUV(id, carType, model, condition, color, capacity,
                year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
            case "hatchback":
                return new Hatchback(id, carType, model, condition, color, capacity,
                year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
            case "pickup":
                return new Hatchback(id, carType, model, condition, color, capacity,
                year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
            default:
                throw new IllegalArgumentException("Invalid car type");
        }
    }
}