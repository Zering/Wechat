package com.github.binarywang.demo.spring.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 文本类型的消息属性
 * @author Zhanghj
 *
 */
@Getter
@Setter
public class TextMsg extends BaseMsg{
	private String content;
}
