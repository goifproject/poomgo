package kr.co.teaming.www.teaming.common;

import kr.co.teaming.www.teaming.models.StudyInfo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TeamingRESTInterface {

    /**
     * @author shc
     * @time 2018.05.14
     */

    @GET("/study")
    Call<StudyInfo> studyInfo(); // 하나의 요청에 대한 제이슨

}
