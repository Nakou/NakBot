package Bot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.EventListener;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

/**
 * Created by Nakou on 09/04/2017.
 */
public class Bot{
    private Conf conf;

    private boolean stop;

    public Bot(){
        conf = Conf.getInstance();
    }

    public void StartBot(){
        JDA jda = conf.getJdaConnector();
        try {
            jda = (JDA) new JDABuilder(AccountType.BOT)
                    .setToken(conf.getDiscordToken())
                    .addEventListener(new BotMessagesListener(this))
                    .buildBlocking();
        } catch (LoginException | InterruptedException | RateLimitedException e) {
            e.printStackTrace();
        }
    }

    public void connectToServer(){
        System.out.println(conf.getJdaConnector().getGuildById(conf.getGuildId()).toString());
    }
}
