package br.com.techsow.sherlock.control.web;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
				.apiKey("E2OSHu3O4cp7Q8wisbvLu3peHrbNgzk-7kKbDqAkz9k7")
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
		
		//File tempFile = File.createTempFile("speech-", ".wav");
		//byte[] buffer = new byte[1024 * 1024];
		//try (FileOutputStream os = new FileOutputStream(tempFile)) {
		//	int length;
		//	while((length = in.read(buffer)) != -1) {
		//		os.write(buffer, 0, length);
		//	}
		//}
		
		//try {
		//	AudioInputStream ais = AudioSystem.getAudioInputStream(tempFile.getAbsoluteFile());
		//	Clip clip = AudioSystem.getClip();
		//	clip.open(ais);
		//	clip.start();
		//} catch (UnsupportedAudioFileException | LineUnavailableException e) {
		//	e.printStackTrace();
		//}
	}	
}
