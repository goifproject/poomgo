package kr.co.teaming.www.teaming.models;

public class Study {
    private String study_id;    //스터디 아이디
    private String director_id; //방장 아이디
    private String name;        //스터디명
    private String reg_date;    //등록일
    private String update_date; //업데이트 날짜
    private String start_date;  //시작 날짜
    private String duration;    //기간
    private String end_date;    //종료 날짜
    private String region;      //지역
    private String category;    //분야
    private String description; //설명
    private int limit;          //모집인원
    private String study_status;//상태
    private int number;         //참여인원
    private String thumbnail;   //썸네일


    public String getStudy_id() {
        return study_id;
    }

    public void setStudy_id(String study_id) {
        this.study_id = study_id;
    }

    public String getDirector_id() {
        return director_id;
    }

    public void setDirector_id(String director_id) {
        this.director_id = director_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getStudy_status() {
        return study_status;
    }

    public void setStudy_status(String study_status) {
        this.study_status = study_status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
