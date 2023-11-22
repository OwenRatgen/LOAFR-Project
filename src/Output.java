import java.util.List;
import java.util.Map;

public class Output {
    
    public Output() {}

    public void printList(List<Map<String, String>> list)
    {
        for(Map<String, String> row : list)
        {
            System.out.println(row);
        }
    }
}
