package controller.command;

import java.io.PrintWriter;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.TransactionDao;
import model.entity.FinancialRelatory;

public class CreateFinancialRelatoryCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TransactionDao dao = new TransactionDao();
		FinancialRelatory rlt = dao.getRelatory();
		response.setContentType("application/json");
		PrintWriter out  = response.getWriter();
		
		out.print(new Gson().toJson(rlt));
		out.flush();
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
