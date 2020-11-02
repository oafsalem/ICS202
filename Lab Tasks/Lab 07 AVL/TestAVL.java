import java.util.Scanner;

public class TestAVL {
	public static void main(String[] args) {
			AVLTree<String> t = new AVLTree<String>();
			for(int i = 1; i <= 5; i++)
				t.insertAVL("a" + i);
			t.breadthFirst();
			System.out.println();

			System.out.println("Question 2 Testing");;

			AVLTree<Integer> s = new AVLTree<Integer>();
			int x[] = {8, 12, 14, 18, 20, 23, 15, 13, 7, 16};
			for(int i = 0; i < 10; i++)
				s.insertAVL(x[i]);
			s.breadthFirst();
			System.out.println();
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter Three elements to delete: ");
			for(int i=0; i<3; i++){
			System.out.println(">> ");
			s.delete(sc.nextInt());
			}
			s.breadthFirst();
			System.out.println();
		
	}
}