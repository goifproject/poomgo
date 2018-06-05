package kr.co.teaming.www.teaming.models;

import java.io.Serializable;
import java.util.ArrayList;

public class NoticeInfo implements Serializable {

    public int total;

    public Result result = new Result();

    public ArrayList<NoticeData> data = new ArrayList<>();

    public class NoticeData{
        public String notice;
        public String reg_date;
        public String update_date;
        public int id;
        public int study_id;
    }

}
