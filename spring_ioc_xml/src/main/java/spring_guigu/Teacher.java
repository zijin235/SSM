package spring_guigu;

public class Teacher {
    private Integer Tid;
    private String Tname;

    public Teacher(Integer tid, String tname) {
        Tid = tid;
        Tname = tname;
    }

    public Teacher() {
    }

    public Integer getTid() {
        return Tid;
    }

    public void setTid(Integer tid) {
        Tid = tid;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Tid=" + Tid +
                ", Tname='" + Tname + '\'' +
                '}';
    }
}
