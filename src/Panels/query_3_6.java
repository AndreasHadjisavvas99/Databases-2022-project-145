package Panels;

import Classes.ConnectSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class query_3_6 {
    private JButton btnFind;
    private JLabel lblRe5;
    private JLabel lblRe1;
    private JLabel lblRe2;
    private JLabel lblRe3;
    private JLabel lblRe4;
    public JPanel query_3_6;
    private JLabel lblCount1;
    private JLabel lblCount2;
    private JLabel lblCount3;
    private JLabel lblCount4;
    private JLabel lblCount5;
    private JButton clearButton;

    public query_3_6() {
        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = ConnectSQL.get_connection();
                    PreparedStatement ps;
                    ps = c.prepareStatement("SELECT r.first_name,r.last_name,r.researcher_id, COUNT(wp.project_id) as count from researcher as r JOIN works_on_project as wp ON r.researcher_id=wp.researcher_id JOIN researchers_under40 as r40 ON wp.researcher_id=r40.researcher_id JOIN active_projects as ap On wp.project_id=ap.project_id GROUP BY r.Researcher_id ORDER BY count  DESC");
                    ResultSet rs = ps.executeQuery();

                    if(rs.next()) {
                        lblRe1.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
                        lblCount1.setText(rs.getString("count"));
                    }
                    if(rs.next()) {
                        lblRe2.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
                        lblCount2.setText(rs.getString("count"));

                    }
                    if(rs.next()) {
                        lblRe3.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
                        lblCount3.setText(rs.getString("count"));
                    }
                    if(rs.next()) {
                        lblRe4.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
                        lblCount4.setText(rs.getString("count"));
                    }
                    if(rs.next()) {
                        lblRe5.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
                        lblCount5.setText(rs.getString("count"));
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
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblRe1.setText("");
                lblCount1.setText("");
                lblRe2.setText("");
                lblCount2.setText("");
                lblRe3.setText("");
                lblCount3.setText("");
                lblRe4.setText("");
                lblCount4.setText("");
                lblRe5.setText("");
                lblCount5.setText("");
            }
        });
    }
}
