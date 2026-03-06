package datastr;


public class MyArrayList<Ttype> {
	//1.mainīgie
	private Ttype[] list;
	private final int DEFAULT_SIZE = 8;//pec noklusjeuma bus 8 sunu masivs, ja lietotajs pats neizdomas citu skaitu
	private int size = DEFAULT_SIZE;//8
	private int howManyElements = 0;
	
	//2. konstruktori
	public MyArrayList() {
		list = (Ttype[])new Object[size];
	}
	
	public MyArrayList(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
				
		list = (Ttype[])new Object[size];
	}
	
	//3. pamatalgoritmu funkcijas
	public boolean isEmpty() {
		//1. garais if-else
		/*if(howManyElements == 0) {
			return true;//ir tukšs saraksts
		}
		else
		{
			return false;//nav tukšs saraksts
		}*/
		
		//2. īsais if-else
		//return (howManyElements == 0) ?  true : false;
		
		//vel viens piemērs īsajam if un else
		/*int aaa;
		if(howManyElements == 0) {
			aaa = 4 * 30;
		}
		else
		{
			aaa = 1000/4;
		}
		
		aaa = (howManyElements == 0) ? 4 * 30 : 1000/4;*/
		
		//3.pats efektīvakais veids
		return (howManyElements == 0);
		
	}
	
	
	public boolean isFull() {
		return (howManyElements == size);
	}
	
	
	private void resize() {

		int largeSize = (howManyElements < 100)? size * 2 : (int)(size * 1.5);
		
		Ttype[] largeList = (Ttype[])new Object[largeSize];
		
		
		for(int i = 0; i < howManyElements; i++) {
			largeList[i] = list[i];
		}
		
		list = largeList;
		System.gc();//izdzēsis no RAM atmiņas mazo masīvu, jo tam vairs nav mainīgais piesaistīts
		size = largeSize;
		
	}
	
	public void add(Ttype element) {
		if(isFull()) {
			resize();
		}
		
		list[howManyElements] = element;
		howManyElements++;
		
		//īsaks pieraksts, apvienot abas koda rindas vienā->list[howManyElements++] = element;
	
	}
	
	//funkcijas definīcija add(char element, int index)
	
	public void add(Ttype element, int index) throws Exception {
		if(index < 0) {
			throw (new Exception("Nevar pievienot elementu, jo index ir negatīvs"));
		}
		
		if(index > howManyElements) {
			throw (new Exception("Nevar pievienot elementu, jo index ir lielāks ka elementu skaits"));
		}
		
	
		
		if(index == howManyElements) {//gribam pievienot pirmajā brīvajā šūnā elementu
			add(element);
		}
		else//ielikt elementu kaut kur pa vidu vai sākumā
		{
			if(isFull()) {
				resize();
			}
			
			for(int i = howManyElements; i > index; i--) {
				list[i] = list[i-1];
			}
			
			list[index] = element;
			howManyElements++;
		}
		
	}


	public void remove(int index) throws Exception {
		
		if(isEmpty()) {
			throw (new Exception("Saraksts ir tukšs, tāpēc nevar izdzēst elementus"));
		}
		
		if(index < 0) {
			throw (new Exception("Nevar izdzēst elementu, jo index ir negatīvs"));
		}
		
		if(index > howManyElements) {
			throw (new Exception("Nevar izdzēst elementu, jo index ir lielāks ka elementu skaits"));
		}
		
		
		for(int i = index; i < howManyElements-1; i++) {
			list[i] = list[i+1];
		}
		list[howManyElements-1] = null;
		howManyElements--;
		
	}
	//izveidot funkciju, kas ies cauri visiem 
	//elementiem un katru elementu izprintē konsolē
	public void print() throws Exception{
		if(isEmpty()) {
			throw (new Exception("Saraksts ir tukšs un to nevar izprintēt"));
		}
		
		for(int i = 0; i < howManyElements; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
	
	public Ttype get(int index) throws Exception{
		if(isEmpty()) {
			throw (new Exception("Saraksts ir tukšs, tāpēc nevar atgriezt elementu"));
		}
		
		if(index < 0) {
			throw (new Exception("Nevar atgriezt elementu, jo index ir negatīvs"));
		}
		
		if(index >= howManyElements) {
			throw (new Exception("Nevar atgreizt elementu, jo index ir lielāks vai vienāds ka elementu skaits"));
		}
		
		return list[index];
		
	}
	
	//TODO mājās partaisīt funkciju, lai var atrast elmentu vairākas vietas un visas pozīcijas atgriež
	public int search(Ttype element) throws Exception {
		if(isEmpty()) {
			throw (new Exception("Saraksts ir tukšs, tāpēc nevar sameklēt elementu"));
		}
		
		for(int i = 0; i < howManyElements; i++) {
			if(list[i].equals(element)) {
				return i;
			}
		}
		
		throw (new Exception("Meklētais elements nav atrasts"));
		
	}
	//TODO mājās uztaisīt iespēju, ka element ir vairākas pozīcijās un viņu next elementi arī ir vairāki
	public Ttype getNextElement(Ttype element)  throws Exception {
		int indexOfSearchElement = search(element);
		
		if(indexOfSearchElement == howManyElements-1) {//ja meklētais elements ir pēdējais, tad viņam nebūs next elements
			throw (new Exception("Jūsu ievadītais elements ir atrasts kā pēdejais un aiz viņa nav nākamais elements"));
		}
		
		int indexForNextElement = indexOfSearchElement + 1;
		return list[indexForNextElement];
		
	}
	
	public void sort() {
		for(int i = 0 ; i < howManyElements; i++) {
			for(int j = 0; j < howManyElements; j++) {
				if(((Comparable)list[i]).compareTo(list[j]) == -1) {
					Ttype temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
	
	public void makeEmpty() {
		list = null;//pazuadē referenci uz datiem, tādā veida dzesot datus
		System.gc();
		howManyElements = 0;
		size = DEFAULT_SIZE;
		list = (Ttype[]) new Object[size];
	}
	
	
	
	
	
	
	
	

}
