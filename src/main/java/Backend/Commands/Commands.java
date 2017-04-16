package Backend.Commands;

import Backend.Bot.Internal.Conf;
import Backend.Bot.Internal.Message;
import Backend.Bot.Internal.Parser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Nakou on 14/04/2017.
 */
public class Commands {

    public static String buildCommandResponse(String message){
        List<String> parsedMessage = Parser.Parse(message);
        String tempFirstWord = parsedMessage.get(0);
        parsedMessage.set(0, tempFirstWord.substring(1));
        String intendedCommand = parsedMessage.get(0);
        Class<?> clazz = null;
        Constructor<?> ctor = null;
        try {
            String cap = intendedCommand.substring(0, 1).toUpperCase() + intendedCommand.substring(1);
            cap = "Backend.Commands."+cap;
            clazz = Class.forName(cap);
            ctor = clazz.getConstructor();
            Object object = ctor.newInstance();
            return ((ICommand)object).action(message);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            return "It's not a command...";
        }
    }

    public static String buildAutoresponse(String message){
        int randomCount, i, randomValue;
        for(Map.Entry<String, List<String>> entry : Conf.getInstance().getAutoresponses().entrySet()) {
            if(entry.getKey().contains(message.toLowerCase())){
                randomCount = entry.getValue().size();
                i = 0;
                randomValue = ThreadLocalRandom.current().nextInt(0,randomCount);
                for(String out : entry.getValue()){
                    if(randomValue == i){
                        return out;
                    }
                    i++;
                }
            }
        }
        return "";
    }
}
