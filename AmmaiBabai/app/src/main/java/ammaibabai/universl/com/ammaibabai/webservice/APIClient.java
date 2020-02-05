package ammaibabai.universl.com.ammaibabai.webservice;



import ammaibabai.universl.com.ammaibabai.common.StringUtils;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tharindu on 12/23/2017.
 */

public class APIClient {
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static final String BASE_URL = "http://siriliyaapp.com/api/";
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static APIService createService(String authToken) {
        if (!StringUtils.isNullOrEmpty(authToken)) {
            AuthenticationInterceptor interceptor =
                    new AuthenticationInterceptor(authToken);

            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor);

                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }
        return retrofit.create(APIService.class);
    }
}
