package controller.chain;

import controller.command.FindByIdCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetByIdHandler extends AbstractHandler{

	@Override
	protected boolean canHandle(HttpServletRequest request) {
		return request.getMethod().equals("GET") && request.getPathInfo() != null && request.getPathInfo().matches("^/\\d+$");
		
	}

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		new FindByIdCommand().execute(request, response);
		
	}

}
