package com.mediahub.contentcatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                // CONTENT_CREATOR — manage their own content
                .requestMatchers("/mediahub/contentCatalog/contentAsset/createContent")
                    .hasAuthority("CONTENT_CREATOR")
                .requestMatchers("/mediahub/contentCatalog/contentAsset/updateContent/**")
                    .hasAuthority("CONTENT_CREATOR")
                .requestMatchers("/mediahub/contentCatalog/contentAsset/updateContentStatus/**")
                    .hasAuthority("CONTENT_CREATOR")
                .requestMatchers("/mediahub/contentCatalog/contentAsset/deleteContent/**")
                    .hasAuthority("CONTENT_CREATOR")
                // CONTENT_CREATOR — manage tags
                .requestMatchers("/mediahub/contentCatalog/contentTag/addTag")
                    .hasAuthority("CONTENT_CREATOR")
                .requestMatchers("/mediahub/contentCatalog/contentTag/removeTag/**")
                    .hasAuthority("CONTENT_CREATOR")
                // CONTENT_CREATOR — manage creator profile
                .requestMatchers("/mediahub/contentCatalog/creator/createCreator")
                    .hasAuthority("CONTENT_CREATOR")
                .requestMatchers("/mediahub/contentCatalog/creator/updateCreator/**")
                    .hasAuthority("CONTENT_CREATOR")
                .requestMatchers("/mediahub/contentCatalog/creator/updateCreatorStatus/**")
                    .hasAuthority("CONTENT_CREATOR")
                // SUBSCRIBER — can only VIEW content
                .requestMatchers("/mediahub/contentCatalog/contentAsset/fetchContents")
                    .hasAnyAuthority("SUBSCRIBER", "CONTENT_CREATOR", "ADMIN")
                .requestMatchers("/mediahub/contentCatalog/contentAsset/fetchContentById/**")
                    .hasAnyAuthority("SUBSCRIBER", "CONTENT_CREATOR", "ADMIN")
                .requestMatchers("/mediahub/contentCatalog/contentTag/fetchTagsByContent/**")
                    .hasAnyAuthority("SUBSCRIBER", "CONTENT_CREATOR", "ADMIN")
                // ADMIN — can see all creators
                .requestMatchers("/mediahub/contentCatalog/creator/fetchCreators")
                    .hasAnyAuthority("ADMIN", "CONTENT_CREATOR")
                .requestMatchers("/mediahub/contentCatalog/creator/fetchCreatorById/**")
                    .hasAnyAuthority("ADMIN", "CONTENT_CREATOR")
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}