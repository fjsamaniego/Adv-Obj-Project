import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

/**
 * The class UserDataLoad is used to create the list of Users from
 * the given .csv file, in addition to updating the list and csv file
 * everytime a user purchases a car
 */

public class UserDataLoad implements DataLoad<User>
{
    @Override
    public List<User> loadData(String file)
    {
        List<User> users = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            br.readLine();
            String line = br.readLine();
            while(line != null)
            {
                String []userInfo = line.split(",");

                double moneyAvailable = Double.parseDouble(userInfo[0]);
                String password = userInfo[1];
                String lastName = userInfo[2];
                int id = Integer.parseInt(userInfo[3]);
                int carsPurchased = Integer.parseInt(userInfo[4]);
                String firstName = userInfo[5];
                String username = userInfo[6];
                boolean minerCarsMembership = Boolean.parseBoolean(userInfo[7]);

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

    @Override
    public void updateData(List<User> users, String file) 
    {
        try(BufferedWriter wr = new BufferedWriter(new FileWriter(file)))
        {
            wr.write("Money Available,Password,Last Name,ID,Cars Purchased,First Name,Username,MinerCars Membership\n");

            for(User user : users)
            {
                String newLine = String.format("%.2f,%s,%s,%d,%d,%s,%s,%s\n", 
                user.getMoneyAvailable(),
                user.getPassword(),
                user.getLastName(),
                user.getID(),
                user.getCarsPurchased(), 
                user.getFirstName(), 
                user.getUsername(), 
                user.getMinerCarsMembership() ? "True" : "False");

                wr.write(newLine);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error writing the new data");
        }
    }   
}
