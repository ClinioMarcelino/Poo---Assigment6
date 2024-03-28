package m;

public class Node implements INode {

	private int x = DEFAULT_X;
	private int y = DEFAULT_Y;

	/**
	 * Default constructor
	 * 
	 * @throws Exception
	 */
	public Node() throws Exception{
		this(DEFAULT_X, DEFAULT_Y);

	}

	/**
	 * Copy constructor: receives an object of the class and copy the values.
	 * 
	 * @param obj -> should be an instance of the class Node
	 * @throws Exception> in case Object is not an Object of the class Node.
	 */
	public Node(Object obj) throws Exception {
		if (this.verifyClass(obj))
			throw new Exception("The Object is not an Node Object");

		Node nd = (Node) obj;

		this.setX(nd.getX());
		this.setY(nd.getY());
	}
	

	/**
	 * Classic constructor, sets X and Y if in range
	 * 
	 * @param x
	 * @param y
	 * @throws Exception> in case x or y are out of the range.
	 */
	public Node(int x, int y) throws Exception {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	/**
	 * Private method that validate the <b>x</b> and <b>y</b>
	 * 
	 * @preconditon in the inclusive range <b>[-100,100]</b>
	 * @param num
	 * @return true if valid<br>
	 *         false if invalid
	 */
	public boolean isInsideLimit(int num) {
		if (num >= INode.LOWER_LIMIT && num <= INode.UPPER_LIMIT)
			return true;
		return false;
	}

	/**
	 * Setting the <b>x</b> value
	 * 
	 * @precondion <b>x</b> is in the valid range
	 * @param x
	 * @throws Exception
	 */
	public void setX(int x) throws Exception {
		if (isInsideLimit(x))
			this.x = x;
		else
			throw new Exception("The value of X must be in the range [-100,100]");
	}

	/**
	 * Setting the <b>y</b> value
	 * 
	 * @precondion <b>y</b> is in the valid range
	 * @param y
	 * @throws Exception
	 */
	public void setY(int y) throws Exception {
		if (isInsideLimit(y))
			this.y = y;
		else
			throw new Exception("The value of Y must be in the range [-100,100]");
	}
	
	/**
	 * This method verifies that the passed object is the same class as the instanced
	 * @param object
	 * @return boolean
	 */
	private boolean verifyClass(Object obj) {
		if (this.getClass() == obj.getClass())
			return true;
		return false;
	}

	/**
	 * Method for adding the <b>x</b> and <b>y</b> values of two classes
	 * 
	 * @param nd -> instance of Node
	 * @throws Exception> in case of stepping out of the range
	 */
	public void add(Node nd) throws Exception {
		int sumX = nd.getX() + this.x;
		int sumY = nd.getY() + this.y;

		if (!isInsideLimit(sumX))
			throw new Exception("Adding the two X's lead to " + sumX + " getting out of the range [-100,100]");
		else if (!isInsideLimit(sumY))
			throw new Exception("Adding the two Y's lead to " + sumY + " getting out of the range [-100,100]");
		setX(sumX);
		setY(sumY);
	}

	/**
	 * Method for verifying if the two instances of the object Node have the same
	 * values for <b>x</b> and <b>y</b>
	 * 
	 * @param nd -> instance of Node
	 * @return true if equals<br>
	 *         false if different
	 */
	public boolean equals(Object obj) {
		if(verifyClass(obj))
			return false;
		Node nd = (Node) obj;
		if (this.x == nd.getX() && this.y == nd.getY())
			return true;
		return false;
	}

	/**
	 * @Overrides toString() in Object class
	 * @return String 
	 */
	public String toString() {
		return "Node: x= " + x + ", y= " + y;
	}

	@Override
	public int sum() {
		return this.getX()+this.getY();
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
