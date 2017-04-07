package Bot;

import org.json.JSONObject;

import java.io.File;

/**
 * Created by Nakou on 07/04/2017.
 */
public class Conf {

    /*
     * Yeah I know it's a Singleton but IT'S MY PROJECT FFS
     */
    static Conf instance;
    static String confFile = "ressources.json";

    JSONObject jsonObject;

    private Conf(){
        File file = new File(confFile);
        jsonObject = new JSONObject(confFile.toLowerCase());
        jsonObject = jsonObject.getJSONObject("tokens");
    }

    public Conf getInstance(){
        if(instance == null){
            instance = new Conf();
        }
        return this.instance;
    }

    public String getSlackToken(){
        return jsonObject.getString("slack");
    }

    public String getDiscordToken(){
        return jsonObject.getString("slack");
    }
}
