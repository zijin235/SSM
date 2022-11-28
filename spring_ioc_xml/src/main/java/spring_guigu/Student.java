package spring_guigu;

import java.util.Arrays;
import java.util.Map;

public class Student {
    private Integer sid;
    private String sname;
    private Integer age;
    private String gender;
    private ClaSZ clazz;
    private String[] hobby;
    private Map<String,Teacher> teacherMap;

    public Student() {
    }

    public Student(Integer sid, String sname, Integer age, String gender, String[] hobby) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
//        this.clazz = clazz;
        this.hobby = hobby;
    }

    public ClaSZ getClazz() {
        return clazz;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setClazz(ClaSZ clazz) {
        this.clazz = clazz;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }


    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", clazz=" + clazz +
                ", hobby=" + Arrays.toString(hobby) +
                ", teacherMap=" + teacherMap +
                '}';
    }
}
