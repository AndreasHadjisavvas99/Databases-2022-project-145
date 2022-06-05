package Panels;
import javax.swing.*;
import Classes.ConnectSQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
public class panel1  {

    public JPanel panel1;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JButton btnClear;
    private JButton btnDO;
    private JLabel lblApotelesma;
    private JLabel lblApotelesma2;
    private JLabel lblApotelesma3;
    private JLabel lblApotelesma4;
    private JTable tblProjects;
    private DefaultTableModel model;


    Object[] columns = {"title"};

    public panel1() {



        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfFirstName.setText("");
                lblApotelesma.setText("");
                tfLastName.setText("");
                lblApotelesma2.setText("");
                lblApotelesma3.setText("");
                lblApotelesma4.setText("");

            }
        });
        btnDO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = ConnectSQL.get_connection();
                    PreparedStatement ps;
                    ps = c.prepareStatement("select project.title from project where project.project_id IN(select project_id from works_on_project where researcher_id = (select researcher_id from researcher where first_name = ? and last_name = ?))");
                    //ps = c.prepareStatement("select project.title from project where project.project_id IN(\n" +
                    //"select project_id from works_on_project where researcher_id = (select researcher_id from researcher where first_name = ? and last_name = ?));");
                    ps.setString(1,tfFirstName.getText());
                    ps.setString(2,tfLastName.getText());

                    ResultSet rs = ps.executeQuery();

                    String[] columns = {"title"};

                    /*while(rs.next()) {
                        //Object[] row={rs.getString("title")};
                        //model.addRow(row);
                        System.out.println(rs.getString("title"));
                        //model.addRow(new Object[] { rs.getString("title")});
                        model.addRow(
                                new Object[]{"hi"}
                        );
                    }*/


                    if(rs.next()) {
                        String apantisi = rs.getString("title");
                        lblApotelesma.setText(apantisi);
                    }
                    if(rs.next()) {
                        String apantisi = rs.getString("title");
                        lblApotelesma2.setText(apantisi);

                    }
                    if(rs.next()) {
                        String apantisi = rs.getString("title");
                        lblApotelesma3.setText(apantisi);
                    }
                    if(rs.next()) {
                        String apantisi = rs.getString("title");
                        lblApotelesma4.setText(apantisi);
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
    }

}
