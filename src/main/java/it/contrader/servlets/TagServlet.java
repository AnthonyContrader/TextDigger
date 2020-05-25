package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.TagDTO;
import it.contrader.service.Service;
import it.contrader.service.TagService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class TagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TagServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<TagDTO> service = new TagService();
		List<TagDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<TagDTO> service = new TagService();
		String mode = request.getParameter("mode");
		TagDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "TAGLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/tag/tagmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/tag/readtag.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/tag/updatetag.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String tag = request.getParameter("tag").toString();
			dto = new TagDTO (tag);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/tag/tagmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			tag = request.getParameter("tag");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new TagDTO (id,tag);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/tag/tagmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/tag/tagmanager.jsp").forward(request, response);
			break;
		}
	}
}