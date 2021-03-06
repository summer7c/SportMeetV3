package luohao.com.sportmeetv3.service;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import luohao.com.sportmeetv3.empty.User;

/**
 * Created by luohao3 on 2017/3/25.
 */

public class LoginActService extends Thread{
    public boolean issetLogin(String username, String password) {
        if (username.equals("") || password.equals("")) {
            return false;
        }
        return true;
    }

    public boolean loginUser(String username, String password) throws JSONException, IOException, InterruptedException {
        JSONObject loginMsg = new JSONObject();
        loginMsg.put("username", username);
        loginMsg.put("password", password);
        String res = LinkService.link(loginMsg.toString(), "POST", LinkService.ADDRESS_API+"login");
        if (res == null) return false;
        if (Integer.parseInt(res) == 0) {
            return false;
        }
        return true;
    }

    public boolean regUser(User user) throws JSONException, InterruptedException {
        String regMsg = new Gson().toJson(user);
        String res = LinkService.link(regMsg, "POST", LinkService.ADDRESS_API+"reg");
        System.out.println(res);
        if (Integer.parseInt(res) == 0) return false;
        return true;
    }

    public String infoUser(String username) throws JSONException, InterruptedException {
        String res = LinkService.link(username, "POST", LinkService.ADDRESS_API+"userindex");
        return res;
    }
}
