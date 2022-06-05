package Panels;

import Classes.ConnectSQL;
import java.sql.Connection;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
public class panel2 {
    public JPanel panel2;
    private JTextField tfSciField;
    private JLabel lblProject1;
    private JLabel lblProject2;
    private JLabel lblProject3;
    private JLabel lblProject4;
    private JLabel lblProject5;
    private JLabel lblResearcher1;
    private JLabel lblResearcher2;
    private JLabel lblResearcher3;
    private JLabel lblResearcher4;
    private JLabel lblResearcher5;
    private JButton btnCalculate;

    public panel2() {
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Statement statement = null;
                //ResultSet rsdate;
                try {
                    Connection c = ConnectSQL.get_connection();
                    /*statement = c.createStatement();

                    get current date
                    String sql = "SELECT CURRENT_TIMESTAMP";
                    rsdate = statement.executeQuery(sql);
                    System.out.print("Today date is - ");
                    Date current_date = null;
                    while (rsdate.next()) {
                        current_date = rsdate.getDate(1);
                        System.out.println(current_date);
                    }*/
                    

                    PreparedStatement ps;
                    ps = c.prepareStatement("select title from active_projects where project_id IN (select project_id from scientific_field_project where field_id = (select field_id from scientific_field where name = ?)) and funding > 0");
                    ps.setString(1,tfSciField.getText());
                    //ps.setDate(2, (java.sql.Date) current_date);
                    
                    //ps = c.prepareStatement("select title from project where project_id IN (select project_id from scientific_field_project where field_id = (select field_id from scientific_field where name = ?))");
                    //ps.setString(1,tfSciField.getText());


                    ResultSet rs = ps.executeQuery();
                    /*if(rs.next()) {
                        String apantisi = rs.getString("project_id");
                        lblProject1.setText(apantisi);
                    }*/
                    if(rs.next()) {
                        String apantisi = rs.getString("title");
                        lblProject1.setText(apantisi);
                    }
                    if(rs.next()) {
                        String apantisi = rs.getString("title");
                        lblProject2.setText(apantisi);

                    }
                    if(rs.next()) {
                        String apantisi = rs.getString("title");
                        lblProject3.setText(apantisi);
                    }
                    if(rs.next()) {
                        String apantisi = rs.getString("title");
                        lblProject4.setText(apantisi);
                    }
                    if(rs.next()) {
                        String apantisi = rs.getString("title");
                        lblProject5.setText(apantisi);
                    }

                    PreparedStatement ps2;
                    ps2 = c.prepareStatement("select first_name,last_name from researcher where researcher_id in (select distinct researcher_id from works_on_project where project_id in (select project_id from active_projects where project_id in(select project_id from scientific_field_project where field_id = (select field_id from scientific_field where name = ?))))");
                    ps2.setString(1,tfSciField.getText());

                    ResultSet rs2 = ps2.executeQuery();

                    if(rs2.next()) {
                        lblResearcher1.setText(rs2.getString("first_name")+" "+ rs2.getString("last_name"));
                    }
                    if(rs2.next()) {
                        lblResearcher2.setText(rs2.getString("first_name")+" "+ rs2.getString("last_name"));

                    }
                    if(rs2.next()) {
                        lblResearcher3.setText(rs2.getString("first_name")+" "+ rs2.getString("last_name"));
                    }
                    if(rs2.next()) {
                        lblResearcher4.setText(rs2.getString("first_name")+" "+ rs2.getString("last_name"));
                    }
                    if(rs2.next()) {
                        lblResearcher5.setText(rs2.getString("first_name")+" "+ rs2.getString("last_name"));
                    }
                    rs2.close();
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
