package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.SearchConnectionDTO;
import it.contrader.service.Service;
import it.contrader.service.SearchConnectionService;

public class SearchConnectionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public SearchConnectionServlet() {
		
	}
	
	public void updateList(HttpServletRequest request) {
		Service<SearchConnectionDTO> service = new SearchConnectionService();
		List<SearchConnectionDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<SearchConnectionDTO> service = new SearchConnectionService();
		String mode = request.getParameter("mode");
		SearchConnectionDTO searchConnectiondto;
		int idDocument;
		int idTag;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "SEARCHCONNECTIONLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/searchconnection/searchconnectionmanager.jsp").forward(request, response);
			break;

		case "READ":
			

			idTag = Integer.parseInt(request.getParameter("idtag"));
			searchConnectiondto = service.read(idTag);
			request.setAttribute("dto", searchConnectiondto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/searchconnection/readsearchconnection.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/searchconnection/updatesearchconnection.jsp").forward(request, response);
			
			break;

		case "INSERT":
			
			
			idTag = Integer.parseInt(request.getParameter("idTag"));
			
			idDocument = Integer.parseInt(request.getParameter("idDocument"));
			
			
			searchConnectiondto = new SearchConnectionDTO(idDocument,idTag);
			ans = service.insert(searchConnectiondto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/searchconnection/searchconnectionmanager.jsp").forward(request, response);
			
			break;
			
		case "UPDATE":
			

			idDocument = Integer.parseInt(request.getParameter("idDocument"));

			idTag = Integer.parseInt(request.getParameter("idTag"));
			
			searchConnectiondto = new SearchConnectionDTO(idDocument,idTag);
			ans = service.update(searchConnectiondto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/searchconnection/searchconnectionmanager.jsp").forward(request, response);
			
						
			break;

		case "DELETE":
			
			idTag = Integer.parseInt(request.getParameter("idtag"));
			ans = service.delete(idTag);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/searchconnection/searchconnectionmanager.jsp").forward(request, response);
			
			break;
		}
	}
	
}
