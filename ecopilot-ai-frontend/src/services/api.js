import axios from "axios";

const api = axios.create({
  baseURL:
    import.meta.env.VITE_API_URL ||
    "https://ecopilot-ai.onrender.com/api/carbon",

  headers: {
    "Content-Type": "application/json",
  },
});

export default api;
