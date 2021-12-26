package com.dmitriy;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Base> bases = new ArrayList<>();

    public Parser() {
        try (CSVReader reader = new CSVReader(new FileReader("base.csv"))) {
            String[] values;
            reader.readNext();
            while ((values = reader.readNext()) != null) {
                Base institution = new Base(values[0], values[1], values[3], values[4], values[5], values[8]);
                bases.add(institution);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}