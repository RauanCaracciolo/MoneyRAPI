package controller.command;

import java.io.BufferedReader;
import java.io.PrintWriter;


import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.TransactionDao;
import model.entity.Transaction;

public class UpdateTransactionCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getPathInfo();
		if(path == null || !path.matches("^/\\d+$")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Transaction id is invalid.");
			return;
		}
		int id = Integer.parseInt(path.substring(1));
		BufferedReader reader = request.getReader();
		Transaction tra = new Gson().fromJson(reader, Transaction.class);
		TransactionDao dao = new TransactionDao();
		boolean a = dao.update(id, tra);
		if(a) {
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(tra));
			out.flush();
			response.setStatus(HttpServletResponse.SC_OK);
		}else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Transaction not found");
		}
		
	}

}
