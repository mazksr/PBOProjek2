/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.composition;

import java.sql.SQLException;
import com.config.MyConnection;

public class ReadData extends MyConnection {
    public static void readDataBase() {
        connection();
        try {
            String query = "SELECT * FROM `table_product`";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.printf("%s\t%-15s\tRp. %-10s\tStok: %-5s\n",
                        resultSet.getString("ID"),
                        resultSet.getString("NAMA"),
                        resultSet.getString("HARGA"),
                        resultSet.getString("STOK")
                );
            }
            System.out.println("=".repeat(50));
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
