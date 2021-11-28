package ru.mals.springboot.tasklist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mals.springboot.tasklist.domain.Task;
import ru.mals.springboot.tasklist.dto.TaskCreateDto;
import ru.mals.springboot.tasklist.dto.TaskDto;
import ru.mals.springboot.tasklist.dto.TaskEditDto;
import ru.mals.springboot.tasklist.service.TaskService;

@Controller
@RequestMapping("/")
public class OperateController {
    private final TaskService taskService;

    public OperateController (TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("new")
    public String newTask (Model model) {
        model.addAttribute("task", new TaskCreateDto());
        return "new";
    }

    @PostMapping("")
    public String create(@ModelAttribute("task") TaskCreateDto taskCreateDtoDto,
                         BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors())
            return "new";

        taskService.createTask(taskCreateDtoDto);
        return "redirect:showAll";
    }

    @GetMapping("{id}/edit")
    public String edit (Model model, @PathVariable("id") long taskId) {
        model.addAttribute("task", taskService.getTask(taskId));
        return "edit";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String update (@ModelAttribute("task") TaskEditDto taskEditDto,
                          BindingResult bindingResult, @PathVariable("id") long id) {

        if (bindingResult.hasErrors())
            return "edit";

        taskService.editTask(id, taskEditDto);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@ModelAttribute("task") Task task, Model  model) {
        taskService.deleteTask(task);
        return "redirect:/";
    }

/*    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("task") Task task) {
        taskService.delete(task);
        return "redirect:/index";
    }*/
}
