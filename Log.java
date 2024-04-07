import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Logs user actions to file such as time when user logged in, displayed all cars etc.
 */
public class Log 
{
    private static final String LOG_FIlE = "dealership_log.txt";

    /**
     * Writes the log entry to the log file
     * 
     * @param action the action performed by user
     * @param user the user that performed said action
     */
    public void writeToLog(String action, User user)
    {
        try(FileWriter fw = new FileWriter(LOG_FIlE,true))
        {
            String timeString =  new SimpleDateFormat("HH:mm:ss MM/dd/yy").format(new Date());
            fw.write(timeString + " - " + user.getUsername() +" "+ action + "\n");
        }
        catch(IOException e)
        {
            System.err.println("Error wrtitin to log file: "+ e.getMessage());
        }
    }
}