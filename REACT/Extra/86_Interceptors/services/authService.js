import axios from "../interceptor";
import { LOGIN_URL, LOGOUT_URL, REFRESH_TOKEN_URL } from "../utils/endPoints";
const login = async (username, password) => {
  try {
    const access_token = await axios({
      url: LOGIN_URL,
      method: "POST",
      data: { username, password },
      headers: { isPublic: true },
    });
    localStorage.setItem("access_token", access_token);
  } catch (error) {
    console.log(error);
  }
};

const logout = async () => {
  try {
    await axios({
      url: LOGOUT_URL,
      method: "POST",
    });
    localStorage.removeItem("access_token");
    // Navigate to Home Page
  } catch (error) {
    console.log(error);
  }
};

const refreshToken = async () => {
  try {
    const access_token = await axios({
      url: REFRESH_TOKEN_URL,
      method: "POST",
      headers: { isPublic: true },
    });
    localStorage.setItem("access_token", access_token);
    return true
  } catch (error) {
    localStorage.removeItem("access_token");
    // Navigate to Login Page
  }
};

export { login, logout, refreshToken };
