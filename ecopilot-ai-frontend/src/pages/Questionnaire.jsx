import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import { calculateCarbon } from "../services/carbonService";

function Questionnaire() {
  const navigate = useNavigate();

  const [loading, setLoading] = useState(false);

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
    const { name, value } = e.target;

    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const validateForm = () => {
    if (formData.name.trim() === "") {
      alert("Please enter your name.");
      return false;
    }

    if (!formData.age || Number(formData.age) <= 0) {
      alert("Please enter a valid age.");
      return false;
    }

    if (!formData.transport) {
      alert("Please select your transport.");
      return false;
    }

    if (!formData.distance || Number(formData.distance) <= 0) {
      alert("Distance must be greater than 0.");
      return false;
    }

    if (!formData.electricity || Number(formData.electricity) <= 0) {
      alert("Electricity usage must be greater than 0.");
      return false;
    }

    if (!formData.diet) {
      alert("Please select your diet.");
      return false;
    }

    if (formData.flights === "" || Number(formData.flights) < 0) {
      alert("Flights cannot be negative.");
      return false;
    }

    if (!formData.plasticUsage) {
      alert("Please select plastic usage.");
      return false;
    }

    return true;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!validateForm()) return;

    setLoading(true);

    const payload = {
      name: formData.name.trim(),
      age: Number(formData.age),
      transport: formData.transport,
      distance: Number(formData.distance),
      electricity: Number(formData.electricity),
      diet: formData.diet,
      flights: Number(formData.flights),
      plasticUsage: formData.plasticUsage,
    };

    console.log("Payload Sent:");
    console.log(payload);

    try {
      const response = await calculateCarbon(payload);

      console.log("Backend Response:");
      console.log(response);

      const result = response.data;

      localStorage.setItem(
        "carbonResult",
        JSON.stringify(result)
      );

      navigate("/dashboard", {
        state: result,
      });

    } catch (error) {

      console.error(error);

      if (error.response) {
        console.log("Status:", error.response.status);
        console.log("Backend Error:", error.response.data);

        if (error.response.data.message) {
          alert(error.response.data.message);
        } else {
          alert("Unable to submit assessment.");
        }
      } else {
        alert("Cannot connect to backend server.");
      }

    } finally {
      setLoading(false);
    }
  };

  return (
    <>
      <Navbar />

      <div className="questionnaire-container">

        <div className="questionnaire-card">

          <h1>🌿 Carbon Footprint Assessment</h1>

          <p>
            Tell us about your lifestyle so EcoPilot AI can
            calculate your carbon footprint and generate
            personalized recommendations.
          </p>

          <form onSubmit={handleSubmit}>

            <label>Full Name</label>

            <input
              type="text"
              name="name"
              placeholder="Enter your name"
              value={formData.name}
              onChange={handleChange}
              required
            />

            <label>Age</label>

            <input
              type="number"
              name="age"
              placeholder="Enter your age"
              value={formData.age}
              onChange={handleChange}
              min="1"
              required
            />

            <label>Primary Transport</label>

            <select
              name="transport"
              value={formData.transport}
              onChange={handleChange}
              required
            >
              <option value="">Select</option>
              <option value="Car">Car</option>
              <option value="Bike">Bike</option>
              <option value="Bus">Bus</option>
              <option value="Metro">Metro</option>
              <option value="Bicycle">Bicycle</option>
              <option value="Walk">Walk</option>
            </select>

            <label>Distance Travelled Per Day (km)</label>

            <input
              type="number"
              name="distance"
              placeholder="e.g. 20"
              value={formData.distance}
              onChange={handleChange}
              min="1"
              step="0.1"
              required
            />

            <label>Monthly Electricity Usage (kWh)</label>

            <input
              type="number"
              name="electricity"
              placeholder="e.g. 250"
              value={formData.electricity}
              onChange={handleChange}
              min="1"
              step="0.1"
              required
            />

            <label>Diet</label>

            <select
              name="diet"
              value={formData.diet}
              onChange={handleChange}
              required
            >
              <option value="">Select</option>
              <option value="Vegan">Vegan</option>
              <option value="Vegetarian">Vegetarian</option>
              <option value="Mixed">Mixed</option>
              <option value="Heavy Meat">Heavy Meat</option>
            </select>

            <label>Flights Per Year</label>

            <input
              type="number"
              name="flights"
              placeholder="e.g. 2"
              value={formData.flights}
              onChange={handleChange}
              min="0"
              required
            />

            <label>Plastic Usage</label>

            <select
              name="plasticUsage"
              value={formData.plasticUsage}
              onChange={handleChange}
              required
            >
              <option value="">Select</option>
              <option value="Low">Low</option>
              <option value="Medium">Medium</option>
              <option value="High">High</option>
            </select>

            <button
              className="btn"
              type="submit"
              disabled={loading}
            >
              {loading
                ? "Analyzing..."
                : "Analyze My Carbon Footprint 🌿"}
            </button>

          </form>

        </div>

      </div>

      <Footer />
    </>
  );
}

export default Questionnaire;

