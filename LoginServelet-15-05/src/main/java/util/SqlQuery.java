package util;

public class SqlQuery {
    public static final String FINDALL = "select * from student_information";
    public static final String CHECK_LOGIN = "select * from user where username = ? and password = ?";
    public static final String FIND_BY_ID = "select * from student_information where rollNumber = ?";
    public static final String UPDATE = "update student_information set fullname = ? ,dob = ?,address = ? ," +
                            "iDCardNumber = ? ,phoneNumber = ? ,gender = ? ,email = ? ,status = ? ,mediumScore = ? where rollnumber = ?";
    public static final String STUDENT_DELETE = "update student_information set status = ? where rollnumber = ?";
    public static final String STUDENT_REGISTER = "insert into student_information(rollnumber," +
            "fullname,dob,address,iDCardNumber,phoneNumber,gender,email,status) values (?,?,?,?,?,?,?,?,?)";


    public static final String SUBJECT_REGISTER = "INSERT INTO subject(id,name,status) VALUES (?,?,?)";
    public static final String SUBJECT_UPDATE = "UPDATE subject SET name=?,status=? WHERE id=?";
    public static final String SUBJECT_DELETE = "UPDATE subject SET status= 0 WHERE id=?";
    public static final String SUBJECT_FINDALL = "SELECT * FROM subject";
    public static final String SUBJECT_FIND_BY_ID = "SELECT * FROM subject WHERE id=?";


}
