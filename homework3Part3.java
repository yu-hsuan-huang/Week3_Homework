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
		catch(IOException e){//�ҥ~���p
			System.out.println("��Ū���ɮ�!\n");
		}
		

		do{
			System.out.println("1)��J�@�y�^��y�l 2)�d�ߥX�{���� 3)�L�X���G 4)�h�X : ");
			Scanner keyInt = new Scanner(System.in);
			Scanner keyStr = new Scanner(System.in);
			if(keyInt.hasNextInt())
				option = keyInt.nextInt();
			switch(option){
				case 1:
					System.out.println("�^��y�l : ");
					String str = keyStr.nextLine();
					str = str.toLowerCase();//��p�g
					String[] token = str.split(" |\\.|,|;|!|\\?|-|_");//����
					
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
					System.out.println("��J��r : ");
					String n1 = keyStr.nextLine();
					if(hash.get(n1) == null)
						System.out.println("����즹��r!\n");
					else
						System.out.println("�X�{���� : " + hash.get(n1));
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