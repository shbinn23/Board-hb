package com.myapp.selfdev;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/study")
public class BookController {

    @GetMapping("/getStudyList")
    public String getStudyList(Model model) {
        // 여기에 필요한 로직을 추가하여 모델에 데이터를 담아봅니다.

        // 예시 데이터
        List<String> studyList = Arrays.asList("Spring MVC Study", "Java Programming Study", "Web Development Study");

        // 모델에 데이터 추가
        model.addAttribute("studyList", studyList);

        // 뷰 이름 반환
        return "study/getStudyList";
    }
}