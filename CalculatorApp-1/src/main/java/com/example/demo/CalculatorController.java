package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("num1") double n1, 
                             @RequestParam("num2") double n2,  
                             @RequestParam("operation") String operation, 
                             Model model) {
        double result;
        try {
            switch (operation.toLowerCase()) {
                case "add":
                    result = calculatorService.add(n1, n2);
                    break;
                case "sub":
                    result = calculatorService.subtract(n1, n2);
                    break;
                case "mul":
                    result = calculatorService.multiply(n1, n2);
                    break;
                case "div":
                    if (n2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = calculatorService.divide(n1, n2);
                    break;
                case "mod":
                    if (n2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = calculatorService.modulus(n1, n2);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation.");
            }
        } catch (ArithmeticException | IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("num1", n1);
            model.addAttribute("num2", n2);
            return "result";
        }

        // Pass valid result to the model
        model.addAttribute("num1", n1);
        model.addAttribute("num2", n2);
        model.addAttribute("operation", operation);
        model.addAttribute("result", result);
        return "result";
    }
}
