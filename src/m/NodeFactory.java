package m;
import java.util.Random;


public class NodeFactory {
	/**
	 * Create a ThreeDNode according to the given parameters, if parameters are invalid
	 * return a default ThreeDNode 
	 * @return
	 * @throws Exception 
	 */
	public static ThreeDNode getThreeDNode() throws Exception {
		Random r = new Random();
		int z = r.nextInt(INode.LOWER_LIMIT,INode.UPPER_LIMIT+1);
		Node node = getNode();
	    return new ThreeDNode(node.getX(),node.getY(),z);
	}
	
	public static Node getNode() throws Exception {
		Random r = new Random();
		int x = r.nextInt(INode.LOWER_LIMIT,INode.UPPER_LIMIT+1);
		int y = r.nextInt(INode.LOWER_LIMIT,INode.UPPER_LIMIT+1);
		return new Node(x,y);
	}
}
