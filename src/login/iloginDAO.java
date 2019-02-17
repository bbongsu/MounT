package login;

import register.registerDTO;

public interface iloginDAO 
{
	////////////////////회원 로그인
	public registerDTO login(registerDTO dto);
}
