package Panels;

import Classes.ConnectSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class update_researchers {
    private JTextField tfReID;
    private JButton showButton;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfDOB;
    private JTextField tfGender;
    private JTextField tfDateStartOrg;
    private JTextField tfOrgID;
    private JButton btnChange;
    public JPanel update_researcher;
    String first_name;
    String last_name ;
    String dob ;
    String gender ;
    String date_start_org ;
    String org_id;

    public update_researchers() {
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement("select first_name,last_name,date_of_birth,gender,date_start_org,org_id from researcher where researcher_id = ?");

                    ps.setInt(1, Integer.parseInt(tfReID.getText()));

                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                        first_name = rs.getString("first_name");
                        tfFirstName.setText(first_name);
                        last_name = rs.getString("last_name");
                        tfLastName.setText(last_name);
                        dob = rs.getString("date_of_birth");
                        tfDOB.setText(dob);
                        gender = rs.getString("gender");
                        tfGender.setText(gender);
                        date_start_org = rs.getString("date_start_org");
                        tfDateStartOrg.setText(date_start_org);
                        org_id = rs.getString("org_id");
                        tfOrgID.setText(org_id);
                    }




                    rs.close();
                    c.close();

                }catch (SQLClientInfoException er){
                    er.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        btnChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement("UPDATE researcher SET first_name = ?, last_name = ?, date_of_birth = ?,gender = ?,date_start_org = ?,org_id = ? WHERE researcher_id = ?");
                    ps.setString(1,tfFirstName.getText());
                    ps.setString(2,tfLastName.getText());
                    ps.setDate(3, Date.valueOf(tfDOB.getText()));
                    ps.setString(4,tfGender.getText());
                    ps.setDate(5, Date.valueOf(tfDateStartOrg.getText()));
                    ps.setInt(6, Integer.parseInt(tfOrgID.getText()));
                    ps.setInt(7, Integer.parseInt(tfReID.getText()));
                    ResultSet rs = ps.executeQuery();
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
