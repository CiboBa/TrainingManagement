package pl.bciborowski.trainingmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.bciborowski.trainingmanagement.domain.Course;
import pl.bciborowski.trainingmanagement.service.CourseService;

@RequestMapping("/course")
@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/list")
    public String getCourses(Model model) {
        model.addAttribute("courses", courseService.listAllCourse());
        return "courses";
    }

    @RequestMapping("/{id}")
    public String getCourseBy(@PathVariable Integer id, Model model) {
        model.addAttribute("course", courseService.getById(id));
        return "course";
    }

    @RequestMapping("/delete/{id}")
    public String getCourseBy(@PathVariable Integer id) {
        courseService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editCourse(@PathVariable Integer id, Model model) {
        model.addAttribute("course", courseService.getById(id));
        return "courseForm";
    }

    @RequestMapping(value = "/new")
    public String newCourse(Model model) {
        model.addAttribute("course", new Course());
        return "courseForm";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveCourse(Course course) {
        Course newOne = courseService.save(course);
        return "redirect:/" + newOne.getCourseId();
    }
}