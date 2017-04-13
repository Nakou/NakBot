package Backend.Bot.Internal;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nakou on 12/04/2017.
 */
public class Parser {
    public static List<String> Parse(String message){
        return Arrays.asList(message.split(" "));
    }
}
