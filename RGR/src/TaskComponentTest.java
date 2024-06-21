import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class TaskComponentTest {

    @Test
    void checkLastIndex() {

        JPanel jPanelTest = new JPanel();
        String stringTest = "Test 2*";
        TaskComponent taskComponent = new TaskComponent(jPanelTest,stringTest);

        taskComponent.taskText = stringTest;

        assertEquals(taskComponent.CheckLastIndex(),true);
    }
}