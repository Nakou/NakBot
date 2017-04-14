package Frontend.Slack;

import Backend.Bot.Internal.Message;
import Frontend.Common.IMessageSender;

/**
 * Created by Nakou on 13/04/2017.
 */
public class SlackMessageSender implements IMessageSender {

    @Override
    public boolean sendMessage(Message message, Object session) {
        return false;
    }
}
