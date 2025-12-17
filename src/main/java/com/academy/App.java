package com.academy;

import java.sql.Connection; // ton utilitaire de connexion

import com.academy.Utils.ConnectionDb;

public class App {
    public static void main(String[] args) {
        Connection conn = ConnectionDb.getConnection();

        if (conn != null) {
            System.out.println(" Connection OK!");
            try {
                conn.close(); // on ferme la connexion
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(" Connection Failed!");
        }
    }
}
