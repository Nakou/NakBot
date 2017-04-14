package Backend.Bot;

import Backend.Bot.Internal.*;
import Backend.Bot.Internal.Specifics.DiscordConnector;
import Backend.Bot.Internal.Specifics.SlackConnector;
import Backend.Bot.Internal.Specifics.Stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nakou on 09/04/2017.
 */
public class Bot{

    private Map<Stream, AbstractConnector> connectors;

    public Bot(){
        Conf.getInstance();
        connectors = new HashMap<>();
        connectors.put(Stream.DISCORD, new DiscordConnector(this));
        connectors.put(Stream.SLACK, new SlackConnector(this));
    }

    public void StartBot(){
        for(Map.Entry<Stream, AbstractConnector> entry: connectors.entrySet()){
            entry.getValue().connectToServer(this);
        }
    }

    public void CallProcess(Message message){
        Thread thread = new Thread(){
            public void run(){
                Engine engine = new Engine(message);
                engine.goEngine();
                engine.sendResponse(connectors);
            }
        };
    }
}
