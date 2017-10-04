/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package neural_network_tests;

import org.junit.Test;
import static org.junit.Assert.*;

import neural_network.*;

public class TeacherTests {
    
    @Test
    public void test_Teacher_NeuralNetwork_inputSignalsAmount_4_outputSignalsAmount_2_positiveEvaluation_true_getCorrectStates_return_1f_0() {
        int inputSignalsAmount = 4;
        int outputSignalsAmount = 2;
        
        try {
            NeuralNetwork network = new NeuralNetwork(inputSignalsAmount, outputSignalsAmount);
            
            Teacher teacher = new Teacher(network);
            boolean positiveEvaluation = true;
            
            try {
                float[] correctStates = teacher.getCorrectStates(positiveEvaluation);
                
                assertEquals(correctStates.length, outputSignalsAmount);
                assertEquals(correctStates[0], 1f, 0);
                assertEquals(correctStates[1], 0, 0);
                
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void test_Teacher_NeuralNetwork_inputSignalsAmount_4_outputSignalsAmount_2_positiveEvaluation_false_getCorrectStates_return_0_1f() {
        int inputSignalsAmount = 4;
        int outputSignalsAmount = 2;
        
        try {
            NeuralNetwork network = new NeuralNetwork(inputSignalsAmount, outputSignalsAmount);
            
            Teacher teacher = new Teacher(network);
            boolean positiveEvaluation = false;
            
            try {
                float[] correctStates = teacher.getCorrectStates(positiveEvaluation);
                
                assertEquals(correctStates.length, outputSignalsAmount);
                assertEquals(correctStates[0], 0, 0);
                assertEquals(correctStates[1], 1f, 0);
                
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void test_Teacher_NeuralNetwork_inputSignalsAmount_4_outputSignalsAmount_2_inputSignalsVector_1f_0_0_1f_positiveEvaluation_true_correctNeuralNetwork_return_ok() {
        int inputSignalsAmount = 4;
        int outputSignalsAmount = 2;
        
        try {
            NeuralNetwork network = new NeuralNetwork(inputSignalsAmount, outputSignalsAmount);
            
            Teacher teacher = new Teacher(network);
            float[] inputSignalsVector = new float[] {1f, 0, 0, 1f};
            boolean positiveEvaluation = true;
            
            try {
                teacher.correctNeuralNetwork(inputSignalsVector, positiveEvaluation);
                assertTrue(true);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void test_Teacher_NeuralNetwork_inputSignalsAmount_4_outputSignalsAmount_2_inputSignalsVector_1f_0_0_positiveEvaluation_true_correctNeuralNetwork_return_ok() {
        int inputSignalsAmount = 4;
        int outputSignalsAmount = 2;
        
        try {
            NeuralNetwork network = new NeuralNetwork(inputSignalsAmount, outputSignalsAmount);
            
            Teacher teacher = new Teacher(network);
            float[] inputSignalsVector = new float[] {1f, 0, 0};
            boolean positiveEvaluation = true;
            
            try {
                teacher.correctNeuralNetwork(inputSignalsVector, positiveEvaluation);
            } catch (RuntimeException e) {
                assertEquals(e.getMessage(), "amounts of inputSignals and neuron's weights amount must be equals");
            }
            
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    
}