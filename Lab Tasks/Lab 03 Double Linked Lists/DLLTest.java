package com.company;

public class DLLTest {
	public static void main(String[] args) {
		DLL<String> test = new DLL<String>();
		for(int i = 0; i < 10; i++)
			test.addToTail("a" + i);
		for (int i = 0; i < 10; i++) {
			test.printAll();
			System.out.println();
			test.delete7();
		}
		DLL<Integer> test2 = new DLL<Integer>();
		for(int i = 0; i < 10; i++) {
			test2.addToTail((int) (10*Math.random()));
		}
		test2.printAll();
		System.out.println();
		for (int i = 0; i < 10; i++) {
			test2.delete7();
			test2.printAll();
			System.out.println();
		}
	}
}