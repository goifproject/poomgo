package kr.co.teaming.www.teaming.model.study.notice;

import java.io.Serializable;
import java.util.ArrayList;

public class NoticeInfo implements Serializable {

    public int total;

    public ArrayList<NoticeData> noticeData = new ArrayList<>();

    public class NoticeData{
        public String notice;
        public String reg_date;
        public String update_date;
        public int id;
        public int study_id;
    }

}
