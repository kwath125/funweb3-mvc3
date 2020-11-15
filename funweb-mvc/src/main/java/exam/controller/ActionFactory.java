package exam.controller;

import java.util.HashMap;
import java.util.Map;

import exam.controller.board.*;
import exam.controller.company.*;
import exam.controller.member.*;
import exam.controller.admin.*;
import exam.controller.schedule.*;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}

	private Map<String, Action> map = new HashMap<>();
	
	private ActionFactory() {
		// 명령어와 명령어를 처리하는 Action 객체 등록하기
		map.put("/index", new IndexAction());
		
		// 회원
		map.put("/memberJoin", new MemberJoinAction());
		map.put("/memberJoinPro", new MemberJoinProAction());
		map.put("/memberLogin", new MemberLoginAction());
		map.put("/memberLoginPro", new MemberLoginProAction());
		map.put("/memberLogout", new MemberLogoutAction());
		map.put("/join_IDCheck", new JoinIdCheckAction());
		map.put("/ajax_join_IDCheck", new AjaxJoinIdCheckAction());
		map.put("/memberUpdateUserCheck", new MemberUpdateUserCheckAction());
		map.put("/memberUpdateUserCheckPro", new MemberUpdateUserCheckProAction());
		map.put("/memberUpdate", new MemberUpdateAction());
		map.put("/memberUpdatePro", new MemberUpdateProAction());
		map.put("/memberDelete", new MemberDeleteAction());
		map.put("/memberDeletePro", new MemberDeleteProAction());
		
		// company
		map.put("/about", new AboutAction());
		
		// 공개 게시판
		map.put("/notice", new NoticeAction());
		map.put("/writeForm", new WriteFormAction());
		map.put("/writePro", new WriteProAction());
		map.put("/content", new ContentAction());
		map.put("/replyWriteForm", new ReplyWriteFormAction());
		map.put("/replyWritePro", new ReplyWriteProAction());
		
		// 자료실 게시판(로그인회원 전용)
		map.put("/fileNotice", new FileNoticeAction());
		map.put("/fileWriteForm", new FileWriteFormAction());
		map.put("/fileWritePro", new FileWriteProAction());
		map.put("/fileContent", new FileContentAction());
		map.put("/download", new DownloadAction());
		map.put("/fileModifyForm", new FileModifyFormAction());
		map.put("/fileModifyPro", new FileModifyProAction());
		map.put("/fileDelete", new FileDeleteAction());
		
		// 관리자 전용
		map.put("/memberListAdmin", new MemberListAdminAction());
		map.put("/memberDeleteAdmin", new MemberDeleteAdminAction());
		map.put("/memberUpdateAdmin", new MemberUpdateAdminAction());
		map.put("/memberUpdateFormAdmin", new MemberUpdateFormAdminAction());
		map.put("/memberUpdateProAdmin", new MemberUpdateProAdminAction());
		map.put("/fileNoticeAdmin", new FileNoticeAdminAction());
		map.put("/fileNoticeAdminDelete", new FileNoticeAdminDeleteAction());
		map.put("/adminCharts", new AdminChartsAction());
		
		
		// 스케줄 작업
		map.put("/schedule", new ScheduleAction());
		map.put("/schedulePro", new ScheduleProAction());
	} // 생성자
	
	
	public Action getAction(String command) {
		Action action = null;
		
//		if (command.equals("/index")) {
//			action = new IndexAction();
//		} else if (command.equals("/memberJoin")) {
//			action = new MemberJoinAction();
//		}
		
		action = map.get(command);
		return action;
	}

}
