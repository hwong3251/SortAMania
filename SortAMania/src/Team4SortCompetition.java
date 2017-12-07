import java.util.Arrays;
import java.util.Random;

/*
 * Created by Hoi Lam Wong and Leon You
 */
public class Team4SortCompetition{
	public String greeting() {
		return null;
	}
	public static void main(String[]args)
	{
		long startTime, endTime, totalTime;
		
		//test1
		int[] test1 = new int[10000];
		for (int i = 0; i < test1.length; i++)
		{
			test1[i] = (int) Math.floor(Math.random()*10001);
		}
		//test2
		String[] test2 = new String[10000];
		for (int i = 0; i < test2.length;i++) 
		{
			String s = "";
			for (int j = 0; j < 5; j++)
			{
				Random r = new Random();
				char c = (char)(r.nextInt(26)+'a');
				s = s+c;
			}
			test2[i] = s;
		}
		
		//test3
		int[] test3 = new int[10000];
		for (int i = 0; i < test3.length; i++)
		{
			test3[i] = (int) Math.floor(Math.random()*10001);
		}
		
		//test4
		int[][]test4 = new int[10][10];
		for(int i = 0; i < test4.length; i++)
		{
			for(int j = 0; j< test4[i].length; j++)
			{
				test4[i][j] = (int) Math.floor(Math.random()*10001);
				System.out.print(test4[i][j]+" ");
			}
			System.out.println();
		}
		startTime = System.nanoTime();
		System.out.println(challengeOne(test1));
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("1) Time Take in nanoseconds: " + totalTime);
		
		startTime = System.nanoTime();
		System.out.println(challengeTwo(test2,"oihdw"));
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("2) Time Take in nanoseconds: " + totalTime);
		
		
		startTime = System.nanoTime();
		System.out.println(challengeThree(test3));
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("3) Time Take in nanoseconds: " + totalTime);
		
		startTime = System.nanoTime();
		System.out.println(challengeFour(test4));
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("4) Time Take in nanoseconds: " + totalTime);

	}
	public static int challengeOne(int[]arr)
	{
		insertionSort(arr);
		return getMedian(arr);
	}
	public static int challengeTwo(String[]arr, String query)
	{
		arr = mergeSort(arr);
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i]==query)
				return i;
		}
		return -1;
	}
	//Mostly Sorted
	public static int challengeThree(int[]arr)
	{
		bubbleSort(arr);
		return getMedian(arr);
	}
	public static int challengeFour(int[][] arr)
	{
		int[]nArr = new int[arr.length];
		int median = 0;
		for(int i = 0; i < arr.length; i++)
		{
			//merge array
			mergeSort(arr[i]);
			nArr[i] = getMedian(arr[i]);
		}
		//bubble sort
			boolean swap = true;
			while(swap)
			{
				int count = 0;
				for(int i = 0; i < nArr.length-1; i++)
				{
					if(nArr[i]>nArr[i+1])
					{
						int[]n = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = n;
						count++;
					}
				}
				if(count == 0)
				{
					swap = false;
				}
			}
		median = getMedian(nArr);
		return median;
	}
	public int challengeFive(Object[] arr, Object query)
	{
		return 0;
	}
	
/******************************************************************************************************************************************/
	//HELPER METHOD
	//merge
		public static String[]merge(String[]list1, String[]list2)
		{
			String[]newArr = new String[list1.length+list2.length];
			int i = 0;
			int j = 0;
			int x = 0;
			while(i < list1.length && j < list2.length)
			{
				if(list1[i].compareTo(list2[j]) < 0)
				{
					newArr[x]=list1[i];
					i++;
					x++;
				}
				else if(list1[i].compareTo(list2[j]) > 0)
				{
					newArr[x]=list2[j];
					j++;
					x++;
				}
				else if(list1[i].compareTo(list2[j]) == 0)
				{
					newArr[x] = list1[i];
					newArr[x+1] = list2[j];
					i++;
					j++;
					x+=2;
				}
			}
			if( i < list1.length)
			{
				for( int k = i;k < list1.length;k++)
				{
					newArr[x] = list1[k];
					x++;
				}
			}
			if( j < list2.length)
			{
				for( int k = j;k < list2.length;k++)
				{
					newArr[x] = list2[k];
					x++;
				}
			}
			return newArr;
		}
		public static int[] merge(int[]list1, int[]list2)
		{
			int[]newArr = new int[list1.length+list2.length];
			int i = 0;
			int j = 0;
			int x = 0;
			while(i < list1.length && j < list2.length)
			{
				if(list1[i] < list2[j])
				{
					newArr[x]=list1[i];
					i++;
					x++;
				}
				else if(list1[i] > list2[j])
				{
					newArr[x]=list2[j];
					j++;
					x++;
				}
				else if(list1[i] == list2[j])
				{
					newArr[x] = list1[i];
					newArr[x+1] = list2[j];
					i++;
					j++;
					x+=2;
				}
			}
			if( i < list1.length)
			{
				for( int k = i;k < list1.length;k++)
				{
					newArr[x] = list1[k];
					x++;
				}
			}
			if( j < list2.length)
			{
				for( int k = j;k < list2.length;k++)
				{
					newArr[x] = list2[k];
					x++;
				}
			}
			return newArr;
		}
		//mergeSort
		public static String [] mergeSort(String [] list)
		{
			if(list.length == 1)
			{
				return list;
			}
			else
			{
				String[]a1 = Arrays.copyOfRange(list, 0, list.length/2);
				String[]a2 = Arrays.copyOfRange(list, list.length/2, list.length);
				a1 = mergeSort(a1);
				a2 = mergeSort(a2);
				return merge(a1, a2);
			}
		}
		public static int[] mergeSort(int [] list)
		{
			if(list.length == 1)
			{
				return list;
			}
			else
			{
				int[]a1 = Arrays.copyOfRange(list, 0, list.length/2);
				int[]a2 = Arrays.copyOfRange(list, list.length/2, list.length);
				a1 = mergeSort(a1);
				a2 = mergeSort(a2);
				return merge(a1, a2);
			}
		}
		//partition
		public static int partition(int[]list,int front, int back)
		{
			int p = list[front];
			int l = front + 1;
			int r = back;
			while(l<r)
			{
				while(l<back&& list[l] < p)
				{
					l++;
				}
				while(r>front&& list[r] >= p)
				{
					r--;
				}
			}
			list[front] = list[r];
			list[r] = p;
			return p;
		}
		//insertion
		public static void insertionSort(int[]list1)
		{
			for ( int i = 0; i < list1.length; i++)
			{
				for ( int j=i; j> 0; j--)
				{
					if(list1[j] < list1[j-1])
					{
						swap(list1,j,j-1);
					}
				}
			}
		}
		//selection
		public static void selectionSort(double[]list1)
		{
			double min;
			int index = 0;
			for ( int j = 0; j < list1.length; j++)
			{
				min = list1[j];
				for ( int i=j; i < list1.length; i++)
				{
					if(list1[i] < min)
					{
						min = list1[i];
						index = i;
					}
				}
				swap(list1,index,j);
			}
		}
		//bubble
		public static void bubbleSort(String[]list1)
		{
			boolean swap = true;
			while(swap)
			{
				int count = 0;
				for(int i = 0; i < list1.length-1; i++)
				{
					if(list1[i].compareTo(list1[i+1])>0)
					{
						swap(list1,i+1,i);
						count++;
					}
				}
				if(count == 0)
				{
					swap = false;
				}
			}
		}
		public static void bubbleSort(int[]list1)
		{
			boolean swap = true;
			while(swap)
			{
				int count = 0;
				for(int i = 0; i < list1.length-1; i++)
				{
					if(list1[i]>list1[i+1])
					{
						swap(list1,i+1,i);
						count++;
					}
				}
				if(count == 0)
				{
					swap = false;
				}
			}
		}
		//swap
		public static void swap(String[]arr,int i,int j)
		{
			String n = arr[i];
			arr[i] = arr[j];
			arr[j] = n;
		}
		public static void swap(double[]arr , int i, int j) 
		{
			double n = arr[i];
			arr[i] = arr[j];
			arr[j] = n;
		}
		public static void swap(int[]arr,int i,int j)
		{
			int n = arr[i];
			arr[i] = arr[j];
			arr[j] = n;
		}
		//media
		public static int getMedian(int[] arr)
		{
			int median;
			if (arr.length % 2 == 0)
			    median = ((int)arr[arr.length/2] + (int)arr[arr.length/2 - 1])/2;
			else
			    median = (int) arr[arr.length/2];
			
			return median;
		}
}
