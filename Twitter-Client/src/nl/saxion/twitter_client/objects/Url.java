package nl.saxion.twitter_client.objects;

import java.util.ArrayList;
/**
 * The Url class
 * @author Sharon and Dennis
 *
 */
public class Url {
	
	private String url;
	private String expanded_url;
	private String display_url;
	private ArrayList<Integer> indices = new ArrayList<Integer>();
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the expanded_url
	 */
	public String getExpanded_url() {
		return expanded_url;
	}
	/**
	 * @param expanded_url the expanded_url to set
	 */
	public void setExpanded_url(String expanded_url) {
		this.expanded_url = expanded_url;
	}
	/**
	 * @return the display_url
	 */
	public String getDisplay_url() {
		return display_url;
	}
	/**
	 * @param display_url the display_url to set
	 */
	public void setDisplay_url(String display_url) {
		this.display_url = display_url;
	}
	/**
	 * @return the indices
	 */
	public ArrayList<Integer> getIndices() {
		return indices;
	}
	/**
	 * @param indices the indices to set
	 */
	public void setIndices(ArrayList<Integer> indices) {
		this.indices = indices;
	}
	

}
