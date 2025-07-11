package controller.chain;

import controller.command.CreateTransactionCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PostTransactionHandler extends AbstractHandler{

	@Override
	protected boolean canHandle(HttpServletRequest request) {
		return request.getMethod().equals("POST") && (request.getPathInfo() == null || request.getPathInfo().equals("/"));
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		new CreateTransactionCommand().execute(request, response);
	}

}
