package com.copyonwrite.areaofarectangularroom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author wolf
 */
@Controller
public class AreaOfARectangularRoomController {
    private final double FACTOR_SQUARE_FEET_TO_SQUARE_METERS = 0.09290304;
    
    @PostMapping("/compute-area")
    String postComputeArea(
            @RequestParam("length") Integer length, 
            @RequestParam("width") Integer width,
            @RequestParam(value = "useMeters", required = false) String useMetersParam,
            Model model
    ) {
        boolean useMeters = useMetersParam != null;
        String unit = useMeters ? "meters" : "feet";
        double areaSquareFeet = useMeters ? length * width / FACTOR_SQUARE_FEET_TO_SQUARE_METERS : length * width;
        double areaSquareMeters = useMeters ? length * width : areaSquareFeet * FACTOR_SQUARE_FEET_TO_SQUARE_METERS;
        
        model.addAttribute("dimensions", String.format("You entered dimensions of %d %s by %d %s.", length, unit, width, unit));
        model.addAttribute("area", String.format("The area is %.3f square feet / %.3f square meters", areaSquareFeet, areaSquareMeters));
        
        return "display-area";
    }
}
