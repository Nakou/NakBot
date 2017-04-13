package Backend.Bot.Internal;

import Backend.Bot.Internal.Specifics.Stream;
import Backend.Commands.ICommand;
import sx.blah.discord.handle.obj.IMessage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Nakou on 12/04/2017.
 */
public class Engine {

    Conf conf;
    Message message;


    public Engine(Message message) {
        this.conf = Conf.getInstance();
        this.message = message;
    }

    public Message goEngine() {
        if(checkForCommands()){

        }
        if(checkAutoresponses()){

        }
        if(!conf.isTransfertActivated()){

        }
        return null;
    }

    private boolean checkForCommands() {
        List<String> message = Parser.Parse(this.message.getMessage());
        String intendedCommand = message.get(0);
        if(conf.getCommands().contains(intendedCommand)){
            Class<?> clazz = null;
            Constructor<?> ctor = null;
            try {
                clazz = Class.forName(intendedCommand);
                ctor = clazz.getConstructor(String.class);
                Object object = ctor.newInstance();
                //buildMessage(((ICommand)object).action(intendedCommand));
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean checkAutoresponses(){
        return false;
    }

    private void transfertMessage(){}

    private Message buildMessage(String message, Stream strem){

        return null;
    }


}
