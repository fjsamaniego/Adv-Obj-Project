import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;

/**
 * The class UserDataLoad is used to create the list of Users from
 * the given .csv file, in addition to updating the list and csv file
 * everytime a user purchases a car
 */

public class UserDataLoad implements DataLoad<User>
{
    /**
     * 
     */
    @Override
    public List<User> loadData(String userFile)
    {
        List<User> users = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(userFile)))
        {
            String[] headers = br.readLine().split(",");

            String line = br.readLine();

            while(line != null)
            {
                if(line.trim().isEmpty())
                    continue;

                Map<String, String> userInfo = new HashMap<>();

                String []details = line.split(",");
                int i = 0;

                for(String header: headers)
                {
                    userInfo.put(header, details[i]);
                    i++;
                }

                User user = UserFactory.createUser(userInfo);

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
    public String[] getHeaders(List<User> users, String filePath)
    {
        String[] headers = null;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            headers = br.readLine().split(",");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return headers;
    }

    /**
     * 
     */
    @Override
    public void updateData(List<User> users, String userFile) 
    {
        String[] headers = getHeaders(users, userFile);

        try(BufferedWriter wr = new BufferedWriter(new FileWriter(userFile)))
        {
            wr.write(String.join(",",headers)+"\n");

            for(User user : users)
            {
                Map<String, String> userMap = user.toMap();
                List<String> info = new ArrayList<>();

                for(String header : headers)
                    info.add(userMap.getOrDefault(header, "Not found"));

                wr.write(String.join(",", info));
                wr.newLine();
            }
        }
        catch (IOException e)
        {
            System.out.println("Error writing the new data");
        }
    }   
}
