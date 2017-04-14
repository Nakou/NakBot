package Backend.Bot.Internal;

import Backend.Bot.Internal.Specifics.Stream;

/**
 * Created by Nakou on 12/04/2017.
 */
public class Message<T> {
    private Stream input;
    private String content;
    private Stream output;
    private T originalMessage;

    public Message(Stream input, String content, T originalMessage){
        this.input = input;
        this.content = content;
        this.originalMessage = originalMessage;
    }

    public Message() {

    }

    public Stream getInput() {
        return input;
    }

    public void setInput(Stream input) {
        this.input = input;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Stream getOutput() {
        return output;
    }

    public void setOutput(Stream output) {
        this.output = output;
    }

    public T getOriginalMessage() {
        return originalMessage;
    }

    public void setOriginalMessage(T originalMessage) {
        this.originalMessage = originalMessage;
    }
}
