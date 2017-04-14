package Frontend.Slack;

import Backend.Bot.Bot;
import com.ullink.slack.simpleslackapi.SlackSession;
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

    }
}
