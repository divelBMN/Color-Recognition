/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package task;

import java.awt.*;
import java.util.Random;

/**
 *  Class Task generate random color.
 *  Also, class generate input signals vector for neuron.
 */

public class Task {

    public enum AvailableColors {RED, GREEN, BLUE, YELLOW};



    /**
     *  Color of Task
     */
    private AvailableColors color;

    private final float valueOfSignal = 1f;



    /**
     * Constructor.
     * Create Task with random color.
     */
    public Task() {
        this.color = this.generateColor();
    }

    /**
     * Constructor.
     * Create Task with known color.
     * @param color
     */
    public Task(AvailableColors color) {
        this.color = color;
    }



    /**
     * Interface for index of color.
     * @return
     */
    public int getIndex() {
        return this.color.ordinal();
    }
    
    /**
     * Interface for input signals vector.
     * @return
     */
    public float[] getInputSignalsVector() {
        return this.generateInputSignalsVector();
    }
    
    /**
     * Interface for Color of Task.
     * @return
     */
    public Color getColor() {
    
        Color result = Color.red;
        
        switch (this.color) {
            case GREEN:
                result = Color.green;
                break;
                
            case BLUE:
                result = Color.blue;
                break;
            case YELLOW:
                result = Color.yellow;
        }
        
        return result;
    }



    /**
     * Creating vector for neurons work.
     * @return
     */
    private float[] generateInputSignalsVector() {
        int size = AvailableColors.values().length;
        float[] result = this.createZeroVector(size);

        int index = this.color.ordinal();
        result[index] = valueOfSignal;

        return result;
    }

    /**
     * Creating vector with values is 0.
     * @param size
     * @return
     */
    private float[] createZeroVector(int size) {
        float[] result = new float[size];

        for (int i = 0; i < size; i++) {
            result[i] = 0;
        }

        return result;
    }
    
    /**
     * Generate random Color.
     * @return
     */
    private AvailableColors generateColor() {
        int maxColorIndex = AvailableColors.values().length;
        Random random = new Random();
        int randomColor = random.nextInt(maxColorIndex);
        
        return AvailableColors.values()[randomColor];
    }

}
