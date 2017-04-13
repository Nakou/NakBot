package Backend.Bot;

import Backend.Bot.Internal.AbstractConnector;
import Backend.Bot.Internal.Conf;
import Backend.Bot.Internal.Specifics.DiscordConnector;
import Backend.Bot.Internal.Specifics.SlackConnector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nakou on 09/04/2017.
 */
public class Bot{

    private List<AbstractConnector> connectors;

    public Bot(){
        Conf.getInstance();
        connectors = new ArrayList<>();
        connectors.add(new DiscordConnector());
        connectors.add(new SlackConnector());
    }

    public void StartBot(){
        for(AbstractConnector connector : connectors){
            connector.connectToServer();
        }
    }
}
