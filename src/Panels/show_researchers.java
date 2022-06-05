package Panels;

import Classes.ConnectSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class show_researchers {
    private JTable table1;
    public JPanel show_researchers;
    private JScrollPane scrollpane1;
    private DefaultTableModel model = new DefaultTableModel();;
    Object[] columns = {"Researcher ID", "First Name", "Last Name", "DOB", "Gender", "Date Start Org","Org ID"};

    public show_researchers() {
        try {
            model.setColumnIdentifiers(columns);
            Connection c = ConnectSQL.get_connection();
            PreparedStatement ps;
            ps = c.prepareStatement("select * from researcher");
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){

                Object[] row = {rs.getString("researcher_id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("date_of_birth"),rs.getString("gender"),rs.getString("date_start_org"),rs.getString("org_id")};
                model.addRow(row);
            }
            c.close();
        }catch (SQLClientInfoException er){
            er.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        table1 = new JTable(model);
        scrollpane1.setViewportView(table1);
    }
}
