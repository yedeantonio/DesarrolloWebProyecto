package co.poli.edu.proyecto.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket nutrientsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.apis(RequestHandlerSelectors.basePackage("co.edu.poli.mongodb.controller")) //Specific package
				.apis(RequestHandlerSelectors.basePackage("co.poli.edu")) //All project
				//.paths(PathSelectors.regex("/api/v1.*")) //filter RequestMapping with regular expression
				.paths(PathSelectors.any())
				.build()
				.apiInfo(mongoProyectApiInfo())
				.tags(new Tag("Class: PasantiaController", "*** Pasantia Controller ***"));
	}

	private ApiInfo mongoProyectApiInfo() {
		return new ApiInfoBuilder()
				.title("Proyect")
				.description("Proyect REST API Spring Boot and SQL")
				.contact(new Contact("Yesenia Deantonio Saenz", "", "yedeantonio@poligran.edu.co"))
				.contact(new Contact("Zaira Rojas", "", "yedeantonio@poligran.edu.co"))
				.contact(new Contact("Josefina Arias Rojas", "", "yedeantonio@poligran.edu.co"))
				.version("0.0.1")
				.build();
	}
}