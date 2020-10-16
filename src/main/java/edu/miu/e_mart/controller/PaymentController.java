package edu.miu.e_mart.controller;

import edu.miu.e_mart.domain.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PaymentController
{

    @RequestMapping(value="/payment",method=RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("payment") Payment payment, BindingResult result, Model model, RedirectAttributes redirectAttributes)
    {
        if(result.hasErrors())
        {
            System.out.println("has errors!");
            return "payment";
        }
        redirectAttributes.addFlashAttribute("payment",payment);
            return "payment"; //need to change to redirect
    }

    @RequestMapping(value = {"/payment"}, method = RequestMethod.GET)
    public String billingPay(@ModelAttribute("payment") Payment payment)
    {
        return "payment";
    }

}
