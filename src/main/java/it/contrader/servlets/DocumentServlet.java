package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.DocumentDTO;
import it.contrader.service.DocumentService;
import it.contrader.service.Service;

public class DocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DocumentServlet() {
		
	}
	
	public void updateList(HttpServletRequest request) {
		Service<DocumentDTO> service = new DocumentService();
		List<DocumentDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<DocumentDTO> service = new DocumentService();
		String mode = request.getParameter("mode");
		DocumentDTO documentDTO;
		int idDocument;
		boolean ans;
		
		switch (mode.toUpperCase()) {
		case "DOCUMENTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/document/documentmanager.jsp").forward(request, response);
			break;
			
		case "READ":
			idDocument = Integer.parseInt(request.getParameter("id"));
			documentDTO = service.read(idDocument);
			request.setAttribute("documentDTO", documentDTO);
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/user/readdocument.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/user/updatedocument.jsp").forward(request, response);
			
			break;
			
		case "INSERT":
			String text = request.getParameter("text").toString();
			documentDTO = new DocumentDTO(user, text);

		default:
			break;
		}
	}
	
	

}
