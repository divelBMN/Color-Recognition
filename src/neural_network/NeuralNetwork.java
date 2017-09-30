/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package neural_network;

/**
 * Class Neural Network unites Neural Layers in Network for teamwork.
 * Main class function is reception of the network response to inputSignals.
 * Also, an important fuction is correct Neurons in Network - learning process.
 */

public class NeuralNetwork {
    
    private NeuralLayer layer;
    
    
    
    /**
     * Constructor.
     * Create Neural Network with known Neural Layer.
     * @param layer 
     */
    public NeuralNetwork(NeuralLayer layer) {
        this.layer = layer;
    }
    
    /**
     * Constuctor.
     * Create Network contains 1 Neural Layer using inputSignalsAmount and outputSignalsAmount.
     * @param inputSignalsAmount
     * @param outputSignalsAmount 
     */
    public NeuralNetwork(int inputSignalsAmount, int outputSignalsAmount) {
        try {
            this.layer = new NeuralLayer(inputSignalsAmount, outputSignalsAmount);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        } 
    }    
    
    
    
    /**
     * Interface for outputSignals - network respons.
     * @param inputSignalsVector
     * @return 
     */
    public float [] getOutputSignalsVector(float [] inputSignalsVector) throws RuntimeException {        
        try {
            return this.calculateOutputSignalsVector(inputSignalsVector);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    /**
     * Interface for Neural Layer
     * @return 
     */
    public NeuralLayer getNeuralLayer() {
        return this.layer;
    }
    
    
    
    /**
     * Calculating output signals vector using input signals vector.
     * @param inputSignalsVector
     * @return 
     */
    private float [] calculateOutputSignalsVector(float [] inputSignalsVector) {
        //At now this method is simple, because in Neural Network only 1 Neural Layer.
        //In future Network will have several Layers and this method will be more difficult.
        return this.layer.getOutputSignalsVector(inputSignalsVector);
    }
    
}
