package model;

import entity.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentModel {
    Connection connection;
    private void initConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/student_manager_information?user=root&password=");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> findAll(){
        initConnection();
        ArrayList<Student> arrayList = new ArrayList<Student>();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from student_information");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){

                Student student = new Student();
                student.setRollnumber(rs.getString(1));
                student.setFullname(rs.getString(2));
                student.setDob(String.valueOf(rs.getString(3)));
                student.setAddress(rs.getString(4));
                student.setIdCard(rs.getString(5));
                student.setPhonenumber(rs.getString(6));
                student.setGender(Integer.parseInt(rs.getString(7)));
                student.setEmail(rs.getString(8));

                if ((rs.getString(9)) != null){
                    student.setStatus(Integer.parseInt(rs.getString(9)));
                }
                if ((rs.getString(10)) !=null){
                    student.setMediumScore(Float.parseFloat(rs.getString(10)));
                }else{
                    student.setMediumScore(0);
                }

                arrayList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public boolean checkLogin(String username,String password){
        initConnection();
        try {
            System.out.println("Check Login ;" + username);
            System.out.println("Check Login ;" + password);

            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username = ? and password = ?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Student findByID(String rollnumber){
        initConnection();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from student_information where rollNumber = ?");
            preparedStatement.setString(1,rollnumber);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setRollnumber(rs.getString(1));
                student.setFullname(rs.getString(2));
                student.setDob(String.valueOf(rs.getString(3)));
                student.setAddress(rs.getString(4));
                student.setIdCard(rs.getString(5));
                student.setPhonenumber(rs.getString(6));
                student.setGender(Integer.parseInt(rs.getString(7)));
                student.setEmail(rs.getString(8));
                student.setStatus(Integer.parseInt(rs.getString(9)));

                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Student student){
        initConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "update student_information " +
                    "set " +
                        "fullname = ? ," +
                        "dob = ?," +
                        "address = ? ," +
                        "iDCardNumber = ? ," +
                        "phoneNumber = ? ," +
                        "gender = ? ," +
                        "email = ? ," +
                        "status = ? ," +
                        " mediumScore = ?" +
                    " where rollnumber = ?");
            preparedStatement.setString(1,student.getFullname());
            preparedStatement.setDate(2,Date.valueOf(student.getDob()));
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setString(4,student.getIdCard());
            preparedStatement.setString(5,student.getPhonenumber());
            preparedStatement.setInt(6,student.getGender());
            preparedStatement.setString(7,student.getEmail());
            preparedStatement.setInt(8,student.getStatus());
            preparedStatement.setDouble(9,student.getMediumScore());
            preparedStatement.setString(10,student.getRollnumber());
            int count = preparedStatement.executeUpdate();
            if (count == 0){
                return false;
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return true;
    }

    public boolean delete(Student student){
        initConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update student_information set status = ? where rollnumber = ?");
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,student.getRollnumber());
            int cout = preparedStatement.executeUpdate();
            if (cout == 0){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean register(Student student){
        initConnection();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into student_information(rollnumber," +
                    "fullname,dob,address,iDCardNumber,phoneNumber,gender,email,status) values (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,student.getRollnumber());
            preparedStatement.setString(2,student.getFullname());
            preparedStatement.setDate(3,Date.valueOf(student.getDob()) );
            preparedStatement.setString(4,student.getAddress() );
            preparedStatement.setString(5,student.getIdCard());
            preparedStatement.setString(6,student.getPhonenumber());
            preparedStatement.setInt(7,student.getGender());
            preparedStatement.setString(8,student.getEmail());
            preparedStatement.setInt(9,student.getStatus());
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
