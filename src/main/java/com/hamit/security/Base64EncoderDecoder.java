package com.hamit.security;

import java.util.Base64;
import java.util.Scanner;

public class Base64EncoderDecoder {
	
	public static String klavye() {
		System.out.println("Şifrelenecek kelime giriniz");
		Scanner klavye = new Scanner(System.in);
		String kelime = klavye.nextLine();
		return kelime;
	}
	
	// Encoder:Sifreleme
	public static String encoderMethod(String kelime) {
		return Base64.getEncoder().encodeToString(kelime.getBytes());
	}
	
	// Decoder:Sifre cozucu
	public static String decoderMethod(String sifrelenmis) {
		return new String(Base64.getMimeDecoder().decode(sifrelenmis));
	}
	
	public static void main(String[] args) {
		// 1.YOL
		String sifrelendi = encoderMethod(klavye());
		System.out.println(sifrelendi);
		
		String coz = decoderMethod(sifrelendi);
		System.out.println(coz);
		
		// 2.YOL
		System.out.println(encoderMethod(klavye()));
		System.out.println(decoderMethod(encoderMethod(klavye())));
		
	}
	
}
