package com.myapp.login.web;

import com.myapp.user.model.UserVO;
import com.myapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) throws Exception {
        return "login/login"; // "login"은 tiles.xml에서 정의한 타일 이름입니다.
    }

    @RequestMapping(value = "/signupForm", method = RequestMethod.GET)
    public String signupForm(Model model) throws Exception {
        model.addAttribute("userVO", new UserVO());
        return "login/signupForm";
    }

    @PostMapping("/login")
    public String login(UserVO userVO, RedirectAttributes redirectAttributes) {
        try {
            UserVO foundUser = userService.getUserInfo(userVO.getUid());

            if (foundUser != null && foundUser.getPwd().equals(userVO.getPwd())) {
                // 로그인 성공
                // 세션 또는 쿠키를 통해 로그인 정보를 유지하는 등의 작업이 추가로 필요할 수 있습니다.
                System.out.println("로그인 성공: " + userVO.getUid());
                return "redirect:/board/getBoardList"; // 로그인 성공 시 이동할 페이지
            } else {
                // 로그인 실패
                redirectAttributes.addFlashAttribute("loginError", true);
                System.out.println("로그인 실패: " + userVO.getUid());
                return "redirect:/login/login";
            }
        } catch (Exception e) {
            // 예외 발생 시 처리
            e.printStackTrace(); // 또는 로그에 기록하도록 수정
            redirectAttributes.addFlashAttribute("loginError", true);
            return "redirect:/login/login";
        }
    }
}
