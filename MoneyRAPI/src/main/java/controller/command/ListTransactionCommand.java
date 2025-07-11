package controller.command;

import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.TransactionDao;
import model.entity.Transaction;

public class ListTransactionCommand implements Command{
	private static final int DEFAULT_PAGE = 0;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int page = DEFAULT_PAGE;
		String pageParam = request.getParameter("page");
		if(pageParam != null && !pageParam.isEmpty()) {
			try {
				page = Integer.parseInt(pageParam);
				if(page < 0) {
					page = DEFAULT_PAGE;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		TransactionDao dao = new TransactionDao();
		List<Transaction> list = dao.listPage(page);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(list));
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
