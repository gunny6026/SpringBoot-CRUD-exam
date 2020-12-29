# Springboot framework 이해하기

## controller => @Controller

파일을 리턴시켜준다.

```
@GetMapping("/saveForm")
	public String saveForm() {
		return "saveForm"; // <- 파일임 문자가 아니라~

	}
```

localhost:8000/saveForm 을 호출하면

saveForm을 찾아준다.

**application.yml** 

```
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
```
를 통해

/WEB-INF/views/saveForm.jsp 파일을 찾아준다.


@PostMapping 일 경우

데이터를 리턴한다.
