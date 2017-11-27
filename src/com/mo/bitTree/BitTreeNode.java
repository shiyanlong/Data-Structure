package com.mo.bitTree;

/**
 * @author 文龙
 * @version 2017-11-26 下午2:52:32
 * 
 * 	二叉树节点类。一个对象代表一个节点
 * 
 */
public class BitTreeNode {
	
	private BitTreeNode leftChild;//左孩子节点对象的引用
	private BitTreeNode rigthChild;//右孩子节点对象的引用
	private Object data;//数据元素
	
	//用于创建带头节点的
	public BitTreeNode() {
		leftChild = null;
		rigthChild = null;
	}
	
	//用于创建不带头节点的
	public BitTreeNode(Object data,BitTreeNode leftChild,BitTreeNode rigthChild) {
		this.leftChild = leftChild;
		this.rigthChild = rigthChild;
		this.data = data;
	}
	
	public BitTreeNode getLeft() {
		return leftChild;
	}
	public BitTreeNode getRight() {
		return rigthChild;
	}
	public Object getData() {
		return data;
	}
	
}