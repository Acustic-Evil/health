package com.travelAgency.Kursovaya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class SurveyController {

    @GetMapping("")
    public String getTestPage(){return "test";}

    @GetMapping("/headSurvey")
    public String getHeadPage(){return "headSurvey";}

    @GetMapping("/heartSurvey")
    public String getHeartPage(){return "heartSurvey";}

    @GetMapping("/backSurvey")
    public String getBackPage(){return "backSurvey";}

    @GetMapping("/stomachSurvey")
    public String getStomachPage(){return "stomachSurvey";}

    @GetMapping("/surveyAnswers")
    public String getSurveyAnswers(){return "surveyAnswers";}

    @PostMapping("/heartSurvey")
    public String getHeartSurveyAnswer(@RequestParam (name = "question1", required = false) Integer ques1, @RequestParam(name = "question2", required = false) Integer ques2,
                                       @RequestParam(name = "question3", required = false) Integer ques3){
        if (ques1 == null || ques2 == null || ques3 == null) return "redirect:/test/heartSurvey?errorValue";
        if (ques1 == 1 && ques2 == 1 && ques3 == 1) return "redirect:/test/surveyAnswers?cancer";
        if (ques1 == 1) return "redirect:/test/surveyAnswers?stenocardia";
        if (ques2 == 1) return "redirect:/test/surveyAnswers?stenocardiaANDheartFailure";
        if (ques3 == 1) return "redirect:/test/surveyAnswers?CoronaryHeartDiseaseORattackOfAtrialFibrillation";
        else return "redirect:/test/surveyAnswers?weDonKnow";
    }

    @PostMapping("/headSurvey")
    public String getHeadSurveyAnswer(@RequestParam (name = "question1", required = false) Integer ques1, @RequestParam(name = "question2", required = false) Integer ques2,
                                      @RequestParam(name = "question3", required = false) Integer ques3, @RequestParam(name = "question4", required = false) Integer ques4,
                                      @RequestParam(name = "question5", required = false) Integer ques5, @RequestParam(name = "question6", required = false) Integer ques6,
                                      @RequestParam(name = "question7", required = false) Integer ques7) {

        if (ques1 == null || ques2 == null || ques3 == null || ques4 == null || ques5 == null || ques6 == null || ques7 == null) return "redirect:/headSurvey?errorValue";
        if ((ques3 == 1 || ques3 == 3) && ques4 == 1) return "redirect:/test/surveyAnswers?hypertension";
        if (ques1 == 2 && ques6 == 2 && ques7 > 1) return "redirect:/test/surveyAnswers?insomnia";
        else return "redirect:/test/surveyAnswers?headache";

    }

    @PostMapping("/backSurvey")
    public String getBackSurveyAnswer(@RequestParam (name = "question1", required = false) Integer ques1, @RequestParam(name = "question2", required = false) Integer ques2,
                                      @RequestParam(name = "question3", required = false) Integer ques3, @RequestParam(name = "question4", required = false) Integer ques4) {
        if (ques1 == null || ques2 == null || ques3 == null || ques4 == null) return "redirect:/test/backSurvey?errorValue";
        else if (ques1 == 4 && ques4 == 1) return "redirect:/test/surveyAnswers?hyperlard";
        else if (ques1 > 2 && ques2 == 1) return "redirect:/test/surveyAnswers?radikul";
        else if (ques4 == 1) return "redirect:/test/surveyAnswers?scoliosis";
        else if (ques1 == 2 && ques4 == 2) return "redirect:/test/surveyAnswers?hyperkif";
        else return "redirect:/test/surveyAnswers?simplePain";
    }

    @PostMapping("/stomachSurvey")
    public String getStomachSurveyAnswer(@RequestParam (name = "question1", required = false) Integer ques1, @RequestParam(name = "question2", required = false) Integer ques2,
                                         @RequestParam(name = "question3", required = false) Integer ques3, @RequestParam(name = "question4", required = false) Integer ques4) {
        if (ques1 == null || ques2 == null || ques3 == null || ques4 == null) return "redirect:/test/stomachSurvey?errorValue";
        else if (ques3 == 1) return "redirect:/test/surveyAnswers?gutsBurn";
        else if (ques4 == 4) return "redirect:/test/surveyAnswers?ezofag";
        else if (ques2>0) return "redirect:/test/surveyAnswers?yazva";
        else if (ques1 == 1) return "redirect:/test/surveyAnswers?gastrits";
        else if (ques1 == 2) return "redirect:/test/surveyAnswers?gutsANDselez";
        else if (ques1 == 3) return "redirect:/test/surveyAnswers?guts";
        else return "redirect:/test/surveyAnswers?poisons";
    }

}
