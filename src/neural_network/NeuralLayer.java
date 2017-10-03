/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package neural_network;

/**
 * Class Neural Layer unites some Neurons.
 * This Neurons uses same input Signals Vector to calculate their own states.
 * Also, States of this Neurons forms input Signal Vector for next Neural Layer in Neural Network.
 */

public class NeuralLayer {

    private Neuron[] neurons;
	
	
	
    /**
     * Constructor.
     * Create Neural Layer with known Neurons.
     * @param neurons
     */
    public NeuralLayer(Neuron[] neurons) throws RuntimeException {
		
        if (neurons.length == 0) {
            throw new RuntimeException("Neural Layer must contain minimum 1 Neuron");
        }
		
        if (!this.checkNeuronsForWeightsAmount(neurons)) {
            throw new RuntimeException("The sizes of weightsVectors should be equals");
        }
		
        this.neurons = neurons;
    }
    
    /**
     * Constructor.
     * Creates Neural Layer of Neurons with random weights.
     * @param inputSignalsAmount amount of neuron's weights.
     * @param outputSignalsAmount amount of neurons.
     */
    public NeuralLayer(int inputSignalsAmount ,int outputSignalsAmount) throws RuntimeException {
        if (inputSignalsAmount < 1) {
            throw new RuntimeException("amount of Neuron's weights must be more then 0");
        }
        
        if (outputSignalsAmount < 1) {
            throw new RuntimeException("Neural Layer must contain minimum 1 Neuron");
        }
        
        this.neurons = new Neuron[outputSignalsAmount];
        
        for (int i = 0; i < outputSignalsAmount; i++) {
            this.neurons[i] = new Neuron(inputSignalsAmount);
        }
    }
    
    
    
    /**
     * Interface for outputSignalVector value's amount.
     * @return 
     */
    public int getOutputSignalsAmount() {
        return this.neurons.length;
    }
    
    /**
     * Interface for imputSignalsVector value's amount.
     * @return 
     */
    public int getInputSignalsAmount() {
        return this.neurons[0].getWeightsVector().length;
    }
    
    /**
     * Interface for Neuron by index.
     * @param index
     * @return
     * @throws RuntimeException 
     */
    public Neuron getNeuron(int index) throws RuntimeException{
        if (!this.indexInBounds(index)) {
            throw new RuntimeException("index out of bounds");
        }
        
        return this.neurons[index];
    }
    
    /**
     * Interface for Output Signals Vector.
     * @param inputSignalsVector
     * @return 
     */
    public float [] getOutputSignalsVector(float [] inputSignalsVector) throws RuntimeException {
        if (inputSignalsVector.length != this.getInputSignalsAmount()) {
            throw new RuntimeException("amounts of inputSignals and neuron's weights must be equals");
        }
        
        return this.calculateOutputSignalsVector(inputSignalsVector);
    }
    
    /**
     * Iterface for correction of Neurons weights.
     * @param index of neuron in layer
     * @param deltaWeights
     * @throws RuntimeException 
     */
    public void correctNeuron(int index, float [] inputSignalsVector, float correctState) throws RuntimeException{
        if (!this.indexInBounds(index)) {
            throw new RuntimeException("index out of bounds");
        }
        
        try {
            this.neurons[index].correctWeights(inputSignalsVector, correctState);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    
    
    /**
     * Checking Neurons for sizes weightsVectors.
     * The sizes of vectors should be equals.
     * @param neurons
     * @return 
     */
    private boolean checkNeuronsForWeightsAmount(Neuron[] neurons) {
        boolean result = true;
		
	int neuronsAmount = neurons.length;
	if (neuronsAmount > 1) {
            int weightsAmount = neurons[0].getWeightsVector().length;
			
            for (int i = 1; i < neuronsAmount; i++) {
                if (weightsAmount != neurons[i].getWeightsVector().length) {
                    result = false;
                    break;
                }
            }
	}
		
	return result;
    }

    /**
     * Calculating output signals vector (states of neurons) by input signals vector.
     * @param inputSignalsVector
     * @return 
     */
    private float [] calculateOutputSignalsVector(float [] inputSignalsVector) {
        int neuronsAmount = this.neurons.length;
        float[] result = new float[neuronsAmount];

        for (int i = 0; i < neuronsAmount; i++) {
            result[i] = this.neurons[i].getState(inputSignalsVector);
        }
        
        return result;
    }
    
    /**
     * Checking index for bounds.
     * @param index
     * @return 
     */
    private boolean indexInBounds(int index) {
        return (index >= 0) && (index < this.neurons.length);
    }
    
}
