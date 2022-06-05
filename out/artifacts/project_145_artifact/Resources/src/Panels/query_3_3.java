package Panels;

import Classes.ConnectSQL;
import java.sql.Connection;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class query_3_3 {
    public JPanel panel2;
    private JTextField tfSciField;
    private JButton btnCalculate;
    public JPanel query_3_3;
    private JTable tbl1;
    private JScrollPane scrollpane1;
    private JTable tbl2;
    private JScrollPane scrollpane2;
    private JButton btnClear;
    private DefaultTableModel model = new DefaultTableModel();;
    Object[] columns = {"Project Name"};
    private DefaultTableModel model2 = new DefaultTableModel();;
    Object[] columns2 = {"Researcher Full Name"};

    public query_3_3() {
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Statement statement = null;
                //ResultSet rsdate;
                try {
                    model.setColumnIdentifiers(columns);
                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement("select title from active_projects where project_id IN (select project_id from scientific_field_project where field_id = (select field_id from scientific_field where name = ?)) and funding > 0");
                    ps.setString(1,tfSciField.getText());


                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){

                        Object[] row = {rs.getString("title")};
                        model.addRow(row);
                    }

                    model2.setColumnIdentifiers(columns2);
                    PreparedStatement ps2;
                    ps2 = c.prepareStatement("select first_name,last_name from researcher where researcher_id in (select distinct researcher_id from works_on_project where project_id in (select project_id from active_projects where project_id in(select project_id from scientific_field_project where field_id = (select field_id from scientific_field where name = ?))))");
                    ps2.setString(1,tfSciField.getText());

                    ResultSet rs2 = ps2.executeQuery();
                    while(rs2.next()){

                        Object[] row = {rs2.getString("first_name")+" "+ rs2.getString("last_name")};
                        model2.addRow(row);
                    }
                    /*if(rs2.next()) {
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
                    }*/
                    rs2.close();
                    rs.close();
                    c.close();

                }catch (SQLClientInfoException er){
                    er.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                tbl1 = new JTable(model);
                scrollpane1.setViewportView(tbl1);
                tbl2 = new JTable(model2);
                scrollpane2.setViewportView(tbl2);
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tbl1.getModel();
                model.setRowCount(0);
                DefaultTableModel model2 = (DefaultTableModel) tbl2.getModel();
                model2.setRowCount(0);
            }
        });
    }
}
