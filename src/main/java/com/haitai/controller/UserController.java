package com.haitai.controller;

import com.haitai.pojo.User;
import com.haitai.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 测试
 */
@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

        @RequestMapping("/toIndex")
    public String toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "showUser";
    }


    /**
     * 无参数项目测试,查询所有
     * @return
     */
    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    /**
     * 测试，传入id查询单人信息
     * @param id
     * @return
     */
    @RequestMapping("/findOne/{id}")
    public User findOne(@PathVariable Long id){
        User user = userService.findOne(id);
        return user;
    }

    /**
     * 测试，修改成员
     * @param user
     */
    @RequestMapping("/update")
    public String update(@RequestBody User user){
        int update = userService.update(user);
        if (update>0){
            System.out.println("修改成功！");
            return "修改成功！";
        }else {
            System.out.println("修改失败！");
            return "修改失败！";
        }
    }

    /**
     * 测试，根据传入id删除员工
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        int delete = userService.delete(id);
        if (delete>0){
            System.out.println("删除成功！");
            return "删除成功！";
        }else {
            System.out.println("删除失败！");
            return "删除失败！";
        }
    }

    /**
     * 测试，插入数据
     * @param user
     * @return
     */
    @RequestMapping("/insert")
    public String insert(@RequestBody User user){
        int insert = userService.insert(user);
        if (insert>0){
            System.out.println("插入成功！");
            return "插入成功";
        }else {
            System.out.println("插入失败！");
            return "插入失败";
        }
    }

    /**
     * 测试，根据姓名查询用户
     * @param name
     * @return
     */
    @RequestMapping("/findByName")
    public List<User> findByName(@RequestParam String name){
        List<User> userList = userService.findByName(name);
        return userList;
    }

    /**
     * 测试，根据age查询员工信息
     * @param age
     * @return
     */
    @RequestMapping("/findByAge")
    public List<User> findByAge(@RequestParam Integer age){
        List<User> byAge = userService.findByAge(age);
        return byAge;
    }

}
