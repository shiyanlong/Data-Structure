package linList;

import com.mo.linList.Node;
import com.mo.object.List;

public class LinList implements List {

	private Node head;//头节点
	private Node current;//当前的节点
	private int size;//当前元素的个数

	public LinList() {
		head = current = new Node(null);
		size = 0;
	}

	//定位-->传插进去和删除都要定位到前一个节点
	public void location(int i) throws Exception {
		if(i < -1 || i > size - 1) throw new Exception();
		//这里是下标为零的插进元素，直接return就行，这是当前的节点是head，就会直接在head的后面进行插进
		if(i == -1) return;
		current = head.next;
		int j = 0;
		while((current.next != null) && j < i) {
			current = current.next;
			j++;
		}
		//到这里就已经是定位成功了，current的节点就是你输入i值的位置了(这里的i是表的下标，从零开始的)
	}

	public void insert(int i, Object obj) throws Exception {
		//因为这是可以插到链表的最后一个元素，所以这里是不同减一的，删除的话就不一样了，因为不存在一个下标为size的元素
		if(i < 0 || i > size) throw new Exception();
		location(i - 1);
		Node node = new Node(obj,current.next);
		current.setNext(node);
		size++;
	}

	public Object delete(int i) throws Exception {
		if(i < 0 || i > size - 1) throw new Exception();
		//删除操作是定位到current的上一位的
		location(i - 1);
		//下面的current是要删除元素的上一个节点，因为你如果定位到要删除的元素的话就要调用上一个节点，但是这个是单链表，不能取得上一个节点
		Object delObj = current.next.getData();
		current.setNext(current.next.next);
		size--;
		return delObj;
	}

	public Object getData(int i) throws Exception {
		if(i < -1 || i > size - 1) throw new Exception();
		location(i);
		return current.getData();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) throws Exception {
		com.mo.linList.LinList linList = new com.mo.linList.LinList();
		for(int i = 0; i < 10; i++) {
			linList.insert(i, i + 1);
		}
		linList.delete(4);
		for(int i = 0; i < linList.size(); i++) {
			System.out.print(linList.getData(i));
		}
	}

}
