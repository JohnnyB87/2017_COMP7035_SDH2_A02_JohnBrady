
/**
* The main class of our project.<br>. 
*/
public class MyMain {
	
	/**
	 * This function is used to test the divide and conquer algorithms.
	 */
	public static void test(){
		//1. We create the object to test the exercises
		DivideAndConquerAlgorithms ex = new DivideAndConquerAlgorithms();
		
		//2. We create extra variables for the tests
		
		// m1 = []
		MyList<Integer> m1 = new MyDynamicList<Integer>();
		
		// m2 = [9,3,2]
		MyList<Integer> m2 = new MyDynamicList<Integer>();
		m2.addElement(0, 9);
		m2.addElement(1, 3);
		m2.addElement(2, 2);
		
		// m3 = [4,8,1,3,6,5,2,6]		
		MyList<Integer> m3 = new MyDynamicList<Integer>();
		m3.addElement(0, 4);
		m3.addElement(1, 8);
		m3.addElement(2, 1);	
		m3.addElement(3, 3);			
		m3.addElement(4, 6);
		m3.addElement(5, 5);
		m3.addElement(6, 2);	
		m3.addElement(7, 6);	
		
		//3. We create extra variables for the results		
		MyList<Integer> resM = null;
		MyList<Integer> resM2 = null;
		//---------------------
		// TESTS
		//---------------------

		//----------------------------
		//0. We test iterativeDisplayElements
		//----------------------------
		System.out.println("\n----------- Test: iterativeDisplayElements -------------\n");
		ex.iterativeDisplayElements(m1);
		ex.iterativeDisplayElements(m2);
		ex.iterativeDisplayElements(m3);
		//----------------------------
		//1. We test recursiveDisplayElements
		//----------------------------
		System.out.println("\n----------- Test: recursiveDisplayElements -------------\n");
		
		ex.recursiveDisplayElements(m1);
		
		ex.recursiveDisplayElements(m2);
		
		ex.recursiveDisplayElements(m3);
		
		//----------------------------
		//2. We test smallerMyList
		//----------------------------
		System.out.println("\n----------- Test: smallerMyList -------------\n");
	
		resM = ex.smallerMyList(m1, 9);
		ex.recursiveDisplayElements(resM);
		
		resM = ex.smallerMyList(m2, 9);
		ex.recursiveDisplayElements(resM);
		
		resM = ex.smallerMyList(m3, 6);
		ex.recursiveDisplayElements(resM);
		
		//----------------------------
		//3. We test biggerEqualMyList
		//----------------------------	
		System.out.println("\n----------- Test: biggerEqualMyList -------------\n");
		
		resM = ex.biggerEqualMyList(m1, 9);
		ex.recursiveDisplayElements(resM);
		
		resM = ex.biggerEqualMyList(m2, 9);
		ex.recursiveDisplayElements(resM);
		
		resM = ex.biggerEqualMyList(m3, 6);
		ex.recursiveDisplayElements(resM);
		
		//----------------------------
		//4. We test concatenate
		//----------------------------
		System.out.println("\n----------- Test: concatenate -------------\n");

		resM = ex.concatenate(m1, m2);
		ex.recursiveDisplayElements(resM);

		resM = ex.concatenate(m2, m1);
		ex.recursiveDisplayElements(resM);

		resM = ex.concatenate(m2, m3);
		ex.recursiveDisplayElements(resM);

		resM2 = ex.concatenate(m2, m3);
		ex.recursiveDisplayElements(resM);

		resM = ex.concatenate(m1, m1);
		ex.recursiveDisplayElements(resM);

		System.out.println("\n----------- Test: recursiveDisplayElements -------------\n");

		ex.recursiveDisplayElements(m1);

		ex.recursiveDisplayElements(m2);

		ex.recursiveDisplayElements(m3);

		//----------------------------
		//5. We test quickSort
		//----------------------------
		System.out.println("\n----------- Test: quickSort -------------\n");

		resM = ex.quickSort(m1);
		ex.recursiveDisplayElements(resM);

		resM = ex.quickSort(m2);
		ex.recursiveDisplayElements(resM);

		resM = ex.quickSort(m3);
		ex.recursiveDisplayElements(resM);

		resM = ex.quickSort(resM2);
		ex.recursiveDisplayElements(resM);

		MyList<Integer> m4 = new MyDynamicList<>();
		
		m4.addElement(0,9);
		m4.addElement(1,9);
		m4.addElement(2,8);
		m4.addElement(3,8);
		m4.addElement(4,7);
		m4.addElement(5,7);
		m4.addElement(6,6);
		m4.addElement(7,6);
		m4.addElement(8,7);
		m4.addElement(9,7);
		m4.addElement(10,8);
		m4.addElement(11,8);
		m4.addElement(12,9);
		m4.addElement(13,9);

		long start = System.currentTimeMillis();

		resM = ex.quickSort(m4);
		ex.recursiveDisplayElements(resM);

		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end-start)/1000.0);

		MyList<Integer> m5 = new MyDynamicList<>();
		m5.addElement(0,0);
		m5.addElement(1,1);
		m5.addElement(2,2);
		m5.addElement(3,3);
		m5.addElement(4,4);
		m5.addElement(5,5);
		m5.addElement(6,6);
		m5.addElement(7,7);
		m5.addElement(8,8);
		m5.addElement(9,9);
		m5.addElement(10,10);

		start = System.currentTimeMillis();
		resM = ex.quickSort(m5);
		ex.recursiveDisplayElements(resM);

		end = System.currentTimeMillis();
		System.out.println("Time: " + (end-start)/1000.0);

		MyList<Integer> m6 = new MyDynamicList<>();
		m6.addElement(0,10);
		m6.addElement(1,9);
		m6.addElement(2,8);
		m6.addElement(3,7);
		m6.addElement(4,6);
		m6.addElement(5,5);
		m6.addElement(6,4);
		m6.addElement(7,3);
		m6.addElement(8,2);
		m6.addElement(9,1);
		m6.addElement(10,0);

		start = System.currentTimeMillis();

		resM = ex.quickSort(m6);
		ex.recursiveDisplayElements(resM);

		end = System.currentTimeMillis();
		System.out.println("Time: " + (end-start)/1000.0);


		//----------------------------
		//7. We test null Array
		//----------------------------

		System.out.println("\n----------- Test is array is null -------------\n");

		MyList m7 = null;
		resM = ex.quickSort(m7);
		ex.recursiveDisplayElements(resM);

		resM = ex.concatenate(m6,m7);
		ex.recursiveDisplayElements(resM);

		ex.recursiveDisplayElements(m7);

		resM = ex.smallerMyList(m7,5);
		ex.recursiveDisplayElements(resM);

		resM = ex.biggerEqualMyList(m7,5);
		ex.recursiveDisplayElements(resM);


	}
	
	/**
	 * Main Method.
	 * @param args: We will run the program parameter free, so do not worry about it.
	 */
	public static void main(String[] args) {
		test();	
	}

}
