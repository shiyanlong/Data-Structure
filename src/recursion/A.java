package recursion;

/**
 * @author 文龙
 * @version 2017-11-26 上午9:57:15
 * 
 * 	递归算法
 */
public class A {

	public static int count = 0;
	
	//求阶乘
	public static long fact(int i) throws Exception {
		int x;
		long y;
		if(i < 0) throw new Exception();
		if(i == 0) return 1;
		else {
			return y = i * fact(i - 1);
		}
	}
	
	//折半查找法
	public static int bSearch(int[] arr,int x,int low,int higth) throws Exception {
		if(low > higth) return -1;
		if(low < 0) return -1;
		int mid = (low + higth) / 2;
		if(x == arr[mid]){
			return mid;
		}else if(x < arr[mid]) {
			return bSearch(arr, x, low, mid - 1);
		}else {
			return bSearch(arr, x, mid + 1, higth);
		}
	}
	
	//汉诺塔的递归，分三步理解
	public static void hanoi(int n,char from,char to,char helper) {
		//递归结束条件
		if(n == 1) {
			move(from, to);
			return;
		}
		//将from中的(n-1)个移动到helper中。借助to
		hanoi(n - 1, from, helper, to);
		//将from中的第n个移动to中
		move(from, to);
		//将helper中的(n-1)个移动到to。借助from区
		hanoi(n - 1, helper, to, from);
	}
	//移动盘子
	private static void move(char from,char to) {
		++count;
		System.out.println(from + "-->" + to);
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
//		System.out.println(fact(3));
//		int[] arr = {4,5,6,7,8,9};
//		towers(20, 'A', 'B', 'C');
//		System.out.p rintln(bSearch(arr, 4, 0, arr.length - 1));
		hanoi(20, 'A', 'C', 'B');
		System.out.println(count);
	}
	
} 