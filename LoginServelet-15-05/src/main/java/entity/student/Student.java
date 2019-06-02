package entity.student;


public class Student {

    private String rollnumber;
    private String fullname;
    private String dob;
    private String address;
    private String idCard;
    private String phonenumber;
    private int gender;
    private String email;
    private int status;
    private float mediumScore;

    public Student() {
    }

    public Student(String rollnumber, String fullname, String dob, String address, String idCard, String phonenumber, int gender, String email, int status, float mediumScore) {
        this.rollnumber = rollnumber;
        this.fullname = fullname;
        this.dob = dob;
        this.address = address;
        this.idCard = idCard;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.email = email;
        this.status = status;
        this.mediumScore = mediumScore;
    }

    public enum Status {
        STUDYING(1),
        I_QUIT_SCHOOL(0),
        PLEASE_SAVE(2);

        private int value;
        private Status(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public enum Gender{
        MALE(0),
        FEMALE(1),
        ORTHER(2);


        private int value;
        private Gender(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

//    public ArrayList<Integer> enumStatusValue(){
//        Gender.values();
//    }


    public String getStatusNamebyIntStatus(int status){
        if (status == 1){
            return "STUDYING";
        }else if (status == 2){
            return "I_QUIT_SCHOOL";
        }
        return "PLEASE_SAVE";
    }


    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        if (gender == 0){
            this.gender = Gender.MALE.getValue();
        }else if (gender == 2){
            this.gender = Gender.ORTHER.getValue();
        }else{
            this.gender = Gender.FEMALE.getValue();
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if (status == 1){
            this.status = Status.STUDYING.getValue();
        }else if (status == 0){
            this.status = Status.I_QUIT_SCHOOL.getValue();
        }else{
            this.status = Status.PLEASE_SAVE.getValue();
        }
    }

    public float getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(float mediumScore) {
        this.mediumScore = mediumScore;
    }
}
