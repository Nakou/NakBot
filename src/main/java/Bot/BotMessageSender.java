package Bot;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MessageBuilder;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

/**
 * Created by abonnet on 12/04/2017.
 */
public class BotMessageSender {
    public static void BotMessageSend(String message, Source source, IChannel channel){
        switch(source){
            case SLACK:
                //sendDiscordMessage(message);
                break;
            case DISCORD:
                break;
            default:
                break;
        }


    }

    private static void sendDiscordMessage(String message, IChannel channel) {
        try {
            new MessageBuilder(Conf.getInstance().getDiscordClient()).withChannel(channel).withContent(message).build();
        } catch (RateLimitException | DiscordException | MissingPermissionsException e) {
            e.printStackTrace();
        }
    }
}
