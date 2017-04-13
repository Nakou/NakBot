package Backend.Bot.Internal;

import com.ullink.slack.simpleslackapi.SlackSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.handle.obj.IMessage;

/**
 * Created by Nakou on 13/04/2017.
 */
public class Starter {

    SlackSession slackSession;
    IMessage message;
    Logger logger = LoggerFactory.getLogger(Starter.class);

    public Starter(Message message){
        Message output;
        Engine engine = new Engine(message);
        output = engine.goEngine();
    }


}
