
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.geesiam.encode.Encoder;

public class GeesiamSender {
	public static void main(String args[]) throws Exception {

		String did = "";
		String pph = "test";
		String enc = "false";
		String msg = "Hello world";
		String urlEnc = "true";

		Encoder encoder = new Encoder();
		msg = encoder.encode(msg, pph, urlEnc);

		String urlParameters = "did=" + did + "&pph=" + pph + "&enc=" + enc
				+ "&msg=" + msg;

		URL url;
		HttpURLConnection connection = null;
		try {
			url = new URL("https://geesiam-backend.appspot.com/push");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			DataOutputStream dos = new DataOutputStream(
					connection.getOutputStream());
			dos.writeBytes(urlParameters);
			dos.flush();
			dos.close();

			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = br.readLine()) != null) {
				response.append(line);
			}
			br.close();
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}

	}

}
