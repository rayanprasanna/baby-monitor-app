package ammaibabai.universl.com.ammaibabai.utils;

/**
 * Created by Tharindu on 1/13/2018.
 */

public class CommonUtils {

    public static String[] getTitlesFromContents(String[] contents) {
        int length = contents.length;
        String[] titles = new String[length];
        for(int i=0;i< length;i++){
            titles[i] = contents[i].split("\n")[0];
        }
        return  titles;
    }
}

