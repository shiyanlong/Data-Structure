package com.mo.sort;

/**
 * @author 文龙
 * @version 2017-11-26 下午9:43:54
 * 
 * 	 排序	
 * 
 */
public class Sort {
	
	//直接插入排序
	public static int[] insertSort(int[] a) {
		
		//取出temp，对在它前面的所有元素都比较一次
		int temp;
		
		//一个数组共有多少个temp，因为数组的第一个元素可以直接和第二个进行比较，所以直接拿第二个作为temp 
		for(int i = 0; i < a.length - 1; i++) {
			temp = a[i + 1];
			int j = i;
			//把temp与它前面的所有元素比较一次
			while(j > -1 && temp <= a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			//把temp放进
			a[j + 1] = temp;
		}
		return a;
	}

	//选择排 序 --->直接排序
	public static int[] selectSort(int[] a) {
		for(int i = 0; i < a.length - 1; i++) {
			//设置最小的元素
			int small = i;
			for(int j = i + 1; j < a.length; j++) {
				//判断后面的元素是否还有小于的small的
				if(a[small] > a[j]) {
					//有的话就记住它的下标，标记为最小
					small = j;
				}
			}
			int temp = a[i];
			a[i] = a[small];
			a[small] = temp;
		}
		return a;
	}
	
	//冒泡排序
	public static int[] dubbleSortM(int[] a){
		
		int count = 0;//总交换次数
		
		int j = a.length - 1;//需要交换的次数，每次冒泡一个需要交换的次数减少一
		
		for(int k = 0; k < a.length; k++) {
			for(int i = 0; i < j; i++) {
				if(a[i] > a[i + 1]) {
					count++;
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
			j--;
		}
		System.out.println("共交换了" + count + "次");
		return a;
	}

	//快速排序
	public static int[] quickSort(int[] a, int low, int high) {
		
		int i = low;//这是左边的值
		int j = high;//这是右边的值
		int temp = low;//这个是标准元素，拿来做对比的
		
		//一个大循环，先对比右边，如果发现比temp小，就转向去对比左边。这样依次交替，这里的临界条件是i < j
		while(i <  j) {
			//对比右边，如果弹出了这个while循环，说明右边有元素比temp小了，要进行交换
			while(i < j && temp <= a[j]) j--; 
			if(i < j) {
				//这时候，因为a[i]中的值是temp有副本了，所以就可以把刚刚那个  a[j](比temp小的数) 放到a[i]中
				a[i] = a[j];
				//经过上一行代码a[i]已经填好元素了，i指向下一个格。 --注意:这个时候，a[j]中的元素已经放到a[i]中了，所以  a[j] 可以放元素了
				i++;
			}

			/**
			 * 对比左边。这时候a[j]是可以放元素的，在a[i]中取出比temp大的元素放到a[j]的位置上
			 * 	如果弹出这个while，说明出现了a[i]比temp大的，需要移动到右边a[j]的位置
			 */
			while(i < j && temp > a[i]) i++;
			if(i < j) {
				//将a[i]的元素移动到a[j]中，a[i]的位置可以放元素了(例如temp)。这时候又跳到右边跳比temp大的元素放到a[i]
				a[j] = a[i];
				//这时候a[j]已经填充元素了，需要移动到前一位
				j--;
			}
			
			a[i] = temp;
		}
		
		//一个大循环结束 将一个  tmep 与全部的元素比对完成。调用递归  对   temp左右两边的  子数组采用同样的方法进行排序 
		if(i > low) quickSort(a, low, i - 1);
		if(i < high) quickSort(a, i + 1, high);
		
		return a;
	}
	
	public static void main(String[] args) {
		int[] a = {2,1,7,6,2,8,3,6,7,8,9,7,8,7,6,5,5,4,2,34,5,66,777,6,5,5,41};
		/*int[] insertSort = insertSort(a);
		for (int i : insertSort) {
			System.out.print(i + " ");
		}*/
		
		System.out.println();
		
		/*int[] selectSort = insertSort(a);
		for (int i : selectSort) {
			System.out.print(i + " ");
		}*/
		
		System.out.println();
		
		/*int[] dubble = dubbleSortM(a);
		for (int i : dubble) {
			System.out.print(i + " ");
		}*/
		
		int[] quickSort = quickSort(a, 0, a.length - 1);
		for (int i : quickSort) {
			System.out.print(i + " ");
		}
		
	}

}
