package nl.saxion.twitter_client.objects;

import java.util.ArrayList;
/**
 * The Entity
 * @author Sharon and Dennis
 *
 */
public class Entity {

	private ArrayList<Url> urlList = new ArrayList<Url>();
	
	/**
	 * Add an url to the arraylist urlList
	 * @param url
	 */
	public void addUrl(Url url) {
		urlList.add(url);
	}
	
	/**
	 * Remove an url from the arrayList urlList
	 * @param url
	 */
	public void removeUrl(Url url) {
		urlList.remove(url);
	}
}
