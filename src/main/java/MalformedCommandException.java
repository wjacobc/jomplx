public class MalformedCommandException extends RuntimeException {
	
	public MalformedCommandException(int mem, String message) {
		super(message + " at memory location " + Integer.toHexString(mem));
	}
	
	public MalformedCommandException(int mem) {
		super("Malformed command at memory location " + Integer.toHexString(mem));
	}

	public MalformedCommandException() {
		super("Malformed command.");
	}
}