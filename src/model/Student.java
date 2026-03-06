package model;

public class Student implements Comparable<Student> {
	//1. mainīgie
	private long stID;
	private String name;
	private String surname;
	private static long counter = 1;//palīgmainīgais, kam nav jataisa set un get funkcijas.
	
	
	
	//2. get funkcijas
	public long getStID() {
		return stID;
	}
	
	public String getName(){
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	//3. set funkcijas
	public void setStID() {
		stID = counter;
		counter = counter + 1;
	}
	
	public void setName(String inputName) {
		//veicam pāŗbaudi ienākošajiem datiem jeb inputName
		if(inputName.matches("[A-Z]{1}[a-z]{2,40}")) {//ja ievades dati ir String, tad ar matches un refgex japārbauda
			name = inputName;//ja regex formāts ir true
		}
		else {
			name = "Test name";//ja nav pēc regex formāta
		}
		
	}
	
	public void setSurname(String inputSurname) {
		//veicam pāŗbaudi ienākošajiem datiem jeb inputSurname
		if(inputSurname.matches("[A-Z]{1}[a-z]{2,40}")) {//ja ievades dati ir String, tad ar matches un regex japārbauda
			surname = inputSurname;//ja regex formāts ir true
		}
		else {
			surname = "Test surname";//ja nav pēc regex formāta
		}
		
	}
	
	//4. bezargumenta konstruktors
	public Student() {
		setStID();
		setName("Kaspars");
		setSurname("Berzins");
	}
	//5. argumenta konstruktors
	public Student(String inputName, String inputSurname) {
		setStID();
		setName(inputName);
		setSurname(inputSurname);
	}
	//6. toString funkcija
	public String toString() {
		String result = stID + ": " + name + " " + surname;//1: Kaspars Berzins
		return result;
	}
	//7. papildus funkcijas (ja nepieciešams)

	@Override
	public int compareTo(Student arg0) {
		if(this.surname.charAt(0) > arg0.surname.charAt(0))
		{
			return -1;
		}
		else if(this.surname.charAt(0) < arg0.surname.charAt(0)) {
			return 1;
		}
		else
		{
			return 0;
		}
	}
}