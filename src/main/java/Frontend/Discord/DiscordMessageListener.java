package Frontend.Discord;

import Backend.Bot.Internal.Engine;
import Backend.Bot.Internal.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;

/**
 * Created by abonnet on 11/04/2017.
 */
public class DiscordMessageListener implements IListener<MessageReceivedEvent> {
    Logger logger = LoggerFactory.getLogger(DiscordMessageListener.class);
    @Override
    public void handle(MessageReceivedEvent event) {
        IMessage message = event.getMessage(); // Gets the message from the event object NOTE: This is not the content of the message, but the object itself
        IChannel channel = message.getChannel(); // Gets the channel in which this message was sent.
        //try {
            // Builds (sends) and new message in the channel that the original message was sent with the content of the original message.
            //new MessageBuilder(Conf.getInstance().getDiscordClient()).withChannel(channel).withContent(message.getContent()).build();
            logger.info("New Message : " + message.getContent());
            new Engine(message.getContent(), Source.DISCORD, message, channel);
        /*} catch (RateLimitException e) { // RateLimitException thrown. The bot is sending messages too quickly!
            System.err.print("Sending messages too quickly!");
            e.printStackTrace();
        } catch (DiscordException e) { // DiscordException thrown. Many possibilities. Use getErrorMessage() to see what went wrong.
            System.err.print(e.getErrorMessage()); // Print the error message sent by Discord
            e.printStackTrace();
        } catch (MissingPermissionsException e) { // MissingPermissionsException thrown. The bot doesn't have permission to send the message!
            System.err.print("Missing permissions for channel!");
            e.printStackTrace();
        }*/
    }
}
