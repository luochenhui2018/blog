package springboot.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springboot.blog.domain.User;
import springboot.blog.repository.UserRepository;

/**
 * User 控制器
 * @author kuangfeng
 * @date 2018-12-17 00:33
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.listUsers());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }


    /**
     * 根据id查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") long id,Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    /**
     * 新增，修改用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("users/list","userModel",user);
    }


}
