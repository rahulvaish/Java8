package encodingdecoding;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncodingDecoding {

	public static void main(String[] args) {
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = "username:password";
		String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
		System.out.println(encodedString);
		
		//
		
		Base64.Decoder decoder = Base64.getDecoder();
		String decodedString = new String(decoder.decode(encodedString.getBytes(StandardCharsets.UTF_8)));
		System.out.println(decodedString);

		
		//NOTE: bytearray[] to String ---> new String() not .toString()
	}

}
