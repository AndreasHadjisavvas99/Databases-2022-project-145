package Panels;

import Classes.ConnectSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
public class query_3_1 {
    private JButton btnShow;
    private JScrollPane scrollPaneApotelesma;
    public JTable tblApotelesma;
    public JPanel query_3_1;

    public query_3_1() {
        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = ConnectSQL.get_connection();
                    PreparedStatement ps;
                    ps = c.prepareStatement("Select name from programm");
                    ResultSet rs = ps.executeQuery();
                    String column[] = {"Prgramm Name"};
                    String data [][] = {{"dandasd"}};
                    rs.close();
                    c.close();
                }catch (SQLClientInfoException er){
                    er.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}
