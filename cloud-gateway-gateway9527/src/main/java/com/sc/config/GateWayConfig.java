package com.sc.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    /*
    配置了一个id为path_route_zp的路由规则，当访问地址http://localhost:9527/categories时会自动转发到本人博客的分类页面：https://jokerboozp.top/categories/
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_zp",
                r -> r.path("/categories")
                        .uri("https://jokerboozp.top/categories/")).build();
        return routes.build();
    }
}
