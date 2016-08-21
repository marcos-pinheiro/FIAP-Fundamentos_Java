package br.com.fiap.scj;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import br.com.fiap.scj.twitter.Tweet;
import br.com.fiap.scj.twitter.TwitterApplication;
import br.com.fiap.scj.twitter.TwitterApplicationImpl;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Main {

	private static final String HASHTAG = "java9";

	static Application application = new Application();
	

	public static void main(String[] args) throws Exception {
		
		tweetsTest();
		
		retweetsTest();
		
		favoritesTest();
		
		sortTest();
		
		//tweetForTest();
	}
	

	private static void tweetsTest() throws Exception {
		System.out.print("\n**********| TWEETS |**********\n");

		Map<DayOfWeek, Integer> tweetsDaSemana = application.quantidadeDeTweetsDaUltimaSemana(HASHTAG);
		tweetsDaSemana.forEach((k, v) -> {
			System.out.println(k + " - " + v);
		});
	}

	private static void retweetsTest() throws Exception {
		System.out.print("\n*********| RETWEETS |*********\n");

		Map<DayOfWeek, Integer> retweetsDaSemana = application.quantidadeDeRetweetsDaUltimaSemana(HASHTAG);
		retweetsDaSemana.forEach((k, v) -> {
			System.out.println(k + " - " + v);
		});
	}
	
	private static void favoritesTest() throws Exception {
		System.out.print("\n*********| FAVORITES |*********\n");
	
		Map<DayOfWeek, Integer> favoritesDaSemana = application.quantidadeDeFavoritesDaUltimaSemana(HASHTAG);
		favoritesDaSemana.forEach((k, v) -> {
			System.out.println(k + " - " + v);
		});
	}
	
	private static void sortTest() throws Exception {
		
		final TwitterApplication twitterApplication = TwitterApplicationImpl.newInstance(); 
		final List<Tweet> tweets = twitterApplication
				.withHashTag(HASHTAG)
				.searchTweetsBetween(LocalDate.now().minusDays(1), LocalDate.now())
				.collect();

		System.out.print("\n********| SORT BY NAME |********\n");

		tweets.stream()
		.sorted((c1, c2) -> c1.getAuthorName().compareToIgnoreCase(c2.getAuthorName()))
		.forEach(System.out::println);



		System.out.print("\n********| SORT BY DATE |********\n");

		tweets.stream()
		.sorted((c1, c2) -> c1.getCreatedAt().compareTo(c2.getCreatedAt()) * -1)
		.forEach(System.out::println);
	}
	
	private static void tweetForTest() throws Exception {
		System.out.print("\n*********| TWEET FOR |*********\n");
		
		final TwitterApplication twitterApplication = TwitterApplicationImpl.newInstance();
		twitterApplication.tweetFor("@UsuarioQueVoceTemQueEstarSeguindo", "Mensagem");
	}

}









