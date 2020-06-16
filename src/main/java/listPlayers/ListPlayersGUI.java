package listPlayers;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ListPlayersGUI extends JFrame{
    private JTable playersTable = new JTable(28, 2);
    private JScrollPane playersScroll = new JScrollPane(playersTable);
    private JLabel playersLabel = new JLabel("Players");

    public ListPlayersGUI()
    {
        setProperties();
        addComponents();
    }
    public void setProperties()
    {
        setSize(400, 640);
        setTitle("Players");
        setResizable(false);
        setBackground(Color.GRAY);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        playersTable.getColumnModel().getColumn(0).setHeaderValue("Username");
        playersTable.getColumnModel().getColumn(1).setHeaderValue("Banned?");
        playersTable.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        playersTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer());
        playersTable.setRowHeight(20);
        playersScroll.setBorder(BorderFactory.createEmptyBorder());
        playersLabel.setFont(new Font("calibri",Font.BOLD,35));

        setVisible(true);
    }

    public void initPositions()
    {
        playersScroll.setBounds(100, 80, 200, 500);
        playersLabel.setBounds(140, 20, 400 ,40);
    }

    public void addComponents()
    {
        initPositions();
        add(playersLabel);
        add(playersScroll);

    }

    public static void main(String[] args)
    {
        ListPlayersGUI lpg = new ListPlayersGUI();

    }

}
