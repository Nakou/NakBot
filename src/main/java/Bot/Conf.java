package Bot;

import net.dv8tion.jda.core.JDA;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Nakou on 07/04/2017.
 */
public class Conf {

    /*
     * Yeah I know it's a Singleton but IT'S MY PROJECT FFS
     */
    static Conf instance;
    static String confFile = "resources.json";

    JDA jda;

    JSONObject baseJson;

    private Conf(){
        File file = new File(confFile);
        try {
            baseJson = new JSONObject(new Scanner(file).useDelimiter("\\Z").next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Conf(String jsonContent){
        baseJson = new JSONObject(jsonContent);
    }

    public static Conf getInstance(){
        if(Conf.instance == null){
            Conf.instance = new Conf();
        }
        return Conf.instance;
    }

    public static Conf getInstance(String jsonContent){
        Conf.instance = new Conf(jsonContent);
        return Conf.instance;
    }

    public String getSlackToken(){
        return baseJson.getJSONObject("tokens").getString("slack");
    }

    public String getGuildId(){
        return baseJson.getJSONObject("tokens").getString("guildId");
    }

    public String getDiscordToken(){
        return baseJson.getJSONObject("tokens").getString("discord");
    }

    public List<String> getCommands(){
        List<String> retValue = new ArrayList<>();
        JSONArray jsonList = baseJson.getJSONArray("commands");

        for(Object o : jsonList.toList()){
            retValue.add(o.toString());
        }
        return retValue;
    }

    public Map<String, List<String>> getAutoresponses(){
        Map<String, List<String>> retValue = new HashMap<>();

        JSONArray autoresponsesArray = baseJson.getJSONArray("autoresponses");
        JSONArray autoresponse;
        List<String> values;
        String keys;
        for(Object o1 : autoresponsesArray){
            values = new ArrayList<>();
            keys = (String) ((JSONObject)o1).get("keys");
            autoresponse = ((JSONObject)o1).getJSONArray("values");
            for(Object o2 : autoresponse.toList()){
                values.add((String)o2);
            }
            retValue.put(keys, values);
        }
        return retValue;
    }

    public JDA getJdaConnector(){
        return jda;
    }
}
