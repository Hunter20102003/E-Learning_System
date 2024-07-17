

package UserManagementController.Google;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import Model.UserGoogleDto;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;

public class GoogleLogin {
public static String getToken(String code) {
    try {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    } catch (HttpResponseException e) {
        // Log the error message
        System.err.println("Failed to get access token from Google: " + e.getMessage());
        return null;
    } catch (IOException e) {
        // Log the error message
        System.err.println("An unexpected error occurred: " + e.getMessage());
        return null;
    }
}


	public static UserGoogleDto getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();

		UserGoogleDto googlePojo = new Gson().fromJson(response, UserGoogleDto.class);

		return googlePojo;
	}
}
