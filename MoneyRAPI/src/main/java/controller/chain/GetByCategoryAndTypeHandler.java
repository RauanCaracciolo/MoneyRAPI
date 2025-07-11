package controller.chain;

import controller.command.FindByTypeAndCategoryCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetByCategoryAndTypeHandler extends AbstractHandler{

	@Override
    protected boolean canHandle(HttpServletRequest request) {
        return request.getMethod().equals("GET") && request.getPathInfo() != null && request.getPathInfo().startsWith("/categoryandtype/") && request.getPathInfo().contains("+");
    }

    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        new FindByTypeAndCategoryCommand().execute(request, response);
    }
}
