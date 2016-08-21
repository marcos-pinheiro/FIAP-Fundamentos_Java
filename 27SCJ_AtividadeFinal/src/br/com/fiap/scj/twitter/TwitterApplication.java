package br.com.fiap.scj.twitter;

import java.time.LocalDate;
import java.util.List;

public interface TwitterApplication {
	
	public TwitterApplication withHashTag(String hashtag);
	
	public TwitterApplication searchTweetsBetween(LocalDate since, LocalDate until) throws Exception;
	
	public void tweet(String text) throws Exception;
	
	public void tweetFor(String user, String text) throws Exception;
	
	public int searchAndCountFavoritesBetween(LocalDate since, LocalDate until) throws Exception;
	
	public int searchAndCountRetweetsBetween(LocalDate since, LocalDate until) throws Exception;
	
	public List<Tweet> collect();	
}
