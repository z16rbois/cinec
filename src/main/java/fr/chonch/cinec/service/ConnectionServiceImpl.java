package fr.chonch.cinec.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.stereotype.Service;

@Service
public class ConnectionServiceImpl implements ConnectionService{

	@Override
	public void getListFiles() {
		Socket socket;
		BufferedReader in;
		final PrintWriter out;

		try {

			socket = new Socket("195.132.202.154",2009);
			System.out.println("Demande de connexion");


			final PrintWriter advsout = new PrintWriter(socket.getOutputStream(), true);
			advsout.println("message du serveur");
			//			out = new PrintWriter(outputStream);


			in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
			final String message_distant = in.readLine();
			System.out.println(message_distant);

			socket.close();

		}catch (final UnknownHostException e) {

			e.printStackTrace();
		}catch (final IOException e) {

			e.printStackTrace();
		}

	}

}
