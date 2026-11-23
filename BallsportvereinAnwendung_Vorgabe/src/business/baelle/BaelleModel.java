package business.baelle;

import java.io.*;

public class BaelleModel {
 	
	//Singleton
	private static BaelleModel theInstance = null;
	
	private Ball[] baelle = new Ball[100];
	private int anzahlBaelle;
	
	//Konstruktor
	private BaelleModel() {	}
	
	//Singleton Methode
	public static BaelleModel getInstance() {
		if (theInstance == null) {
			theInstance = new BaelleModel();
		}
		return theInstance;
	}
	
	
	
	//Methoden
	private int getAnzahlBaelle() {
		return anzahlBaelle;
	}
	
	private void setAnzahlBaelle(int anzahlBaelle) {
		this.anzahlBaelle = anzahlBaelle;
	}

	/**
	 * gibt ein Array zurueck, der alle vorhandenen Baelle enthaelt.
	 * Die Laenge des Arrays entspricht der Anzahl der vorhandenen Baelle.
	 * @return Array mit Baellen
	 */
	public Ball[] holeBaelle() {
		Ball[] result = new Ball[this.getAnzahlBaelle()];
		for(int i = 0; i < result.length; i++) {
			result[i] = this.baelle[i];
		}
		return result;
	}
	
	public Ball gibBall(String einkaufsdatum) {
		Ball ball = null;
		int i = 0;
		while (ball == null && i < this.getAnzahlBaelle()) {
			if(Integer.parseInt(einkaufsdatum) == this.holeBaelle()[i].getEinkaufsdatum()){
				ball = this.holeBaelle()[i];
			}
			i++;
		}
		return ball;
	}

	// Die Fabrik-Methode wurde zum Lesen aus der CsvDatei nicht angewendet
	public void leseBaelleAusDatei()
	    throws Exception{
	    BufferedReader ein = new BufferedReader(new FileReader("Baelle.csv"));
	   	for(int i = 0; i < this.getAnzahlBaelle(); i++) {
	   	 	this.baelle[i] = null;
	   	}
	   	this.setAnzahlBaelle(Integer.parseInt(ein.readLine()));
	   	String[] zeile;
	   	for(int i = 0; i < this.getAnzahlBaelle(); i++) {
	   		zeile = ein.readLine().split(";");
	   		this.baelle[i] = new Ball(
	   			Integer.parseInt(zeile[0]), 
	   			zeile[1], zeile[2], zeile[3], zeile[4], 
	   			Double.parseDouble(zeile[5]));
	   	}
	    ein.close();
 	}

}