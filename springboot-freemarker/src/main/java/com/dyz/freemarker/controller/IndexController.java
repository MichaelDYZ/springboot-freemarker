package com.dyz.freemarker.controller;

import cn.hutool.core.util.ObjectUtil;
import com.dyz.freemarker.data.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dyz
 * @version 1.0
 * @date 2020/5/9 15:28
 */
@Controller
@Slf4j
public class IndexController {
    @GetMapping(value = {"", "/"})
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        Student student = (Student) request.getSession().getAttribute("student");
        if (ObjectUtil.isNull(student)) {
            mv.setViewName("redirect:/student/login");
        } else {
            mv.setViewName("page/index");
            mv.addObject(student);
        }

        return mv;
    }
}
