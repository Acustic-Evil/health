package com.travelAgency.Kursovaya.controller;

import com.travelAgency.Kursovaya.entity.Questions;
import com.travelAgency.Kursovaya.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/expert")
public class ExpertController {
    @Autowired
    QuestionsRepository questionsRepository;
    @GetMapping("")
    public String getExpertPage(){
        return "expert";
    }

    @PostMapping("/newQuestion")
    public String newQuestion(@RequestParam(name = "question", required = false) String question, @RequestParam(name = "bodyPart", required = false) String bodyPart, @RequestParam(name = "illness", required = false) String illness,
                              @RequestParam(name = "var1", required = false) String var1, @RequestParam(name = "var2", required = false) String var2, @RequestParam(name="var3", required = false) String var3) {
        if (Objects.equals(question, "") || Objects.equals(illness, "") || Objects.equals(bodyPart, "") || ( Objects.equals(var1, "") && Objects.equals(var2, "") ) || ( Objects.equals(var1, "") && Objects.equals(var3, "") ) ||
                ( Objects.equals(var2, "") && Objects.equals(var3, ""))) {
            return "redirect:/expert?errorValue";
        }
        else if (Objects.equals(var1, var2) || Objects.equals(var1, var3) || Objects.equals(var2, var3)) {
            return "redirect:/expert?errorSameVar";
        }
        else if (questionsRepository.findQuestion(question, bodyPart, illness)) {
            return "redirect:/expert?errorSameQuestion";
        }
        else {
            Questions questions = new Questions(question, bodyPart, illness, var1, var2, var3);
            questionsRepository.save(questions);
            return "redirect:/expert?success";
        }
    }
}
