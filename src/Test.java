

public class Test {
	public static boolean duplicate(int numbers[],int length,int [] duplication) {
		
		for(int i = 0; i < length - 1;i++) {
			int temp = numbers[i];
			int j = i + 1;
			while(j < length) {
				if(temp == numbers[j]) {
					duplication[0] = temp;
					return true;
				}
				j++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] a = {5,6,7,8,3,4,56,7};
		duplicate(a, a.length, new int[1]);
	}
}
