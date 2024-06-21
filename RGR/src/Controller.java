import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.Month;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;

import static java.time.Month.*;

public class Controller {
    Model model = new Model();
    View view = new View();

    static Month selected_Month;

    boolean Selected_Date;


    public Controller() throws IOException {
        ActionComboBoxMonth();
        ActionSaveButton(); //кнопка сохранить
        ActionAddTask();


    }

    public void CreateDayBox(int day) {
        String[] dayArr = new String[day];

        for (int i = 0; i < day; i++) {

            dayArr[i] = Integer.toString(i + 1);
        }

        if (!CheckCreateDayBox()) //(view.container.isAncestorOf(view.dayBox))
        {


            view.dayBox = new JComboBox<>(dayArr);
            view.newPanel.add(view.dayBox);
            view.dayBox.setBounds(290, 40, 100, 40);

            view.frame.revalidate();
            view.frame.repaint();
            Selected_Date = true;

        } else {
            Selected_Date = false;

            view.newPanel.remove(view.dayBox);
            view.newPanel.revalidate();
            view.newPanel.repaint();
        }
    }

    //
    boolean CheckCreateDayBox() {
        Component[] components = view.newPanel.getComponents();
        boolean dayBoxFound = false;
        for (Component component : components) {
            if (component == view.dayBox) {
                dayBoxFound = true;
                break;
            }
        }

        return dayBoxFound;
    }


    public void ActionComboBoxMonth() // Action JComboBox Month
    {

        view.monthBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = view.monthBox.getSelectedItem().toString();

                switch (selectedOption) {
                    case "Январь":
                        System.out.println("Вы выбрали Январь");
                        CreateDayBox(31);
                        selected_Month = JANUARY;
                        break;
                    case "Февраль":
                        System.out.println("Февраль");
                        CreateDayBox(29);
                        selected_Month = FEBRUARY;
                        break;
                    case "Март":
                        selected_Month = MARCH;
                        CreateDayBox(31);
                        break;
                    case "Апрель":
                        selected_Month = APRIL;
                        CreateDayBox(30);
                        break;
                    case "Май":
                        selected_Month = MAY;
                        CreateDayBox(31);
                        break;
                    case "Июнь":
                        selected_Month = JUNE;
                        CreateDayBox(30);
                        break;

                    case "Июль":
                        selected_Month = JULY;
                        CreateDayBox(31);
                        break;

                    case "Август":
                        selected_Month = AUGUST;
                        CreateDayBox(31);
                        break;
                    case "Сентябрь":
                        selected_Month = SEPTEMBER;
                        CreateDayBox(30);
                        break;
                    case "Октябрь":
                        selected_Month = OCTOBER;
                        CreateDayBox(31);
                        break;
                    case "Ноябрь":
                        selected_Month = NOVEMBER;
                        CreateDayBox(30);
                        break;
                    case "Декабрь":
                        selected_Month = DECEMBER;
                        CreateDayBox(31);
                        break;

                }

                // Активация 2 JComboBox с днями

                ActionComboBoxDay();
            }
        });

    }

    // JComboBox с днями
    static int selectedOptionDay;
    void ActionComboBoxDay() {

            view.dayBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    selectedOptionDay = Integer.parseInt(view.dayBox.getSelectedItem().toString());


                    ActionCreateField(2); //добавление
                    // taskComponent на панель, нужно добавить условие добавление, чтоб size != null
                }
            });
        }


    void ActionSaveButton() //SAVE BUTTON
    {
        view.buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action 3 on");
                ActionSaveHashMapTask();


            }
        });

    }
    void ActionAddTask()// кнопка Add Task
    {
        view.addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ActionCreateField(1);

            }

        });

    }
    void ActionCreateField(int choise_variant)
    {


        // if (!list.isEmpty()) DeleteTaskComponent();
        if(choise_variant == 1 )   // create using a button Addtask
        {
            ActionCreateTaskComponent(""); //изменил

        }


        else
        {
          if(choise_variant == 2) //create using a Hashmap
          {
                DeleteTaskComponent();
                 if(model.getValueFromCache(model.hashMap, selected_Month, selectedOptionDay).isEmpty()){

                     System.out.println("Error 5 действие");
                 }
                 else
                 {
                     for(int i =0;i<model.getValueFromCache(model.hashMap, selected_Month, selectedOptionDay).size();i++)
                     {
                         ActionCreateTaskComponent(model.getValueFromCache(model.hashMap, selected_Month, selectedOptionDay).get(i));  //изменил
                     }
                 }




          }
          else{
              System.out.println("Error");
          }
        }


    }
    static  ArrayList<TaskComponent> list = new ArrayList<>();

    void ActionCreateTaskComponent(String taskText)   // create a taskcomponent
    {

        TaskComponent taskComponent = new TaskComponent(view.taskPanel,taskText) ;
        taskComponent.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        view.taskPanel.add(taskComponent);
        view.taskPanel.revalidate();
        view.taskPanel.repaint();

        list.add(taskComponent);// Добавляем в list экземпляр класса // зависит отдобавления

        if (Selected_Date ) //передача в hashmap индекса
        {

        }

    }

    void DeleteTaskComponent()
    {
        if (!list.isEmpty()) // заменить инт
        {
            for(int j = 0 ; j<list.size();j++)
            {
                view.taskPanel.remove(list.get(j));
                

            }
            list.clear();

            view.taskPanel.repaint();
            view.taskPanel.revalidate();

        }

    }

    static List <String> listStringTaskComponent = new ArrayList<>();

    void ActionSaveHashMapTask() // add in hashMap taskComponent
    {
       System.out.println("Action 7");

        if(!listStringTaskComponent.isEmpty()) listStringTaskComponent.clear();
        int Size_hashMap =  model.getValueFromCache(model.hashMap,selected_Month,selectedOptionDay).size();
        int Size_list = list.size();
        System.out.println("size hash" + Size_hashMap);
        System.out.println("size list"+Size_list);



        // изменить редактирования каждого taskcomponent
        for(int i = 0 ; i< list.size();i++)
        {

            String temp_string = list.get(i).getTaskText().replaceAll("<[^>]*>", "").trim();
            listStringTaskComponent.add(temp_string);

        }
        MonthDay key = MonthDay.of(selected_Month,selectedOptionDay);

        Model.hashMap.put(key, listStringTaskComponent);
       // model.hashMap.replace(key,
        //        model.getValueFromCache(model.hashMap,selected_Month,selectedOptionDay),
         //       listStringTaskComponent);

        try {
            Model.writeHashToFile("hash_file.dat", Model.hashMap);
        } catch (IOException ex) {

        }




    }

}
