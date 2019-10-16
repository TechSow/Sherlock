package br.com.techsow.sherlock.control.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.techsow.sherlock.model.bo.UnansweredBO;
import br.com.techsow.sherlock.model.entities.Usuario;

@WebServlet("/responseAudio")
public class FullServiceServlet extends HttpServlet {

	private static final long serialVersionUID = 8243165626402208738L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		byte[] buffer = new byte[1024 * 1024];
		
		InputStream is = req.getInputStream();
		File tempFile = File.createTempFile("speech-", ".wav");
		
		try (FileOutputStream os = new FileOutputStream(tempFile)) {
			int length;
			while((length = is.read(buffer)) != -1) {
				os.write(buffer, 0, length);
			}
		}
		
		String msg = new SpeachToTextServlet()
							.speachToTextApiCall(tempFile)
							.getResults().get(0)
							.getAlternatives().get(0)
							.getTranscript();
		
		AssistantServlet assistant = new AssistantServlet();
		String response = assistant.assistantApi(msg).getOutput().getGeneric().get(0).getText();
		System.out.println(response);
		if(response.equals("Eu não entendi, poderia repetir?")) {
			
				responseTreatment(msg, buffer, req);
			
		}
		TextToSpeachServlet ttss = new TextToSpeachServlet(response);
		ttss.doPost(req, resp);
	}
	
	private void responseTreatment(String mensagem, byte[] audio, HttpServletRequest req) {
		UnansweredBO bo = new UnansweredBO();
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		bo.add(usuario.getIdUsuario(), mensagem, audio);
		
	}
}
