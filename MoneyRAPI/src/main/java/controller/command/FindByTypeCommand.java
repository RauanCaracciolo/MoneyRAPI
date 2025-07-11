package controller.command;

import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.TransactionDao;
import model.entity.Transaction;

public class FindByTypeCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getPathInfo();
		if(path == null || !path.startsWith("/type/") || path.length() <= "/type/".length()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Transaction id is invalid.");
			return;
		}
		String type = path.substring("/type/".length());
		TransactionDao dao = new TransactionDao();
		List<Transaction> list = dao.searchForType(type);
		
		if(list != null || !list.isEmpty()) {
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(list));
			out.flush();
		}else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Theres is no one transaction with this type");
		}
	}

}
