import java.util.Scanner;
import java.util.*;

class homework3Part2{
	public static void main(String[] args){
		//ArrayList<String> name = new ArrayList<String>();
		//ArrayList<Integer> grade = new ArrayList<Integer>();
		HashMap<String,Integer> hash = new HashMap<String,Integer>();
		int option = 0;
		do{
			System.out.println("1)��J�ǥͦ��Z 2)�ΦW�r�d�ߦ��Z 3)�L�X 4)�h�X");
			Scanner keyInt = new Scanner(System.in);
			Scanner keyStr = new Scanner(System.in);
			if(keyInt.hasNextInt())
				option = keyInt.nextInt();
			else
				continue;
			switch(option)
			{
				case 1:
					System.out.println("��J�ǥͦW�r : ");
					String n = keyStr.nextLine();
					Scanner keyI = new Scanner(System.in);
					int g = -1;
					
					while(g < 0 || g > 100)
					{
							System.out.println("��J�ǥͦ��Z : ");
							g = keyI.nextInt();
							
							
					}
					//name.add(n);
					//grade.add(g);
					hash.put(n,g);
					break;
				case 2:
					System.out.println("��J�ǥͦW�r : ");
					n = keyStr.nextLine();
					if(hash.get(n) == null)
						System.out.println("����즹�H!\n");
					else
						System.out.println("���� : " + hash.get(n));
					break;
				case 3:
					for(Object k : hash.keySet())
					{
						System.out.println(k + " : " + hash.get(k));
					}
					break;
			}
		}while(option != 4);
	}
}