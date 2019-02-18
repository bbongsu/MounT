package Myinfo;

import java.util.List;

public interface iMyscheduleDAO 
{
	public List<MyscheduleDTO> getscheduleList(String id, String yyyyMM);
	
	public boolean addschedule(MyscheduleDTO dto);
}
