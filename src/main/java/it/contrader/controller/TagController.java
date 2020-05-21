package it.contrader.controller;

import java.util.List;

import it.contrader.dto.TagDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.TagsService;

public class TagController implements Controller {
	
	private static String sub_package = "tags";
	
	private TagsService tagService;
	
	 public TagController() {
		this.tagService = new TagsService();
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		
		int id;
		String tag;
		
		switch(mode) {
		case "READ":
			id = Integer.parseInt(request.get("idtags").toString());
			TagDTO tagDTO = tagService.read(id);
			request.put("tags", tagDTO);
			MainDispatcher.getInstance().callView(sub_package + "TagRead", request);
			break;
		
		case "INSERT":
			tag = request.get("tag").toString();
			
			TagDTO tagToInsert = new TagDTO(tag);
			
			tagService.insert(tagToInsert);
			
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TagInsert", request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			
			tagService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TagDelete", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("idtags").toString());
			tag = request.get("tag").toString();
			TagDTO tagDTOToUpdate = new TagDTO(tag);
			tagDTOToUpdate.setIdTag(id);
			tagService.update(tagDTOToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TagUpdate", request);
			break;
			
		case "TAGLIST":
			List<TagDTO> tagDTOList = tagService.getAll();
			request.put("tags", tagDTOList);
			MainDispatcher.getInstance().callView("Tag", request);
			break;
			
		case "GETCHOICE":
			
			switch(choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "TagRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "TagInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "TagUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "TagDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		
		}
		
	}

}
