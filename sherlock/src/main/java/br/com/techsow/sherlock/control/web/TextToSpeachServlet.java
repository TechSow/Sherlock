package br.com.techsow.sherlock.control.web;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;

/**
 * Servlet implementation class TextToSpeachServlet
 */

public class TextToSpeachServlet extends HttpServlet {
	

	private static final long serialVersionUID = -2401066502875815163L;
	private String msg;
	public TextToSpeachServlet(String msg) {
		this.msg = msg;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IamOptions options = new IamOptions.Builder()
				.apiKey("knp5iE698AHMiak6Rz7nKnFsieZKEzBD6nJDeFizP7jd")
				.build();
		
		TextToSpeech service = new TextToSpeech(options);
		
		SynthesizeOptions sOptions = new SynthesizeOptions.Builder()
				.text(this.msg)
				.accept("audio/wav")
				.voice("pt-BR_IsabelaV3Voice")
				//.customizationId("5be7a6a4-6bc8-4331-9c39-2d81423957cc")
				.build();
		
		InputStream is = service.synthesize(sOptions)
				.execute()
				.getResult();
		InputStream in = WaveUtils.reWriteWaveHeader(is);
		
		byte[] buffer = new byte[1024 * 1024];
		try(OutputStream os = resp.getOutputStream()) {
			int length;
			while((length = in.read(buffer)) != -1) {
				os.write(buffer, 0, length);
			}
		}
	}

}
