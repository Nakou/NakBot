package Backend.Bot;

import java.util.Arrays;
import java.util.List;

/**
 * Created by abonnet on 12/04/2017.
 */
public class Parser {
    public static List<String> Parse(String message){
        return Arrays.asList(message.split(" "));
    }
}
