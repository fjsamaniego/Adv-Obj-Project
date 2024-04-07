/**
 * Admin class extenteding person class
 */
public class Admin extends Person
{   
    private int employeeID;

    /**
     * 
     * @param username
     * @param password
     * @param employeeID
     */
    public Admin(String username, String password, int employeeID) 
    {
        super(username, password);
        this.employeeID = employeeID;
    }

    /**
     * 
     * @param newID
     */
    public void setEmployeeID(int newID)
    {
        employeeID = newID;
    }

    /**
     * 
     * @return
     */
    public int getEmployeeID()
    {
        return employeeID;
    }
  
}
 