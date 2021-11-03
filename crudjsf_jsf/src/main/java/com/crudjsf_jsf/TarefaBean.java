package com.crudjsf_jsf;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.crudjsf_jsf.model.Tarefa;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse;

@ManagedBean(name = "tarefaBean")
@RequestScoped
public class TarefaBean {

	private Tarefa tarefa = new Tarefa();

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public List<Tarefa> getTarefas() {
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/tarefas");
		String json = wr.get(String.class);
		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<List<Tarefa>>() {}.getType());
	}

	public void salvar() {
		Gson gson = new Gson();
		String tarefaJson = gson.toJson(tarefa);
		
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/tarefas/add");
		ClientResponse response = wr.accept("application/json").type("application/json").post(ClientResponse.class, tarefaJson);
		
		if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        String output = response.getEntity(String.class);
        System.out.println("Server response .... \n");
        System.out.println(output);
	}

}
