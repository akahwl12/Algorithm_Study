package com.ssafy.movie;

public class Movie {
	protected String title;
	protected String director;
	protected double grade;
	protected String genre;
	protected String summary;
	public Movie() {
		this("", "", 0, "", "");
	}
	public Movie(String title, String director, double grade, String genre, String summary) {
		super();
		this.title = title;
		this.director = director;
		this.grade = grade;
		this.genre = genre;
		this.summary = summary;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
	public String toString() {
		return "제목 = " + title + ", 감독 = " + director + ", 평점 = " + grade + ", 장르 = " + genre
				+ ", 요약 = " + summary;
	}
}
