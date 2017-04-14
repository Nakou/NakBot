package Backend.Bot.Internal.Specifics;

import Backend.Bot.Bot;
import Backend.Bot.Internal.AbstractConnector;
import Backend.Bot.Internal.Conf;
import Frontend.Slack.SlackMessageListener;
import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Nakou on 13/04/2017.
 */
public class SlackConnector extends AbstractConnector {

    public SlackConnector(Bot bot){
        super(bot);
        logger = LoggerFactory.getLogger(DiscordConnector.class);
        connector = SlackSessionFactory.createWebSocketSlackSession(Conf.getInstance().getSlackToken());
        logger.info("Slack token initialization");
    }

    @Override
    public void connectToServer(Bot bot) {
        try {
            ((SlackSession)connector).connect();
            logger.info("Connection to Slack completed");
            ((SlackSession)connector).addMessagePostedListener(new SlackMessageListener(this.bot));
            logger.info("Slack listener loaded");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("DiscordServer Listeners error");
        }
    }
}
