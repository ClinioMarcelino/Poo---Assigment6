package m;

public class ThreeDNode extends Node {
	private int z = INode.DEFAULT_Z;;
	
	/**
	 * Default constructor sets everything to default value
	 * @throws Exception
	 */
	public ThreeDNode() throws Exception {
		super();
		this.setZ(INode.DEFAULT_Z);
	}

	/**
	 * Constructor thar receives the values of X,Y and Z and if they are inside the limits the object is created
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @throws Exception
	 */
	public ThreeDNode(int x, int y, int z) throws Exception {
		super(x, y);
		setZ(z);
	}

	/**
	 * Copy constructor receives an object, verifies that is from the correct class and copy the values.
	 * @param obj
	 * @throws Exception
	 */
	public ThreeDNode(Object obj) throws Exception {
		if (this.getClass() != obj.getClass())
			throw new Exception("Object is not an instance of ThreeDNode");

		ThreeDNode tdn = (ThreeDNode) obj;

		super.setX(tdn.getX());
		super.setY(tdn.getY());
		this.setZ(tdn.getZ());
	}
	
	/**
	 * This method adds the values from another ThreeDNode to the caller if all 3 values are inside limits.<br>
	 * Also verifies if is the correct class
	 * 
	 * @param obj
	 * @throws Exception
	 */
	public void add(Object obj) throws Exception {
		if(this.getClass() != obj.getClass())
			throw new Exception("The Objects do not belong to the same class");
		ThreeDNode	tdn = (ThreeDNode) obj;
		if(!isInsideLimit(super.getX() + tdn.getX()))
			throw new Exception("X step out of the range ["+INode.LOWER_LIMIT+","+INode.UPPER_LIMIT+"]");
		else if (!isInsideLimit(super.getY() + tdn.getY()))
			throw new Exception("Y step out of the range ["+INode.LOWER_LIMIT+","+INode.UPPER_LIMIT+"]");
		else if (!isInsideLimit(getZ() + tdn.getZ()))
			throw new Exception("X step out of the range ["+INode.LOWER_LIMIT+","+INode.UPPER_LIMIT+"]");
			
		setX(super.getX() + tdn.getX());
		setY(super.getY() + tdn.getY());
		setZ(getZ() + tdn.getZ());
	}
	
	/**
	 * This method sum the 3 variables from the class.
	 * @return sum
	 */
	public int sum() {
		return super.getX()+super.getY()+this.getZ();
	}

	public int getZ() {
		return z;
	}

	/**
	 * Method for setting Z if inside limits
	 * @param z
	 * @throws Exception
	 */
	public void setZ(int z) throws Exception {
		if (!isInsideLimit(z))
			throw new Exception("Z is off limits");

		this.z = z;
	}
	
	/**
	 * @Overrides toString() in Object class
	 * @return String
	 */
	public String toString() {
		return "ThreeDNode: x= "+getX()+", y= "+getY()+", z= "+getZ();
	}
	
}
