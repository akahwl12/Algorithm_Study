package com.ssafy.movie;

import java.util.Scanner;

public class MovieMgr extends Movie {
	private static MovieMgr movieMgr = new MovieMgr();
	private MovieMgr() {};
	public static MovieMgr getInstance() {
		return movieMgr;
	}
	
	private Movie[] movies = new Movie[100];
	private int index=0;
	
	Scanner sc = new Scanner(System.in);
	
//	영화정보 프린트
	public void print(Movie[] m) {
		for (int i = 0; i < m.length; i++) {
			if(m[i]!=null)
				System.out.println(m[i].toString());
		}
		System.out.println();
	}
	
	public void print(Movie m) {
		System.out.println(m.toString());
		System.out.println();
	}
	
//	영화 정보를 입력받아 정보를 리턴
	public Movie setInfo() {
		Movie tmp = new Movie();
		
		tmp.setTitle(sc.next());
		tmp.setDirector(sc.next());
		tmp.setGrade(sc.nextDouble());
		sc.nextLine();
		tmp.setGenre(sc.next());
		tmp.setSummary(sc.next());
		
		return tmp;
	}
	
//	파라메터로 전달된 영화 정보를 배열에 저장한다.
	public void add(Movie m) {
		if(index>=0 && index<=100)
			movies[index++] = m;
	}
	
//	현재 저장된 모든 영화 정보를 리턴한다.
	public Movie[] search() {
		Movie[] tmp = new Movie[100];
		int idx = 0;
		for (int i = 0; i < movies.length; i++) {
			if(movies[i]!=null)
				tmp[idx++] = movies[i];
		}
		return tmp;
	}
	
//	파라메터로 전달된 타이틀을 포함하고있는 모든 영화 정보를 검색하여 리턴
	public Movie[] search(String title) {
		Movie[] tmp = new Movie[100];
		int idx = 0;
		for (int i = 0; i < movies.length; i++) {
			if(movies[i]!=null && movies[i].getTitle().contains(title))
				tmp[idx++] = movies[i];
		}
		return tmp;
	}
	
//	파라메터로 전달된 감독명의 모든 영화 정보를 검색하여 리턴
	public Movie[] searchDirector(String name) {
		Movie[] tmp = new Movie[100];
		int idx = 0;
		for (int i = 0; i < movies.length; i++) {
			if(movies[i]!=null && movies[i].getDirector().equals(name))
				tmp[idx++] = movies[i];
		}
		return tmp;
	}
	
//	파라메터로 전달된 장르의 모든 영화 정보를 검색하여 리턴
	public Movie[] searchGenre(String genre) {
		Movie[] tmp = new Movie[100];
		int idx = 0;
		for (int i = 0; i < movies.length; i++) {
			if(movies[i]!=null && movies[i].getGenre().equals(genre))
				tmp[idx++] = movies[i];
		}
		return tmp;
	}
	
//	파라메터로 전달된 제목의 영화을 삭제한다.
	public void delete(String title) {
		boolean check = false;
		for (int i = 0; i < movies.length; i++) {
			if(movies[i]!=null && movies[i].getTitle().equals(title)) {
				movies[i] = null;
				check = true;
			}
		}
		if(!check)
			System.out.println("해당 영화이 없습니다.");
	}
	
//	배열에 저장된 영화 대수를 리턴한다.
	public int getSize() {
		int cnt=0;
		for (int i = 0; i < movies.length; i++) {
			if(movies[i]!=null)
				cnt++;
		}
		return cnt;
	}
}
