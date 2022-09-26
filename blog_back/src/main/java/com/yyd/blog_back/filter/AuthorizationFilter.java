package com.yyd.blog_back.filter;



import com.yyd.blog_back.common.util.RequestUtil;
import com.yyd.blog_back.config.JwtConfig;
import com.yyd.blog_back.service.MyUserDetailService;
import com.yyd.blog_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {
    /**
     * 范围时间内限制最大请求次数
     */
    private static final int LIMIT_REQUEST_FREQUENCY_COUNT = 8;

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private MyUserDetailService userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        checkPermission(request, response, chain);
    }

    /**
     * 校验权限
     *
     * @param request
     * @param response
     */
    private void checkPermission(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean giveFlag = false;
        String method = request.getMethod();
        if(method.equals("OPTIONS")){
            giveFlag = true;
        }
        String authHeader = request.getHeader(jwtConfig.getHeader());

        if (authHeader != null && authHeader.startsWith(jwtConfig.getPrefix())) {
            UserDetails userDetails = userDetailService.loadUserByToken(authHeader);

            if (null != userDetails) {
                //此请求是否校验过
                if (SecurityContextHolder.getContext().getAuthentication() == null) {

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                }
            } else {
                giveFlag = true;
            }
        } else {
            //token校验失败
            giveFlag = true;
        }

        if (giveFlag) {
            //token因某原因校验失败,给定游客身份->[游客]角色未写入数据库角色表
            // 省去每个方法上的permitAll注解
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("VISITOR"));
            //假定身份
            User user = new User("VISITOR", "VISITOR", authorities);
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            //赋予权限
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }


}
