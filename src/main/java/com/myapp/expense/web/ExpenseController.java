package com.myapp.expense.web;

import com.myapp.expense.model.ExpenseVO;
import com.myapp.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // 지출 기록 폼을 렌더링하는 메소드
    @GetMapping("/expenseForm")
    public String expenseForm(Model model) {
        // 기존 지출 내역을 가져와서 모델에 추가
        List<ExpenseVO> expenseList = expenseService.getExpenseList("userId"); // 여기에 사용자 아이디 추가
        model.addAttribute("expenseList", expenseList);

        // 새로운 지출을 기록하기 위한 빈 ExpenseVO 객체를 추가
        model.addAttribute("expenseVO", new ExpenseVO());

        return "expense/expenseForm";
    }

    // 지출을 기록하는 메소드
    @PostMapping("/recordExpense")
    public String recordExpense(ExpenseVO expenseVO, RedirectAttributes redirectAttributes) {
        try {
            // 서비스를 통해 지출을 데이터베이스에 추가
            // 레코드 날짜를 현재 날짜로 설정
            expenseVO.setRecordDate(LocalDate.now());
            expenseService.addExpense(expenseVO);

            // 성공 메시지 또는 기록 성공에 대한 로직 추가
            redirectAttributes.addFlashAttribute("recordSuccess", true);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace(); // 또는 예외를 로그에 기록
            // 에러 메시지를 플래시 속성에 추가하여 화면에 표시
            redirectAttributes.addFlashAttribute("recordError", true);
        }

        // 기록 후에도 기존 지출 내역을 다시 가져와서 모델에 추가
        List<ExpenseVO> expenseList = expenseService.getExpenseList("userId"); // 여기에 사용자 아이디 추가
        redirectAttributes.addFlashAttribute("expenseList", expenseList);

        return "redirect:/expense/form";
    }
}
