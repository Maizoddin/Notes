import axios from "axios";
import { refreshToken } from "./services/authService";
const BASE_URL = process.env.REACT_APP_BASE_URL;

const axiosInstance = axios.create({
  baseURL: BASE_URL,
  headers: {
    "Content-Type": "application/json",
  },
  withCredentials: true,
});

axiosInstance.interceptors.request.use(
  (config) => {
    if (config.headers.isPublic) {
      return config;
    }
    const access_token = localStorage.getItem("access_token");
    if (!access_token) {
      // Navigate to Lagin Page
      return;
    }
    config.headers["Authorization"] = `Bearer ${access_token}`;
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

axiosInstance.interceptors.response.use(
  (response) => response.data,
  async (error) => {
    const originalRequest = error.config;
    const status = error?.response?.status;
    const statusText = error?.response?.statusText;
    // UnAuthorised
    if (status === 401 && !error.config.headers.isPublic) {
      if (statusText === "Token Expired" && !originalRequest._retry) {
        originalRequest._retry = true;
        const isRefreshTokenSuccessful = await refreshToken();
        if (isRefreshTokenSuccessful) {
          axiosInstance(originalRequest);
        }
        return;
      } else {
        // Invalid Token
        // Logout and Navigate to Login
      }
    } else {
      return Promise.reject(error);
    }
  }
);
export default axiosInstance;
