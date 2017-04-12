package Frontend.Discord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.obj.IUser;

/**
 * Created by Nakou on 09/04/2017.
 */
public class DiscordConnectionListener implements IListener<ReadyEvent> {

    Logger logger = LoggerFactory.getLogger(DiscordConnectionListener.class);

    @Override
    public void handle(ReadyEvent event) {
        IDiscordClient client = event.getClient(); // Gets the client from the event object
        IUser ourUser = client.getOurUser();// Gets the user represented by the client
        String name = ourUser.getName();// Gets the name of our user
        logger.info("Logged in as " + name);
    }
}
