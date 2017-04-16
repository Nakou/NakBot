package Backend.Bot.Internal;

import Backend.Bot.Internal.Specifics.Stream;

/**
 * Created by Nakou on 12/04/2017.
 */
public class Message {
    private Stream input;
    private String content;
    private Stream output;
    private String channelKey;
    private String authorName;

    public Message(Stream input, String content, String channelKey, String authorName){
        this.input = input;
        this.content = content;
        this.channelKey = channelKey;
        this.authorName = authorName;
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

    public String getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(String channelKey) {
        this.channelKey = channelKey;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString(){
        String value = "[";
        if(input != null)
            value += "INPUT:"+input.toString();
        if(output != null)
            value += "OUTPUT:"+output.toString();
        if(authorName != null)
            value += "authorName:"+authorName;
        if(channelKey != null)
            value += "channelKey:"+channelKey;
        if(content != null)
            value += "content:"+content;
        value += "]";
        return value;
    }
}
