/**
 * 
 */

import br.unicamp.cst.core.entities.Memory;

import java.util.List;
/**
 * @author andre
 *
 */
public interface IMotorCodelet {

	/**
	 * Returns the id of this Motor Codelet.
	 * 
	 * @return the id
	 */
	String getId();

	/**
	 * Gets the input memories list.
	 * 
	 * @return the inputs.
	 */
	List<Memory> getInputs();

	/**
	 * Add one memory to the input list.
	 * 
	 * @param motorMemoryContainer
	 *            one input to set.
	 */
	void addInput(Memory motorMemoryContainer);

}
