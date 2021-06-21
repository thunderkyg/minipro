package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class PhoneBookApp {

	public static void main(String[] args) throws IOException {

		//스캐너
		Scanner input = new Scanner(System.in);
		
		//시작
		System.out.println("****************************************");
		System.out.println("*       전화번호 관리 프로그램         *");
		System.out.println("****************************************");
		
		// Input Stream
		InputStream is = new FileInputStream("C:\\javaStudy\\workspace\\minipro\\미니프로젝트\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//Output Stream
		
		//ListArray
		List<PhoneBook> pArray = new ArrayList<PhoneBook>();
		
		// text 파일 읽기 반복문
		String data;
		while (true) {
			data = br.readLine();
			if (data == null) {
				break;
			}
			String[] phoneInfo = data.split(",");
			String name = phoneInfo[0];
			String hp = phoneInfo[1];
			String company = phoneInfo[2];
			pArray.add(new PhoneBook(name, hp, company));
		}
		
		//반복문
		while(true) {
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("----------------------------------------");
			System.out.print(">메뉴번호: ");
			String num = input.nextLine();
			int i = 1;
			//리스트
			if("1".equals(num)) {
				System.out.println("<1.리스트>");
				for(PhoneBook list : pArray) {
					System.out.println(i + ". " + list.showInfo());
					i++;
				}
				System.out.println();
			//등록
			} else if("2".equals(num)) {
				System.out.println("<2.등록>");
				System.out.print(">이름: ");
				String name = input.nextLine();
				System.out.print(">휴대전화: ");
				String hp = input.nextLine();
				System.out.print(">회사전화: ");
				String company = input.nextLine();
				pArray.add(new PhoneBook(name, hp, company));
				System.out.println("[등록되었습니다.]");
				System.out.println();
			//삭제
			} else if("3".equals(num)) {
				System.out.println("<3. 삭제>");
				System.out.print(">번호: ");
				int delete = input.nextInt();
				delete--;
				pArray.remove(delete);
				System.out.println("[삭제되었습니다.]");
				System.out.println();
			//검색
			} else if("4".equals(num)) {
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				String search = input.nextLine();
				for(PhoneBook list : pArray) {
					if(list.getName().contains(search))
					System.out.println(i + ". " + list.showInfo());
					i++;
				}
			//종료
			} else if("5".equals(num)) {
				break;
			//잘못된번호
			} else {
				System.out.println("[다시 입력해주세요]");
				System.out.println();
			}
			
		}
		System.out.println("****************************************");
		System.out.println("*             감사합니다               *");
		System.out.println("****************************************");

		input.close();
		br.close();
		
	}

}
