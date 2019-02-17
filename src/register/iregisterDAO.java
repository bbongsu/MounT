package register;

public interface iregisterDAO 
{
	////////////////////회원추가
	public boolean AddRegister(registerDTO dto);
	
	////////////////////ID체크
	public boolean getId(String id);
}
