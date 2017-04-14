package Backend.Commands;

import Backend.Bot.Internal.Message;
import Backend.Bot.Internal.Parser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by abonnet on 14/04/2017.
 */
public class Commands {
    public static String buildCommandResponse(Message message){
        List<String> parsedMessage = Parser.Parse(message.getContent());
        String intendedCommand = parsedMessage.get(0);
        String returnContent = "";
        Class<?> clazz = null;
        Constructor<?> ctor = null;
        try {
            clazz = Class.forName(intendedCommand);
            ctor = clazz.getConstructor(String.class);
            Object object = ctor.newInstance();
            return ((ICommand)object).action(intendedCommand);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
}
