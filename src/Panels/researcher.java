package Panels;

import Classes.ConnectSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class researcher {

    public JPanel researcher;
    private JTextField tftReIDinsert;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfDateOfBirth;
    private JTextField tfGender;
    private JTextField tfOrgID;
    private JTextField tfDateStartOrg;
    private JButton btnInsert;
    private JPanel paneladd;
    static final String QUERY = "SELECT researcher_id, first_name, last_name FROM researcher";
    public researcher() {

        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = ConnectSQL.get_connection();
                    PreparedStatement ps;
                    ps = c.prepareStatement("insert into researcher values (?, ?, ?, ?, ?, ?, ?)");
                    ps.setInt(1, Integer.parseInt(tftReIDinsert.getText()));
                    ps.setString(2,tfFirstName.getText());
                    ps.setString(3,tfLastName.getText());
                    ps.setDate(4, Date.valueOf(tfDateOfBirth.getText()));
                    ps.setString(5,tfGender.getText());
                    ps.setDate(6, Date.valueOf(tfDateStartOrg.getText()));
                    ps.setInt(7, Integer.parseInt(tfOrgID.getText()));
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
