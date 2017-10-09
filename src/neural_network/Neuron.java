/**
 * @author Maxim Bezdenezhnykh
 * @email esgiliot@gmail.com
 */

package neural_network;

import java.util.Random;

/**
 * Neuron is elementary particle of the Neural Network.
 * Calculating state of Neuron by input signals vector.
 * Correcting weights for learning of neuron.
 */

public class Neuron {

	private float[] weightsVector;
	
	private final float minValue = 0;
	private final float maxValue = 1f;
	private final float weightsSum = 1f;


	
	/**
	 * Constructor.
	 * Create Neuron with known weights vector.
	 * @param weightsVector
	 */
	public Neuron(float[] weightsVector) throws RuntimeException {
		
		if (!this.checkValues(weightsVector)) {
			throw new RuntimeException("one or more values out of range");
		}
		
		if (!this.checkSum(weightsVector)) {
			throw new RuntimeException("sum of vector's values must be 1f");
		}
		
		this.weightsVector = weightsVector;
	}
	
	/**
	 * Constructor.
	 * Create Neuron with random weights.
	 * @param weightsAmount
	 */
	public Neuron(int weightsAmount) {
		float[] randomVector = this.generateRandomVector(weightsAmount);
		float[] unitVector = this.createUnitVector(randomVector);
		this.weightsVector = unitVector;
	}
	
	
	
	/**
	 * Interface for weights vector.
	 * @return
	 */
	public float[] getWeightsVector() {
		return this.weightsVector;
	}
	
	/**
	 * Interface for minValue.
	 * @return
	 */
	public float getMinValue() {
		return this.minValue;
	}
	
	/**
	 * Interface for maxValue.
	 * @return
	 */
	public float getMaxValue() {
		return this.maxValue;
	}
	
	/**
	 * Interface for weightsSum.
	 * @return
	 */
	public float getWeightsSum() {
		return this.weightsSum;
	}
	
	/**
	 * Interface for calculating of state.
	 * @param inputSignalsVector
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public float getState(float[] inputSignalsVector) throws RuntimeException {
		float result;
		
		int size = this.weightsVector.length;
		if (size == inputSignalsVector.length) {
			result = this.calculateState(inputSignalsVector);
		} else {
			throw new RuntimeException("size of inputSignalsVector must be equals size of weightsVector");
		}
		
		return result;
	}

	/**
	 * Interface for weight's correcting.
         * @param inputSignalsVector
         * @param correctState
	 * @throws RuntimeException
	 */
	public void correctWeights(float[] inputSignalsVector, float correctState) throws RuntimeException {
		int size = this.weightsVector.length;
		if (size != inputSignalsVector.length) {
                    throw new RuntimeException("size of inputSignalsVector must be equals size of weightsVector");
		}

		if (!this.checkValues(inputSignalsVector)) {
                    throw new RuntimeException("one or more values out of range");
		}
                
                if ((correctState < this.minValue) || (correctState > this.maxValue)) {
                    throw new RuntimeException("correctState out of range");
                }
                
                float state = this.getState(inputSignalsVector);
                if (state <= correctState) {
                    float[] deltaWeightsVector = this.generateDeltaWeightsVector(inputSignalsVector, correctState);
                    float[] totalVector = this.calculateTotalVector(deltaWeightsVector);
                    this.weightsVector = this.createUnitVector(totalVector);
                }

	}

        

	/**
         * Generating vector for weights correcting.
         * @param inputSignalsVector
         * @param correctState
         * @return 
         */
        private float [] generateDeltaWeightsVector(float [] inputSignalsVector, float correctState) {
            int size = this.weightsVector.length;            
            
            float state = this.calculateState(inputSignalsVector);
            float delta = correctState - state;
            
            float[] vector = new float[size];
            for (int i = 0; i < size; i++)  {
                vector[i] = inputSignalsVector[i] * delta;
            }
            
            float[] result = this.correctMinBound(vector);
            
            return result;
        }
        
        /**
         * Correcting min bound of vector.
         * Min bound must be more or equals than minValue.
         * @param vector
         * @return 
         */
        private float [] correctMinBound(float [] vector) {
            int size = vector.length; 
            float[] result = new float[size];
            
            float min = this.findMinValue(vector);
            if (min < this.minValue) {
                float delta = this.minValue - min;
                for (int i = 0; i < size; i++) {
                    result[i] = vector[i] + delta;
                }
            } else {
                result = vector;
            }
            
            return result;
        }
        
        /**
         * Finding minimum value in vector.
         * @param vector
         * @return 
         */
        private float findMinValue(float [] vector) {
            float result = this.minValue;
            
            int size = vector.length;
            for (int i = 0; i < size; i++) {
                if (vector[i] < result) {
                    result = vector[i];
                }
            }
            
            return result;
        }
        
	/**
	 * Checking values of vector for minValue and maxValue.
	 * Return true, if all values of vector in the range minValue...maxValue.
	 * @param vector
	 * @return
	 */
	private boolean checkValues(float[] vector) {
		boolean result = true;
		
		int size = vector.length;
		for (int i = 0; i < size; i++) {
			if ((vector[i] < this.minValue) || (vector[i] > this.maxValue)) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * Calculating sum of vector's values and checking for weightsSum.
	 * @param vector
	 * @return
	 */
	private boolean checkSum(float[] vector) {
		boolean result = true;
		
		int size = vector.length;
		float sum = 0;
		for (int i = 0; i < size; i++) {
			sum += vector[i];
		}
		
		if (sum != this.weightsSum) {
			result = false;
		}
		
		return result;
	}
	
	/**
	 * Creating vector with random values.
	 * @param size
	 * @return
	 */
	private float[] generateRandomVector(int size) {
		float[] result = new float[size];
		
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			float value = random.nextFloat() * (this.maxValue - this.minValue) + this.minValue;
			result[i] = value;
		}
		
		return result;
	}
	
	/**
	 * Creating vector with sum of values is 1f.
	 * @param vector
	 * @return
	 */
	private float[] createUnitVector(float[] vector) {
		int size = vector.length;
		float[] result = new float[size];
		
		float sum = this.calculateSum(vector);
		for (int i = 0; i < size; i++) {
			result[i] = this.weightsSum * vector[i] / sum;
		}
		
		return result;
	}
	
	/**
	 * Calculating sum of vector's values.
	 * @param vector
	 * @return
	 */
	private float calculateSum(float[] vector) {
		float result = 0;
		
		int size = vector.length;
		for (int i = 0; i < size; i++) {
			result += vector[i];
		}
		
		return result;
	}
	
	/**
	 * Calculating State of Neuron.
	 * @param inputSignals
	 * @return
	 */
	private float calculateState(float[] inputSignals) {
		float result = 0;
		int size = this.weightsVector.length;
		for (int i = 0; i < size; i++) {
			result += inputSignals[i] * this.weightsVector[i];
		}
		
		//Activation function is linear. f(x) = x, i.e. result = result.
		
		return result;
	}

	/**
	 * Calculating vector with values is sum of values of weightsVector and vector.
	 * @param vector
	 * @return
	 */
	private float[] calculateTotalVector(float[] vector) {
		int size = this.weightsVector.length;
		float[] result =new float[size];

		for (int i = 0; i < size; i++) {
			result[i] = this.weightsVector[i] + vector[i];
		}

		return result;
	}
	
}
