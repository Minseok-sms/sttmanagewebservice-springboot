package com.sttmanageweb.service.sttmanagewebservicespringboot.web;

import com.sttmanageweb.service.sttmanagewebservicespringboot.config.auth.LoginUser;
import com.sttmanageweb.service.sttmanagewebservicespringboot.config.auth.dto.SessionUser;
import com.sttmanageweb.service.sttmanagewebservicespringboot.service.posts.PostsService;
import com.sttmanageweb.service.sttmanagewebservicespringboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;



    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());
        // SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userEmail", user.getEmail());
        }
        return "index";
    }

    @GetMapping("/loginpage")
    public String loginpage(@LoginUser SessionUser user){
        return "loginPage";
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
