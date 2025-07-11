package controller.command;

import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.TransactionDao;
import model.entity.Transaction;

public class FindByTypeAndCategoryCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getPathInfo();
		if(path == null || !path.startsWith("/categoryandtype/") || !path.contains("+")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Url format is invalids, Expected: /categoryandtype/{category}+{type}");
			return;
		}
		String params = path.substring("/categoryandtype/".length());
		String[] parts = params.split("\\+");
		if(parts.length!=2 || parts[0].isEmpty() || parts[1].isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Url format is invalids, Expected: /categoryandtype/{category}+{type}");
			return;
		}
		String category = parts[0];
		String type = parts[1];
		
		TransactionDao dao = new TransactionDao();
		List<Transaction> list = dao.searchForCategoryAndType(category, type);
		
		if(list != null && !list.isEmpty()) {
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(list));
			out.flush();
			response.setStatus(HttpServletResponse.SC_OK);
		}else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "None transaction is found to the category and/or type.");
		}
	}
	

}
