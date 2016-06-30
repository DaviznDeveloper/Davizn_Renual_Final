package kr.or.davizn.etcController;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.etcService.Alarm;

@Controller
public class IndexController {
	@Autowired
	private Alarm alarm;

	
	@RequestMapping("index.dvn")
	public String moveIndex(Principal principal, HttpSession session){
		if(principal ==null){return "home.index";}
		else{
		session.setAttribute("userid", principal.getName());
		return "redirect:davizn.dvn"; }
	}
	
	@RequestMapping("davizn.dvn")
	public String moveIndex2(Principal principal,Model model,HttpSession session) throws Exception{
		System.out.println("index2.dvn 에 들어옴");
		String userid=principal.getName();
		session.getAttribute(userid);
		System.out.println(userid);
		int result=alarm.getCount(userid);
		System.out.println("result : "+result);
		session.setAttribute("alarmList", alarm.showAlarmList(userid, model));
		session.setAttribute("alarmCount", result);
		return "home.index"; //select 시키면 됨
	}
}
