package com.dmitriy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tasks {

    public static int taskOne(int countFloor, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT COUNT(number) FROM spreadsheet WHERE CAST(TRIM(number_floor,'АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя-') AS INTEGER) == ?")) {
            statement.setObject(1, countFloor);

            return statement.executeQuery().getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public static void taskTwo(Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT address FROM spreadsheet WHERE(appellation == 'Зарегистрированный участок' AND prefix_code == 9881)")) {
            var resultSet = statement.executeQuery();
            resultSet.next();
            do {
                System.out.println(resultSet.getString(1));
            } while (resultSet.next());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void taskThree(Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT address, prefix_code FROM spreadsheet WHERE appellation LIKE 'Университет' AND year_construction != ''AND CAST(TRIM(number_floor,'АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя-') AS INTEGER) >= 6 ")) {
            ResultSet resultSet = statement.executeQuery();
            int i = 0;
            int sum = 0;
            resultSet.next();
            do {
                System.out.println(resultSet.getString(1));
                sum += resultSet.getInt(2);
                i++;
            } while (resultSet.next());
            System.out.println("Средний prefix_code = " + sum / i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
