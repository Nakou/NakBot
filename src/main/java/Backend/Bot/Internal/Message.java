package Backend.Bot.Internal;

import Backend.Bot.Internal.Specifics.Stream;

/**
 * Created by Nakou on 12/04/2017.
 */
public class Message<T> {
    private Stream input;
    private String message;
    private Stream output;
    private T session;

    public Message(Stream input, String message, T session){
        this.input = input;
        this.message = message;
        this.session = session;
    }

    public Stream getInput() {
        return input;
    }

    public void setInput(Stream input) {
        this.input = input;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Stream getOutput() {
        return output;
    }

    public void setOutput(Stream output) {
        this.output = output;
    }

    public T getSession() {
        return session;
    }

    public void setSession(T session) {
        this.session = session;
    }
}
