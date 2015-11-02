package com.mdpoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mdpoint.MdpointApplication;

@Controller
public class PresentationController {

	/**
	 * presentation data set & create presentation page
	 * 
	 * @param model
	 * @return HTML file name
	 */
	@RequestMapping("/")
	public String presentation(Model model) {
		model.addAttribute("presenData", MdpointApplication.getPresenData());
		return "presentation";
	}

}
