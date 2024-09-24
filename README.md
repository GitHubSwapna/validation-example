
1. Add Dependency
   <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
</dependency>
2.Use @Valid with RequestBody inside Controller
3.Use validate the input DTO using @min,@max,@email,@notBlank
 @Min(value = 18,message = "Minimum Age Required  18 years or above")
 @Max(value = 56, message = "Maximum Age allowed as 56 years")
@Email
@NotBlank
