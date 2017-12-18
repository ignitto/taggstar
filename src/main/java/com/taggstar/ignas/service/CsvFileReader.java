package com.taggstar.ignas.service;

import com.taggstar.ignas.model.Visitor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

@Service
public class CsvFileReader {

    public List<Visitor> readCSVFile() throws IOException {
        InputStream is =  new ClassPathResource("visitor_segments.csv").getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        List<Visitor> persons = br.lines()
                .skip(1) //skipping first line
                .map(mapToPerson)
                .collect(toList());

        br.close();

        return persons;
    }

    private static Function<String, Visitor> mapToPerson = (line) -> {
        String[] p = line.trim().split("\\s*,\\s*");
        return new Visitor(Integer.valueOf(p[0]), p[1], Integer.valueOf(p[2]), p[3], Integer.valueOf(p[4]), p[6]);
    };


}
