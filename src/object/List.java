package object;

/**
 *  线程表-->顺序表的抽象数据结构
 */
public interface List {
	/**
	 * 插入
	 */
	void insert(int i, Object obj)throws Exception;
	/**
	 * 删除
	 */
	Object delete(int i)throws Exception;
	/**
	 * 取数据元素
	 */
	Object getData(int i)throws Exception;
	/**
	 * 求元素个数
	 */
	int size();
	/**
	 * 是否空
	 */
	boolean isEmpty();
}
