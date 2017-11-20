
/**
 * The class contains the Divide and Conquer-based Algorithms we are using.
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}

	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.
	 */
	public void iterativeDisplayElements(MyList<Integer> m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		//Rule 1. MyList is empty
		if (m.length() == 0)
			scenario = 1;
			//Rule 2. MyList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch(scenario){

			//Rule 1. MyList is empty
			case 1:
				//1. We print the empty message
				System.out.println("Empty MyList");

				break;

			//Rule 2. MyList is non-empty
			case 2:
				//1. We print the initial message
				int size = m.length();
				System.out.println("MyList Contains the following " + size + " items: ");

				//2. We traverse the items
				for (int i = 0; i < size; i++)
					System.out.println("Item " + i + ": " + m.getElement(i));

				break;

		}

	}

	//-------------------------------------------------------------------
	// 1. recursiveDisplayElements --> Displays all elements of a MyList
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.
	 */
	public void recursiveDisplayElements(MyList<Integer> m){

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int mSize = m == null ? -1 : m.length();
		int scenario = mSize;
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch(scenario){
			case -1:
				System.out.println("Empty List");
			break;
			case 0:
				//System.out.printf("MyList Contains the following %d item%s:%n", mSize, mSize == 1 ? "" : "'s");
				break;
			default:

				Integer i = m.getElement(0);

				m.removeElement(0);
				recursiveDisplayElements(m);
				
				System.out.printf("Item %d: %d%n",mSize-1,i);
				m.addElement(0,i);
				break;
		}
	}

	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyList smaller than e
	//-------------------------------------------------------------------
	/**
	 * The function filters all elements of MyList being smaller than 'e'
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being smaller than 'e'
	 */
	public MyList<Integer> smallerMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res;

		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int i=0;
		int scenario = 0;
		int mSize = m == null ? 0 : m.length();
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------

		if(mSize > 0) {
			i = m.getElement(0);
			scenario = i < e ? 2 : 1;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch(scenario){
			case 1:
				m.removeElement(0);
				res = smallerMyList(m,e);
				m.addElement(0,i);
				break;
			case 2:
				m.removeElement(0);
				res = smallerMyList(m,e);
				res.addElement(0,i);
				m.addElement(0,i);
				break;
			default: res = new MyDynamicList<>(); break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}

	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyList bigger than e
	//-------------------------------------------------------------------
	/**
	 * The function filters all elements of MyList being bigger than 'e'
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being bigger or equal than 'e'
	 */
	public MyList<Integer> biggerEqualMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res;

		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int i = 0;
		int scenario = 0;
		int mSize = m == null ? 0 : m.length();
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------

		if(mSize > 0) {
			i = m.getElement(0);
			scenario = i >= e ? 2 : 1;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch(scenario){

			case 1:
				m.removeElement(0);
				res = biggerEqualMyList(m,e);
				m.addElement(0,i);
				break;
			case 2:
				m.removeElement(0);
				res = biggerEqualMyList(m,e);
				res.addElement(0,i);
				m.addElement(0,i);
				break;
			default: res = new MyDynamicList<>(); break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}

	//-------------------------------------------------------------------
	// 3. concatenate --> It concatenates 2 MyList
	//-------------------------------------------------------------------
	/**
	 * The function concatenates the content of 2 MyList.
	 * @param m1: The first MyList.
	 * @param m2: The second MyList.
	 * @return: The new MyList resulting of concatenate the other 2 MyList
	 */
	public MyList<Integer> concatenate(MyList<Integer> m1, MyList<Integer> m2){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res;

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		int m1Size = m1 == null ? 0 : m1.length();
		int m2Size = m2 == null ? 0 : m2.length();

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		if(m1Size >= 0 && m2Size >= 0){
			if(m1Size > 0)
				scenario = 1;
			else if(m2Size > 0)
				scenario = 2;
		}
		switch(scenario){
			case 1:
				int n = m1.getElement(0);
				m1.removeElement(0);
				res = concatenate(m1,m2);
				res.addElement(0,n);
				m1.addElement(0,n);
				break;
			case 2:
				n = m2.getElement(0);
				m2.removeElement(0);
				res = concatenate(m1,m2);
				res.addElement(0,n);
				m2.addElement(0,n);
				break;
			default:
				res = new MyDynamicList<>();
				break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}

	//-------------------------------------------------------------------
	// 4. quickSort --> Sort a MyList using the method quick sort
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyList, it computes a new sorted list using the method Quick Sort.
	 * @param m: The MyList we want to sort.
	 * @return: The new MyList being sorted.
	 */
	public MyList<Integer> quickSort(MyList<Integer> m){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res;
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		int mSize = m == null ? 0 : m.length();
		int scenario;
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		scenario = mSize;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------

		switch(scenario){
			case 0:
				res = new MyDynamicList<>();
				break;
			case 1:
				res = new MyDynamicList<>();
				int n = m.getElement(0);
				res.addElement(0,n);
				break;
			default:
				int pivot = mSize/2;
				int p = m.getElement(pivot);

				m.removeElement(pivot);

				MyList<Integer> l = smallerMyList(m,p);
				MyList<Integer> r = biggerEqualMyList(m,p);

				m.addElement(pivot,p);

				l = quickSort(l);
				r = quickSort(r);

				r.addElement(0,p);

				res = concatenate(l,r);
				break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}

	public MyList<Integer> quickSort2(MyList<Integer> m){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res;
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		int mSize = m == null ? 0 : m.length();
		int scenario;

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		scenario = mSize;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------

		switch(scenario){
			case 0:
				res = new MyDynamicList<>();
				break;
			case 1:
				res = new MyDynamicList<>();
				int n = m.getElement(0);
				res.addElement(0,n);
				break;
			default:
				int pivot = mSize/2;
				int low = 0;
				int high = mSize-1;
				int p = m.getElement(pivot);

				while(low < pivot && high > pivot){
					while(low < pivot && m.getElement(low) < p ){
						low++;
					}
					while(high > pivot && m.getElement(high) >= p){
						high--;
					}

					if(low < pivot && high > pivot){
						int i = m.getElement(low);
						int j = m.getElement(high);
						m.removeElement(low);
						m.addElement(low,j);
						m.removeElement(high);
						m.addElement(high,i);
						low++;
						high--;
					}
					else if ((low == pivot && high > pivot)) {
						m.removeElement(pivot++);
						m.addElement(pivot,p);
					}
					else if(low < pivot && high == pivot){
						m.removeElement(pivot--);
						m.addElement(pivot,p);
					}
				}

				m.removeElement(pivot);
				res = quickSort2(m);
				m.addElement(pivot,p);
				res.addElement(pivot,p);
				break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}
}
