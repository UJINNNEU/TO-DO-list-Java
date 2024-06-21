import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class TaskComponent extends JPanel implements ActionListener {
    private JCheckBox checkBox;
    private JTextPane taskField;
    private JButton deleteButton;


    public JTextPane getTaskField() {
        return taskField;
    }

    // this panel is used so that we can make updates to the task component panel when deleting tasks
    private JPanel parentPanel;

    public TaskComponent(JPanel parentPanel, String taskText){
        this.parentPanel = parentPanel;
        this.taskText = taskText;



        // task field
        taskField = new JTextPane();
        taskField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        taskField.setPreferredSize(Size.TASKFIELD_SIZE);
        taskField.setContentType("text/html");
        taskField.setText(taskText);
        taskField.addFocusListener(new FocusListener() {
            // indicate which task field is currently being edited
            @Override
            public void focusGained(FocusEvent e) {
                taskField.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                taskField.setBackground(null);
            }
        });

        // checkbox
        checkBox = new JCheckBox();
        checkBox.setPreferredSize(Size.CHECKBOX_SIZE);
        checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkBox.addActionListener(this);

        // delete button
        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(Size.DELETE_BUTTON_SIZE);
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteButton.addActionListener(this);

        // add to this taskcomponent
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(checkBox);
        add(taskField);
        add(deleteButton);

        if(CheckLastIndex())
        {
            checkBox.setSelected(true);

            taskText = taskField.getText().replaceAll("<[^>]*>", "");
            taskField.setText("<html><s>"+ taskText + "</s></html>");
        }


    }
    String taskText;

    public boolean CheckLastIndex()
    {
        if (taskText.indexOf('*') != -1) {
            return true;
        }
        else {
            return false;
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(checkBox.isSelected()){
            // replaces all html tags to empty string to grab the main text
            taskText = taskField.getText().replaceAll("<[^>]*>", "");



            if (!CheckLastIndex())
            {
                taskText += "*";
                System.out.println("Сработал иквелся");

            }

            // add strikethrough text
            taskField.setText("<html><s>"+ taskText + "</s></html>");

        }else if(!checkBox.isSelected()){
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");


            if (CheckLastIndex())
            {    taskText= taskText.substring(0, taskText.indexOf('*')-1);
                System.out.println("Сработал метод удаления послуднего символа");

            }


            taskField.setText(taskText);


        }

        if(e.getActionCommand().equalsIgnoreCase("X")){
            // delete this component from the parent panel
            parentPanel.remove(this);
            parentPanel.repaint();
            parentPanel.revalidate();


            Controller.list.remove(this); // удаление объекта из листа


        }
    }

    public String getTaskText() {
        return taskField.getText();
    }


    }



