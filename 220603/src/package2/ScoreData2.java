package package2;
//성적
//ArrayList 4개 생성
//각 ArrayList로 이름 , java 점수 , web 점수 , jsp 점수를 각각 저장한다

import java.util.ArrayList;

class ScoreData2 {
	private String name;
	private int java;
	private int web;
	private int jsp;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getWeb() {
		return web;
	}
	public void setWeb(int web) {
		this.web = web;
	}
	public int getJsp() {
		return jsp;
	}
	public void setJsp(int jsp) {
		this.jsp = jsp;
	}
	
}
