package entity.student;

public enum StudentStatus {
    STUDYING(1),
    I_QUIT_SCHOOL(0),
    PLEASE_SAVE(2);

    private int value;
    private StudentStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
