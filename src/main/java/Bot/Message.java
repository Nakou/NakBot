package Bot;

/**
 * Created by abonnet on 12/04/2017.
 */
public class Message<T> {
    private Source source;
    private String message;
    private T channel;

    public Message(Source source, String message, T channel){
        this.source = source;
        this.message = message;
        this.channel = channel;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getChannel() {
        return channel;
    }

    public void setChannel(T channel) {
        this.channel = channel;
    }
}
