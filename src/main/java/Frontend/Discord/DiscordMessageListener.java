package Frontend.Discord;

import Backend.Bot.Bot;
import Backend.Bot.Internal.Engine;
import Backend.Bot.Internal.Message;
import Backend.Bot.Internal.Specifics.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;

/**
 * Created by Nakou on 11/04/2017.
 */
public class DiscordMessageListener implements IListener<MessageReceivedEvent> {
    Bot bot;
    Logger logger = LoggerFactory.getLogger(DiscordMessageListener.class);


    public DiscordMessageListener(Bot bot){
        super();
        this.bot = bot;
    }

    @Override
    public void handle(MessageReceivedEvent event) {
        IMessage message = event.getMessage(); // Gets the message from the event object NOTE: This is not the content of the message, but the object itself
        IChannel channel = message.getChannel(); // Gets the channel in which this message was sent.
        logger.info("[DISCORD] New Message from "+ message.getAuthor().getName() + " in #" + channel.getName() + ": " + message.getContent());
        Message newMessage = new Message(Stream.DISCORD, message.getContent(), channel.getName(), message.getAuthor().getName());
        bot.CallProcess(newMessage);
    }
}
