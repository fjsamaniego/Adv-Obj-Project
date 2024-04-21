import java.util.List;

public class RegisterCarsPurchased 
{
    List<Car> carsSold;

    public RegisterCarsPurchased(List<Car> carsSold)
    {
        this.carsSold = carsSold;
    }

    public void showRevenue(String charactetistic)
    {
        if(charactetistic.length() < 3)
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

        if()
        
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
    }

}
