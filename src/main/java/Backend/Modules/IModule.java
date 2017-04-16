package Backend.Modules;

import Backend.Bot.Internal.Message;

/**
 * Created by Nakou on 07/04/2017.
 */
public interface IModule {
    Message action(Message argument);
}
