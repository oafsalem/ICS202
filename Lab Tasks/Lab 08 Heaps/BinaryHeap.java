import java.util.Arrays;

public class BinaryHeap 
{
	protected Comparable array[];
	int count;
	  
    public BinaryHeap(int i)
    {
        array = new Comparable[i + 1];
    }
    
    public BinaryHeap(Comparable[] comparable) 
    {
    	this(comparable.length);
    	 
    	for(int i = 0; i < comparable.length; i++)
    	   array[i + 1] = comparable[i];
    	   
    	count = comparable.length;
    	
    	buildHeapTopDown();
        //buildHeapBottomUp();
	}
	
	private void buildHeapBottomUp()
	{
	    for(int i = count/2; i>=1; i--) {
            percolateDown(i);
        }
	}
	
	private void buildHeapTopDown()
	{
        for (int i = 1; i < count; i++)
        {
            percolateUp(i);
        }
	}
	
	
	private void percolateDown(int hole)
	{
	    boolean done = false;
        for (int i = hole; !done && (2*i <= count);){
            i = 2*i;
            if ((i+1<=count) && (array[i+1].compareTo(array[i])<0))
            i++;
            if (array[i/2].compareTo(array[i]) > 0){
                Comparable tmp = array[i];
                array[i] = array[i/2];
                array[i/2] = tmp;
            }
            else
                done = true;
            }

        }
	
	private void percolateUp(int hole){
        Comparable tmp = array[hole];
        for(; hole > 1 && tmp.compareTo(array[hole/2]) < 0; hole  = hole/2)
            array[hole] = array[hole/2];

        array[hole] = tmp;
	}
	

	public void purge()
    {
        while(count > 0) 
            array[count--] = null;
    }

    public void enqueue(Comparable comparable)
    {
        int hole = ++count;
        
        // percolate up via a hole
        while(hole > 1 && array[hole / 2].compareTo(comparable)>0)
        {
            array[hole] = array[hole / 2];
            hole = hole / 2 ;
    	}

        array[hole] = comparable;
    }

    public Comparable findMin()
    {
            return array[1];
    }

    public Comparable dequeueMin()
    {
        Comparable minItem = array[1];
        array[1] = array[count];
        count--;
        percolateDown(1);
        return minItem;
    }
    
    public Comparable[] heapSort() {
    	Comparable[] x = new Comparable[count];
    	int total = count;
    	for(int i = 0; i < total; i++) {
    		x[i] = dequeueMin();    		
    	}
    	return x;
    }
    
    
    public boolean isFull()
    {
        return count == array.length - 1;
    }
    
    public boolean isEmpty() {
    	return count == 0;
    }
    
    public String toString(){
    	Comparable[] tempArray = new Comparable[array.length - 1];
    	System.arraycopy(array, 1, tempArray, 0, array.length - 1);
    	return Arrays.toString(tempArray);
    	
    }
    
    public static void main(String[] args) {
    	Integer[] a = {10, 2, 8, 9, 1, 6, 3, 4, 0, 5};
    	System.out.println("The original array is: "+Arrays.toString(a));
    	BinaryHeap bh = new BinaryHeap(a);
    	//builds heap bottom up: change the constructor to build it top-down
    	System.out.println("\nThe heap is: "+bh);
        System.out.println("\nSorted Array is: "+Arrays.toString(bh.heapSort()));
        
        Patient patients[] = new Patient[10];
        for (int i =0; i <10; i++){
            Patient x = new Patient();
            x.name = String.format("x%d", i);
            x.emergencyLevel = (int) (Math.random() *5);
            patients[i] = x;
        }
        BinaryHeap bh2 = new BinaryHeap(patients);
        for (int i =0; i <10; i++){
            bh2.enqueue(patients[i]);
        }
        for (int i =0; i <10; i++){
            System.out.println(bh2.dequeueMin());
        }
        
    }
}