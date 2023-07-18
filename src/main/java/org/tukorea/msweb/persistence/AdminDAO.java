package org.tukorea.msweb.persistence;

import org.tukorea.msweb.domain.AdminVO;

public interface AdminDAO {
	
	public void memberJoin(AdminVO vo) throws Exception;
	
	public AdminVO login(AdminVO vo) throws Exception;
}
