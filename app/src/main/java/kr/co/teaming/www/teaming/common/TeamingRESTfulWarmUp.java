package kr.co.teaming.www.teaming.common;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeamingRESTfulWarmUp {

    private static TeamingRESTfulWarmUp teamingRESTfulWarmUp;
    private static final int HTTP_TIMEOUT = 15;
    private static final String Teaming_BASE_URL = "http://192.168.1.159:3000/";

    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    public TeamingRESTfulWarmUp() {
        HttpLoggingInterceptor httpLogging = new HttpLoggingInterceptor();
        httpLogging.setLevel(HttpLoggingInterceptor.Level.BODY);

        RequestResponseTimeInterceptor totalTime = new RequestResponseTimeInterceptor();
        // Interceptor Okhttp3에 있는 거
        // RequestHeaderInterceptor headerinterceptor = new RequestHeaderInterceptor();

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLogging)
                .addInterceptor(totalTime)
                //.addInterceptor(headerinterceptor)
                //.addInterceptor(new RetryIntereptor)
                .connectTimeout(HTTP_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(HTTP_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(HTTP_TIMEOUT, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Teaming_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    /*
        요청 후 응답 받는 시간.
     */

    private class RequestResponseTimeInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            long t1 = System.nanoTime();
            Log.e("request 요청시간", String.format(" %s on %s%n%s",request.url(), chain.connection(), request.headers()));

            Response response = chain.proceed(request);
            long t2 = System.nanoTime();
            Log.e("response 응답시간",String.format(" %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));

            return response;
        }
    }

    /*
    다시 요청을 시도할 때
     */

    private static class RetryInterceptor implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);

            int tryCount = 0;
            int maxLimit = 2;
            while (!response.isSuccessful() && tryCount < maxLimit) {
                Log.d("interceptor", "Request failed - " + tryCount);
                tryCount++;
                response = chain.proceed(request);
                if(maxLimit == 2){
                    Log.e("RetryInterceptor", "문제발생");
                }
            }
            return response;
        }
    }

    /*
        컨텐츠 타입

     */

   /* private class RequestHeaderInterceptor  implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request original = chain.request();

            Request.Builder requestBuilder = original.newBuilder();

            requestBuilder.addHeader("Content-Type","application/x-www-form-urlencoded");

            if(GsonReturedModel.getLoginInfo() != null){
                String token = GsonReturedModel.getLoginInfo().token;
                if(token != null && !TextUtils.isEmpty(token)){
                    requestBuilder.addHeader("Authorization","Bearer " + token);
                }
            }
            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
    }*/

   private <T> T getTeamingRESTInterface(Class<T> restful){
       return retrofit.create(restful);
   }

   public static <T> T createTeamingRESTInterface(Class<T> restful){
       if(teamingRESTfulWarmUp == null){
           teamingRESTfulWarmUp = new TeamingRESTfulWarmUp();
       }
       return teamingRESTfulWarmUp.getTeamingRESTInterface(restful);
   }

}
