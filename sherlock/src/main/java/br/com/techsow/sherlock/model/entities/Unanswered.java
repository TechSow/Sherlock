package br.com.techsow.sherlock.model.entities;



/**
 * @author Breno
 *
 */
public class Unanswered {
	private int id_unanswered;
	private int id_usuario;
	private String mensagem;
	private byte[] audio;
	
	
	
	public Unanswered(int id_unanswered, int id_usuario, String mensagem, byte[] audio) {
		this.id_unanswered = id_unanswered;
		this.id_usuario = id_usuario;
		this.mensagem = mensagem;
		this.audio = audio;
	}
	
	
	public static class Builder{
		private int id_usuario;
		private String mensagem;
		private byte[] audio;
		
		public Builder() {
			
		}
		public Builder usuarioId(int id) {
			this.id_usuario = id;
			return this;
		}
		
		public Builder mensagem(String mensagem) {
			this.mensagem = mensagem;
			return this;
		}
		
		public Builder audio(byte[] audio) {
			this.audio = audio;
			return this;
		}
		
		public Unanswered build() {
			return new Unanswered(this);
		}
		
	}
	public Unanswered(Builder build) {
		this.id_usuario = build.id_usuario;
		this.mensagem = build.mensagem;
		this.audio = build.audio;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_unanswered() {
		return id_unanswered;
	}
	public void setId_unanswered(int id_unanswered) {
		this.id_unanswered = id_unanswered;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public byte[] getAudio() {
		return audio;
	}
	public void setAudio(byte[] audio) {
		this.audio = audio;
	}
	
	
	
}
