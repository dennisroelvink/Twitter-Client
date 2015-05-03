package nl.saxion.twitter_client.model;


import android.app.Application;

public class TweetApplication extends Application{

	private Model model;
	
	public TweetApplication(){
		this.model = new Model();
	}

	public Model getModel(){
		return model;
	}
}
