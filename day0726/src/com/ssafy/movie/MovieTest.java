package com.ssafy.movie;

import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {
		MovieMgr mm = MovieMgr.getInstance();
		
		Scanner sc = mm.sc;
		
		int option = -1;
		mm.add(new Movie("기생충", "봉준호", 5, "스릴러", "기생해서 산다."));
		mm.add(new Movie("라이온킹", "라이온", 3, "다큐", "어흥"));
		mm.add(new Movie("알라딘", "지니", 5, "판타지", "마법의 양탄자"));
		mm.add(new Movie("스파이더맨", "피터", 2, "판타지", "피터 찌리릿"));
		while(option!=0) {
			System.out.println("<<< 영화 관리 프로그램 >>>");
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영화 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 영화 장르별 검색");
			System.out.println("5. 영화 정보 삭제");
			System.out.println("0. 종료");
			System.out.println("원하는 번호를 선택하세요 ==> ");
			option = sc.nextInt();
			sc.nextLine();
			
			switch (option) {
				case 0:
					break;
				case 1:
					System.out.println("제목 감독 평점 장르 요약 순으로 입력해주세요");
					mm.add(mm.setInfo());
					break;
				case 2:
					mm.print(mm.search());
					break;
				case 3:
					System.out.println("찾는 영화의 제목을 입력해주세요 : ");
					mm.print(mm.search(sc.next()));
					break;
				case 4:
					System.out.println("찾는 영화 장르를 입력해주세요 : ");
					mm.print(mm.searchGenre(sc.next()));
					break;
				case 5:
					System.out.println("삭제할 영화 제목을 입력해주세요");
					mm.delete(sc.next());
					break;
				default:
					System.err.println("입력범위 초과!! 다시 입력해주세요!!");
					break;
			}
			
		}
	}
}
