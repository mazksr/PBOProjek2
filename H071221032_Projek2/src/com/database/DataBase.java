/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import java.sql.SQLException;
import com.config.MyConnection;
import com.reference.Product;
import java.util.ArrayList;

public class DataBase extends MyConnection {
    public static void getDatabase() {
        connection();
        try {
            query = "SELECT NAMA,HARGA,STOK FROM `table_product`ORDER BY ID DESC";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("NAMA") + ": Rp." +
                                resultSet.getString("HARGA") + " (" +
                                resultSet.getString("STOK") + ")");

            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public static void readDB() {
        connection();
        try {
            query = "SELECT NAMA, HARGA, STOK FROM `table_product` ORDER BY ID DESC ";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("NAMA") + ": Rp." +
                                resultSet.getString("HARGA") + " (" +
                                resultSet.getString("STOK") + ")");

            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public static boolean insertDB(String product, Long harga, Integer stok) {
        connection();
        query = "INSERT INTO `table_product` (NAMA, HARGA, STOK) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product);
            preparedStatement.setLong(2, harga);
            preparedStatement.setInt(3, stok);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }
    
    public static void updateNamaDB(int id, String name) {
        connection();
        query= "UPDATE `tb_produk` SET NAMA=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateHargaDB(int id, Long harga) {
        connection();
        query= "UPDATE `table_product` SET HARGA=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, harga);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateStokDB(int id, Integer stok) {
        connection();
        query= "UPDATE `table_product` SET JUMLAH=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, stok);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean deletDB(String nama) {
        connection();
        query= "DELETE FROM `table_product` WHERE NAMA=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            int rowDelete = preparedStatement.executeUpdate();
            if (rowDelete>0) {
                return true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
       public static void deleteDB() {
        connection();
        query= "DELETE FROM `table_product`";
        try {
            preparedStatement = connection.prepareStatement(query);
            int rowDelete = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       
    public static Product getProdukbyNama(String nama){
        Product produk = null;
        connection();
        query = "SELECT * FROM `table_product` WHERE NAMA=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                produk = new Product(resultSet.getInt("ID"), resultSet.getString("NAMA"), resultSet.getInt("HARGA"), resultSet.getInt("STOK"));
            }
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produk;
    }
    
    public static void insertDB(ArrayList<Product> listProduct) {
        connection();
        query = "INSERT INTO `table_product` (NAMA, HARGA, STOK) VALUES (?, ?, ?)";
        try {
            for (int i = 0; i<listProduct.size();i++) {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, listProduct.get(i).getName());
                preparedStatement.setInt(2, listProduct.get(i).getPrice());
                preparedStatement.setInt(3, listProduct.get(i).getStock());
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();

//           
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}

