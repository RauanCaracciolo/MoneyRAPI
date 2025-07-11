package controller.command;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.TransactionDao;
import model.entity.Transaction;

public class CreateTransactionCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BufferedReader reader = request.getReader();
		Transaction tr = new Gson().fromJson(reader, Transaction.class);
		TransactionDao dao = new TransactionDao();
		dao.insert(tr);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(tr));
		out.flush();
		response.setStatus(HttpServletResponse.SC_CREATED);
	}

}
