package io.github.ruantarcisio.libraryapi.controllers;

import io.github.ruantarcisio.libraryapi.controllers.dto.TokenDTO;
import io.github.ruantarcisio.libraryapi.security.CustomAuthentication;
import io.github.ruantarcisio.libraryapi.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LoginViewController {

    private final SecurityService securityService;

    @GetMapping("/login")
    public String paginaLogin() {
        return "login";
    }

    @GetMapping("/")
    @ResponseBody
    public String paginaHome(Authentication authentication) {
        if (authentication instanceof CustomAuthentication customAuth) {
            System.out.println(customAuth.getUsuario());
        }
        return "Olá " + authentication.getName();
    }

    @GetMapping("/authorized")
    @ResponseBody
    public String getAuthorizationCode(@RequestParam("code") String code) {
        return "Seu authorization code: " + code;
    }

    @GetMapping("/authenticated")
    @ResponseBody
    public TokenDTO getAccessAndRefreshToken(Authentication authentication) {
        return securityService.getAccessTokenAndRefreshToken(authentication);
    }
}