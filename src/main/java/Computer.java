/**
 * Object representing the main LC-3 computer. Has registers, memory,
 * condition code, and other shared resources.
 */
public class Computer {
	private static final int maxMemory = 65536;
	private static short[] registers = new short[8];
	private static short[] memory = new short[maxMemory];
	private short pc;
	private Cond cc;

	/**
	 * Method to set a particular register - requires converting the register
	 * to an int first to index into the array and handle two's complement 
	 * @param register - the register to be changed
	 * @param value - the short value you're setting the register to
	 */
	public static void setRegister(int register, short value) {
		registers[register] = value;
	}

	/**
	 * Method to set a memory location - also requires converting memory location
	 * to an int
	 * @param memoryLocation - the memory location we are setting
	 * @param value - the short value you're setting the register to
	 */
	public static void setMemory(int memoryLocation, short value) {
		memory[memoryLocation] = value;
	}

	/**
	 * Returns the value of a memory location
	 * @param memoryLocation - the location in memory to get
	 * @return the short value at that location
	 */
	public static short getMemory(int memoryLocation) {
		return memory[memoryLocation];
	}

	/**
	 * Returns the value of a register
	 * @param register - the register to get
	 * @return the short value at that location
	 */
	public static short getRegister(int register) {
		return registers[register];
	}

}