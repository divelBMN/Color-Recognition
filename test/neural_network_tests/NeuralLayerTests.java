/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package neural_network_tests;

import org.junit.Test;
import static org.junit.Assert.*;

import neural_network.Neuron;
import neural_network.NeuralLayer;

public class NeuralLayerTests {

    @Test
    public void test_NeuralLayer_neuron0_size_4_neuron1_size_4_getOutputSignalsVectorAmount_return_2() {
        Neuron[] neurons = new Neuron[2];
        neurons[0] = new Neuron(4);
        neurons[1] = new Neuron(4);
        
        try {
            NeuralLayer neuralLayer = new NeuralLayer(neurons);
            
            int amount = neuralLayer.getOutputSignalsAmount();
            assertEquals(amount, 2);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }        
    }
    
    @Test
    public void test_NeuralLayer_neuron0_size_4_neuron1_size_4_getInputSignalsVectorAmount_return_4() {
        Neuron[] neurons = new Neuron[2];
        neurons[0] = new Neuron(4);
        neurons[1] = new Neuron(4);
        
        try {
            NeuralLayer neuralLayer = new NeuralLayer(neurons);
            
            int amount = neuralLayer.getInputSignalsAmount();
            assertEquals(amount, 4);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }        
    }
    
    @Test
    public void test_NeuralLayer_neuronAmount_0_return_exception_noNeurons() {
        Neuron[] neurons = new Neuron[0];
        
        try {
            NeuralLayer neuralLayer = new NeuralLayer(neurons);
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Neural Layer must contain minimum 1 Neuron");
        }        
    }
    
    @Test
    public void test_NeuralLayer_neuron0_size_4_neuron1_size_3_return_exception_wrongNeuronsWeightsAmount() {
        Neuron[] neurons = new Neuron[2];
        neurons[0] = new Neuron(4);
        neurons[1] = new Neuron(3);
        
        try {
            NeuralLayer neuralLayer = new NeuralLayer(neurons);
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "The sizes of weightsVectors should be equals");
        }        
    }

    @Test
    public void test_NeuralLayer_inputs_4_outputs_2_getOutputSignalsVectorAmount_return_2() {        
        try {
            int inputs = 4;
            int outputs = 2;
            NeuralLayer neuralLayer = new NeuralLayer(inputs, outputs);
            
            int amount = neuralLayer.getOutputSignalsAmount();
            assertEquals(amount, 2);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }        
    }
    
    @Test
    public void test_NeuralLayer_inputs_4_outputs_2_getInputSignalsVectorAmount_return_2() {        
        try {
            int inputs = 4;
            int outputs = 2;
            NeuralLayer neuralLayer = new NeuralLayer(inputs, outputs);
            
            int amount = neuralLayer.getInputSignalsAmount();
            assertEquals(amount, 4);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }        
    }
    
    @Test
    public void test_NeuralLayer_inputs_0_outputs_2_return_exception_wrongNeuronsWeightsAmount() {        
        try {
            int inputs = 0;
            int outputs = 2;
            NeuralLayer neuralLayer = new NeuralLayer(inputs, outputs);
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "amount of Neurons must be more then 0");
        }        
    }
    
    @Test
    public void test_NeuralLayer_inputs_4_outputs_0_return_exception_noNeurons() {        
        try {
            int inputs = 4;
            int outputs = 0;
            NeuralLayer neuralLayer = new NeuralLayer(inputs, outputs);
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "Neural Layer must contain minimum 1 Neuron");
        }        
    }
    
    @Test
    public void test_NeuralLayer_neuron0_weights_02f_03f_05f_neuron1_weights_0_1f_0_inputSignals_1f_05f_0_getOutputSignalsVector_return_035f_05f() {
        Neuron[] neurons = new Neuron[2];
        neurons[0] = new Neuron(new float[] {.2f, .3f, .5f});
        neurons[1] = new Neuron(new float[] {0, 1f, 0});
        
        try {
            NeuralLayer neuralLayer = new NeuralLayer(neurons);
            
            float[] inputSignals = new float[] {1f, .5f, 0};
            
            try {
                float[] outputSignals = neuralLayer.getOutputSignalsVector(inputSignals);
            
            assertEquals(outputSignals.length, 2);
            assertEquals(outputSignals[0], .35f, .01f);
            assertEquals(outputSignals[1], .5f, .01f);
            } catch(RuntimeException e) {
                System.err.println(e.getMessage());
            }
            
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }        
    }
    
    @Test
    public void test_NeuralLayer_neuron0_weights_02f_03f_05f_neuron1_weights_0_1f_0_inputSignals_1f_05f_getOutputSignalsVector_return_exception_WrongAmount() {
        Neuron[] neurons = new Neuron[2];
        neurons[0] = new Neuron(new float[] {.2f, .3f, .5f});
        neurons[1] = new Neuron(new float[] {0, 1f, 0});
        
        try {
            NeuralLayer neuralLayer = new NeuralLayer(neurons);
            
            float[] inputSignals = new float[] {1f, .5f};
            
            try {
                float[] outputSignals = neuralLayer.getOutputSignalsVector(inputSignals);
            
            } catch(RuntimeException e) {
                assertEquals(e.getMessage(), "amounts of inputSignals and neuron's weights must be equals");
            }
            
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }        
    }
    
    @Test
    public void test_NeuralLayer_neuron0_size_4_neuron1_size_4_getNeuron_index_1_return_ok() {
        Neuron[] neurons = new Neuron[2];
        neurons[0] = new Neuron(4);
        neurons[1] = new Neuron(4);
        
        try {
            NeuralLayer neuralLayer = new NeuralLayer(neurons);
            
            try {
                Neuron neuron = neuralLayer.getNeuron(1);
                
                assertTrue(true);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }        
    }
    
    @Test
    public void test_NeuralLayer_neuron0_size_4_neuron1_size_4_getNeuron_index_2_return_exception_WrongIndex() {
        Neuron[] neurons = new Neuron[2];
        neurons[0] = new Neuron(4);
        neurons[1] = new Neuron(4);
        
        try {
            NeuralLayer neuralLayer = new NeuralLayer(neurons);
            
            try {
                Neuron neuron = neuralLayer.getNeuron(2);
            } catch (RuntimeException e) {
                assertEquals(e.getMessage(), "index out of bounds");
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }        
    }
    
    @Test
    public void test_NeuralLayer_neuron0_size_3_neuron1_size_3_deltaWeightsVector_0_1f_1f_correct_index_0_return_ok() {
        Neuron[] neurons = new Neuron[2];
        neurons[0] = new Neuron(3);
        neurons[1] = new Neuron(3);
        
        try {
            NeuralLayer neuralLayer = new NeuralLayer(neurons);
            int index = 0;
            float[] deltaWeights = new float[] {0, 1f, 1f};
            
            try {
                neuralLayer.correctNeuron(index, deltaWeights);
                assertTrue(true);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }        
    }
    
    @Test
    public void test_NeuralLayer_neuron0_size_3_neuron1_size_3_deltaWeightsVector_0_1f_1f_correct_index_2_return_exception_WrongIndex() {
        Neuron[] neurons = new Neuron[2];
        neurons[0] = new Neuron(3);
        neurons[1] = new Neuron(3);
        
        try {
            NeuralLayer neuralLayer = new NeuralLayer(neurons);
            int index = 2;
            float[] deltaWeights = new float[] {0, 1f, 1f};
            
            try {
                neuralLayer.correctNeuron(index, deltaWeights);
            } catch (RuntimeException e) {
                assertEquals(e.getMessage(), "index out of bounds");
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }        
    }
    
    @Test
    public void test_NeuralLayer_neuron0_size_3_neuron1_size_3_deltaWeightsVector_0_1f_correct_index_0_return_exception_WrongAmount() {
        Neuron[] neurons = new Neuron[2];
        neurons[0] = new Neuron(3);
        neurons[1] = new Neuron(3);
        
        try {
            NeuralLayer neuralLayer = new NeuralLayer(neurons);
            int index = 0;
            float[] deltaWeights = new float[] {0, 1f};
            
            try {
                neuralLayer.correctNeuron(index, deltaWeights);
            } catch (RuntimeException e) {
                assertEquals(e.getMessage(), "amounts of deltaWeightsVector and weightsVector of Neuron must be equals");
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }        
    }
    
}