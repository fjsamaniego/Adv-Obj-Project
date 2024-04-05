public class User extends Person
{
    public String username;
    public int customerID;
    public int creditScore;
    

    public User(String newUsername, int newCustomerID, int newCreditScore, String newName, 
    int newAge, String newAddress, int newSSN) 
    {
        super(newName, newAge, newAddress, newSSN);
        username = newUsername;
        customerID = newCustomerID;
        creditScore = newCreditScore;
        
    }

    /** Setters */
    public void setUsername(String newUsername)
    {
        username = newUsername;
    }

    public void setCustomerID(int newID)
    {
        customerID = newID;
    }

    public void setCreditScore(int newCreditScore)
    {
        creditScore = newCreditScore;
    }

    public String getUsername()
    {
        return username;
    }

    public int getCustomerID()
    {
        return customerID;
    }

    public int getCreditScore()
    {
        return creditScore;
    }
    
    
}
