package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Uesr;

import service.UesrService;

@Controller
public class UesrController {
	@Autowired
	private UesrService uService;

	public UesrService getuService() {
		return uService;
	}

	public void setuService(UesrService uService) {
		this.uService = uService;
	}
	@RequestMapping("/deng")
	public String dl(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String userCode=request.getParameter("uname");
		String userPassword=request.getParameter("pwd");
		System.out.println("322222222"+userCode+userPassword);
		int num=uService.dl(userCode, userPassword);
		if (num>0) {
			return "getAll?fan=shou";
		}
		return "dl.jsp";
		
	}
	@RequestMapping("/ax")
	public void ax(HttpServletRequest request,HttpServletResponse response){
		PrintWriter out = null;
		try {
			out = response.getWriter();
		}catch (IOException e) {
			e.printStackTrace();
		}
		String userCode=request.getParameter("uname");
		Uesr uesr=uService.ax(userCode);
		if (uesr!=null) {
			out.print("true");
			
		}else {
			out.print("false");
		}
		
		
	}
	
	@RequestMapping("/getAll")
	public String getAll(HttpServletRequest request,HttpServletResponse response){
		String fan=request.getParameter("fan");
		int num=uService.zong();
		
		if (fan.equals("shou")) {
			List<Uesr>list= uService.getAll(0, 5);
			System.out.println(list.size());
			request.getSession().setAttribute("list", list);
			if (list!=null) {
				return "index.jsp";
			}
		}else if(fan.equals("wei")){
			if (num%5!=0) {
				
				int ye=Integer.valueOf(num/5) +3;
				System.out.println(ye+"aaaaaa");
			
				List<Uesr>list= uService.getAll(ye, 5);
				System.out.println(list.size());
				request.getSession().setAttribute("list", list);
				if (list!=null) {
					return "index.jsp";
				}
			}
			
		}
		
		return null;
	
		
	}
	@RequestMapping("/uadd")
	public String uadd(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String userCode = request.getParameter("bm");
		String userName = request.getParameter("mc");
		String userPassword = request.getParameter("mm");
		int gender = Integer.parseInt(request.getParameter("six"));
		String birthday = request.getParameter("data");
		String phone = request.getParameter("dh");
		String address = request.getParameter("dz");
		int userRole = Integer.parseInt(request.getParameter("js"));
		Uesr su = new Uesr();
		su.setUserCode(userCode);
		su.setUserName(userName);
		su.setUserPassword(userPassword);
		su.setGender(gender);
		su.setBirthday(birthday);
		su.setPhone(phone);
		su.setAddress(address);
		su.setUserRole(userRole);
		int num= uService.uadd(su);
		if (num>0) {
			return "getAll";
		}
		return "uadd.jsp";
		
	}
	@RequestMapping("/udelete")
	public String udelete(HttpServletRequest request,HttpServletResponse response){
		
		int id=Integer.parseInt(request.getParameter("id")) ;
		
		int num= uService.udelete(id);
		if (num>0) {
			return "getAll";
		}
		return null;
		
	}
	@RequestMapping("/user")
	public String luesr(HttpServletRequest request,HttpServletResponse response){
		
		int id=Integer.parseInt(request.getParameter("id")) ;
		Uesr uesr=uService.lUesr(id);
		request.getSession().setAttribute("uesr", uesr);
		if (uesr!=null) {
			return "updateues.jsp";
		}
		return null;
		
		
	}
	@RequestMapping("/uupdate")
	public String update(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int id=Integer.parseInt(request.getParameter("id")) ;
		String userCode = request.getParameter("bm");
		String userName = request.getParameter("mc");
		int gender = Integer.parseInt(request.getParameter("six"));
		String birthday = request.getParameter("data");
		String phone = request.getParameter("dh");
		String address = request.getParameter("dz");
		int userRole = Integer.parseInt(request.getParameter("js"));
		Uesr su = new Uesr();
		su.setUserCode(userCode);
		su.setUserName(userName);
		su.setId(id);
		su.setGender(gender);
		su.setBirthday(birthday);
		su.setPhone(phone);
		su.setAddress(address);
		su.setUserRole(userRole);
		
		int num= uService.uupdate(su);
		if (num>0) {
			return "getAll";
		}
		return "updateues.jsp";
		
		
	}
}
