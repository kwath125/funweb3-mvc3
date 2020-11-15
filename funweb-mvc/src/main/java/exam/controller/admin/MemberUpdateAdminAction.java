package exam.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.controller.Action;
import exam.dao.BoardDao;
import exam.dao.MemberDao;
import exam.domain.MemberVo;

public class MemberUpdateAdminAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 세션값 가져오기
		HttpSession session = request.getSession(); 
		MemberDao dao = MemberDao.getInstance();
		
		//세션에 저장된 아이디를 가져와서
		// 그 아이디 해당하는 회원정보를 가져온다.
		String id = request.getParameter("id");
		MemberVo vo = dao.getMemberById(id);
		System.out.println("vo=" + vo);
		
		request.setAttribute("member", vo);
		
		
		return "admin/memberUpdateAdmin";  // jsp 뷰 이름 리턴
	}

}



