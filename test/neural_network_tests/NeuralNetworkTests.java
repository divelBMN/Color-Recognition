/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package neural_network_tests;

import org.junit.Test;
import static org.junit.Assert.*;

import neural_network.*;

public class NeuralNetworkTests {
    
    @Test
    public void test_Network_inputs_4_outputs_2_result_ok() {
        int inputSignalsAmount = 4;
        int outputSignalsAmount = 2;
        
        try {
            NeuralNetwork network = new NeuralNetwork(inputSignalsAmount, outputSignalsAmount);
            
            assertTrue(true);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void test_Network_inputs_minus4_outputs_2_result_exception_WrongWeights() {
        int inputSignalsAmount = -4;
        int outputSignalsAmount = 2;
        
        try {
            NeuralNetwork network = new NeuralNetwork(inputSignalsAmount, outputSignalsAmount);
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "amount of Neuron's weights must be more then 0");
        }
    }
    
    @Test
    public void test_Network_inputs_4_outputs_0_result_exception_WrongNeuronsAmount() {
        int inputSignalsAmount = 4;
        int outputSignalsAmount = 0;
        
        try {
            NeuralNetwork network = new NeuralNetwork(inputSignalsAmount, outputSignalsAmount);
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Neural Layer must contain minimum 1 Neuron");
        }
    }
    
    @Test
    public void test_Network_inputs_4_outputs_2_inputSignals_0_01f_1f_05f_result_ok() {
        int inputSignalsAmount = 4;
        int outputSignalsAmount = 2;
        
        try {
            NeuralNetwork network = new NeuralNetwork(inputSignalsAmount, outputSignalsAmount);
            float[] inputSignals = new float[] {0, .1f, 1f, .5f};
            
            try {
                float[] outputSignals = network.getOutputSignalsVector(inputSignals);
                assertTrue(true);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void test_Network_inputs_4_outputs_2_inputSignals_0_01f_1f_result_exception_WrongInputSignalsAmount() {
        int inputSignalsAmount = 4;
        int outputSignalsAmount = 2;
        
        try {
            NeuralNetwork network = new NeuralNetwork(inputSignalsAmount, outputSignalsAmount);
            float[] inputSignals = new float[] {0, .1f, 1f};
            
            try {
                float[] outputSignals = network.getOutputSignalsVector(inputSignals);
            } catch (RuntimeException e) {
                assertEquals(e.getMessage(), "amounts of inputSignals and neuron's weights must be equals");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    
}