import Panels.main_panel;
import javax.swing.*;


import Panels.query_3_1;
import Panels.query_3_2;
import Panels.query_3_3;
import Panels.query_3_5;
import Panels.query_3_6;
import Panels.query_3_8;
import Panels.researcher;
public class Main {

    public static void main(String[] args) {

        JFrame f=new JFrame("Project_145");
        f.setSize(400,400);
        f.add(new main_panel().main_panel);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}