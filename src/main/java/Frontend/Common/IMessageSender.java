package Frontend.Common;

import Backend.Bot.Internal.Message;

/**
 * Created by Nakou on 13/04/2017.
 */
public interface IMessageSender<T> {
    boolean sendMessage(Message message, T session);
    boolean isChannelAccessible(String channel, T session);
}
