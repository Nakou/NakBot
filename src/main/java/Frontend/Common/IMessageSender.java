package Frontend.Common;

import Backend.Bot.Internal.Message;

/**
 * Created by abonnet on 13/04/2017.
 */
public interface IMessageSender {
    boolean sendMessage(Message message);
}