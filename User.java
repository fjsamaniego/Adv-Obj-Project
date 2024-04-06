public class User extends Person
{
    private int userID;
    private String firstName;
    private String lastName;
    private double moneyAvailable;
    private int carsPurchased;
    private boolean minerCarsMembership;
    
    public User(int userID, String firstName, String lastName, double moneyAvailable, 
        int carsPurchased, boolean minerCarsMembership, String username, String password) {

        super(username, password);
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.moneyAvailable = moneyAvailable;
        this.carsPurchased = carsPurchased;
        this.minerCarsMembership = minerCarsMembership;
    
    }

    /** Setters */
    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void lastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setMoneyAvailable(double moneyAvailable)
    {
        this.moneyAvailable = moneyAvailable;
    }

    public void setCarsPurchased(int carsPurchased)
    {
        this.carsPurchased = carsPurchased;
    }

    public void setMinerCarsMembership(boolean minerCarsMembership)
    {
        this.minerCarsMembership = minerCarsMembership;
    }
    
    
    /**
     * 
     * 
     * @return
     */
    public double getID()
    {
        return userID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public double getMoneyAvailable()
    {
        return moneyAvailable;
    }

    public int getCarsPurchased()
    {
        return carsPurchased;
    }

    public boolean getMinerCarsMembership()
    {
        return minerCarsMembership;
    }

    public String toString()
    {
        return String.format("%-5s %-15s %-18s %-10s",
            userID, firstName, lastName, moneyAvailable);
    }

}
