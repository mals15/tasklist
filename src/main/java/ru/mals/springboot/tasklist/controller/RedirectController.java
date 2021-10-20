package ru.mals.springboot.tasklist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mals.springboot.tasklist.domain.Task;
import ru.mals.springboot.tasklist.impl.TaskService;

@Controller
@RequestMapping("/")
public class RedirectController {

    private final TaskService taskService;

    public RedirectController (TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

    @RequestMapping(value="showAll", method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("tasks", taskService.getAll());
        return "/showAll";
    }
    @GetMapping("tasks/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("task", taskService.get(id));
        return "/show";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@ModelAttribute("task") Task task, Model  model) {
        taskService.delete(task);
        return "redirect:/";
    }
    @GetMapping("/new")
    public String newTask (Model model) {
        model.addAttribute("task", new Task());
        return "/new";
    }

    @PostMapping("")
    public String create(@ModelAttribute("task") Task task, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors())
            return "/new";

        taskService.save(task);
        return "redirect:/showAll";
    }

    @GetMapping("{id}/edit")
    public String edit (Model model, @PathVariable("id") int id) {
        model.addAttribute("task", taskService.get(id));
        return "/edit";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String update (@ModelAttribute("task") Task task, BindingResult bindingResult, @PathVariable("id") int id) {

        if (bindingResult.hasErrors())
            return "/edit";

        taskService.save(task);
        return "redirect:/index";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("task") Task task) {
        taskService.delete(task);
        return "redirect:/index";
    }
/*    @Autowired
    private final TaskService taskService;
    @Autowired
    public RedirectController (TaskService taskService) {
        this.taskService = taskService;
    }











 */
}
