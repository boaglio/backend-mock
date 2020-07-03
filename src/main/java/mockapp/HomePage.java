package mockapp;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;


@ApiIgnore
@RestController
public class HomePage {

	@GetMapping(value="/",produces=MediaType.APPLICATION_JSON_VALUE)
	public String home() {
		
		return "{ \"mockApp\": \"simula um backend rápido ou lento\"}";
		
	}
	
}
