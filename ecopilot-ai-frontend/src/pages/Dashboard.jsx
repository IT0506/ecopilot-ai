import Navbar from "../components/Navbar";
import Footer from "../components/Footer";

function Dashboard() {
  return (
    <>
      <Navbar />

      <div className="dashboard-container">

        <h1 className="dashboard-title">
          🌿 EcoPilot AI Dashboard
        </h1>

        <p className="dashboard-subtitle">
          Here's an overview of your sustainability journey.
        </p>

        <div className="dashboard-cards">

          <div className="dashboard-card">
            <h3>Carbon Score</h3>
            <h1>612 kg</h1>
            <p>Estimated yearly CO₂ emissions</p>
          </div>

          <div className="dashboard-card">
            <h3>Sustainability Grade</h3>
            <h1>B</h1>
            <p>Good, but there's room for improvement.</p>
          </div>

          <div className="dashboard-card">
            <h3>Main Emission Source</h3>
            <h1>🚗 Transport</h1>
            <p>52% of your emissions</p>
          </div>

          <div className="dashboard-card">
            <h3>Trees Needed</h3>
            <h1>31 🌳</h1>
            <p>To offset your annual emissions</p>
          </div>

        </div>

        <div className="dashboard-section">

          <h2>🤖 AI Recommendations</h2>

          <div className="recommendation">

            <h3>Use Public Transport</h3>

            <p>
              Switching to public transport twice a week can significantly
              reduce your yearly emissions.
            </p>

          </div>

          <div className="recommendation">

            <h3>Reduce Electricity Usage</h3>

            <p>
              Turning off unused appliances can save energy and lower your
              carbon footprint.
            </p>

          </div>

          <div className="recommendation">

            <h3>Carry a Reusable Bottle</h3>

            <p>
              Reducing single-use plastic helps both the environment and your
              sustainability score.
            </p>

          </div>

        </div>

        <div className="dashboard-section">

          <h2>🎯 Weekly Goal</h2>

          <div className="goal-card">

            <h3>Walk or Cycle 15 km This Week</h3>

            <p>
              Completing this goal could reduce approximately
              <strong> 12 kg CO₂</strong>.
            </p>

          </div>

        </div>

        <div className="dashboard-section">

          <h2>📈 Progress</h2>

          <div className="progress-bar">

            <div
              className="progress-fill"
              style={{ width: "72%" }}
            ></div>

          </div>

          <p>72% of your weekly sustainability goal completed.</p>

        </div>

      </div>

      <Footer />
    </>
  );
}

export default Dashboard;