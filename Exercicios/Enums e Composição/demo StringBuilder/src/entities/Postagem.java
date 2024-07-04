package entities;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Postagem {
	
	private static 	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date dataPostagem;
	private String tituloPostagem;
	private String conteudoPostagem;
	private int likesPostagem;

	private List<Comentario> comments = new ArrayList<>();
	
	// Construtores
	
	public Postagem() {
	}

	public Postagem(Date dataPostagem, String tituloPostagem, String conteudoPostagem, int likesPostagem) {
		this.dataPostagem = dataPostagem;
		this.tituloPostagem = tituloPostagem;
		this.conteudoPostagem = conteudoPostagem;
		this.likesPostagem = likesPostagem;
	}
	
	// Getters e Setters

	public Date getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Date dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public String getTituloPostagem() {
		return tituloPostagem;
	}

	public void setTituloPostagem(String tituloPostagem) {
		this.tituloPostagem = tituloPostagem;
	}

	public String getConteudoPostagem() {
		return conteudoPostagem;
	}

	public void setConteudoPostagem(String conteudoPostagem) {
		this.conteudoPostagem = conteudoPostagem;
	}

	public int getLikesPostagem() {
		return likesPostagem;
	}

	public void setLikesPostagem(int likesPostagem) {
		this.likesPostagem = likesPostagem;
	}

	public List<Comentario> getComments() {
		return comments;
	}
	
	public void addComments(Comentario comentario) {
		comments.add(comentario);
	}
	
	public void removeComments(Comentario comentario) {
		comments.remove(comentario);
	}	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(tituloPostagem + "\n");
		sb.append(likesPostagem);
		sb.append(" Likes - ");
		sb.append(sdf.format(dataPostagem) + "\n");
		sb.append(conteudoPostagem + "\n");
		sb.append("Comentários:\n");
		for (Comentario c : comments) {
			sb.append(c.getTexto() + "\n");
		}
		return sb.toString();
	}
}
