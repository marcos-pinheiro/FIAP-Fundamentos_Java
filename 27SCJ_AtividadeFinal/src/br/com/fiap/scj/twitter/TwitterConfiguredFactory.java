package br.com.fiap.scj.twitter;

import java.util.ResourceBundle;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public final class TwitterConfiguredFactory {
	
	static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("twitter-config");
	static final String ACCESS_TOKEN;
	static final String ACCESS_SECRET;
	static final String CONSUMER_KEY;
	static final String CONSUMER_SECRET;
	static {
		ACCESS_TOKEN 	= RESOURCE_BUNDLE.getString("accessToken");
		ACCESS_SECRET 	= RESOURCE_BUNDLE.getString("accessSecret");
		CONSUMER_KEY 	= RESOURCE_BUNDLE.getString("consumerKey");
		CONSUMER_SECRET = RESOURCE_BUNDLE.getString("consumerSecret");
	}
	
	
	private static Configuration configure() {
		
		final ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey(CONSUMER_KEY);
		builder.setOAuthConsumerSecret(CONSUMER_SECRET);
		
		return builder.build();
	}
	
	public static Twitter getInstance() {
		final Twitter twitter = new TwitterFactory(configure()).getInstance();
		twitter.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN, ACCESS_SECRET));
		
		return twitter;
	}
	
}
