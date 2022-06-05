package Panels;

import Classes.ConnectSQL;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class query_3_2 {
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JButton btnDO;
    private JLabel lblApotelesma;
    private JLabel lblApotelesma2;
    private JLabel lblApotelesma3;
    private JLabel lblApotelesma4;
    public JPanel query_3_2;
    private JTextField tfProject;
    private JButton btnSciField;
    private JLabel lblField1;
    private JLabel lblField2;
    private JLabel lblField3;
    private JLabel lblField4;
    private JTable tbl1;
    private JScrollPane scrollpane1;
    private JTable tbl2;
    private JScrollPane scrollpane2;
    private DefaultTableModel model = new DefaultTableModel();
    Object[] columns = {"Έργα/Επιχορηγίσεις"};

    private DefaultTableModel model2 = new DefaultTableModel();
    Object[] columns2 = {"Επιστημονικό Πεδίο"};
    public query_3_2() {
        btnDO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.setColumnIdentifiers(columns);
                    Connection c = ConnectSQL.get_connection();
                    PreparedStatement ps;
                    ps = c.prepareStatement("select project.title from project where project.project_id IN(select project_id from works_on_project where researcher_id = (select researcher_id from researcher where first_name = ? and last_name = ?))");
                    //ps = c.prepareStatement("select project.title from project where project.project_id IN(\n" +
                    //"select project_id from works_on_project where researcher_id = (select researcher_id from researcher where first_name = ? and last_name = ?));");
                    ps.setString(1,tfFirstName.getText());
                    ps.setString(2,tfLastName.getText());

                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){

                        Object[] row = {rs.getString("title")};
                        model.addRow(row);
                    }

                    rs.close();
                    c.close();
                }catch (SQLClientInfoException er){
                    er.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                tbl1 = new JTable(model);
                scrollpane1.setViewportView(tbl1);

            }

        });
        btnSciField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model2.setColumnIdentifiers(columns2);
                    Connection c = ConnectSQL.get_connection();
                    PreparedStatement ps;
                    ps = c.prepareStatement("select scientific_field.name from scientific_field where scientific_field.field_id in (select field_id from scientific_field_project where project_id = (select project_id from project where title = ?))");
                    ps.setString(1,tfProject.getText());


                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        Object[] row = {rs.getString("name")};
                        model2.addRow(row);
                    }

                    rs.close();
                    c.close();
                }catch (SQLClientInfoException er){
                    er.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                tbl2 = new JTable(model2);
                scrollpane2.setViewportView(tbl2);
            }
        });
    }
}
