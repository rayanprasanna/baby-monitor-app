package ammaibabai.universl.com.ammaibabai.webservice;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Tharindu on 12/23/2017.
 */

public class APIUtils {

    public static MultipartBody.Part getMultipartFromImage(File file,String name){
        return MultipartBody.Part.createFormData(name, file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
    }
}
