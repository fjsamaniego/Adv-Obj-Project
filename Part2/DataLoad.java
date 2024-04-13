import java.io.IOException;
import java.util.List;

public interface DataLoad<T> 
{
    List<T> loadData(String filePath) throws IOException;
    void updateData(List<T> data, String filePath);
}