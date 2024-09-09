package com.keshav.SpringJDBCEx.Service;

import com.keshav.SpringJDBCEx.models.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepo repo ;

    public StudentRepo getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudents(Students s) {
        repo.save(s);
    }

    public List<Students> getstudents() {
        return repo.findAll();
    }
}
