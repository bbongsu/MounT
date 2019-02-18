package BBSreview;

import java.util.List;

public interface iBBSreviewDAO 
{
	public List<BBSreviewDTO> getReviewList();
	
	public BBSreviewDTO reviewDetail(int seq);

}
