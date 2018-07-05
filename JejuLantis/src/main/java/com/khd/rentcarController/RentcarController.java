package com.khd.rentcarController;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentcarController {
	
	@RequestMapping(value="car.do",method=RequestMethod.GET)
	public String car(HttpSession session) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("cartype","���þ�");
		map.put("menufactur","���");
		map.put("perwage","26400");
		map.put("passenger","5");
		map.put("fuel","�ֹ���");
		map.put("trans","����");
		map.put("best","Ư���ѷ�Ʈī");
		map.put("option1","�ɼ�1");
		map.put("option2","�ɼ�2");
		map.put("option3","�ɼ�3");
		map.put("option4","�ɼ�4");
		map.put("option5","�ɼ�5");
		map.put("branch","Ư���ѷ�Ʈī");
		map.put("rating","4.1");
		map.put("xx","13400");
		map.put("insurance","13000");
		map.put("yy","2000����");
		map.put("cartype","26400");
		session.setAttribute("car", map);
		return "rentcar/car";
	}
	
	@RequestMapping(value="car.do",method=RequestMethod.POST)
	public String car(@RequestParam("Checkouttime")String checkouttime,@RequestParam("Checkoutdate")String checkoutdate,@RequestParam("Checkintime")String checkintime,@RequestParam("Checkindate")String checkindate,@RequestParam("car_kind_name")String car_kind_name) {
/*		System.out.println(checkindate);
		System.out.println(checkintime);
		System.out.println(checkoutdate);
		System.out.println(checkouttime);
		System.out.println(car_kind_name);*/

		return "rentcar/car";
	}
	
	@RequestMapping(value="rentcar.do",method=RequestMethod.GET)
	public String rentcar() {
		return "rentcar/rentcar";

	}
}
