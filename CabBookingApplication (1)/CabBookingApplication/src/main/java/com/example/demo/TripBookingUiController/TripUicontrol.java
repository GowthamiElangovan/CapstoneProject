package com.example.demo.TripBookingUiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.TripBookingEntity.Tripbooking;
import com.example.demo.TripBookingRepository.Tripbookingrepo;

@Controller
public class TripUicontrol {

	@Autowired
	private Tripbookingrepo repoTripbookingrepo;

	@GetMapping("/gettripform")
	public String gettrip(Model model ,Tripbooking tripbooking)
	{
		model.addAttribute("trip", tripbooking);
		return "TripBooking";
	}
	
	@PostMapping("/saveform")
	public String savedata(Model model, @ModelAttribute("trip") Tripbooking tripbooking)
	{
		repoTripbookingrepo.save(tripbooking);
		return "redirect:/gettripform";
	}
}
