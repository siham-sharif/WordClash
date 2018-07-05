import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    public Font font = new Font("Matura MT Script Capitals", Font.BOLD, 25);

    private JMenuBar menuBar = new JMenuBar();

    private JMenu menu = new JMenu("Menu");
    JMenuItem changeUser, gotoMenu, rankList, sound, closeGame;

    JMenu newGame = new JMenu("New Game");
    JMenuItem beg, med, hard;

    public GameFrame(String title){
        // basic skeleton of JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);

        //menu bar and menu item
        setJMenuBar(menuBar);

        changeUser = new JMenuItem("Change User");
        changeUser.addActionListener(this);
        menu.add(changeUser);

        gotoMenu = new JMenuItem("Go to Menu");
        gotoMenu.addActionListener(this);
        menu.add(gotoMenu);

        rankList = new JMenuItem("Ranklist");
        rankList.addActionListener(this);
        menu.add(rankList);

        sound = new JMenuItem("Sound");
        sound.addActionListener(this);
        menu.add(sound);

        menu.addSeparator();
        closeGame = new JMenuItem("Close Game");
        closeGame.addActionListener(this);
        menu.add(closeGame);

        //adding all the above to menu bar
        menuBar.add(menu);


        beg = new JMenuItem("Beginner");
        beg.addActionListener(this);
        med = new JMenuItem("Medium");
        med.addActionListener(this);
        hard = new JMenuItem("Hard");
        hard.addActionListener(this);

        newGame.add(beg);
        newGame.add(med);
        newGame.add(hard);

        menuBar.add(newGame);

        // Jframe parameter ending
        getContentPane().setBackground(Color.darkGray);
        setSize(600,700);
        setResizable(false);

    }

    @Override
    public void actionPerformed (ActionEvent actionTaken) {
        //action listener for Menu
        if(actionTaken.getSource() == changeUser){
            System.out.println("Clicked on Change User in JMenuBar");
            setVisible(false);
            new LoginPage();
        }
        if(actionTaken.getSource() == gotoMenu){
            System.out.println("Clicked on Goto Menu in JMenuBar");
            setVisible(false);
            new MenuFrame();
        }
        if(actionTaken.getSource() == rankList){
            System.out.println("Clicked on RankList in JMenuBar");
            setVisible(false);
            new RankList();
        }
        if(actionTaken.getSource() == sound){
            System.out.println("Clicked on Sound in JMenuBar");
            setVisible(false);
            new Options();
        }
        if(actionTaken.getSource() == closeGame){
            //System.out.println("Clicked on Close Button in JMenuBar");
            System.exit(0);
        }

        //action listener for New Game
        if(actionTaken.getSource() == beg){
            System.out.println("Clicked on Beginner in JMenuBar (New Game)");
            setVisible(false);
            new BeginnerLevel();
        }
        if(actionTaken.getSource() == med){
            System.out.println("Clicked on Medium in JMenuBar (New Game)");
            setVisible(false);
            new MediumLevel();
        }
        if(actionTaken.getSource() == hard){
            System.out.println("Clicked on Hard in JMenuBar (New Game)");
            setVisible(false);
            new HardLevel();
        }

    }
}
