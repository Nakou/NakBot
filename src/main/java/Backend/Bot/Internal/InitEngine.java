package Backend.Bot.Internal;

import Backend.Commands.ICommand;
import sx.blah.discord.handle.obj.IMessage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Nakou on 12/04/2017.
 */
public class InitEngine<T> {
    String messageContent;

    private IMessage iMessage;
    private T iChannel;

    Conf conf;
    private InitEngine(){}
    public InitEngine(String messageContent, Source source, IMessage message, T channel){
        conf = Conf.getInstance();
        iMessage = message;
        iChannel = channel;
        List<String> parsedMessage = Parser.Parse(messageContent);
        if(checkForCommands(parsedMessage, source))
            return;
        if(checkAutoresponses(messageContent, source))
            return;
        if(!conf.isTransfertActivated())
            return;
        transfertMessage(messageContent, source);
    }

    private boolean checkForCommands(List<String> message, Source source) {
        String intendedCommand = message.get(0);
        if(conf.getCommands().contains(intendedCommand)){
            Class<?> clazz = null;
            Constructor<?> ctor = null;
            try {
                clazz = Class.forName(intendedCommand);
                ctor = clazz.getConstructor(String.class);
                Object object = ctor.newInstance();
                publish(((ICommand)object).action(intendedCommand));
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean checkAutoresponses(String message, Source source){
        return false;
    }

    private void transfertMessage(String message, Source source){

    }

    private void publish(String message){}

    public IMessage getiMessage() {
        return iMessage;
    }

    public T getiChannel() {
        return iChannel;
    }
}
