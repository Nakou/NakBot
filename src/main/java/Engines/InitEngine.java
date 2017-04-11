package Engines;

import Bot.Conf;
import Bot.Source;
import Commands.ICommand;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Nakou on 12/04/2017.
 */
public class InitEngine {
    public String message;

    Conf conf;
    private InitEngine(){}
    public InitEngine(String message, Source source){
        conf = Conf.getInstance();
        if(checkForCommands(message, source))
            return;
        if(checkAutoresponses(message, source))
            return;
        if(!conf.isTransfertActivated())
            return;
        transfertMessage(message, source);
    }

    private boolean checkForCommands(String message, Source source) {
        if(conf.getCommands().contains(message)){
            Class<?> clazz = null;
            Constructor<?> ctor = null;
            try {
                clazz = Class.forName(message);
                ctor = clazz.getConstructor(String.class);
                Object object = ctor.newInstance();
                publish(((ICommand)object).action(message));
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
}
