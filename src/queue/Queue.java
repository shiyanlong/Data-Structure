package queue;

/**
 * 队列的抽象数据结构
 *
 */
public interface Queue {
	/**
	 *	入队 
	 */
	void append(Object obj) throws Exception;
	/**
	 *	出队 
	 */
	Object delete() throws Exception;
	/**
	 * 取队头
	 */
	Object getFront() throws Exception;
	/**
	 * 是否为空
	 */
	boolean isEmpty();
}
