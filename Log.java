public class Log 
{
    // attributes
    private String password;
    public Car[] listOfCars;

    /** Setters */
    public void setPassword(String newPassword)
    {
        password = newPassword;
    }

    public void setListOfCars(Car[] newListC)
    {
        listOfCars = newListC;
    }

    /** Getters */

    public String getPassword()
    {
        return password;
    }

    public Car[] getListOfCars()
    {
        return listOfCars;
    }

}