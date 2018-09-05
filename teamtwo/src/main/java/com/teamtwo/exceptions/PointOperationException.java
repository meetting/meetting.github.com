package com.teamtwo.exceptions;

/**
 * 配送点异常，
 * @author 经舒媛
 *
 */
public class PointOperationException extends RuntimeException {
	//使用RuntiomeException，事务才能回滚，其他的异常类型在插入数据后无法回滚
	/**
	 * 随机序列化ID
	 */
	private static final long serialVersionUID = 4372293051737219230L;

	public PointOperationException(String msg){
		super(msg);
	}
}
