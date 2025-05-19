package com.crud.tournoi_project.Security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.io.IOException;

public class CustomAuthFailureHandler implements AuthenticationFailureHandler {

    private final String failureUrl;

    public CustomAuthFailureHandler(String failureUrl) {
        this.failureUrl = failureUrl;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception)
            throws IOException, ServletException {

        // 1) Prépare le FlashMap
        FlashMap flashMap = new FlashMap();
        flashMap.put("errorMessage", "Invalid username or password");

        // 2) Sauvegarde dans la session via le FlashMapManager
        FlashMapManager flashMapManager = RequestContextUtils.getFlashMapManager(request);
        if (flashMapManager != null) {
            flashMapManager.saveOutputFlashMap(flashMap, request, response);
        }

        // 3) Redirection vers /login
        response.sendRedirect(request.getContextPath() + failureUrl);
    }
}
