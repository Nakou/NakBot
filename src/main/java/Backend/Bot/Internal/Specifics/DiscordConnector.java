package Backend.Bot.Internal.Specifics;

import Backend.Bot.Bot;
import Backend.Bot.Internal.AbstractConnector;
import Backend.Bot.Internal.Conf;
import Frontend.Discord.DiscordConnectionListener;
import Frontend.Discord.DiscordMessageListener;
import org.slf4j.LoggerFactory;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;

/**
 * Created by Nakou on 13/04/2017.
 */
public class DiscordConnector extends AbstractConnector {

    ClientBuilder clientBuilder;

    public DiscordConnector(Bot bot){
        super(bot);
        logger = LoggerFactory.getLogger(DiscordConnector.class);
        clientBuilder = new ClientBuilder(); // Creates the ClientBuilder instance
        clientBuilder.withToken(Conf.getInstance().getDiscordToken());
        logger.info("DiscordServer token initialization");
    }

    @Override
    public void connectToServer(Bot bot) {
        try {
            connector = clientBuilder.login();
            logger.info("Connection to DiscordServer completed");
            ((IDiscordClient)connector).getDispatcher().registerListener(new DiscordConnectionListener(bot));
            ((IDiscordClient)connector).getDispatcher().registerListener(new DiscordMessageListener(bot));
            logger.info("DiscordServer Listeners loaded");
        } catch (DiscordException e) {
            e.printStackTrace();
            logger.error("DiscordServer Listeners error");
        }
    }
}
