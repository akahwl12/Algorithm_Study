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
	
//	��ȭ���� ����Ʈ
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
	
//	��ȭ ������ �Է¹޾� ������ ����
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
	
//	�Ķ���ͷ� ���޵� ��ȭ ������ �迭�� �����Ѵ�.
	public void add(Movie m) {
		if(index>=0 && index<=100)
			movies[index++] = m;
	}
	
//	���� ����� ��� ��ȭ ������ �����Ѵ�.
	public Movie[] search() {
		Movie[] tmp = new Movie[100];
		int idx = 0;
		for (int i = 0; i < movies.length; i++) {
			if(movies[i]!=null)
				tmp[idx++] = movies[i];
		}
		return tmp;
	}
	
//	�Ķ���ͷ� ���޵� Ÿ��Ʋ�� �����ϰ��ִ� ��� ��ȭ ������ �˻��Ͽ� ����
	public Movie[] search(String title) {
		Movie[] tmp = new Movie[100];
		int idx = 0;
		for (int i = 0; i < movies.length; i++) {
			if(movies[i]!=null && movies[i].getTitle().contains(title))
				tmp[idx++] = movies[i];
		}
		return tmp;
	}
	
//	�Ķ���ͷ� ���޵� �������� ��� ��ȭ ������ �˻��Ͽ� ����
	public Movie[] searchDirector(String name) {
		Movie[] tmp = new Movie[100];
		int idx = 0;
		for (int i = 0; i < movies.length; i++) {
			if(movies[i]!=null && movies[i].getDirector().equals(name))
				tmp[idx++] = movies[i];
		}
		return tmp;
	}
	
//	�Ķ���ͷ� ���޵� �帣�� ��� ��ȭ ������ �˻��Ͽ� ����
	public Movie[] searchGenre(String genre) {
		Movie[] tmp = new Movie[100];
		int idx = 0;
		for (int i = 0; i < movies.length; i++) {
			if(movies[i]!=null && movies[i].getGenre().equals(genre))
				tmp[idx++] = movies[i];
		}
		return tmp;
	}
	
//	�Ķ���ͷ� ���޵� ������ ��ȭ�� �����Ѵ�.
	public void delete(String title) {
		boolean check = false;
		for (int i = 0; i < movies.length; i++) {
			if(movies[i]!=null && movies[i].getTitle().equals(title)) {
				movies[i] = null;
				check = true;
			}
		}
		if(!check)
			System.out.println("�ش� ��ȭ�� �����ϴ�.");
	}
	
//	�迭�� ����� ��ȭ ����� �����Ѵ�.
	public int getSize() {
		int cnt=0;
		for (int i = 0; i < movies.length; i++) {
			if(movies[i]!=null)
				cnt++;
		}
		return cnt;
	}
}
