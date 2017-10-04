/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package neural_network;

/**
 * 
 */
public class Teacher {
    
    private NeuralNetwork network;
    
    
    /**
     * Constructor.
     * @param network 
     */
    public Teacher(NeuralNetwork network) {
        this.network = network;
    }
    
    
    /**
     * Interface for correcting Neural Network.
     * @param inputSignalsVector
     * @param positiveEvaluation true, if the network response is correct.
     */
    public void correctNeuralNetwork(float [] inputSignalsVector, boolean positiveEvaluation) throws RuntimeException {
        if (this.network.getNeuralLayer().getInputSignalsAmount() != inputSignalsVector.length) {
            throw new RuntimeException("amounts of inputSignals and neuron's weights amount must be equals");
        }

        float[] correctStates = this.generateCorrectStates(positiveEvaluation);
        this.correct(inputSignalsVector, correctStates);
    }
    
    /**
     * Interface for correct states. For testing.
     * @param positiveEvaluation
     * @return 
     */
    public float [] getCorrectStates(boolean positiveEvaluation) {
        return this.generateCorrectStates(positiveEvaluation);
    }
       

    
    /**
     * Correcting Neural Network.
     */
    private void correct(float [] inputSignalsVector, float[] correctStates) {
        
        NeuralLayer layer = this.network.getNeuralLayer();
        int neuronsAmount = layer.getOutputSignalsAmount();
        
        for (int i = 0; i < neuronsAmount; i++) {
            try {
                Neuron neuron = layer.getNeuron(i);
                
                neuron.correctWeights(inputSignalsVector, correctStates[i]);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    /**
     * Generating correct states for neurons correcting.
     * @param positiveEvaluation
     * @return 
     */
    private float [] generateCorrectStates(boolean positiveEvaluation) {
        int size = this.network.getNeuralLayer().getOutputSignalsAmount();
        float[] result = this.generateZeroVector(size);
        
        if (positiveEvaluation) {
            result[0] = 1f;
        } else {
            result[size -1] = 1f;
        }
        
        return result;
    }
    
    /**
     * Creating vector with values is 0.
     * @param size
     * @return 
     */
    private float [] generateZeroVector(int size) {
        float[] result = new float[size];
        
        for (int i = 0; i < size; i++) {
            result[i] = 0;
        }
        
        return result;
    }
            
}
