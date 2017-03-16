/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judicael.springmavenstarter.config;

import javax.servlet.annotation.WebServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author judicael
 */
@Controller
@RequestMapping(value = "/springmavenstarter")
//@WebServlet(value = "/springmavenstarter")
public class DefaultController {
    @RequestMapping( method = RequestMethod.GET)
   public String index(ModelMap map) {
       map.put("msg", "Hello Spring 4 Web MVC!");
       return "index";
   }
    
}