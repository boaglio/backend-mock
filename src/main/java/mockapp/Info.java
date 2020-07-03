package mockapp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Info {

	private String name;
	private Integer esperaEmSegundos;
	private String dtInicio;
	private String dtFim;
	private String duracao;
	private Long hit;
	private String msg;
	
	public Info() {
		esperaEmSegundos=0;
		hit = Hits.get();
	}
	 
	public Info(String msg) {
		this();
		this.msg = msg;
	}
 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getEsperaEmSegundos() {
		return esperaEmSegundos;
	}
	public void setEsperaEmSegundos(Integer esperaEmSegundos) {
		this.esperaEmSegundos = esperaEmSegundos;
	}
	public String getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}
	public String getDtFim() {
		return dtFim;
	}
	public void setDtFim(String dtFim) {
		this.dtFim = dtFim;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
