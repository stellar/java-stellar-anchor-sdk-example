package org.stellar.anchor.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.stellar.anchor.exception.SepValidationException;

import javax.servlet.http.HttpServletRequest;

/**
 * The controller that implement the endpoints of the Sep24 interactive flow.
 */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/ref")
public class Sep24InteractiveController {
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/sep24/interactive", method = {RequestMethod.GET})
    @ResponseBody
    public String interactive(HttpServletRequest request) throws SepValidationException {
        String operation = request.getParameter("operation");
        if (operation == null)
            throw new SepValidationException("Missing [operation] parameter.");
        if (operation.equals("withdraw"))
            return "The sep24 interactive WITHDRAW starts here.";
        else if (operation.equals("deposit"))
            return "The sep24 interactive DEPOSIT starts here.";
        else
            return "Undefined operation " + operation;
    }
}
