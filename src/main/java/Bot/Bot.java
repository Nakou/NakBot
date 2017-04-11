package Bot;

import Bot.Listeners.Discord.BotConnectionListener;
import Bot.Listeners.Discord.BotMessageListener;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;

/**
 * Created by Nakou on 09/04/2017.
 */
public class Bot{
    private Conf conf;

    ClientBuilder clientBuilder;

    public Bot(){
        conf = Conf.getInstance();
    }

    public void StartBot(){
        clientBuilder = new ClientBuilder(); // Creates the ClientBuilder instance
        clientBuilder.withToken(conf.getDiscordToken());
    }

    public void connectToServer(){
        IDiscordClient discordClient;
        try {
            discordClient = clientBuilder.login();
            discordClient.getDispatcher().registerListener(new BotConnectionListener());
            discordClient.getDispatcher().registerListener(new BotMessageListener());
        } catch (DiscordException e) {
            e.printStackTrace();
        }
    }
}
