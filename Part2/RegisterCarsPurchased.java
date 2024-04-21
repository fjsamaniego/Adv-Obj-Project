import java.util.List;

/**
 * 
 */
public class RegisterCarsPurchased 
{
    List<Car> carsSold;

    /**
     * 
     * @param carsSold
     */
    public RegisterCarsPurchased(List<Car> carsSold)
    {
        this.carsSold = carsSold;
    }

    /**
     * 
     * @param characteristic
     */
    public void showRevenue(String characteristic)
    {
        // if (characteristic.length() < 3) {
        //     System.out.println("Invalid type");
        //     return;
        // }

        int numCarsSold = 0;
        double revenue = 0;

        for (Car car : carsSold) {
            if (car.getCarType().equalsIgnoreCase(characteristic)) {
                numCarsSold++;
                revenue += car.getPrice();
            }
        }

        if (numCarsSold == 0) {
            System.out.println("No cars of type " + characteristic + " were sold.");
        } else {
            System.out.println();
            System.out.println("Total number of " + characteristic + " cars sold: " + numCarsSold);
            System.out.println("Total revenue from " + characteristic + " cars: $" + revenue);
        }
        
    }

    /**
     * 
     * @param charactetistic
     */
    public void showRevenue(int characteristic)
    {
        int numCarsSold = 0;
        double revenue = 0;

        for (Car car : carsSold) {
            if (car.getID() == characteristic) {
                numCarsSold++;
                revenue += car.getPrice();
            }
        }

        if (numCarsSold == 0) {
            System.out.println("No cars with ID " + characteristic + " were sold.");
        } else {
            System.out.println();
            System.out.println("Total number of cars sold with ID " + characteristic + ": " + numCarsSold);
            System.out.println("Total revenue from cars with ID " + characteristic + ": $" + revenue);
        }
    }

}
