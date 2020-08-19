/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author OpenClassroom 
 * https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/25552-structurez-mieux-votre-code-avec-le-pattern-mvc
 *
 */
public abstract class AbstractMVCModel implements Observable{

	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
  
	//Implémentation du pattern observer
	public void addObserver(Observer obs) {
		this.listObserver.add(obs);
	}

	public void notifyObserver(String str) {
		for(Observer obs : listObserver)
			obs.update(str);
	}

	public void removeObserver() {
		listObserver = new ArrayList<Observer>();
	}  
}