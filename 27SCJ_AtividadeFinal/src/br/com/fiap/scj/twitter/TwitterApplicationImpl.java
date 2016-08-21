package br.com.fiap.scj.twitter;

import static java.util.Objects.requireNonNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toCollection;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;


/**
 * @author Marcos Pinheiro
 *
 */
public final class TwitterApplicationImpl implements TwitterApplication {
	
	private final Twitter twitter;
	
	private String hashtag;
	private List<Tweet> tweets;
	
	
	private TwitterApplicationImpl() {
		twitter = TwitterConfiguredFactory.getInstance();
	}
	
	public static TwitterApplicationImpl newInstance() {
		return new TwitterApplicationImpl();
	}
	
	@Override
	public final TwitterApplicationImpl withHashTag(String hashtag) {
		this.hashtag = hashtag;
		return this;
	}

	@Override
	public TwitterApplicationImpl searchTweetsBetween(LocalDate since, LocalDate until) throws TwitterException {
		requireNonNull(hashtag, "Hashtag de pesquisa não pode ser nulo");
		
		this.tweets = new ArrayList<>();
		Query query = new Query(hashtag);
		
		query.setSince(localDateToString(since));
		query.setUntil(localDateToString(until));
		query.setResultType(Query.RECENT);

		QueryResult result = twitter.search(query);
		
		do {
			query = result.nextQuery();
			result.getTweets()
				.stream()
				.map(status -> new Tweet(
						status.getUser().getName(), 
						status.getText(),
						LocalDateTime.ofInstant(status.getCreatedAt().toInstant(), ZoneId.systemDefault())))
				.collect(toCollection(() -> tweets));			
			
			if(nonNull(query)) { result = twitter.search(query); }
		} while(result.hasNext());
				
		return this;
	}
	
	@Override
	public int searchAndCountRetweetsBetween(LocalDate since, LocalDate until) throws TwitterException {
		requireNonNull(hashtag, "Hashtag de pesquisa não pode ser nulo");
		
		Query query = new Query(hashtag);		
		query.setSince(localDateToString(since));
		query.setUntil(localDateToString(until));

		int totalCount = 0;		
		QueryResult result = twitter.search(query);
		do {
			query = result.nextQuery();
			totalCount += result.getTweets()
					.stream()
					.map(status -> status.getRetweetCount())
					.reduce((value1, value2) -> value1 + value2)
					.get();			
			
			if(nonNull(query)) { result = twitter.search(query); }
		} while(result.hasNext());

		return totalCount;
	}

	@Override
	public int searchAndCountFavoritesBetween(LocalDate since, LocalDate until) throws TwitterException {
		requireNonNull(hashtag, "Hashtag de pesquisa não pode ser nulo");
		
		Query query = new Query(hashtag);		
		query.setSince(localDateToString(since));
		query.setUntil(localDateToString(until));

		int totalCount = 0;		
		QueryResult result = twitter.search(query);
		do {
			query = result.nextQuery();
			totalCount += result.getTweets()
					.stream()
					.map(status -> status.getFavoriteCount())
					.reduce((value1, value2) -> value1 + value2)
					.get();			
			
			if(nonNull(query)) { result = twitter.search(query); }
		} while(result.hasNext());
		
		return totalCount;
	}
	
	@Override
	public void tweet(String text) throws TwitterException {
		twitter.updateStatus(text);
	}
	
	@Override
	public void tweetFor(String user, String text) throws TwitterException {
		twitter.sendDirectMessage(user, text);
	}
	
	@Override
	public List<Tweet> collect() {
		requireNonNull(this.tweets, "Não se pode coletar tweets sem efetuar uma busca anteriormente");
		return Collections.unmodifiableList(this.tweets);
	}
	
	private String localDateToString(LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
}
