package nl.saxion.twitter_client.objects;

import java.util.ArrayList;

public class Entity {

	private ArrayList<Url> urlList = new ArrayList<Url>();
	
	public void addUrl(Url url) {
		urlList.add(url);
	}
	public void removeUrl(Url url) {
		urlList.remove(url);
	}
}
