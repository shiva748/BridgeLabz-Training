package org.dbms.dao;

import org.dbms.config.DatabaseConnection;
import org.dbms.model.Patient;
import org.dbms.utils.ResultSetMapper;

import java.sql.*;

public class PatientDaoImpl implements PatientDao {
    private Connection connection;

    public PatientDaoImpl() {
        connection = DatabaseConnection.getInstance().getConnection();
    }
    @Override
    public boolean save(Patient p) {
        try{
            String sql = "INSERT INTO patient (name, dob, phone, email, address, bloodGroup) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, p.getName());
            pstmt.setDate(2, Date.valueOf(p.getDob()));
            pstmt.setString(3, p.getPhone());
            pstmt.setString(4, p.getEmail());
            pstmt.setString(5, p.getAddress());
            pstmt.setString(6, p.getBloodGroup());
            int rowsEffected = pstmt.executeUpdate();
            if (rowsEffected > 0) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Patient p) {
        return false;
    }

    @Override
    public boolean update(Patient p) {
        try{
            String sql = "UPDATE patient SET name=?, dob=?, phone=?, email=?, address=?, bloodGroup=? WHERE id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, p.getName());
            pstmt.setDate(2, Date.valueOf(p.getDob()));
            pstmt.setString(3, p.getPhone());
            pstmt.setString(4, p.getEmail());
            pstmt.setString(5, p.getAddress());
            pstmt.setString(6, p.getBloodGroup());
            pstmt.setLong(7, p.getId());
            int rowsEffected = pstmt.executeUpdate();
            if (rowsEffected > 0) {
                return true;
            }
            return false;
        }catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Patient findById(Long id) {
        try {
            String sql = "SELECT * FROM patient WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Patient p = ResultSetMapper.map(rs,  Patient.class);
                return p;
            } else {
                System.out.println("Patient not found");
            }
            return null;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Patient findByPhone(String phone) {
        try {
            String sql = "SELECT * FROM patient WHERE phone = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, phone);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Patient p = ResultSetMapper.map(rs,  Patient.class);
                return p;
            } else {
                System.out.println("Patient not found");
            }
            return null;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return null;
        }
    }
}
