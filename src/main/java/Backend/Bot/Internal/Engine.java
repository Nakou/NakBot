package Backend.Bot.Internal;

import Backend.Bot.Internal.Specifics.Stream;
import Backend.Commands.Commands;
import Frontend.Discord.DiscordMessageSender;
import Frontend.Slack.SlackMessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by Nakou on 12/04/2017.
 */
public class Engine {

    private Conf conf;
    private Message incomingMessage;
    private Message outgoingMessage;
    Logger logger = LoggerFactory.getLogger(Engine.class);

    public Engine(Message incomingMessage) {
        this.conf = Conf.getInstance();
        this.incomingMessage = incomingMessage;
        this.outgoingMessage = new Message();
    }

    public void goEngine() {
        if(checkForCommands()){
            outgoingMessage.setStream(incomingMessage.getStream());
            outgoingMessage.setContent(Commands.buildCommandResponse(incomingMessage.getContent()));
            outgoingMessage.setAuthorName(incomingMessage.getAuthorName());
            outgoingMessage.setChannelKey(incomingMessage.getChannelKey());
        }
        if(checkAutoresponses()){
            outgoingMessage.setStream(incomingMessage.getStream());
            outgoingMessage.setContent(Commands.buildAutoresponse(incomingMessage.getContent()));
            outgoingMessage.setAuthorName(incomingMessage.getAuthorName());
            outgoingMessage.setChannelKey(incomingMessage.getChannelKey());
        }
        if(conf.isTransfertActivated()){
            transfertMessage();
        }
    }

    private boolean checkForCommands() {
        if(this.incomingMessage.getContent().charAt(0) == '/'){
            return true;
        }
        return false;
    }

    private boolean checkAutoresponses(){
        for(Map.Entry<String, List<String>> entry : conf.getAutoresponses().entrySet()) {
            if(entry.getKey().contains(this.incomingMessage.getContent().toLowerCase())){
                return true;
            }
        }
        return false;
    }

    private void transfertMessage(){
        String origin = "";
        switch (incomingMessage.getStream()){
            case DISCORD:
                outgoingMessage.setStream(Stream.SLACK);
                origin = "Discord";
                break;
            case SLACK:
                outgoingMessage.setStream(Stream.DISCORD);
                origin = "Slack";
                break;
            default:
                break;
        }
        String content = "Message posted on [" + origin + "] by @" + incomingMessage.getAuthorName() + " : " + incomingMessage.getContent();
        outgoingMessage.setContent(content);
        outgoingMessage.setAuthorName(incomingMessage.getAuthorName());
        outgoingMessage.setChannelKey(incomingMessage.getChannelKey());
    }

    public void sendResponse(Map<Stream, AbstractConnector> connectors) {
        switch (outgoingMessage.getStream()){
            case DISCORD:
                new DiscordMessageSender().sendMessage(outgoingMessage, connectors.get(Stream.DISCORD));
                break;
            case SLACK:
                new SlackMessageSender().sendMessage(outgoingMessage, connectors.get(Stream.SLACK));
                break;
            default:
                break;
        }
    }
}
