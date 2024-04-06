import java.util.List;

public class UserAuthentication 
{
    private List<User> users;

    public UserAuthentication(List<User> users)
    {
        this.users = users;
    }

    public boolean verifyCredentials(String usernameIN, String passwordIN)
    {
        for(User user : users)
        {
            if(user.getUsername().equals(usernameIN) && user.getPassword().equals(passwordIN))
            {
                return true;
            }
        }

        return false;
    }

}
