package br.com.cast.ajaxjquery.servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.cast.ajaxjquery.business.PessoaBusiness;
import br.com.cast.ajaxjquery.dto.PessoaDTO;

@WebServlet("/pessoa")
public class AddPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-chamar o metodo buscarTodas do business
		PessoaBusiness business = new PessoaBusiness();
		List<PessoaDTO> pessoasDTO = business.buscarTodas();
		
		//2-converter para Json
		Gson gson = new Gson();
		String json = gson.toJson(pessoasDTO);
		
		escreveJSON(response, json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json = req.getReader().lines().collect(Collectors.joining());
		
		//1-converter o json para DTO
		Gson gson = new Gson();
		PessoaDTO pessoaDTO = gson.fromJson(json, PessoaDTO.class);
		
		//2-enviar o dto para o metodo salvar do business
		
		PessoaBusiness business = new PessoaBusiness();
		business.salvar(pessoaDTO);
	
	}
	
	private void escreveJSON(HttpServletResponse resp, String json) throws IOException {
		//3-mudar o contentType para application/json
		resp.setContentType("application/json");
		
		//4-escrever o json na resposta
		resp.getWriter().append(json);
	}
}