package neural_network_tests;

import org.junit.Test;
import static org.junit.Assert.*;

import neural_network.Neuron;

public class NeuronTests {

	@Test
	public void test_Neuron_weights_02f_03f_05f_0_getWeightsVector_return_02f_03f_05_0() {
		float[] vector = new float[] {.2f, .3f, .5f, 0};
		
		try {
			Neuron neuron  = new Neuron(vector);
			float[] weightsVector = neuron.getWeightsVector();
			
			assertEquals(weightsVector.length, 4);
			assertEquals(weightsVector[0], .2f, 0);
			assertEquals(weightsVector[1], .3f, 0);
			assertEquals(weightsVector[2], .5f, 0);
			assertEquals(weightsVector[3], 0, 0);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void test_Neuron_weights_2f_03f_05_0_getWeightsVector_return_exception_WrongValue() {
		float[] vector = new float[] {2f, .3f, .5f, 0};
		
		try {
			Neuron neuron  = new Neuron(vector);
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "one or more values out of range");
		}
	}
	
	@Test
	public void test_Neuron_weights_02f_03f_05_01f_getWeightsVector_return_exception_WrongSum() {
		float[] vector = new float[] {.2f, .3f, .5f, .1f};
		
		try {
			Neuron neuron  = new Neuron(vector);
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "sum of vector's values must be 1f");
		}
	}
	
	@Test
	public void test_Neuron_weightsAmount_4_getWeightsVector_checkValues_checkSum_return_ok() {
		try {
			int weightsAmount = 4;
			Neuron neuron  = new Neuron(weightsAmount);
			
			float[] weights = neuron.getWeightsVector();
			
			assertEquals(weights.length, 4);
			assertTrue(((weights[0] >= neuron.getMinValue()) && (weights[0] <= neuron.getMaxValue())));
			assertTrue(((weights[1] >= neuron.getMinValue()) && (weights[1] <= neuron.getMaxValue())));
			assertTrue(((weights[2] >= neuron.getMinValue()) && (weights[2] <= neuron.getMaxValue())));
			assertTrue(((weights[3] >= neuron.getMinValue()) && (weights[3] <= neuron.getMaxValue())));
			
			float sum = weights[0] + weights[1] + weights[2] + weights[3];
			assertTrue(sum == neuron.getWeightsSum());
			
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void test_Neuron_weights_02f_03f_05f_0_inputSignalsVector_01f_0_05f_1f_return_027f() {
		float[] weights = new float[] {.2f, .3f, .5f, 0};
		float[] inputSignals = new float[] {.1f, 0, .5f, 1f};

		try {
			Neuron neuron  = new Neuron(weights);
			try {
				float state = neuron.getState(inputSignals);

				assertEquals(state, .27f, 0);

			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void test_Neuron_weights_02f_03f_05f_0_inputSignalsVector_01f_0_05f_return_exception_IndexOutOfBounds() {
		float[] weights = new float[] {.2f, .3f, .5f, 0};
		float[] inputSignals = new float[] {.1f, 0, .5f};

		try {
			Neuron neuron  = new Neuron(weights);
			try {
				float state = neuron.getState(inputSignals);

				assertEquals(state, .27f);

			} catch (RuntimeException e) {

				assertEquals(e.getMessage(), "size of inputSignalsVector must be equals size of weightsVector");

			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void test_Neuron_weights_02f_03f_05f_0_inputSignals_1f_0_0_0_correctState_1f_getWeightsVector_return_0556f_0167f_0278f_0f() {
		float[] weights = new float[] {.2f, .3f, .5f, 0};
		float[] inputSignals = new float[] {1f, 0, 0, 0};
                float correctState = 1f;

		try {
			Neuron neuron  = new Neuron(weights);
			try {
				neuron.correctWeights(inputSignals, correctState);
				float[] newWeights = neuron.getWeightsVector();

				assertEquals(newWeights.length, 4);
				assertEquals(newWeights[0], .556f, .001f);
				assertEquals(newWeights[1], .167f, .001f);
				assertEquals(newWeights[2], .278f, .001f);
				assertEquals(newWeights[3], 0, .001f);

			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
        
        @Test
	public void test_Neuron_weights_02f_03f_05f_0_inputSignals_0_1f_1f_0_correctState_0_getWeightsVector_return_028f_032f_02f_02f() {
		float[] weights = new float[] {.2f, .3f, .5f, 0};
		float[] inputSignals = new float[] {0, 0, 1f, 0};
                float correctState = 0;

		try {
			Neuron neuron  = new Neuron(weights);
			try {
				neuron.correctWeights(inputSignals, correctState);
				float[] newWeights = neuron.getWeightsVector();

				assertEquals(newWeights.length, 4);
				assertEquals(newWeights[0], .28f, .001f);
				assertEquals(newWeights[1], .32f, .001f);
				assertEquals(newWeights[2], .2f, .001f);
				assertEquals(newWeights[3], .2f, .001f);

			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
        
        @Test
	public void test_Neuron_weights_02f_03f_05f_0_inputSignals_1f_0_0_correctState_1f_getWeightsVector_return_exception_WrongInputSignalsSize() {
		float[] weights = new float[] {.2f, .3f, .5f, 0};
		float[] inputSignals = new float[] {1f, 0, 0};
                float correctState = 1f;

		try {
			Neuron neuron  = new Neuron(weights);
			try {
				neuron.correctWeights(inputSignals, correctState);
				float[] newWeights = neuron.getWeightsVector();
			} catch (RuntimeException e) {
                            assertEquals(e.getMessage(), "size of inputSignalsVector must be equals size of weightsVector");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
        
        @Test
	public void test_Neuron_weights_02f_03f_05f_0_inputSignals_2f_0_0_0_correctState_1f_getWeightsVector_return_exception_WrongValue() {
		float[] weights = new float[] {.2f, .3f, .5f, 0};
		float[] inputSignals = new float[] {2f, 0, 0, 0};
                float correctState = 1f;

		try {
			Neuron neuron  = new Neuron(weights);
			try {
				neuron.correctWeights(inputSignals, correctState);
				float[] newWeights = neuron.getWeightsVector();
			} catch (RuntimeException e) {
                            assertEquals(e.getMessage(), "one or more values out of range");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
        
        @Test
	public void test_Neuron_weights_02f_03f_05f_0_inputSignals_1f_0_0_0_correctState_minus1f_getWeightsVector_return_exception_WrongCorrectState() {
		float[] weights = new float[] {.2f, .3f, .5f, 0};
		float[] inputSignals = new float[] {1f, 0, 0, 0};
                float correctState = -1f;

		try {
			Neuron neuron  = new Neuron(weights);
			try {
				neuron.correctWeights(inputSignals, correctState);
				float[] newWeights = neuron.getWeightsVector();
			} catch (RuntimeException e) {
                            assertEquals(e.getMessage(), "correctState out of range");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
        
}