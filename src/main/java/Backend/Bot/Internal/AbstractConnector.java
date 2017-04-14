package Backend.Bot.Internal;

import Backend.Bot.Bot;
import org.slf4j.Logger;

/**
 * Created by Nakou on 13/04/2017.
 */
public abstract class AbstractConnector<T> {
    protected T connector;
    protected Logger logger;
    protected Bot bot;

    protected AbstractConnector(Bot bot){
        this.bot = bot;
    }

    public abstract void connectToServer(Bot bot);

    public T getConnector() {
        return connector;
    }

    public void setConnector(T connector) {
        this.connector = connector;
    }
}
