package entity.subject;

public class SubjectInfor {
    private String id;
    private String name;
    private int status;

    public SubjectInfor() {
    }

    public SubjectInfor(String id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }


    public enum SubjectStatus{
        USING(1),
        COURSE(0);
        private int value;

        SubjectStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int value) {
        if (value == 1){
            this.status = SubjectStatus.USING.getValue();
        }else if (value == 0){
            this.status = SubjectStatus.COURSE.getValue();
        }


    }
}
