package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class PhoneBookApp {

	public static void main(String[] args) throws IOException {

		// 스캐너
		Scanner input = new Scanner(System.in);

		// 시작
		System.out.println("****************************************");
		System.out.println("*       전화번호 관리 프로그램         *");
		System.out.println("****************************************");

		// Input Stream
		InputStream is = new FileInputStream("C:\\javaStudy\\workspace\\minipro\\미니프로젝트\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		// Writer

		// ListArray
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

		Boolean loop = true;
		// 반복문
		while (loop) {
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("----------------------------------------");
			System.out.print(">메뉴번호: ");
			int num = input.nextInt();
			// 리스트
			switch (num) {
			case 1: {
				System.out.println("<1.리스트>");
				for (int i = 0; i < pArray.size(); i++) {
					System.out.println(i + 1 + ". " + pArray.get(i).showInfo());
				}
				System.out.println();
				break;
			}
			case 2: {
				System.out.println("<2.등록>");
				System.out.print(">이름: ");
				String name = input.next();
				System.out.print(">휴대전화: ");
				String hp = input.next();
				System.out.print(">회사전화: ");
				String company = input.next();
				pArray.add(new PhoneBook(name, hp, company));
				Writer wr = new FileWriter("C:\\javaStudy\\workspace\\minipro\\미니프로젝트\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(wr);
				for (PhoneBook list : pArray) {
					bw.write(list.getName() + "," + list.getHp() + "," + list.getCompany());
					bw.newLine();
					bw.flush();
					;
				}
				bw.close();
				System.out.println("[등록되었습니다.]");
				System.out.println();
				break;
			}
			case 3: {
				System.out.println("<3. 삭제>");
				System.out.print(">번호: ");
				int delete = input.nextInt();
				delete--;
				pArray.remove(delete);
				Writer wr = new FileWriter("C:\\javaStudy\\workspace\\minipro\\미니프로젝트\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(wr);
				for (PhoneBook list : pArray) {
					bw.write(list.getName() + "," + list.getHp() + "," + list.getCompany());
					bw.newLine();
					bw.flush();
					;
				}
				bw.close();
				System.out.println("[삭제되었습니다.]");
				System.out.println();
				break;
			}
			case 4: {
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				String search = input.next();
				for (int i = 0; i < pArray.size(); i++) {
					if (pArray.get(i).getName().contains(search)) {
						System.out.println(i + 1 + ". " + pArray.get(i).showInfo());
					}
				}
				System.out.println();
				break;
			}
			case 5: {
				System.out.println();
				loop = false;
				break;
			}
			default:
				System.out.println("[다시 입력해주세요]");
				System.out.println();
				break;
			}

		}

		System.out.println("****************************************");
		System.out.println("*             감사합니다               *");
		System.out.println("****************************************");

		input.close();
		br.close();
	}
}
