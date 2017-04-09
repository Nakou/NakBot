import Bot.Conf;

/**
 * Created by Nakou on 07/04/2017.
 */
public class App {
    public static void main(String[] args){
        Conf confInstance = Conf.getInstance();
        System.out.println(confInstance.getAutoresponses().toString());
    }
}
