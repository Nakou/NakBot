package Backend.Bot.Internal;

import Backend.Bot.Internal.Specifics.Stream;

/**
 * Created by Nakou on 12/04/2017.
 */
public class Message {

    private String content;
    private Stream stream;
    private String channelKey;
    private String authorName;

    public Message(Stream stream, String content, String channelKey, String authorName){
        this.stream = stream;
        this.content = content;
        this.channelKey = channelKey;
        this.authorName = authorName;
    }

    public Message() {

    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream input) {
        this.stream = input;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        if(stream != null)
            value += "INPUT:"+stream.toString();
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
