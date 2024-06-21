import javax.swing.*;
import java.awt.*;
public class View {
    String[] monthGUI = {"Январь", "Февраль", "Март", "Апрель", "Май",
            "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    public JComboBox monthBox = new JComboBox(monthGUI);
    public JComboBox dayBox;

    ImageIcon icon = new ImageIcon("2.gif");
    JButton buttonSave = new JButton("", icon);

    public JFrame frame;
    public JPanel taskPanel;
    JPanel newPanel = new JPanel();
    public JScrollPane scrollPane;
    public JButton addTaskButton;

    public View() {
        frame = new JFrame("TO-DO List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);

        newPanel.setBackground(Color.BLUE);

        newPanel.setBounds(0, 0, 800, 190);
        newPanel.setLayout(null);
        monthBox.setBounds(40,40,80,40);
        frame.add(monthBox);
        buttonSave.setBounds(550,100,60,60);


        frame.add(newPanel, BorderLayout.CENTER); // добавляем новую панель в центр фрейма

        frame.setVisible(true); // делаем фрейм видимым

        taskPanel = new JPanel();
        taskPanel.setBackground(Color.white);
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        taskPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        taskPanel.setBounds(0, 200, 800, 500);

        frame.add(buttonSave);
        scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(0, 200, 800, 500);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        addTaskButton = new JButton("Add Task");
        addTaskButton.setBounds(0, 710, 800, 60);

        frame.add(scrollPane);
        frame.add(addTaskButton);

        frame.setVisible(true);
    }



}