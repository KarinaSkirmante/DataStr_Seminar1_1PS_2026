package service;

import datastr.MyArrayList;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		MyArrayList<Character> symbols = new MyArrayList<Character>(2);
		symbols.add('a');//a
		symbols.add('b');//a b
		symbols.add('c');//a b c (automātiski būs resize izpildījies)
		try
		{
			symbols.print();//a b c
			symbols.add('Z', 1);//a Z b c
			symbols.print();//a Z b c
			symbols.remove(2);//a Z c (jeb b tiek izdzēsts)
			symbols.print();//a Z c
			
			System.out.println(symbols.get(1));//Z
			
			System.out.println(symbols.search('c'));//2.pozīcijā
			System.out.println(symbols.getNextElement('a'));//Z
			
			
			symbols.sort();
			symbols.print();//Z a c
			
			symbols.makeEmpty();//visi iepriekšējie elementi tiek dzēsti
			symbols.add('W');//W
			symbols.print();//W
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("-----------------STUDENTI------------");
		MyArrayList<Student> allStudents = new MyArrayList<Student>();
		allStudents.add(new Student("Janis", "Berzins"));//Janis
		Student s1 = new Student("Baiba", "Jauka");
		allStudents.add(s1);//Janis Baiba
		try
		{
			allStudents.add(new Student("Peteris", "Nejaukais"), 0);//Peteris Janis Baiba
			allStudents.print();//Peteris Janis Baiba
			allStudents.remove(0);//Pēteris izdzest
			allStudents.print();//Janis Baiba
			allStudents.add(new Student("Kaspars", "Kalnins"));//Janis Baiba Kaspars
			allStudents.add(new Student("Liga", "Jautra"));//Janis Baiba Kaspars Liga
			System.out.println(allStudents.get(3));//Liga
			System.out.println(allStudents.search(s1));//Mekleju Baibu - 1
			System.out.println(allStudents.getNextElement(s1));//Kaspars
			allStudents.print();
			allStudents.sort();
			allStudents.print();
			allStudents.makeEmpty();
			allStudents.add(new Student("Karina", "Skirmante"));
			allStudents.print();//Karina
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
