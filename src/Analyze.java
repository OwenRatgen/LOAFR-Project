import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analyze {
    
    public Analyze() {}

    //creates a sublist which contains only the rows found using the header and keyword parameters
    public List<Map<String, String>> findInstances(List<Map<String, String>> data, String header, String keyword)
    {
        List<Map<String, String>> newList;
        newList = data.stream().filter(map -> map.containsKey(header) && map.get(header).equals(keyword)).collect(Collectors.toList());
        return newList;
    }
}