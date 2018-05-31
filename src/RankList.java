import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Logger;

public class RankList extends JFrame {

    public JFrame ranklistFrame = new JFrame("Rank List");
    public Font font = new Font("Matura MT Script Capitals", Font.BOLD, 25);

    public JButton backBtn;
    public JLabel rankListLabel;
    public JPanel panel;

    JTable rankTable = new JTable();

    public RankList(){

        System.out.println("RankList Page hit!");

        // basic skeleton of credit frame
        ranklistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ranklistFrame.setSize(500,600);
        ranklistFrame.setVisible(true);
        ranklistFrame.setResizable(false);

        // working with JTable
        ArrayList<Users> usersArrayList = new ArrayList<Users>();
        DbLayer dbLayer = new DbLayer();
        usersArrayList = dbLayer.checkRankList();

        DefaultTableModel model = new DefaultTableModel();
        Object[] columnName = new Object[2];
        columnName[0] = "User";
        columnName[1] = "Score";

        Object[] rowData = new Object[2];

        model.setColumnIdentifiers(columnName);

        for(int i =0; i<usersArrayList.size();i++){
            rowData[0] = usersArrayList.get(i).getUserName();
            rowData[1] = usersArrayList.get(i).getUserScore();

            model.addRow(rowData);
        }

        rankTable.setModel(model);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(rankTable);
        rankTable.setFillsViewportHeight(true);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.setVisible(true);
        //panel.setBackground(Color.WHITE);

        ranklistFrame.setContentPane(panel);

        // adding back button
        backBtn = new JButton("Back to Menu");
        backBtn.setSize(200,100);
        backBtn.setBackground(Color.DARK_GRAY);
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(font);

        // setting back button to bottom
        panel.add(backBtn, BorderLayout.SOUTH);
        ranklistFrame.setContentPane(panel);

        backToMenu backBtnClicked = new backToMenu();
        backBtn.addActionListener(backBtnClicked);
    }

    public class backToMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent backBtnClicked) {
            new MenuFrame();
            ranklistFrame.setVisible(false);
        }
    }

}
