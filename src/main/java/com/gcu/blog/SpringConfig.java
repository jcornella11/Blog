package com.gcu.blog;

import com.gcu.blog.business.BlogBusinessInterface;
import com.gcu.blog.business.BlogBusinessService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean(name="BlogBusinessService")
    public BlogBusinessInterface getBlogBusiness()
    {
        return new BlogBusinessService();
    }
}
