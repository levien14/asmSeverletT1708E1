package entity;

import entity.student.Student;
import entity.subject.SubjectInfor;

import java.lang.reflect.Field;

public class test {
    public static void main(String[] args) {
        Student student = new Student();
//        student.setStatus(Student.Status.STUDYING);
//        System.out.println(student.getStatus());
//
//        student.setStatusNamebyIntValue(1);
//        System.out.println(student.getStatus());
//        System.out.println(student.getStatusNamebyIntStatus(student.getStatus()));

        SubjectInfor subjectInfor = new SubjectInfor();


//        for (Field f: Student.Gender.class.getFields()
//             ) {
//            System.out.println(f.getName());
//            System.out.println( f.getModifiers());
//            System.out.println(Student.Gender.FEMALE.getValue());
//
//        }
    }
}
