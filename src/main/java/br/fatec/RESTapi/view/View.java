package br.fatec.RESTapi.view;


public class View {
	/**
	* Visualizacao principal com os principais atributos
	*/
	public static class AlunoResumo {
	}
	/**
	* Visualizacao com todos os atributos
	* Inclui tudos os atributos marcados com UsuarioResumo
	*/
	public static class AlunoCompleto extends AlunoResumo {
	}
	/**
	* Visualizacao alternativa
	*/
	public static class AlunoResumoAlternativo extends  AlunoResumo{
	}
}