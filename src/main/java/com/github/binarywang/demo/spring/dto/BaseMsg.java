package com.github.binarywang.demo.spring.dto;

import java.util.Date;

import lombok.Data;

/**
 * 消息的基本属性
 * @author Zhanghj
 *
 */
@Data
public class BaseMsg {
	private String toUser;
	private String fromUser;
	private Date createTime;
	private String msgType;
	private long msgId;
}
