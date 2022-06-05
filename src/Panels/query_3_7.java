package Panels;

import Classes.ConnectSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class query_3_7 {
    private JLabel lblCompany1;
    private JLabel lblCompany2;
    private JLabel lblCompany3;
    private JLabel lblCompany4;
    private JLabel lblCompany5;
    private JLabel lblExec1;
    private JLabel lblExec2;
    private JLabel lblExec3;
    private JLabel lblExec4;
    private JLabel lblExec5;
    private JLabel lblTotal1;
    private JLabel lblTotal2;
    private JLabel lblTotal3;
    private JLabel lblTotal4;
    private JLabel lblTotal5;
    public JPanel query_3_7;
    private JButton btnFind;
    private JButton btnClear;

    public query_3_7() {
        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = ConnectSQL.get_connection();
                    PreparedStatement ps;
                    ps = c.prepareStatement("select exec.name as Executive_name, org.company_id , sum(funding) as total_amount from project as p JOIN executive as exec ON exec.exec_id=p.exec_id JOIN organization as org On org.org_id=p.org_id JOIN company as c ON c.company_id =org.company_id Group BY exec.name, p.title,org.company_id order by total_amount desc limit 5");
                    ResultSet rs = ps.executeQuery();

                    if(rs.next()) {
                        lblExec1.setText(rs.getString("executive_name"));
                        lblCompany1.setText(rs.getString("company_id"));
                        lblTotal1.setText(rs.getString("total_amount"));
                    }
                    if(rs.next()) {
                        lblExec2.setText(rs.getString("executive_name"));
                        lblCompany2.setText(rs.getString("company_id"));
                        lblTotal2.setText(rs.getString("total_amount"));

                    }
                    if(rs.next()) {
                        lblExec3.setText(rs.getString("executive_name"));
                        lblCompany3.setText(rs.getString("company_id"));
                        lblTotal3.setText(rs.getString("total_amount"));
                    }
                    if(rs.next()) {
                        lblExec4.setText(rs.getString("executive_name"));
                        lblCompany4.setText(rs.getString("company_id"));
                        lblTotal4.setText(rs.getString("total_amount"));
                    }
                    if(rs.next()) {
                        lblExec5.setText(rs.getString("executive_name"));
                        lblCompany5.setText(rs.getString("company_id"));
                        lblTotal5.setText(rs.getString("total_amount"));
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
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblExec1.setText("");
                lblCompany1.setText("");
                lblTotal1.setText("");
                lblExec2.setText("");
                lblCompany2.setText("");
                lblTotal2.setText("");
                lblExec3.setText("");
                lblCompany3.setText("");
                lblTotal3.setText("");
                lblExec4.setText("");
                lblCompany4.setText("");
                lblTotal4.setText("");
                lblExec5.setText("");
                lblCompany5.setText("");
                lblTotal5.setText("");
            }
        });
    }
}
