package controller.chain;

import controller.command.CreateFinancialRelatoryCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FinancialRelatoryHandler  extends AbstractHandler{
	@Override
	protected boolean canHandle(HttpServletRequest request) {
		return request.getMethod().equals("GET") && request.getPathInfo() != null && request.getPathInfo().equals("/relatory");
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		new CreateFinancialRelatoryCommand().execute(request, response);
	}
}
