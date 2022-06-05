package Panels;

import Classes.ConnectSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;




public class query_3_1 {
    private JButton btnShow;
    private JScrollPane scrollPaneApotelesma;
    private JTable tblApotelesma;
    public JPanel query_3_1;

    private DefaultTableModel model = new DefaultTableModel();;
    Object[] columns = {"Program Name"};
    public query_3_1() {
        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.setColumnIdentifiers(columns);
                    Connection c = ConnectSQL.get_connection();
                    PreparedStatement ps;
                    ps = c.prepareStatement("Select name from programm");
                    ResultSet rs = ps.executeQuery();

                    while(rs.next()) {
                        Object[] row = {rs.getString("name")};
                        model.addRow(row);
                    }

                    rs.close();
                    c.close();
                }catch (SQLClientInfoException er){
                    er.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                tblApotelesma = new JTable(model);
                scrollPaneApotelesma.setViewportView(tblApotelesma);
            }
        });
    }
}
