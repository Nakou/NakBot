package Bot;

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
        clientBuilder.withToken(conf.getDiscordToken()); // Adds the login info to the builder
    }

    public void connectToServer(){
        try {
            clientBuilder.login(); // Creates the client instance and logs the client in
        } catch (DiscordException e) {
            e.printStackTrace();
        }
    }
}
