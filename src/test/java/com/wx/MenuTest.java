package com.wx;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.github.binarywang.demo.spring.controller.AbstractWxPortalController;
import com.github.binarywang.demo.spring.service.BaseWxService;
import com.github.binarywang.demo.spring.service.Gzh1WxService;
import com.github.binarywang.demo.spring.service.Gzh2WxService;
import com.google.gson.JsonObject;

import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.exception.WxErrorException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MenuTest extends AbstractWxPortalController {
	@Resource
	private Gzh2WxService wxMpService;
	
	@Test
	public void creatMenu() {
		WxMenu wxMenu = new WxMenu();
		List<WxMenuButton> buttons = new ArrayList<>();
		WxMenuButton button11 = new WxMenuButton();
		button11.setName("click菜单");
		button11.setType("click");
		button11.setKey("11");
		WxMenuButton button21 = new WxMenuButton();
		button21.setName("view菜单");
		button21.setType("view");
		button21.setUrl("https://github.com/Zering");		
		buttons.add(button11);
		buttons.add(button21);
		wxMenu.setButtons(buttons);
		
		try {
			System.out.println(wxMpService.getAccessToken());
			wxMpService.getMenuService().menuCreate(wxMenu);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getMenu(){
		WxMenu wxMenu = new WxMenu();
		try {
			wxMenu = wxMpService.getMenuService().menuGet();

			System.out.println(JSON.toJSONString(wxMenu));
		} catch (WxErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void deletemenu() {
		try {
			wxMpService.getMenuService().menuDelete();
		} catch (WxErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected BaseWxService getWxService() {
		return this.wxMpService;
	}
}
