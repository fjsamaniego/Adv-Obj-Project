import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

public class UserDataLoad
{
    public List<User> loadUsers (String file)
    {
        List<User> users = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine();
            String line = br.readLine();
            while(line != null)
            {
                String []userInfo = line.split(",");

                int id = Integer.parseInt(userInfo[0]);
                String firstName = userInfo[1];
                String lastName = userInfo[2];
                double moneyAvailable = Double.parseDouble(userInfo[3]);
                int carsPurchased = Integer.parseInt(userInfo[4]);
                boolean minerCarsMembership = Boolean.parseBoolean(userInfo[5]);
                String username = userInfo[6];
                String password = userInfo[7];

                User user = new User(id, firstName, lastName,
                moneyAvailable, carsPurchased, minerCarsMembership,
                username, password);

                users.add(user);
                line = br.readLine();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return users;
    }

    public void updateUsers(List<User> users, String newFile) 
    {
        try(BufferedWriter wr = new BufferedWriter(new FileWriter(newFile)))
        {
            wr.write("ID,First Name,Last Name,Money Availale,Cars Purchased,"+
            "MinerCars Membership, Username, Password\n");

            for(User user : users)
            {
                String newLine = String.format("%d,%s,%s,%.2f,%d,%s,%s,%s\n", 
                user.getID(), user.getFirstName(), user.getLastName(),
                user.getMoneyAvailable(), user.getCarsPurchased(), user.getMinerCarsMembership() ? "True" : "False",
                user.getUsername(), user.getPassword());
            }
        }
        catch (IOException e)
        {
            System.out.println("Error writing the new data");
        }
    }   
}
