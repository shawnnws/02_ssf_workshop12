package sg.nus.iss.visa.ssf.workshop_12a.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import sg.nus.iss.visa.ssf.workshop_12a.model.Image;
import sg.nus.iss.visa.ssf.workshop_12a.service.RandomNumService;


// To handle request of user keying in and submitting input.
// This Controller method can be accessed with /api set under RequestMapping
@Controller
// @RequestMapping(path = "/api")
public class RandomNumGenController {

    @Autowired
    RandomNumService service;
    
    // Method 1: Loading of the landing/home page for user to key input and click on <Generate> button
    // This can be accessed with /home set with GetMapping
    @GetMapping("/home")
    public String landingPage() {
        return "home";
    }


    // What is <HttpServletRequest request>?
    /*
     * For this example, we are getting the user input through Http request for number.
     * We can also try to get the user input through a Path Variable or Query.
     */
    @GetMapping("/get")
    public String generateRanNum(Model model, HttpServletRequest request) {

        int number = Integer.parseInt(request.getParameter("number"));


        // Check if number is within expected range 1 - 30
        // NOTE: model does not have addAttribute method, check against Nilesh's code
        if (number < 1 || number > 30) {
            
            String errorMessage = "Invalid number: " + number;
            model.addAttribute("errorMessage", errorMessage);

            // Print error message at home page if input is invalid
            return "home";
        }

        // Inject service to call RandomNumService if no error found in previous step
        List<Integer> randomNumbers = service.generateRanNum(number);

        // Inject service to populate number of required images if no error found in previous step
        List<Image> imageList = new ArrayList<Image>();

        // For each generated random number in randomNumbers List, add the corresponding image into imageList, accessing it by path
        for (int randomNumber: randomNumbers) {
            imageList.add(new Image(Integer.toString(randomNumber), "/images/" + Integer.toString(randomNumber) + ".png"));
        }

        model.addAttribute(imageList);



        return "display";
    }
}
