package controller.chain;

import controller.command.FindByCategoryCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetByCategoryHandler extends AbstractHandler{
	@Override
    protected boolean canHandle(HttpServletRequest request) {
        return request.getMethod().equals("GET") && request.getPathInfo() != null && request.getPathInfo().startsWith("/category/");
    }

	@Override
	protected void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		new FindByCategoryCommand().execute(request, response);
	}

	

}
