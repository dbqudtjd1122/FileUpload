package com.sol.upload;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class DAO {

	public void upload(HttpServletRequest req) {		
		// 기존의 방식으로 값을 읽을 수 없음.
		// System.out.println(req.getParameter("title")); // 기존방식
		
		// 파일업로드 방식
		try {
			// 파일 업로드될 폴더 경로 (서버상의 경로)
			String path = req.getSession().getServletContext().getRealPath("resources/img");
			
			// System.out.println(path); 
			// C:\Users\soldesk\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\FileUpload\resources\img
			
			// 업로드 작업 multipart/form-data 방식으로 전송된 값을 읽음
			MultipartRequest mr = new MultipartRequest( req,  // request
														path, // 저장 경로
														10*1024*1024, // 최대바이트 
														"utf-8", // 인코딩
														new DefaultFileRenamePolicy()); // 중복처리
			// 파라메터 값 읽기
			System.out.println(mr.getParameter("title"));
			req.setAttribute("title", mr.getParameter("title"));
			
			// 업로드한 파일명
			System.out.println(mr.getFilesystemName("photo"));
			req.setAttribute("file_name", mr.getFilesystemName("photo"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
