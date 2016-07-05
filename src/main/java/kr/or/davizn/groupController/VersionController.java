package kr.or.davizn.groupController;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.datasetDTO.PersonalDataNoteDTO;
import kr.or.davizn.datasetService.NoteService;
import kr.or.davizn.groupDTO.VersionDTO;
import kr.or.davizn.groupService.VersionService;

@Controller
@RequestMapping("/version/")
public class VersionController {
	
	@Autowired
	NoteService noteservice;
	
	@Autowired
	VersionService versionService;

	@RequestMapping("showVerionlist")
	public String showVersionlist(Model model, int dataseq, HttpServletRequest request) throws IOException{
		List<VersionDTO> versionlist = versionService.getVersionlist(dataseq);
		//가장 최근에 수정한 버전
		VersionDTO newversion = versionlist.get(versionlist.size()-1);
		
		PersonalDataNoteDTO note = noteservice.detailNote(request, dataseq);
		
		//이미지로 변환될 부분의 내용
		 model.addAttribute("datahtml",note.getDatahtml());
	     model.addAttribute("dataname",newversion.getDataname());
	     model.addAttribute("userid", newversion.getUserid());
	     model.addAttribute("datacreate", newversion.getModifytime());
	     //버전 히스토리
		 model.addAttribute("versionlist",versionlist);
		return "group.group-data-share-history";
	}
}
