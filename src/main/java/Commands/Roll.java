package Commands;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Nakou on 08/04/2017.
 */
public class Roll implements ICommand{
    @Override
    public String action(String argument) {
        if(argument.split("").length > 1);
        String firstArg = argument.split("")[0];
        try {
            int i = Integer.getInteger(firstArg);
            Integer rand = ThreadLocalRandom.current().nextInt(0,i);
            return rand.toString();
        } catch (Exception e) {
            return "Wrong arguments";
        }
    }
}
