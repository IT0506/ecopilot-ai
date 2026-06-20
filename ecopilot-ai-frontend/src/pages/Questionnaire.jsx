import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import { calculateCarbon } from "../services/carbonService";

function Questionnaire() {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    name: "",
    age: "",
    transport: "",
    distance: "",
    electricity: "",
    diet: "",
    flights: "",
    plasticUsage: "",
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (
      !formData.name ||
      !formData.age ||
      !formData.transport ||
      !formData.distance ||
      !formData.electricity ||
      !formData.diet
    ) {
      alert("Please fill all required fields.");
      return;
    }

	try {

	    console.log("Submitting:", formData);

	    const result = await calculateCarbon(formData);

	    console.log("Backend Response:", result);

	    alert("Assessment submitted successfully!");

	    navigate("/dashboard");

	} catch (error) {

	    console.error(error);

	    alert("Unable to submit assessment.");

	}  };

  return (
    <>
      <Navbar />

      <div className="questionnaire-container">
        <div className="questionnaire-card">

          <h1>🌿 Carbon Footprint Assessment</h1>

          <p>
            Tell us about your lifestyle so EcoPilot AI can calculate your
            carbon footprint and provide personalized recommendations.
          </p>

          <form onSubmit={handleSubmit}>

            <label>Full Name</label>
            <input
              type="text"
              name="name"
              placeholder="Enter your name"
              value={formData.name}
              onChange={handleChange}
            />

            <label>Age</label>
            <input
              type="number"
              name="age"
              placeholder="Enter your age"
              value={formData.age}
              onChange={handleChange}
            />

            <label>Primary Transport</label>
            <select
              name="transport"
              value={formData.transport}
              onChange={handleChange}
            >
              <option value="">Select</option>
              <option>Car</option>
              <option>Bike</option>
              <option>Bus</option>
              <option>Metro</option>
              <option>Bicycle</option>
              <option>Walk</option>
            </select>

            <label>Distance Travelled Per Day (km)</label>
            <input
              type="number"
              name="distance"
              placeholder="e.g. 20"
              value={formData.distance}
              onChange={handleChange}
            />

            <label>Monthly Electricity Usage (kWh)</label>
            <input
              type="number"
              name="electricity"
              placeholder="e.g. 250"
              value={formData.electricity}
              onChange={handleChange}
            />

            <label>Diet</label>
            <select
              name="diet"
              value={formData.diet}
              onChange={handleChange}
            >
              <option value="">Select</option>
              <option>Vegan</option>
              <option>Vegetarian</option>
              <option>Mixed</option>
              <option>Heavy Meat</option>
            </select>

            <label>Flights Per Year</label>
            <input
              type="number"
              name="flights"
              placeholder="e.g. 2"
              value={formData.flights}
              onChange={handleChange}
            />

            <label>Plastic Usage</label>
            <select
              name="plasticUsage"
              value={formData.plasticUsage}
              onChange={handleChange}
            >
              <option value="">Select</option>
              <option>Low</option>
              <option>Medium</option>
              <option>High</option>
            </select>

            <button className="btn" type="submit">
              Analyze My Carbon Footprint 🌿
            </button>

          </form>

        </div>
      </div>

      <Footer />
    </>
  );
}

export default Questionnaire;