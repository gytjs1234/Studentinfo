package com.callor.student.service.impl;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.StudentService;
import com.callor.student.model.StudentVO;

public class StudentServiceImpl implements StudentService {
	protected String saveFileName;
	protected final Scanner scan;
	protected final List<StudentVO> scList;
	
	public StudentServiceImpl(String fileName){
		
		scan = new Scanner(System.in);
		scList = new ArrayList<>();
		saveFileName = "src/student.txt";

	}
	

	@Override
	public void inputStudent() {

		while (true) {
			System.out.print("학번입력받기(QUIT:종료) >> ");
			String stnum = scan.nextLine();
			if (stnum.equals("QUIT")){
				break;
			}

			System.out.print("이름 입력받기 >>");
			String stName = scan.nextLine();

			System.out.print("학과 입력받기 >>");
			String stdept = scan.nextLine();

			System.out.print("전화번호 입력받기 >>");
			String stTel = scan.nextLine();

			System.out.print("학년 입력받기 >>");
			String grade = scan.nextLine();
			Integer intgrade = Integer.valueOf(grade);
			
			
			StudentVO scVO = new StudentVO();
			scVO.setName(stName);
			scVO.setGrade(intgrade);
			scVO.setDept(stdept);
			scVO.setStnum(stnum);
			scVO.setTel(stTel);
			scList.add(scVO);

		}
		System.out.println("입력이 중단되었습니다");

	}

	@Override
	public void printstudent() {
		FileOutputStream fileOut = null;
		BufferedOutputStream buffer = null;

		try {
			fileOut = new FileOutputStream(saveFileName);
			buffer = new BufferedOutputStream(fileOut);
			for (StudentVO scVO : scList) {
				String writeStr = "";
				writeStr += String.format("%s:", scVO.getDept()+":");
				writeStr += String.format("%d:", scVO.getGrade()+":");
				writeStr += String.format("%d:", scVO.getName()+":");
				writeStr += String.format("%d\n", scVO.getStnum()+":");
				writeStr += String.format("%d\n", scVO.getTel()+":");
				buffer.write(writeStr.getBytes());
			} // end for
			buffer.flush();
			buffer.close();
			fileOut.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void saveStudent() {

		FileWriter fileWriter = null;
		PrintWriter print = null;

		try {
			fileWriter = new FileWriter(saveFileName);
			print = new PrintWriter(fileWriter);
			for (StudentVO scVO : scList) {
				
			print.printf("%s:", scVO.getDept());
			print.printf("%d:", scVO.getGrade());
			print.printf("%d:", scVO.getName());
			print.printf("%d\n", scVO.getStnum());
			print.printf("%d\n", scVO.getTel());
			} // end for
			print.close();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
