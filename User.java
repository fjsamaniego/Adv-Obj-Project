/**
 * The User class extends the Person class and represents the user and all 
 * their attributes and functions
 */
public class User extends Person
{
    private int userID;
    private String firstName;
    private String lastName;
    private double moneyAvailable;
    private int carsPurchased;
    private boolean minerCarsMembership;
    
    /**
     * Creates contructor for user, including super for username & password
     * from Person class
     * 
     * @param userID
     * @param firstName
     * @param lastName
     * @param moneyAvailable
     * @param carsPurchased
     * @param minerCarsMembership
     * @param username
     * @param password
     */
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

    /** 
     * Sets the userID
     * @param userID the user id to set 
    */
    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    /**
     * Sets the user first name
     * @param firstName user first name to be set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Sets the user last name
     * @param lastName user last name to be set
     */
    public void lastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Sets the user's money available
     * @param moneyAvailable user money available to be set
     */
    public void setMoneyAvailable(double moneyAvailable)
    {
        this.moneyAvailable = moneyAvailable;
    }


    /**
     * Sets the user's cars purchased
     * @param carsPurchased user cars purchased to be set
     */
    public void setCarsPurchased(int carsPurchased)
    {
        this.carsPurchased = carsPurchased;
    }

    /**
     * Sets the miner cars membership
     * @param minerCarsMembership miner cars membership to be set
     */
    public void setMinerCarsMembership(boolean minerCarsMembership)
    {
        this.minerCarsMembership = minerCarsMembership;
    }
    
    
    /**
     * Returns the user ID
     * @return integer of user ID
     */
    public int getID()
    {
        return userID;
    }

    /**
     * Returns the user first name
     * @return String of user first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Returns the user last name
     * @return String of user last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Returns the user's money available
     * @return double of money available
     */
    public double getMoneyAvailable()
    {
        return moneyAvailable;
    }

    /**
     * Returns the user's cars purchased
     * @return integer of user's cars purchased
     */
    public int getCarsPurchased()
    {
        return carsPurchased;
    }

    /**
     * Returns whether user has miner cars membership
     * @return boolean for miner cars membership
     */
    public boolean getMinerCarsMembership()
    {
        return minerCarsMembership;
    }

    /**
     * Returns string representation of car object with userID,
     * firstName, lastName, moneyAvailable attributes 
     * user attributes
     * 
     * @return formatted string of user
     */
    public String toString()
    {
        return String.format("%-5s %-15s %-18s %-10s",
            userID, firstName, lastName, moneyAvailable);
    }

}
