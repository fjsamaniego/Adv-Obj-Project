import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;

/**
 * CarDataLoad reads through car_data csv and find and sets Car attributes
 * to variables
 */
public class CarDataLoad implements DataLoad<Car>
{
    /**
     * Loads car data from csv file.
     * 
     * @param file The path of the csv file to load data from.
     * @return A list containing Car objects loaded from the csv file
     */

    public List<Car> loadData(String file)
    {
        List<Car> cars = new ArrayList<>();
        

        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String[] headers = br.readLine().split(",");
            
            String line = br.readLine();
            while(line != null)
            {
                Map<String, String> carInformation = new HashMap<>();
                String []details = line.split(",",-1);
                int i = 0;
                for(String header:headers)
                {
                    carInformation.put(header,details[i]);
                    i++;
                }
                Car car = CarFactory.createCar(carInformation);

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

    // @Override
    // public List<Car> loadData(String file)
    // {
    //     List<Car> cars = new ArrayList<>();
    //     try(BufferedReader br = new BufferedReader(new FileReader(file)))
    //     {
    //         br.readLine();
    //         String line = br.readLine();
    //         while(line != null)
    //         {
    //             String []carInformation = line.split(",",-1);
    //             Car car = CarFactory.createCar(carInformation);

    //             cars.add(car);
    //             line = br.readLine();
    //         }

    //     }
    //     catch(IOException e)
    //     {
    //         e.printStackTrace();
    //     }

    //     return cars;
    // }

    /**
     * Updates car data in csv file.
     * 
     * @param cars The list of Car objects containing updated data.
     * @param file The path of the csv file to update.
     */
    @Override
    public void updateData(List<Car> cars, String file)
    {
        try(BufferedWriter wr = new BufferedWriter(new FileWriter(file)))
        {
            wr.write("Capacity,Car Type,Cars Available,Condition,Color,ID,Year,Price,Transmission,VIN,Fuel Type,Model,hasTurbo\n");

            for(Car car : cars)
            {
                String newLine = String.format("%d,%s,%d,%s,%s,%d,%d,%.2f,%s,%s,%s,%s,%s\n",
                car.getCapacity(), 
                car.getCarType(), 
                car.getCarsAvailable(),
                car.getCondition(), 
                car.getColor(), 
                car.getID(), 
                car.getYear(),
                car.getPrice(), 
                car.getTransmission(), 
                car.getVin(), 
                car.getFuelType(),
                car.getModel(), 
                car.getHasTurbo());

                wr.write(newLine);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error writing the new data");
        }
    }
}
