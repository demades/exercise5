package lu.uni.jakarta;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
// Enabling Swagger
@EnableSwagger2
public class SpringProject001Application {
	

	public static void main(String[] args) {
		SpringApplication.run(SpringProject001Application.class, args);		
	}
	
	
	//  Docket created to setup Swagger 
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())      
          .build()
          .apiInfo(apiDetails());                                           
    }
    
    private ApiInfo apiDetails() {
		return new ApiInfo(
				"Exercise 5",
				"Jakarta Course",
				"1.0",
				"Free of use",
				"by Fernando NAVARRO",
				"API License",
				"https://wwwen.uni.lu/");
    	
    }

}
