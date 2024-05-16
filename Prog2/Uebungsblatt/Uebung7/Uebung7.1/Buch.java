//package collection2.bibliothek2;

public class Buch implements Comparable<Buch> {
	
	private final String  isbn, autor, titel;
	private float preis;

	public Buch(String isbn, String autor, String titel, float preis) {
		super();
		this.isbn = isbn;
		this.autor = autor;
		this.titel = titel;
		this.preis = preis;
	}
	
	public float getPreis() {
		return preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}

	
	
	public int compareTo(Buch b) {
		return this.isbn.compareTo(b.isbn);
	}
	
	
	public String getIsbn() {
		return isbn;
	}

	public String getAutor() {
		return autor;
	}
	
	public String getTitel() {
		return titel;
	}
	
	public String toString() {
		return String.format("%s",autor) + " " + String.format("\"%s\"", titel)+ " " 
	                 + String.format("%s", isbn) + " " + String.format("%.1f", preis);
	}
	
	

}
