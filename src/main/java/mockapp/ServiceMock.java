package mockapp;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

@Api(value = "ServiceMock")
@RestController
public class ServiceMock {

	private ObjectMapper objectMapper = new ObjectMapper();

	@ApiOperation(value = "Simula processo de back-end")
	@PostMapping("/app")
	public Info runMockService(@RequestBody(required = false)
	 @ApiParam(
			    name =  "request",
			    value = "JSON com a espera em segundos",
			    examples = @Example(value = { 
			    		@ExampleProperty(value=" \"{name: nome,esperaEmSegundos:1}\"")
			    }),
			    required = true) String request) throws InterruptedException {

		if (request != null)
			System.out.println("Request recebida = " + request);
		else
			return new Info("Valid JSON: {name: nome,esperaEmSegundos:1}");

		Info infoRequest;
		try {
			infoRequest = objectMapper.readValue(request, Info.class);
		} catch (Exception e) {
			return new Info("Valid JSON: {'name':'teste de API','esperaEmSegundos':1}");
		}

		Info infoResponse = new Info();
		infoResponse.setName(infoRequest.getName());
		infoResponse.setEsperaEmSegundos(infoRequest.getEsperaEmSegundos());

		Instant previous, current;
		long gap;
		previous = Instant.now();
		System.out.println(Hits.get() + " ---- inicio - " + previous);

		TimeUnit.SECONDS.sleep(infoRequest.getEsperaEmSegundos());

		current = Instant.now();
		gap = ChronoUnit.MILLIS.between(previous, current);

		infoResponse.setDuracao(gap + " ms");
		System.out.println(Hits.get() + " ------- fim - " + current);
		System.out.println(Hits.get() + " - intervalo - " + gap + " ms");

		infoResponse.setHit(Hits.get());
		Hits.add();

		return infoResponse;
	}
}
