package kr.or.davizn.etcController;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


	
	@RequestMapping("index.dvn")
	public String moveIndex(Principal principal){
		if(principal ==null){return "home.index";}
		return "redirect:davizn.dvn"; 
	}
	
	@RequestMapping("davizn.dvn")
	public String moveIndex2(String userid,Model model,HttpSession session) throws Exception{
		return "home.index"; //select 시키면 됨
	}
	
}
