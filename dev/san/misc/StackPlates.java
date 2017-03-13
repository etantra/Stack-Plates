package dev.san.misc;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class StackPlates {
	static ArrayList<ArrayList<Integer>> finalMaster = new ArrayList<ArrayList<Integer>>();
	static int counter = 0;
	 public static void main(String[] args) {
		 ArrayList<ArrayList<Integer>> master = new ArrayList<ArrayList<Integer>>();
		 ArrayList<Integer> tempList;
		 
		 try(Scanner scan = new Scanner(System.in)) {
			 int n = scan.nextInt(); 
			 int items;
			 scan.nextLine();
			 while(n>0) {
				 items = scan.nextInt();
				 tempList = new ArrayList<Integer>();
				 while(items>0) {
					 tempList.add(scan.nextInt());
					 items--;
				 }
				 master.add(tempList);
				 n--;
			 }
			 System.out.println(master);
			 
			 ListIterator<ArrayList<Integer>> it =  master.listIterator();
			 while(it.hasNext()) {
				 tempList = it.next();
				 if(null != tempList && !tempList.isEmpty()) {
					 getSubLists(tempList);
				 }
			 }
			 System.out.println(finalMaster);
//			 Collections.sort(finalMaster, new Comparator<List<Integer>>() {
//				@Override
//				public int compare(List<Integer> o1, List<Integer> o2) {
//					return o1.get(0).compareTo(o2.get(0));
//				}
//			 });
//			 System.out.println("split counter::"+counter);
			 int joinCounter = finalMaster.size()-1;
//			 System.out.println("join counter::"+joinCounter);
			 counter += joinCounter;
			 System.out.println(counter);
		 } catch(Exception e) {
			 e.printStackTrace();
		 }

	 }
	 
	 public static void getSubLists(ArrayList<Integer> list) {
		 int size = list.size();
		 boolean isSplit = false;
		 for(int i=0; i<size-1; i++) {
			 if((list.get(i)+1) < list.get(i+1)) {
				 finalMaster.add(new ArrayList<Integer>(list.subList(0, i+1)));
				 counter++;
				 isSplit = true;
				 getSubLists(new ArrayList<Integer>(list.subList(i+1, size)));
				 break;
			 }
		 }
		 if(!isSplit) {
			 finalMaster.add(list);
		 }
	 }
}
