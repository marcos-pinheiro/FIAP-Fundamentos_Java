package br.com.fiap.scj.twitter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Tweet {
	
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	
	private final String authorName;
	private final String content;
	private final LocalDateTime createdAt;
	
	public Tweet(String authorName, String content, LocalDateTime createdAt) {
		this.authorName = authorName;
		this.content = content;
		this.createdAt = createdAt;
	}
	
	
	public String getAuthorName() {
		return authorName;
	}
	
	public String getContent() {
		return content;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	@Override
	public String toString() {
		return "Nome = " + authorName + " \t\t\t\t Data = " + createdAt.format(DATE_PATTERN) + "]";
	}
}
