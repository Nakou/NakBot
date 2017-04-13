package Backend.Bot.Internal.Specifics;

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

    SlackSession session;

    public SlackConnector(){
        logger = LoggerFactory.getLogger(DiscordConnector.class);
        session = SlackSessionFactory.createWebSocketSlackSession(Conf.getInstance().getSlackToken());
        logger.info("Slack token initialization");
    }

    @Override
    public void connectToServer() {
        try {
            session.connect();
            logger.info("Connection to Slack completed");
            session.addMessagePostedListener(new SlackMessageListener());
            logger.info("Slack listener loaded");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("DiscordServer Listeners error");
        }
    }
}
