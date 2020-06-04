package it.contrader.converter;


import it.contrader.dto.SubscribeDTO;
import it.contrader.model.Subscribe;

public class SubscribeConverter extends AbstractConverter<Subscribe, SubscribeDTO> {

	@Override
	public Subscribe toEntity(SubscribeDTO subscribeDto) {
		Subscribe subscribe = null;
		if(subscribeDto != null) {
			subscribe = new Subscribe(subscribeDto.getIdSubscribe(), subscribeDto.getName(), subscribeDto.getUser(), subscribeDto.getInterestgroup());
		}
		return subscribe;
	}

	@Override
	public SubscribeDTO toDTO(Subscribe subscribe) {
		SubscribeDTO subscribeDTO = null;
		if(subscribe != null) {
			subscribeDTO = new SubscribeDTO(subscribe.getIdSubscribe(), subscribe.getName(), subscribe.getUser(), subscribe.getInterestgroup());
		}
		return subscribeDTO;
	}

}
