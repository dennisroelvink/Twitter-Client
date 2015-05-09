package nl.saxion.twitter_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import nl.saxion.twitter_client.model.Model;
import nl.saxion.twitter_client.model.TweetApplication;
import nl.saxion.twitter_client.objects.Tweet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The TweetAdapter class
 * @author Sharon and Dennis
 *
 */
public class TweetAdapter extends ArrayAdapter<Tweet> implements Observer{

	private LayoutInflater inflater;
	private Model model;
	private Bitmap bitmap;
	private String url = "";
	
	public TweetAdapter(Context context, int resource, List<Tweet> objects) {
		super(context, resource, objects);
		
		TweetApplication app = (TweetApplication) getContext().getApplicationContext();
		model = app.getModel();
		inflater = LayoutInflater.from(context);
	}
	
	/**
	 * Updates the listview for every position
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = inflater.inflate(R.layout.tweet, parent,false);
		
		Tweet tweet  = getItem(position);
		
		TextView tweetmsg = (TextView)convertView.findViewById(R.id.textViewTweetMessage);
		TextView userName = (TextView)convertView.findViewById(R.id.textViewUserName);
		TextView name = (TextView) convertView.findViewById(R.id.textViewName);
		ImageView profilePhoto = (ImageView) convertView.findViewById(R.id.imageViewProfilePhoto);
		
		
		tweetmsg.setText(tweet.getText());
		userName.setText(tweet.getUser().getUserName());
		name.setText(" (" +tweet.getUser().getName() + ")");
		url = tweet.getUser().getProfilePhotoUrl();
		
		new URLHandler().execute();
		profilePhoto.setImageBitmap(bitmap);
		return convertView;
		
	}
	

	/**
	 * Updates the class as soon as the observable is changed
	 */
	@Override
	public void update(Observable observable, Object data) {
		notifyDataSetChanged();
		
	}

	/**
	 * The URLHandler class
	 * @author Sharon and Dennis
	 * 
	 * Handles the exception which occurred when converting the url into an imageview
	 */
	private final class URLHandler extends AsyncTask<Void,Void,Void> {

		@Override
		protected Void doInBackground(Void... params) {
			try {
				URL Imageurl = new URL(url);
				bitmap = BitmapFactory.decodeStream(Imageurl.openConnection().getInputStream());
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException r) {
				r.printStackTrace();
			}
			
			return null;
		}
		
	}
}
