public class Admin extends Person
{
    public String username;
    public int employeeID;
    
    public Admin(String newUsername, int newID,String newName,int newAge, String newAddress, int newSSN) 
    {
        super(newName, newAge, newAddress, newSSN);
        username = newUsername;
        employeeID = newID;        
    }

    /** Setters  */
    public void setUsername(String newUsername)
    {
        username = newUsername;
    }

    public void setEmployeeID(int newID)
    {
        employeeID = newID;
    }

    /** Getters */
    public String getUsername()
    {
        return username;
    }

    public int getEmployeeID()
    {
        return employeeID;
    }
  
}
 