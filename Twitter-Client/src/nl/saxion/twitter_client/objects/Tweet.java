package nl.saxion.twitter_client.objects;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

/**
 * The Tweet class
 * @author Sharon and Dennis
 *
 */
public class Tweet {
	
	private ArrayList<Hashtag> hashtagList;
	private String text;
	private long tweetID;
	private User user;
	
	public Tweet(String text, User user, ArrayList<Hashtag> list) {
		this.text = text;
		this.user = user;
		hashtagList = list;
	}

	public int getHashtagListSize() {
		return hashtagList.size();
	}
	public Hashtag getHashtagAtPosition(int pos) {
		return hashtagList.get(pos);
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the tweetID
	 */
	public long getTweetID() {
		return tweetID;
	}

	/**
	 * @param tweetID the tweetID to set
	 */
	public void setTweetID(long tweetID) {
		this.tweetID = tweetID;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


	
}
