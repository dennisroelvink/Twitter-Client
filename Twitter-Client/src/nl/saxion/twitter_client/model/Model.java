package nl.saxion.twitter_client.model;

import java.util.ArrayList;
import java.util.Observable;

import nl.saxion.twitter_client.objects.Tweet;
import nl.saxion.twitter_client.objects.User;

public class Model extends Observable {

	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	
	public void addTweet(Tweet tweet){
		tweetList.add(tweet);
	}
	
	public ArrayList<Tweet> getTweetList(){
		return tweetList;
	}
}
