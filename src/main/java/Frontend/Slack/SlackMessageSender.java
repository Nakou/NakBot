package Frontend.Slack;

import Backend.Bot.Internal.Message;
import Backend.Bot.Internal.Specifics.SlackConnector;
import Frontend.Common.IMessageSender;
import com.ullink.slack.simpleslackapi.SlackChannel;
import com.ullink.slack.simpleslackapi.SlackSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Nakou on 13/04/2017.
 */
public class SlackMessageSender implements IMessageSender {

    Logger logger = LoggerFactory.getLogger(SlackMessageSender.class);

    @Override
    public boolean sendMessage(Message message, Object session) {
        if(!isChannelAccessible(message.getChannelKey(), ((SlackConnector)session).getConnector())){
            logger.error("Error sending message on Slack : This channel doesn't exist on this side");
            return false;
        }
        SlackSession slackSession = ((SlackSession)((SlackConnector)session).getConnector());
        SlackChannel channel = slackSession.findChannelByName(message.getChannelKey());
        slackSession.sendMessage(channel, message.getContent());
        return true;
    }

    @Override
    public boolean isChannelAccessible(String channel, Object session) {
        SlackSession slackSession = ((SlackSession)session);
        for(SlackChannel slackChannel : slackSession.getChannels()){
            if(channel.equals(slackChannel.getName())){
                return true;
            }
        }
        return false;
    }
}
