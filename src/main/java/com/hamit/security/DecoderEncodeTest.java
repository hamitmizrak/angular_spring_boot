package com.hamit.security;

public class DecoderEncodeTest {
	public static void main(String[] args) {
		// header: algoritma,turu
		// {
		// "alg": "HS256",
		// "typ": "JWT"
		// }
		String header = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
		// System.out.println(Base64EncoderDecoder.decoderMethod(sifre1));
		
		// payload:Data
		// {
		// "sub": "1234567890",
		// "name": "John Doe",
		// "iat": 1516239022
		// }
		String payload = "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ";
		// System.out.println(Base64EncoderDecoder.decoderMethod(payload));
		
		// verify signature
		// HMACSHA256(
		// base64UrlEncode(header) + "." +
		// base64UrlEncode(payload),
		//
		// your-256-bit-secret
		// ) secret base64 encoded
		String signature = "SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
		System.out.println(Base64EncoderDecoder.decoderMethod(signature));
		
		// https://jwt.io/#debugger-io?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.HFrnphY_tGiQAG0AkVgRGF6-XAx2BXKeQkB2cCjSmP8
		
	}
}
