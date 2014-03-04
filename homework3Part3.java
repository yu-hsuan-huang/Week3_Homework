import java.util.Scanner;
import java.util.*;
import java.io.*;

class homework3Part3{
	public static void main(String[] args) throws IOException{
		HashMap<String,Integer> hash = new HashMap<String,Integer>();
		int option = 0,count = 0;
				
		try{
			FileReader fOpen = new FileReader("homework3Part3.txt");
			BufferedReader bufOpen = new BufferedReader(fOpen);
			
			String strTemp = bufOpen.readLine();
			count=Integer.parseInt(strTemp);
			//StringBuffer sb = new StringBuffer();
			while((strTemp = bufOpen.readLine()) != null){
				String[] token = strTemp.split(" |\\.|,|!|\\?|~|-|_");
				String word = token[0];
				int con = Integer.parseInt(token[1]);
				hash.put(word,con);
			}
			fOpen.close();
		}
		catch(IOException e){//例外狀況
			System.out.println("未讀到檔案!\n");
		}
		

		do{
			System.out.println("1)輸入一句英文句子 2)查詢出現次數 3)印出結果 4)退出 : ");
			Scanner keyInt = new Scanner(System.in);
			Scanner keyStr = new Scanner(System.in);
			if(keyInt.hasNextInt())
				option = keyInt.nextInt();
			switch(option){
				case 1:
					System.out.println("英文句子 : ");
					String str = keyStr.nextLine();
					str = str.toLowerCase();//轉小寫
					String[] token = str.split(" |\\.|,|;|!|\\?|-|_");//切割
					
					for(String k : token){
						if(k.length() > 0){
							try{
								int t = Integer.parseInt(k);
								count += t;
							}
							catch(Exception e){
								if(hash.get(k) == null)
									hash.put(k,1);
								else{
									int val = hash.get(k) + 1;
									hash.put(k,val);
								}
							}
						}
					}
					break;
				case 2:
					System.out.println("輸入單字 : ");
					String n1 = keyStr.nextLine();
					if(hash.get(n1) == null)
						System.out.println("未找到此單字!\n");
					else
						System.out.println("出現次數 : " + hash.get(n1));
					break;
				case 3:
					for(Object k : hash.keySet())
						System.out.println(k + " : " + hash.get(k));
					System.out.println("count = " + count);
					break;
				case 4:
					FileWriter fWrite = new FileWriter("homework3Part3.txt");
					BufferedWriter bufWite = new BufferedWriter(fWrite);
					String strVal = Integer.toString(count);
					bufWite.write(strVal);
					bufWite.newLine();
					for(Object k : hash.keySet()){
						bufWite.write(k + " " + hash.get(k));
						bufWite.newLine();
					}
					bufWite.flush();
					fWrite.close();
					break;
			}
		}while(option != 4);
	}
}