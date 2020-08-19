/**
 * 
 */
package view;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;

import controller.DhcpController;

/**
 * @author Humbert Meyers
 *
 */
public class SerieTemps {
	
	public LocalTime eventTemps;
	private ArrayList<String> timeList = new ArrayList<String>();
	

	/**
	 * 
	 */
	public SerieTemps() {
		
	}
	
	public void addEvent(String temps){
		this.eventTemps = LocalTime.now();
		timeList.add(eventTemps.toString());
		timeList.add(temps);
		//System.out.println(timeList);
	}
	
	public ArrayList<String> getEventList() {
		return timeList;
	}
	public String toString(){
		String eventString="";
		eventString += "ArrayList composée de :\n";
		for(int i=0;i<timeList.size();i++){
			eventString += "Event : "+ timeList.get(i)+"\n";
		}
		//System.out.println(eventString);
		return eventString;
	}
}
