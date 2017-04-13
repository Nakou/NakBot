package Frontend.Discord;

import Backend.Bot.Internal.Message;
import Frontend.Common.IMessageSender;

/**
 * Created by abonnet on 12/04/2017.
 */
public class DiscordMessageSender implements IMessageSender {

    @Override
    public boolean sendMessage(Message message) {
        /*try {
            new MessageBuilder(Conf.getInstance().getDiscordClient()).withChannel(channel).withContent(message).build();
        } catch (RateLimitException | DiscordException | MissingPermissionsException e) {
            e.printStackTrace();
        }*/
        return false;
    }
}
