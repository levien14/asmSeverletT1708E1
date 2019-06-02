package model;

import entity.subject.SubjectInfor;
import model.connector.ConnectionHelper;
import util.SqlQuery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectModel {



    public boolean register(SubjectInfor subjectInfor){

        try {

            PreparedStatement preparedStatement =  ConnectionHelper.getConnection().prepareStatement(SqlQuery.SUBJECT_REGISTER);
            preparedStatement.setString(1,subjectInfor.getId());
            preparedStatement.setString(2,subjectInfor.getName());
            preparedStatement.setInt(3,subjectInfor.getStatus());
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<SubjectInfor> findAllSubject(){
        ArrayList<SubjectInfor> subjectInforArrayList = new ArrayList<SubjectInfor>();
        try {
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(SqlQuery.SUBJECT_FINDALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                SubjectInfor subjectInfor = new SubjectInfor();
                subjectInfor.setId(rs.getString(1));
                subjectInfor.setName(rs.getString(2));
                subjectInfor.setStatus(rs.getInt(3));

                subjectInforArrayList.add(subjectInfor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjectInforArrayList;
    }

    public SubjectInfor findSubjectById(String id){
        try {
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(SqlQuery.SUBJECT_FIND_BY_ID);
            preparedStatement.setString(1,id);
            ResultSet rs =  preparedStatement.executeQuery();
            while(rs.next()){
                SubjectInfor subjectInfor = new SubjectInfor();
                subjectInfor.setId(rs.getString(1));
                subjectInfor.setName(rs.getString(2));
                subjectInfor.setStatus(rs.getInt(3));
                return subjectInfor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean editSubject(SubjectInfor subjectInfor){
        try {
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(SqlQuery.SUBJECT_UPDATE);

            preparedStatement.setString(1,subjectInfor.getName());
            preparedStatement.setInt(2,subjectInfor.getStatus());
            preparedStatement.setString(3,subjectInfor.getId());
            if (preparedStatement.executeUpdate() != 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }

    public boolean deleteSubject(String id){
        try {
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(SqlQuery.SUBJECT_DELETE);
            preparedStatement.setString(1,id);
            if (preparedStatement.executeUpdate() != 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
