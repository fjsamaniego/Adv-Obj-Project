import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegisterCarsPurchased 
{
    private static List<Car> carsSold = new ArrayList<>();


    public RegisterCarsPurchased(List<Car> carsSold)
    {
        this.carsSold = carsSold;
    }

    public static void addPurchasedCar(Car car)
    {
        if(car != null)
        {
            carsSold.add(car);
        }
    }

    public List<Car> getPurchasedCars(Car car)
    {
        return Collections.unmodifiableList(carsSold);
    }

    public void showRevenue(String charactetistic)
    {
        if(charactetistic.isEmpty())
        {
            System.out.println("Invalid type");
            return;
        }

        int numCarsSold = 0;
        double revenue = 0;

        for(Car car: carsSold)
        {
            if(car.getCarType().equalsIgnoreCase(charactetistic))
            {
                numCarsSold++;
                revenue += car.getPrice();
            }
        }

        if(numCarsSold == 0)
        {
            System.out.println("Car type not found in the register");
            return;
        }

        System.out.println("Total number of cars sold of type: "+charactetistic+" is "+numCarsSold);
        System.out.println("Revenue: "+ revenue);

        
    }

    public void showRevenue(int charactetistic)
    {
        if(charactetistic <= 0)
        {
            System.out.println("Invalid ID");
            return;
        }

        int numCarsSold = 0;
        double revenue = 0;

        for(Car car: carsSold)
        {
            if(car.getID() == charactetistic)
            {
                numCarsSold++;
                revenue += car.getPrice();
            }
        }

        if(numCarsSold == 0 || numCarsSold == 0)
        {
            System.out.println("ID not found in the register");
            return;
        }

        System.out.println("Total number of cars sold of ID: "+charactetistic+" is "+numCarsSold);
        System.out.println("Revenue: "+revenue);

    }

}
