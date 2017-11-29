package com.mo.bitTree;

import java.util.Stack;

import com.mo.queue.LinQueue;


/**
 * @author 文龙
 * @version 2017-11-26 下午3:24:18
 * 
 *   遍历二叉树
 *   
 */
public class Traverse {

	//前序遍历二叉树。访问节点的操作是vs.print(t.data);
	public static void preOrder(BitTreeNode t,Visit vs) {
		if(t != null) {
			vs.print(t.getData());
			preOrder(t.getLeft(), vs);
			preOrder(t.getRight(), vs);
		}
	}
	
	//中序遍历二叉树
	public static void inOrder(BitTreeNode t,Visit vs) {
		if(t != null) {
			inOrder(t.getLeft(), vs);
			vs.print(t.getData());
			inOrder(t.getRight(), vs);
		}
	}
	
	//后序遍历二叉树
	public static void postOrder(BitTreeNode t,Visit vs) {
		if(t != null) {
			postOrder(t.getLeft(), vs);
			postOrder(t.getRight(), vs);
			vs.print(t.getData());
		}
	}
	
	//层序访问二叉树
	public static void levelOrder(BitTreeNode t,Visit vs) throws Exception {
		LinQueue q = new LinQueue();
		if(t == null) return;
		BitTreeNode curr;
		q.append(t);//将根节点置入队列
		while(! q.isEmpty()) {
			curr = (BitTreeNode) q.delete();//将队列的第一个元素拿出来，然后下面再访问它的左右节点
			vs.print(curr.getData());//打印刚刚取出来的元素
			if(curr.getLeft() != null) {
				q.append(curr.getLeft());//将左节点置入队列
			}
			if(curr.getRight() != null) {
				q.append(curr.getRight());//将右节点置入队列。 --> 这两个左右节点一定是兄弟节点
			}
		} 
	}
	
	//打印二叉树,
	public static void printBitTree(BitTreeNode root,int level) {
		if(root != null) {
			printBitTree(root.getRight(), level + 1);

			if(level != 0) {
				for(int i = 0; i < 6 * (level - 1); i++) {
					System.out.print(" ");
				}
				System.out.print("----");
			}
			System.out.println(root.getData());
			
			printBitTree(root.getLeft(), level + 1);
			
		}
	}
	
	//查找数据元素
	public static BitTreeNode search(BitTreeNode t,Object obj) {
		BitTreeNode temp;
		
		if(t == null) return null;
		if(t.getData() == obj) return t;
		
		if(t.getLeft() != null) {
			temp = search(t.getLeft(), obj);
			if(temp != null) return temp; 
		}
		
		if(t.getRight() != null){
			temp = search(t.getRight(), obj);
			if(temp != null) return temp; 
		}
		return null;
	}
	
	//使用非递归的方法前序遍历二叉树
	public static void preOrderNoRecur(BitTreeNode root) {
		if(root == null) return;
		Stack<BitTreeNode> stack = new Stack<BitTreeNode>();
		BitTreeNode cur = root;
		stack.push(root);
		while(!stack.isEmpty()) {
			cur = stack.pop();
			System.out.print(cur.getData() + " ");
			if(cur.getRight() != null) stack.push(cur.getRight());
			if(cur.getLeft() != null) stack.push(cur.getLeft());
		}
	}
	
	//使用非递归的后序遍历
	public static void postOrderNoRecur(BitTreeNode root) {
		
	}
	
	
	public static void m1(BitTreeNode root) {
		
	}
	
	public static void main(String[] args) throws Exception {
		//构造一颗二叉树，分别构建两个树，再拼接到根节点上
		BitTreeNode g = new BitTreeNode("g",null,null);
		BitTreeNode d = new BitTreeNode("d",null,g);
		BitTreeNode b = new BitTreeNode("b",d,null);
		
		BitTreeNode e = new BitTreeNode("e",null,null);
		BitTreeNode f = new BitTreeNode("f",null,null);
		BitTreeNode c = new BitTreeNode("c",e,f);
		
		//根节点
		BitTreeNode a = new BitTreeNode("a",b,c);
		//打印二叉树
		Traverse.printBitTree(a, 0);
		//分别 先，中，后，层 遍历二叉树
		Visit vs = new Visit();
		System.out.print("先");
		Traverse.preOrder(a, vs);
		System.out.println();
		System.out.print("中");
		Traverse.inOrder(a, vs);
		System.out.println();
		System.out.print("后 ");
		Traverse.postOrder(a, vs);
		System.out.println();
		System.out.print("层");
		Traverse.levelOrder(a, vs);
		System.out.println();
		System.out.print("查找数值");
		BitTreeNode search = Traverse.search(a, "a");
		System.out.println(search.getData());
		System.out.println("使用非递归的前序遍历");
		preOrderNoRecur(a);
	}	
}
