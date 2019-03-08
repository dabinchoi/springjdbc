package my.examples.springjdbc.controller;

import my.examples.springjdbc.dto.User;
import my.examples.springjdbc.service.UserService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/loginform")
    public String loginform() {
        return "loginform";
    }

/*

    @GetMapping("login")
    public String login(){
        return "board";
    }


*/

    @PostMapping("/login")
    public String login(@RequestParam(name = "email") String email,
                        String passwd,
                        HttpServletRequest request,
                        HttpSession session) {
        User user = userService.getUserByEmail(email);
        session = request.getSession();
        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

return  "sucess";
    }


    //  @RequestMapping(method=GET, path="/list") 와 같은 것
    @GetMapping("/list")
    public String main(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            Model model) {
        List<User> users = userService.getUsers(page);
        model.addAttribute("users", users);
        return "index"; // view name
    }

    @GetMapping("/joinform")
    public String joinform() {
        return "joinform";
    }

    @PostMapping("/join")
    public String join(@RequestParam(name = "name") String name,
                       @RequestParam(name = "nickname") String nickname,
                       @RequestParam(name = "email") String email,
                       @RequestParam(name = "passwd") String passwd,
                       @RequestHeader(name = "Accept") String accept,
                       HttpSession session) {

        // 값에 검증.
        Assert.hasLength(name, "이름을 입력하세요.");
        if (name == null || name.length() <= 1)
            throw new IllegalArgumentException("이름을 입력하세요.");

        User user = new User();
        user.setPasswd(passwd);
        user.setNickname(nickname);
        user.setEmail(email);
        user.setName(name);

        userService.addUser(user);

        return "redirect:/list";
    }
}