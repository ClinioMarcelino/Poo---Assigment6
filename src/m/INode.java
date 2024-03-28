package m;

public interface INode extends Comparable<Object> {

	public static final int LOWER_LIMIT = -100;
	public static final int UPPER_LIMIT = 100;
	static final int DEFAULT_X = 0;
	static final int DEFAULT_Y = 0;
	static final int DEFAULT_Z = 0;

	public void add(Node INode) throws Exception;

	public boolean isInsideLimit(int num) throws Exception;
	
	int sum();
}
