import java.time.Month;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @org.junit.jupiter.api.Test
    void getValueFromCache()
    {
        int dayTest =1;
        Month monthTest = Month.FEBRUARY;
        Map<MonthDay, List<String>> hashMapTest = new HashMap<>();
        List<String> listTest = new ArrayList<>();
        listTest.add("Test 1");
        MonthDay keyTest = MonthDay.of(monthTest,dayTest);
        hashMapTest.put(keyTest,listTest);

        assertEquals(Model.getValueFromCache(hashMapTest,monthTest,dayTest),listTest);
    }


}