import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

public class CarDataLoad
{
    public List<Car> loadCars(String file)
    {
        List<Car> cars = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine();
            String line = br.readLine();
            while(line != null)
            {
                String []carInformation = line.split(",");

                int id = Integer.parseInt(carInformation[0]);
                String carType = carInformation[1];
                String model = carInformation[2];
                String condition = carInformation[3];
                String color = carInformation[4];
                int capacity = Integer.parseInt(carInformation[5]);
                int mileage = Integer.parseInt(carInformation[6]);
                String fuelType = carInformation[7];
                String transmission = carInformation[8];
                String vin = carInformation[9];
                double price = Double.parseDouble(carInformation[10]);
                int carsAvailable = Integer.parseInt(carInformation[11]);

                Car car = new Car(id, carType ,model, condition,
                color, capacity, mileage, fuelType, transmission, vin,
                price, carsAvailable);

                cars.add(car);
                line = br.readLine();
            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return cars;
    }

    public void updateCars(List<Car> cars, String file)
    {
        try(BufferedWriter wr = new BufferedWriter(new FileWriter(file)))
        {
            wr.write("ID,Car Type,Model,Condition,Color,Capacity,Mileage,Fuel Type,Transmission,VIN,Price,Cars Available\n");

            for(Car car : cars)
            {
                String newLine = String.format("%d,%s,%s,%s,%s,%d,%d,%s,%s,%s,%.2f,%d\n",
                car.getID(), 
                car.getCarType(), 
                car.getModel(), 
                car.getCondition(), 
                car.getColor(), 
                car.getCapacity(), 
                car.getMileage(), 
                car.getFuelType(),
                car.getTransmission(), 
                car.getVin(), 
                car.getPrice(), 
                car.getCarsAvailable());

                wr.write(newLine);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error writing the new data");
        }
    }
}
