import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void checkCreateDayBox() throws IOException {

        Controller controllerTest = new Controller();
        assertEquals(controllerTest.CheckCreateDayBox(),false);

    }
}