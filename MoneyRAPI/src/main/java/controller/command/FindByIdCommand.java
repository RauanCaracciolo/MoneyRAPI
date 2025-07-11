package controller.command;

import java.io.PrintWriter;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.TransactionDao;
import model.entity.Transaction;

public class FindByIdCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getPathInfo();
		if(path == null || !path.matches("^/\\d+$")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Transaction id is invalid.");
			return;
		}
		int id = Integer.parseInt(path.substring(1));
		TransactionDao dao = new TransactionDao();
		Transaction tr = dao.searchId(id);
		
		if( tr != null) {
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(tr));
			out.flush();
		}else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Transaction with this id is not found.");
		}
	}
	

}
