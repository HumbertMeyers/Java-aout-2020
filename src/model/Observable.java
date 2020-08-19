/**
 * 
 */
package model;

/**
 * @author OpenClassroom 
 * https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/25552-structurez-mieux-votre-code-avec-le-pattern-mvc
 */

public interface Observable {
  public void addObserver(Observer obs);
  public void removeObserver();
  public void notifyObserver(String str);
}