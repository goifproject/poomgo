package kr.co.teaming.www.teaming.common.remote;

import kr.co.teaming.www.teaming.model.study.notice.NoticeInfo;
import kr.co.teaming.www.teaming.model.study.study.StudyInfo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TeamingRESTInterface {

    /**
     * @author shc
     * @time 2018.05.14
     */

    @GET("/study")
    Call<StudyInfo> studyInfo(); // 하나의 요청에 대한 제이슨

    @GET("/study/3434/notice")
    Call<NoticeInfo> noticeinfo();

}
