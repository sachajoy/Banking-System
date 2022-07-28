package com.banking.bankingsystem.controller;

import com.banking.bankingsystem.model.User;
import com.banking.bankingsystem.pojo.DepositAmount;
import com.banking.bankingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepositMoneyController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/deposit")
    public ModelAndView deposit(DepositAmount depositAmount) {
      ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        int balance = user.getBalance();
        if ( depositAmount.getDepositAmount() < 1) {
            modelAndView.addObject("errorMessage", "Amount Cannot to less than one");
            modelAndView.addObject("userDetails", user);
            modelAndView.setViewName("home");
            return modelAndView;
        }
        balance += depositAmount.getDepositAmount();
        user.setBalance(balance);
        userService.saveUser(user);
        modelAndView.addObject("successMessage", "Amount Deposited");
        modelAndView.addObject("userDetails", user);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @PostMapping(value = "/withdraw")
    public ModelAndView withdraw(DepositAmount depositAmount) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        int balance = user.getBalance();
        if (balance < depositAmount.getDepositAmount()) {
            modelAndView.addObject("errorMessage", "Cannot withdraw amount more than your balance");
            modelAndView.addObject("userDetails", user);
            modelAndView.setViewName("home");
            return modelAndView;
        }
        balance -= depositAmount.getDepositAmount();
        user.setBalance(balance);
        userService.saveUser(user);
        modelAndView.addObject("successMessage", "Amount Withdrawn");
        modelAndView.addObject("userDetails", user);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
