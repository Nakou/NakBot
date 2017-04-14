package Backend.Bot.Internal;

import Backend.Bot.Internal.Specifics.Stream;

import java.util.List;

/**
 * Created by Nakou on 12/04/2017.
 */
public class Engine {

    Conf conf;
    Message incomingMessage;
    Message outgoingMessage;


    public Engine(Message incomingMessage) {
        this.conf = Conf.getInstance();
        this.incomingMessage = incomingMessage;
        this.outgoingMessage = new Message();
    }

    public Message goEngine() {
        if(checkForCommands()){
            outgoingMessage.setOutput(incomingMessage.getInput());

        }
        if(checkAutoresponses()){

        }
        if(!conf.isTransfertActivated()){

        }
        return null;
    }

    private boolean checkForCommands() {
        List<String> message = Parser.Parse(this.incomingMessage.getContent());
        String intendedCommand = message.get(0);
        if(conf.getCommands().contains(intendedCommand)){
            return true;
        }
        return false;
    }

    private boolean checkAutoresponses(){
        return false;
    }

    private void transfertMessage(){}

    private Message buildMessage(String message, Stream strem){

        return null;
    }

    public void sendResponse() {
        // use outgoingMessage
    }
}
