package edu.miu.e_mart.controller;

import edu.miu.e_mart.domain.Payment;
import edu.miu.e_mart.domain.Review;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ReviewController
{
    @RequestMapping(value="/review",method= RequestMethod.POST)
    public String processReview(@Valid @ModelAttribute("review") Review review, BindingResult result, Model model, RedirectAttributes redirectAttributes)
    {
        if(result.hasErrors())
        {
            System.out.println("review has errors!");
            return "review";
        }
        redirectAttributes.addFlashAttribute("review",review);
        return "review"; //need to redirect (for later)
    }

    @RequestMapping(value = {"/review"}, method = RequestMethod.GET)
    public String getReview(@ModelAttribute("review") Review review)
    {
        return "review";
    }
}
