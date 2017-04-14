package Frontend.Discord;

import Backend.Bot.Internal.Message;
import Frontend.Common.IMessageSender;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.impl.obj.Channel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MessageBuilder;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

/**
 * Created by Nakou on 12/04/2017.
 */
public class DiscordMessageSender implements IMessageSender {

    @Override
    public boolean sendMessage(Message message, Object session) {
        IMessage client = (IMessage) message.getOriginalMessage();
        Channel channel = (Channel) client.getChannel();
        try {
            new MessageBuilder((IDiscordClient) session).withChannel(channel).withContent(message.getContent()).build();
            return true;
        } catch (RateLimitException | DiscordException | MissingPermissionsException e) {
            e.printStackTrace();
            return false;
        }
    }
}
