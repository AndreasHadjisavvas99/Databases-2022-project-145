package Panels;

import Classes.ConnectSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class query_3_5 {
    public JPanel query_3_5;
    private JLabel lblZevgos1;
    private JLabel lblZevgos2;
    private JLabel lblZevgos3;
    private JButton btnFind;
    private JLabel lblCount1;
    private JLabel lblCount2;
    private JLabel lblCount3;

    public query_3_5() {
        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = ConnectSQL.get_connection();
                    PreparedStatement ps;
                    ps = c.prepareStatement("SELECT sf1.field_id, sf2.field_id as field_id2, COUNT(1) FROM scientific_field_project AS sf1 JOIN scientific_field_project AS sf2 ON sf1.project_id=sf2.project_id WHERE sf1.field_id<sf2.field_id GROUP BY sf1.field_id,sf2.field_id ORDER BY COUNT(1) DESC");
                    ResultSet rs = ps.executeQuery();

                    if(rs.next()) {
                        lblZevgos1.setText(rs.getString("field_id") + " , " + rs.getString("field_id2"));
                        lblCount1.setText(rs.getString("count"));
                    }
                    if(rs.next()) {
                        lblZevgos2.setText(rs.getString("field_id") + " , " + rs.getString("field_id2"));
                        lblCount2.setText(rs.getString("count"));

                    }
                    if(rs.next()) {
                        lblZevgos3.setText(rs.getString("field_id") + " , " + rs.getString("field_id2"));
                        lblCount3.setText(rs.getString("count"));
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
