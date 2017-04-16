package Frontend.Slack;

import Backend.Bot.Internal.Message;
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
        SlackChannel channel = ((SlackSession)session).findChannelByName(message.getChannelKey());
        logger.error("Error sending message on Slack");
        return false;
    }
}
