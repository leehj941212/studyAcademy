package memberProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MemberDAO {
    static HashMap <String, MemberDTO> memberHash = new HashMap <String, MemberDTO> ();
    HashMap<String, MemberDTO> members = getMember();
    static int memberRank = 0;	// 회원 등수

    public static HashMap<String, MemberDTO> getMember() {
        File info = new File("MemberDTO.txt");
        FileInputStream fis = null;
        String data = null;
        try{
            fis = new FileInputStream(info);
            byte[] b = new byte[fis.available()];
            while(fis.read(b) != -1) {
            }
            System.out.println(b);
            data = new String(b);
        } catch (IOException e) {
            System.out.println("...");
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] splitRN = data.split("\r\n");  // "\r\n" 사람 단위로 끊어서 읽기 위해서. output할때 마지막에 써준거네.
        // split은 ()안의 것을 기준으로 끊어준다는 메소드 인거네.
        /** 	split(String regex)
         Splits this string around matches of the given regular expression.*/     //split메소드..

        for(int i=0; i < splitRN.length; i++)        //splitRN 배열 0번에 저장되는 건 홍길동의 정보들, 1번에 저장되는 건 박지성의 정보들
        {                                               // splitRN에 저장된 사람 한줄을 가져옴
            MemberDTO member = new MemberDTO();                 // MemberDTO에 저장하기 위해 객체를 생성
            String[] splitSlash = splitRN[i].split("/"); //  splitRN에서 가져온 사람 한줄을 가져와서 새배열 splitSlash에 하나하나 저장
            for(int j=0; j < splitSlash.length; j++)
            {
                if(j==0) member.setMemberId(splitSlash[j]);
                if(j==1) member.setPassword(splitSlash[j]);
                if(j==2) member.setMailAdress(splitSlash[j]);
                if(j==3) member.setMemberName(splitSlash[j]);
                if(j==4) member.setBirthDate(splitSlash[j]);
                if(j==5) member.setPhoneNum(splitSlash[j]);
                if(j==6) member.setGender(splitSlash[j]);
                if(j==7) member.setKorGrade(splitSlash[j]);
                if(j==8) member.setEngGrade(splitSlash[j]);
                if(j==9) member.setMathGrade(splitSlash[j]);
                if(j==10) member.setAverage(splitSlash[j]);
            }
            memberHash.put(member.getMemberId(), member);       //괄호안에들어간 내용은 key값  쉼표하고 key에 연결될 value값으로 member Hashmap에 키값이랑 밸류값을 입력해준거야.
            memberHash.put(member.getMemberName(),member);
        }
        return memberHash;     // LoginWindow에서 login버튼 누를 때 이벤트 연결 시키는 데에서 getMember메소드를 호출하니까 거기로 memberHash를 리턴 보낸다는 뜻
    }

	/* text에서 가져온 데이터 전체를 hashMap으로 리턴 */
	public static HashMap<String, MemberDTO> getAllMemeber()
	{
		FileInputStream fi = null;
		HashMap<String, MemberDTO> memberHash = new HashMap<String, MemberDTO>();
		
		try {
			
			fi = new FileInputStream("memberDTO.txt");
			
			byte[] allByte = new byte[fi.available()];
			
			while(fi.read(allByte) != -1) {}
			
			String allMember = new String(allByte);
			
			String[] splitRN = allMember.split("\r\n");
			for(int i=0; i<splitRN.length; i++)
			{
				MemberDTO member = new MemberDTO();
				String[] splitSlash = splitRN[i].split("/");
				for(int j=0; j<splitSlash.length; j++)
				{
					if(j==0) member.setMemberId(splitSlash[j]);
					else if(j==1) member.setPassword(splitSlash[j]);
					else if(j==2) member.setMailAdress(splitSlash[j]);
					else if(j==3) member.setMemberName(splitSlash[j]);
					else if(j==4) member.setBirthDate(splitSlash[j]);
					else if(j==5) member.setPhoneNum(splitSlash[j]);
					else if(j==6) member.setGender(splitSlash[j]);
					else if(j==7) member.setKorGrade(splitSlash[j]);
					else if(j==8) member.setEngGrade(splitSlash[j]);
					else if(j==9) member.setMathGrade(splitSlash[j]);
					else if(j==10) member.setAverage(splitSlash[j]);
				}
				memberHash.put(member.getMemberId(), member);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return memberHash;
	}

}
