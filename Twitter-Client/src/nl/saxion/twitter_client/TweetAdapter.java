package nl.saxion.twitter_client;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import nl.saxion.twitter_client.model.Model;
import nl.saxion.twitter_client.model.TweetApplication;
import nl.saxion.twitter_client.objects.Tweet;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TweetAdapter extends ArrayAdapter<Tweet> implements Observer{

	private LayoutInflater inflater;
	private Model model;
	
	public TweetAdapter(Context context, int resource, List<Tweet> objects) {
		super(context, resource, objects);
		
		TweetApplication app = (TweetApplication) getContext().getApplicationContext();
		model = app.getModel();
		
		inflater = LayoutInflater.from(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = inflater.inflate(R.layout.tweet, parent,false);
		
		Tweet tweet  = getItem(position);
		
		TextView tweetmsg = (TextView)convertView.findViewById(R.id.textViewTest);
		TextView user = (TextView)convertView.findViewById(R.id.textViewName);
		
		tweetmsg.setText(tweet.getText());
		user.setText(tweet.getUserString());
		
		return convertView;
	}

	@Override
	public void update(Observable observable, Object data) {
		notifyDataSetChanged();
		
	}

}
