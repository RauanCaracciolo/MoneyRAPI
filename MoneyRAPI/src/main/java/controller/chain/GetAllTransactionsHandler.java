package controller.chain;

import controller.command.ListTransactionCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetAllTransactionsHandler  extends AbstractHandler{

	@Override
	protected boolean canHandle(HttpServletRequest request) {
		return request.getMethod().equals("GET") && request.getPathInfo() != null && request.getPathInfo().equals("/paginated");
				}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		new ListTransactionCommand().execute(request, response);
		
	}

}
