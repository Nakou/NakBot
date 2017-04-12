import Backend.Bot.Bot;

/**
 * Created by Nakou on 07/04/2017.
 */
public class App {
    public static void main(String[] args){
        Bot bot = new Bot();
        bot.StartBot();
        bot.connectToServer();
    }
}
