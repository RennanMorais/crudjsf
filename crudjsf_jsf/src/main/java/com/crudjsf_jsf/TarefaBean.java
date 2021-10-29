package com.crudjsf_jsf;

import java.util.List;
import javax.faces.bean.ManagedBean;
import com.crudjsf_jsf.model.Tarefa;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@ManagedBean(name = "tarefaBean")
public class TarefaBean {

	public List<Tarefa> getTarefas() {
		Client c = Client.create();
	    WebResource wr = c.resource("http://localhost:8080/tarefas");
	    String json = wr.get(String.class);
	    Gson gson = new Gson();
	    return gson.fromJson(json, new TypeToken<List<Tarefa>>(){}.getType());
	}

}
