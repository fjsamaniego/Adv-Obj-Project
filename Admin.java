public class Admin extends Person
{   
    private int employeeID;

    public Admin(String username, String password, int employeeID) 
    {
        super(username, password);
        this.employeeID = employeeID;
    }

    /** Setters  */
    public void setEmployeeID(int newID)
    {
        employeeID = newID;
    }


    public int getEmployeeID()
    {
        return employeeID;
    }
  
}
 