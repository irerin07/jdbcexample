package com.tistory.irerin07.servlet;

import com.tistory.irerin07.dao.BoardDao;
import com.tistory.irerin07.dao.BoardDaoImpl;
import com.tistory.irerin07.dto.Board;
import com.tistory.irerin07.service.BoardService;
import com.tistory.irerin07.service.BoardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FreeDeleteServlet", urlPatterns = "/free/delete")
public class FreeDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 로그인한 관리자인가? 관리자일경우에만 실행.
        Long id = 0L;
        try{
            String idStr = req.getParameter("id");
            System.out.println("idStr = " + idStr);
            id = Long.parseLong(idStr);
        }catch(Exception ex){
            // id가 잘못되었을 경우엔 에러페이지로 이동.
        }
        BoardService boardService = new BoardServiceImpl();
        boardService.deleteBoard(id);

        resp.sendRedirect("/free/list");
    }
}