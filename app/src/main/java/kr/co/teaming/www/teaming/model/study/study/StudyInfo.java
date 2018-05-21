package kr.co.teaming.www.teaming.model.study.study;

import java.io.Serializable;
import java.util.ArrayList;

public class StudyInfo implements Serializable {

    public int total;
//    public RESULT result;

//    public class RESULT{
//        public int code;
//        public String msg;
//    } // 따로 클래스로 만들어라.

    public ArrayList<Data> datas = new ArrayList<>();

    public class Data{
        public int id;
        public String director_id;
        public String name;
        public String reg_date;
        public String update_date;
        public String start_date;
        public int duration;
        public int region;
        public int category;
        public String description;
        public int lim;
        public int status;
        public  int number;
        public String thumbnail;
    }

}
