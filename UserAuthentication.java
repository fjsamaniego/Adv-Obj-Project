import java.util.List;

public class UserAuthentication 
{
    private List<User> users;
    private User currentUser;

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
                currentUser = user;
                return true;
            }
        }

        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

}
