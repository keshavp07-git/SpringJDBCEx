package com.keshav.SpringJDBCEx.Service;

import com.keshav.SpringJDBCEx.models.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc ;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Students s) {

        String sql = "insert into Students (name , marks , rollno) values (?,?,?)";
        int rows = jdbc.update(sql,
                s.getName(),
                s.getMarks(),
                s.getRollNo()
        );
        System.out.println(rows + "effcted");

    }

    public List<Students> findAll() {
        String sql = "select * from Students";
        return jdbc.query(sql,(rs,rowNum) -> {
            Students student = new Students();
            student.setRollNo(rs.getInt("rollno"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));
            return student;
        });
    }
}
