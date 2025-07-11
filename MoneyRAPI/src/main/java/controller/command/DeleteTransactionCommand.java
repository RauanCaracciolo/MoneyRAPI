package controller.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.TransactionDao;

public class DeleteTransactionCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getPathInfo();
		if(path == null || !path.matches("^/\\d+$")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Transaction id is invalid.");
			return;
		}
		int id = Integer.parseInt(path.substring(1));
		TransactionDao dao = new TransactionDao();
		boolean r = dao.delete(id);
		if(r) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Transaction not found");
		}
		
	}
	

}
