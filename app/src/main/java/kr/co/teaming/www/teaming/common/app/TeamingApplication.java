package kr.co.teaming.www.teaming.common.app;

import android.app.Application;
import android.content.Context;

import kr.co.teaming.www.teaming.common.remote.TeamingRESTInterface;
import kr.co.teaming.www.teaming.common.remote.TeamingRESTfulWarmUp;

public class TeamingApplication extends Application {
    private static Context context;
    private static TeamingRESTInterface request;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        request = TeamingRESTfulWarmUp.createTeamingRESTInterface(TeamingRESTInterface.class);
    }

    public static TeamingRESTInterface getTeamingRESTInterface(){
        if(request != null){
              return request;
        } else {
            return TeamingRESTfulWarmUp.createTeamingRESTInterface(TeamingRESTInterface.class);
        }
    }

    public static Context getTeamingContext(){
        return context; // null이 될 수 없다.
    }
}
