package br.com.fiap.scj;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import br.com.fiap.scj.twitter.TwitterApplicationImpl;

public class Application {
	
	//Quantidade de Tweets da ultima semana usando Executor Service
	public Map<DayOfWeek, Integer> quantidadeDeTweetsDaUltimaSemana(String hashtag) throws InterruptedException {
				
		final Map<DayOfWeek, Integer> map = new ConcurrentHashMap<>();
		final ExecutorService executor = Executors.newCachedThreadPool();
		final LocalDate today = LocalDate.now();
		
		for(int i = 0; i < 7; i++) {
			final LocalDate date = today.minusDays(i);
			executor.submit(() -> {
				
				try {
					map.put(date.getDayOfWeek(), TwitterApplicationImpl.newInstance()
							.withHashTag(hashtag)
							.searchTweetsBetween(date.minusDays(1), date)
							.collect()
							.size());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}); 
		}
		executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);
		
		return Collections.unmodifiableMap(map);
	}
	
	
	//Quantidade de Retweets da ultima semana usando Threads e Runnables
	public Map<DayOfWeek, Integer> quantidadeDeRetweetsDaUltimaSemana(String hashtag) throws InterruptedException {
		
		final Map<DayOfWeek, Integer> map = new ConcurrentHashMap<>();
		final LocalDate today = LocalDate.now();
		final Deque<Thread> stack = new ArrayDeque<>(7);
		
		for(int i = 0; i < 7; i++) {
			final LocalDate date = today.minusDays(i);
			stack.push(new Thread(() -> {
				try {
					map.put(date.getDayOfWeek(), TwitterApplicationImpl.newInstance()
							.withHashTag(hashtag)
							.searchAndCountRetweetsBetween(date.minusDays(1), date));
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}));
		}
		
		stack.forEach(Thread::start);
		
		do {
			stack.pop().join();			
		} while(! stack.isEmpty());
		
		return Collections.unmodifiableMap(map);
	}
	
	
	//Quantidade de Favorites da ultima semana usando Threads e Runnables
	public Map<DayOfWeek, Integer> quantidadeDeFavoritesDaUltimaSemana(String hashtag) throws InterruptedException {
		
		final Map<DayOfWeek, Integer> map = new ConcurrentHashMap<>();
		final LocalDate today = LocalDate.now();
		final Deque<Thread> stack = new ArrayDeque<>(7);
		
		for(int i = 0; i < 7; i++) {
			final LocalDate date = today.minusDays(i);
			stack.push(new Thread(() -> {
				try {
					map.put(date.getDayOfWeek(), TwitterApplicationImpl.newInstance()
							.withHashTag(hashtag)
							.searchAndCountFavoritesBetween(date.minusDays(1), date));
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}));
		}
		
		stack.forEach(Thread::start);
		
		do {
			stack.pop().join();			
		} while(! stack.isEmpty());
		
		return Collections.unmodifiableMap(map);
	}
	
}

