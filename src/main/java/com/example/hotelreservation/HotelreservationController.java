package com.example.hotelreservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("Uname")
public class HotelreservationController {
	/* http://localhost:8080/Login_page */
    @GetMapping("/Login_page")
    public String Login_page() {
    	return "Login_page";
    }
    /* http://localhost:8080/home_page */
    @GetMapping("/home_page")
    public String home_page(@RequestParam("Uname")String Uname, Model model) {
    	model.addAttribute("Uname", Uname);
    	return "home_page";
    }
    /* http://localhost:8080/rooms */
    @GetMapping("/rooms")
    public String rooms() {
       	
    	return "rooms";
    }
    /* http://localhost:8080/payment_page */
    @GetMapping("/payment_page")
    public String payment_page(@RequestParam("room1")int room1,@RequestParam("room2")int room2,@RequestParam("room3")int room3,@RequestParam("room4")int room4, Model model) {
       	model.addAttribute("room1", room1);
       	model.addAttribute("room2", room2);
       	model.addAttribute("room3", room3);
       	model.addAttribute("room4", room4);
       	int value1=0;
        int value2=0;
        int value3=0;
        int value4=0;
       	if(room1>0)
       	{
       		value1= 3000*room1;
       		model.addAttribute("value1", value1);
       	}
       	if(room2>0)
       	{
       		value2= 5000*room2;
       		model.addAttribute("value2", value2);
       	}
       	if(room3>0)
       	{
       		value3= 2000*room3;
       		model.addAttribute("value3", value3);
       	}
       	if(room4>0)
       	{
       		value4= 4000*room4;
       		model.addAttribute("value4", value4);
       	}
       	int value=value1+value2+value3+value4;
       	model.addAttribute("value", value);
    	return "payment_page";
    }

}
