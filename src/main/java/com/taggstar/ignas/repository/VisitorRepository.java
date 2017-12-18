package com.taggstar.ignas.repository;

import com.taggstar.ignas.model.Visitor;
import com.taggstar.ignas.service.CsvFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class VisitorRepository {

    @Autowired
    private CsvFileReader csvFileReader;

    private List<Visitor> visitors;

    @PostConstruct
    public List<Visitor> getAllVisitors() {
        try {
            List<Visitor> visitorsFromCSV = csvFileReader.readCSVFile();
            visitors = Collections.synchronizedList(visitorsFromCSV);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }
}
