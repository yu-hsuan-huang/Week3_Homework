import java.util.Scanner;
import java.util.*;

class homework3Part1{
	public static void main(String[] args){
		ArrayList<String> aList = new ArrayList<String>();
		int count = 0;
		
		System.out.println("請輸入一段英文句子 : ");
		Scanner keyin = new Scanner(System.in);
		String str = keyin.nextLine();
		
		str = str.toLowerCase();//轉小寫
		String[] token = str.split(" |\\.|,|;|!|\\?|-|_");//切割
		
		for(String k : token)
		{
			if(k.length() > 0){
				try
				{
					int t = Integer.parseInt(k);
					count += t;
				}
				catch(Exception e)
				{
					aList.add(k);
				}
			}
		}
		
		for(String k : aList)
		{
			System.out.println(k);
		}
		System.out.println("count = " + count);
		
	}
}