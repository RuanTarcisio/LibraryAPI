package io.github.ruantarcisio.libraryapi.security;

import io.github.ruantarcisio.libraryapi.controllers.dto.TokenDTO;
import io.github.ruantarcisio.libraryapi.domain.Usuario;
import io.github.ruantarcisio.libraryapi.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityService {

    private final UsuarioService usuarioService;
    private final OAuth2AuthorizedClientService authorizedClientService;
//    private final OAuth2AuthenticationToken authenticationToken;

    public Usuario obterUsuarioLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof CustomAuthentication customAuth){
            return customAuth.getUsuario();
        }
        return null;
    }

//    public TokenDTO getAccessTokenAndRefreshToken(Authentication authentication) {
//
//        if (authentication.isAuthenticated()) {
//            OAuth2AuthenticationToken auth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
//            // Obter o ID do cliente registrado (clientId) e o nome de usuário
//            String clientRegistrationId = auth2AuthenticationToken.getAuthorizedClientRegistrationId();
//            String principalName = auth2AuthenticationToken.getName();
//
//            // Carregar o OAuth2AuthorizedClient
//            OAuth2AuthorizedClient authorizedClient = this.authorizedClientService.loadAuthorizedClient(
//                    clientRegistrationId,
//                    principalName
//            );
//
//            // Obter os tokens de acesso e refresh
//            String accessToken = authorizedClient.getAccessToken().getTokenValue();
//            String refreshToken = authorizedClient.getRefreshToken() != null ?
//                    authorizedClient.getRefreshToken().getTokenValue() : null;
//
//            // Retornar os tokens em um DTO
//            return new TokenDTO(accessToken, refreshToken);
//
//        }
//        // Se não for um OAuth2AuthenticationToken, retornar null ou tratamento adequado
//        return null;
//    }

    public TokenDTO getAccessTokenAndRefreshToken(Authentication authentication) {
        if (authentication instanceof OAuth2AuthenticationToken oauth2AuthToken) {
            // Carrega o cliente autorizado
            OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(
                    oauth2AuthToken.getAuthorizedClientRegistrationId(),
                    oauth2AuthToken.getName()
            );

            if (authorizedClient != null) {
                // Extrai os tokens
                String accessToken = authorizedClient.getAccessToken().getTokenValue();
                String refreshToken = authorizedClient.getRefreshToken() != null
                        ? authorizedClient.getRefreshToken().getTokenValue()
                        : null;

                // Retorna os tokens
                return new TokenDTO(accessToken, refreshToken);
            }
        }
        throw new IllegalStateException("Não foi possível obter os tokens");
    }
}