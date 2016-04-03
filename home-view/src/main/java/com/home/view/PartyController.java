package com.home.view;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.business.PartyService;
import com.home.business.dto.Party;

@RestController
public class PartyController {

	@Inject
	private PartyService partyService;

	@RequestMapping("/getParties")
	public Collection<Party> getParties() {
		return partyService.getParties();
	}
}
