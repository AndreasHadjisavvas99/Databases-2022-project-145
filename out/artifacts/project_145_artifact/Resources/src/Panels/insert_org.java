package Panels;

import Classes.ConnectSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Statement;

public class insert_org {
    public JPanel insert_org;
    private JTextField txtabbreviation;
    private JTextField txtname;
    private JTextField txtpostcode;
    private JTextField txtcity;
    private JTextField txtstreet_name;
    private JTextField txtphone_number;
    private JTextField txtcompany_id;
    private JTextField txtid_university;
    private JTextField txtresce_id;
    private JButton btnInsertOrg;

    public insert_org() {
        btnInsertOrg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = ConnectSQL.get_connection();
                    Statement stmt = c.createStatement();

                    System.out.println("Inserting records into the table Organization");
                    String sql = "INSERT INTO organization VALUES (100, 'Zara', 'Ali', 18)";
                    stmt.executeUpdate(sql);
                    sql = "INSERT INTO Registration VALUES (101, 'Mahnaz', 'Fatma', 25)";
                    stmt.executeUpdate(sql);
                    sql = "INSERT INTO Registration VALUES (102, 'Zaid', 'Khan', 30)";
                    stmt.executeUpdate(sql);
                    sql = "INSERT INTO Registration VALUES(103, 'Sumit', 'Mittal', 28)";
                    stmt.executeUpdate(sql);
                    System.out.println("Inserted records into the table...");


                }catch (SQLClientInfoException er){
                    er.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}
