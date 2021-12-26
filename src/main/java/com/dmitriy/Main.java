package com.dmitriy;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {
        Parser list = new Parser();
        Sql sql = new Sql();

//        for (Base value : list.bases) //Генерация таблицы
//            sql.generateString(value);

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (var countFloors = 1; 30 >= countFloors; countFloors++) {
            int count = Tasks.taskOne(countFloors, sql.connection);
            map.put(countFloors, count);
        }

        Chart.createCharts(map);
        System.out.println("\nЗадача 1");
        for (var a : map.entrySet())
            System.out.println(a.getKey() + " - " + a.getValue());

        System.out.println("\nЗадача 2");
        Tasks.taskTwo(sql.connection);

        System.out.println("\nЗадача 3");
        Tasks.taskThree(sql.connection);
    }
}
