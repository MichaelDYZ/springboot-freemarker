package com.dyz.freemarker.controller;

import com.dyz.freemarker.data.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dyz
 * @version 1.0
 * @date 2020/5/9 15:28
 */
@Controller
@RequestMapping("/student")
@Slf4j
public class StudentController {
    @PostMapping("/login")
    public ModelAndView login(Student student, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        mv.addObject(student);
        mv.setViewName("redirect:/");

        request.getSession().setAttribute("student", student);
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("page/login");
    }
}
