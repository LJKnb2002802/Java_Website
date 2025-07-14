package com.tfswufe.resume.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 分页插件
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        // 设置最大分页数
        paginationInnerInterceptor.setMaxLimit(100L);
        // 是否对超过最大分页时做溢出处理，默认false不处理，即直接丢弃溢出的数据，为true时，怎么把溢出数据放入到下一个分页中。
        paginationInnerInterceptor.setOverflow(true);
        // 设置数据库类型以匹配不同方言
        paginationInnerInterceptor.setDbType(DbType.MYSQL);
        // 添加分页插件
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }
}
