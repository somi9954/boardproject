package SpringBoot_BoardProject.controllers.members;

import SpringBoot_BoardProject.commons.CommonProcess;
import SpringBoot_BoardProject.commons.MemberUtil;
import SpringBoot_BoardProject.commons.Utils;
import SpringBoot_BoardProject.entities.Member;
import SpringBoot_BoardProject.models.member.MemberInfo;
import SpringBoot_BoardProject.models.member.MemberSaveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController implements CommonProcess {

    private final Utils utils;
    private final MemberSaveService saveService;

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form, Model model) {
        commonProcess(model, Utils.getMessage("회원가입", "common"));

        return utils.tpl("member/join");
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors, Model model) {
        commonProcess(model, Utils.getMessage("회원가입", "common"));

        saveService.join(form, errors);

        if (errors.hasErrors()) {
            return utils.tpl("member/join");
        }

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login(String redirectURL, Model model) {
        commonProcess(model, Utils.getMessage("로그인", "common"));

        model.addAttribute("redirectURL", redirectURL);

        return utils.tpl("member/login");
    }

}