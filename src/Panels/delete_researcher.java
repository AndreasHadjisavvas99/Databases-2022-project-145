package Panels;

import Classes.ConnectSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class delete_researcher {
    private JTextField tfReIDdelete;
    private JButton btnDelete;
    public JPanel delete_researcher;

    public delete_researcher() {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = ConnectSQL.get_connection();
                    PreparedStatement ps;
                    ps = c.prepareStatement("DELETE FROM researcher WHERE researcher_id = ?");
                    ps.setInt(1, Integer.parseInt(tfReIDdelete.getText()));
                    ps.executeQuery();
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
