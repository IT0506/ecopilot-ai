import api from "./api";

export const calculateCarbon = async (data) => {
  const response = await api.post("/calculate", data);
  return response.data;
};

export const getCarbonHistory = async () => {
  const response = await api.get("/history");
  return response.data;
};

export const getDashboard = async () => {
  const response = await api.get("/dashboard");
  return response.data;
};
