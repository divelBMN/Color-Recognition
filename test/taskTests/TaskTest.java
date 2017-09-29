/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package taskTests;

import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.*;

import task.Task;

public class TaskTest {

    @Test
    public void test_Task_color_RED_getIndex_return_0() {

        Task.AvailableColors color = Task.AvailableColors.RED;
        Task task = new Task(color);

        int index = task.getIndex();

        assertEquals(index, 0);

    }

    @Test
    public void test_Task_color_GREEN_getIndex_return_1() {

        Task.AvailableColors color = Task.AvailableColors.GREEN;
        Task task = new Task(color);

        int index = task.getIndex();

        assertEquals(index, 1);

    }

    @Test
    public void test_Task_color_BLUE_getIndex_return_2() {

        Task.AvailableColors color = Task.AvailableColors.BLUE;
        Task task = new Task(color);

        int index = task.getIndex();

        assertEquals(index, 2);

    }

    @Test
    public void test_Task_color_YELLOW_getIndex_return_3() {

        Task.AvailableColors color = Task.AvailableColors.YELLOW;
        Task task = new Task(color);

        int index = task.getIndex();

        assertEquals(index, 3);

    }

    @Test
    public void test_Task_color_RED_getInputSignalsVector_return_1f_0_0_0() {

        Task.AvailableColors color = Task.AvailableColors.RED;
        Task task = new Task(color);

        float[] inputSignalsVector = task.getInputSignalsVector();

        assertEquals(inputSignalsVector[0], 1f, 0);
        assertEquals(inputSignalsVector[1], 0, 0);
        assertEquals(inputSignalsVector[2], 0, 0);
        assertEquals(inputSignalsVector[3], 0, 0);
    }

    @Test
    public void test_Task_color_GREEN_getInputSignalsVector_return_0_1f_0_0() {

        Task.AvailableColors color = Task.AvailableColors.GREEN;
        Task task = new Task(color);

        float[] inputSignalsVector = task.getInputSignalsVector();

        assertEquals(inputSignalsVector[0], 0, 0);
        assertEquals(inputSignalsVector[1], 1f, 0);
        assertEquals(inputSignalsVector[2], 0, 0);
        assertEquals(inputSignalsVector[3], 0, 0);
    }

    @Test
    public void test_Task_color_BLUE_getInputSignalsVector_return_0_0_1f_0() {

        Task.AvailableColors color = Task.AvailableColors.BLUE;
        Task task = new Task(color);

        float[] inputSignalsVector = task.getInputSignalsVector();

        assertEquals(inputSignalsVector[0], 0, 0);
        assertEquals(inputSignalsVector[1], 0, 0);
        assertEquals(inputSignalsVector[2], 1f, 0);
        assertEquals(inputSignalsVector[3], 0, 0);
    }

    @Test
    public void test_Task_color_BLUE_getInputSignalsVector_return_0_0_0_1f() {

        Task.AvailableColors color = Task.AvailableColors.YELLOW;
        Task task = new Task(color);

        float[] inputSignalsVector = task.getInputSignalsVector();

        assertEquals(inputSignalsVector[0], 0, 0);
        assertEquals(inputSignalsVector[1], 0, 0);
        assertEquals(inputSignalsVector[2], 0, 0);
        assertEquals(inputSignalsVector[3], 1f, 0);
    }
    
    @Test
    public void test_Task_color_RED_getColor_return_red() {
        
        Task.AvailableColors color = Task.AvailableColors.RED;
        Task task = new Task(color);
        
        Color tasksColor = task.getColor();
        
        assertEquals(tasksColor, Color.red);
    }
    
    @Test
    public void test_Task_color_GREEN_getColor_return_green() {
        
        Task.AvailableColors color = Task.AvailableColors.GREEN;
        Task task = new Task(color);
        
        Color tasksColor = task.getColor();
        
        assertEquals(tasksColor, Color.green);
    }
    
    @Test
    public void test_Task_color_BLUE_getColor_return_blue() {
        
        Task.AvailableColors color = Task.AvailableColors.BLUE;
        Task task = new Task(color);
        
        Color tasksColor = task.getColor();
        
        assertEquals(tasksColor, Color.blue);
    }
    
    @Test
    public void test_Task_color_YELLOW_getColor_return_YELLOW() {
        
        Task.AvailableColors color = Task.AvailableColors.YELLOW;
        Task task = new Task(color);
        
        Color tasksColor = task.getColor();
        
        assertEquals(tasksColor, Color.yellow);
    }
    
}