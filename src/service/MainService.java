package service;

import datastr.MyArrayList;

public class MainService {

	public static void main(String[] args) {
		MyArrayList symbols = new MyArrayList(2);
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
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
