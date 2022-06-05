package Panels;

import Classes.ConnectSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class delete_programm {
    private JTextField tfprogrammIDdel;
    private JButton btnDel;

    public delete_programm() {
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection c = ConnectSQL.get_connection();
                PreparedStatement ps;
                ps = c.prepareStatement("DELETE FROM programm WHERE programm_id = ?");
                ps.setInt(1, Integer.parseInt(tfReIDdelete.getText()));
                ps.executeQuery();
                c.close();
            }
        });
    }
}
