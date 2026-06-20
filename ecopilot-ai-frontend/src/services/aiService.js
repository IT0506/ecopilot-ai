import api from "./api";

export const getAIRecommendations = async (data) => {
  const response = await api.post("/ai/recommendations", data);
  return response.data;
};