package Frontend.Discord;

import Backend.Bot.Internal.Conf;
import Backend.Bot.Internal.Message;
import Backend.Bot.Internal.Specifics.DiscordConnector;
import Frontend.Common.IMessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.impl.obj.Channel;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MessageBuilder;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.List;

/**
 * Created by Nakou on 12/04/2017.
 */
public class DiscordMessageSender implements IMessageSender {

    Logger logger = LoggerFactory.getLogger(DiscordMessageSender.class);
    IChannel channelId;

    @Override
    public boolean sendMessage(Message message, Object session) {
        if(!isChannelAccessible(message.getChannelKey(), ((DiscordConnector)session).getConnector())){
            logger.error("Error sending message on Discord : This channel doesn't exist on this side");
            return false;
        }
        try {
            new MessageBuilder((IDiscordClient) ((DiscordConnector)session).getConnector()).withChannel(channelId).withContent(message.getContent()).build();
            return true;
        } catch (RateLimitException | DiscordException | MissingPermissionsException e) {
            e.printStackTrace();
            logger.error("Error sending message on Discord : see stack for details");
            return false;
        }
    }

    @Override
    public boolean isChannelAccessible(String channel, Object session) {
        List<IChannel> discordChannel = ((IDiscordClient)session).getChannels();
        for(IChannel iChannel : discordChannel){
            if(channel.equals(iChannel.getName())){
                channelId = iChannel;
                return true;
            }
        }
        return false;
    }
}
