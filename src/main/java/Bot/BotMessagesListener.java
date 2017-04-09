package Bot;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by Nakou on 09/04/2017.
 */
public class BotMessagesListener extends ListenerAdapter{

    private Bot bot;

    public BotMessagesListener(Bot bot){
        super();
        this.bot = bot;
    }

    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.isFromType(ChannelType.PRIVATE))
        {
            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),
                    event.getMessage().getContent());
        }
        else
        {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                    event.getTextChannel().getName(), event.getMember().getEffectiveName(),
                    event.getMessage().getContent());
        }
    }

    public void onReady(ReadyEvent event) {
        System.out.println("I'm Ready!");
        //bot.connectToServer();
    }
}
