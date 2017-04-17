package Frontend.Slack;

import Backend.Bot.Bot;
import Backend.Bot.Internal.Conf;
import Backend.Bot.Internal.Message;
import Backend.Bot.Internal.Specifics.Stream;
import com.ullink.slack.simpleslackapi.SlackChannel;
import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.SlackUser;
import com.ullink.slack.simpleslackapi.events.SlackMessagePosted;
import com.ullink.slack.simpleslackapi.listeners.SlackMessagePostedListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Nakou on 11/04/2017.
 */
public class SlackMessageListener implements SlackMessagePostedListener {
    Logger logger = LoggerFactory.getLogger(SlackMessageListener.class);

    Bot bot;

    public SlackMessageListener(Bot bot){
        super();
        this.bot = bot;
    }

    @Override
    public void onEvent(SlackMessagePosted event, SlackSession session) {
        SlackChannel channelOnWhichMessageWasPosted = event.getChannel();
        String messageContent = event.getMessageContent();
        SlackUser messageSender = event.getSender();
        if(messageSender.getUserName().toLowerCase().contains(Conf.getInstance().getBotName().toLowerCase())){
            return;
        }
        logger.info("[SLACK] New Message from "+ messageSender.getUserName() + " in #" + channelOnWhichMessageWasPosted.getName() + ": " + messageContent);
        Message newMessage = new Message(Stream.SLACK, messageContent, channelOnWhichMessageWasPosted.getName(), messageSender.getUserName());
        bot.CallProcess(newMessage);
    }
}
