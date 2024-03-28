package m;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * 
 * @author ClinioMarcelino
 * @date 03/27/2024
 * @version 1.0
 */
public class Nodes {
	private ArrayList<INode> arr;
	
	/**
	 * Default constructor, creates a new empty array
	 */
	public Nodes() {
		arr = new ArrayList<INode>();
		
	}
	
	/**
	 * This method has the intention of filling the INode ArrayList its size passed as a parameter
	 * @param size
	 * @throws Exception
	 */
	public void fill(int size) throws Exception {
		if(size<=0) {
			throw new Exception("Array size cannat bem less than 1");
		}
		if(this.arr.size() > 0)
			this.arr.clear();
//		this.arr = new ArrayList<INode>();
		Random rnd = new Random();
		for(int i=0;i<size;i++) {
			if(rnd.nextBoolean())
				arr.add(NodeFactory.getThreeDNode());
			else
				arr.add(NodeFactory.getNode());
		}
	}
	
	/**
	 * This method has the intention of clearing the declared array by creating a new empty one
	 */
	public void clear() {
		this.arr = new ArrayList<INode>();
	}
	
	/**
	 * This method counts the amount of Node Objects in the INode ArrayList
	 * @return quantity of Node in the array
	 */
	public int countNodes() {
		int node = 0;
		for(INode ind:arr) {
			if(ind.getClass()== Node.class)
				node++;
		}
		return node;
	}
	
	/**
	 * This method counts the amount of ThreeDNode Objects in the INode ArrayList 
	 * by calling the method count nodes and subtracting from the ArrayList size.
	 * @return quantity of ThreeDNode in the array
	 */
	public int countThreeDNodeS() {
		return this.arr.size() - countNodes();
	}
	
	/**
	 * This method calls the method sort from the Collections class in order to 
	 * sort the ArrayList in the ascending order
	 */
	public void sort() {
		Collections.sort(this.getArr(), new Sort());
	}
	
	/**
	 * This private method passes the array address so sort() method can arrange it in the proper way
	 * @return address of the INode array
	 */
	private ArrayList<INode> getArr() {
		return this.arr;
	}

	/**
	 * This method returns a String of the INode elements of the arrayList
	 * @overrides toString() 
	 * @return String that represents the Array's INode Objects
	 */
	public String toString() {
		String str = "[\n";
		for(INode ind: arr) {
			str+=ind+"\n";
		}
		return str+"]";
	}
	
	/**
	 * Support class for the Collections to sort the ArrayList of INode
	 */
	class Sort implements Comparator<INode> {
		
		@Override
		public int compare(INode o1, INode o2) {
			return o1.sum() - o2.sum();
		}
	}


public static void main(String a[]) throws Exception{
	Nodes nd = new Nodes();
	nd.fill(5);
	System.out.println(nd);
//	nd.clear();
	System.out.println(nd.countNodes());
	System.out.println(nd.countThreeDNodeS());
	nd.sort();
	System.out.println(nd);
	
	
}
}

