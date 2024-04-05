public class User extends Person
{
    private userID;
    private String firstName;
    private String lastName;
    private double moneyAvailable;
    private int carsPurchased;
    

    
    public User(String username, String password, double userBudget) 
    {
        super(username, password);
        this.userBudget = userBudget;
    }

    /** Setters */
    public void setBudget(double userBudget)
    {
        this.userBudget = userBudget;
    }

    public double getBudget()
    {
        return userBudget;
    }
    
}
