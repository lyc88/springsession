package com.lyc.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class MyController {

	@RequestMapping("/login")
	@ResponseBody
	public void login(HttpServletRequest request, HttpServletResponse response) {

		System.out.println(request.getLocalName());
		System.out.println(response.getContentType());
		System.out.println(request.getSession());

		HttpSession session = request.getSession();
		session.setAttribute("jack", "luoyang");
		session.setAttribute("jack1", "luoyang1");

		
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress() + ":"
			        + InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/queryUser")
	@ResponseBody
	public String queryUserInfo(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		String name1 = (String) session.getAttribute("jack");
		String name2 = (String) session.getAttribute("jack1");
		
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress() + ":"
			        + InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return name1 + "  " + name2;
	}
}
