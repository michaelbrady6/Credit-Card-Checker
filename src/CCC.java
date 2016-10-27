import java.io.*;
import java.util.*;

public class CCC
	{
		static long num = 0;
		static int ran = 0;
		public static void main(String[] args)throws IOException
			{
				Scanner file = new Scanner(new File("creditCardNumbers2.txt"));
				Scanner input = new Scanner(System.in);
				int total = 0;
				boolean a = true;
				long d2 = 0;
				int count = 0;
				System.out.println("How many numbers do you want?");
				int n = input.nextInt();
				ArrayList valid = new ArrayList<Long>();
				while (count < n )
					{
						random();
						valid.add(num);
//						long num = file.nextLong();
						for (int j = 0; j < 16; j++)
							{
								long d = num % 10;
								num = num/10;
								if(a == true)
									{
										total += d;
										a = false;
									}
								else
									{
										d = d*2;
										if (d > 9)
											{
												d2 = d % 10;
												d = d/10;
												d2 += d;
											}
										else
											{
												d2 = d;
											}
										total += d2;
										a = true;
									}
							}
						if (total % 10 == 0)
							{
								count++;
							}
						if (total % 10 != 0)
							{
								valid.remove(valid.size()-1);
							}
						total = 0;
					}
				for (int i = 0; i < valid.size(); i++)
					{
						if (valid.get(i).toString().length() < 16)
							{
								valid.remove(i);
								count--;
							}
						else
							{
								System.out.println(valid.get(i));
							}
					}
				System.out.println(count + " of these numbers are potentially valid");
			}
		public static void random()
		{
			for (int i = 0; i < 16; i++)
				{
					ran = (int) (Math.random()*9 + 1);
					num +=  ran * Math.pow(10, i);
				}
		}

	}
