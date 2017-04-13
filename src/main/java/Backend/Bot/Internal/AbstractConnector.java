package Backend.Bot.Internal;

import org.slf4j.Logger;

/**
 * Created by Nakou on 13/04/2017.
 */
public abstract class AbstractConnector<T> {
    protected T connector;
    protected Logger logger;

    public abstract void connectToServer();

    public T getConnector() {
        return connector;
    }

    public void setConnector(T connector) {
        this.connector = connector;
    }
}
