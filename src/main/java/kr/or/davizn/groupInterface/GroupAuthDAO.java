package kr.or.davizn.groupInterface;

import kr.or.davizn.groupDTO.GroupAuthListDTO;

public interface GroupAuthDAO {
	public int locking(GroupAuthListDTO authlistdto);
	
}
