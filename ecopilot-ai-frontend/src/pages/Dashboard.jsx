import { useLocation, useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";

function Dashboard() {
  const location = useLocation();
  const navigate = useNavigate();

  // Get result from navigation OR localStorage (supports page refresh)
  let result = location.state;

  if (!result) {
    const saved = localStorage.getItem("carbonResult");

    if (saved) {
      try {
        result = JSON.parse(saved);
      } catch (error) {
        console.error(error);
      }
    }
  }

  // No data available
  if (!result) {
    return (
      <>
        <Navbar />

        <div className="dashboard-container">

          <h1>No Assessment Found</h1>

          <p>
            Please complete the carbon assessment first.
          </p>

          <button
            className="btn"
            onClick={() => navigate("/questionnaire")}
          >
            Start Assessment
          </button>

        </div>

        <Footer />
      </>
    );
  }

  // ----------------------------
  // Grade Descriptions
  // ----------------------------

  const gradeDescriptions = {
    A: "Excellent sustainability performance.",
    B: "Good performance. Small improvements can help.",
    C: "Average sustainability. Improvement recommended.",
    D: "High carbon emissions detected.",
    E: "Very high emissions. Immediate action recommended.",
  };

  // ----------------------------
  // Progress Calculation
  // ----------------------------

  const progressMap = {
    A: 100,
    B: 80,
    C: 60,
    D: 40,
    E: 20,
  };

  const progress =
    progressMap[result.sustainabilityGrade] || 0;

  // ----------------------------
  // Emission Source Icons
  // ----------------------------

  const emissionIcons = {
    Transportation: "🚗",
    Electricity: "⚡",
    Diet: "🍽",
    "Air Travel": "✈",
    "Plastic Usage": "🛍",
  };

  const sourceIcon =
    emissionIcons[result.majorEmissionSource] || "🌍";

  // ----------------------------
  // Progress Color
  // ----------------------------

  const progressColor = () => {
    switch (result.sustainabilityGrade) {
      case "A":
        return "#16a34a";

      case "B":
        return "#22c55e";

      case "C":
        return "#facc15";

      case "D":
        return "#f97316";

      default:
        return "#ef4444";
    }
  };

  return (
    <>
      <Navbar />

      <div className="dashboard-container">

        <h1 className="dashboard-title">
          🌿 EcoPilot AI Dashboard
        </h1>

        <p className="dashboard-subtitle">
          Your personalized sustainability report.
        </p>

        {/* Cards */}

        <div className="dashboard-cards">

          <div className="dashboard-card">

            <h3>Carbon Score</h3>

            <h1>
              {result.carbonScore.toFixed(2)} kg
            </h1>

            <p>
              Estimated carbon footprint
            </p>

          </div>

          <div className="dashboard-card">

            <h3>Sustainability Grade</h3>

            <h1>{result.sustainabilityGrade}</h1>

            <p>
              {
                gradeDescriptions[
                  result.sustainabilityGrade
                ]
              }
            </p>

          </div>

          <div className="dashboard-card">

            <h3>Main Emission Source</h3>

            <h1>
              {sourceIcon}
            </h1>

            <p>
              {result.majorEmissionSource}
            </p>

          </div>

          <div className="dashboard-card">

            <h3>Trees Needed</h3>

            <h1>
              {result.treesNeeded} 🌳
            </h1>

            <p>
              Trees required to offset emissions
            </p>

          </div>

        </div>

        {/* Recommendation */}

        <div className="dashboard-section">

          <h2>
            🤖 AI Recommendation
          </h2>

          <div className="recommendation">

            <h3>
              Personalized Advice
            </h3>

            <p>
              {result.aiRecommendation}
            </p>

          </div>

        </div>

        {/* Weekly Goal */}

        <div className="dashboard-section">

          <h2>
            🎯 Sustainability Goal
          </h2>

          <div className="goal-card">

            <h3>
              Improve Your Sustainability Grade
            </h3>

            <p>
              Follow the recommendation above to reduce
              your emissions and improve your grade in
              the next assessment.
            </p>

          </div>

        </div>

        {/* Progress */}

        <div className="dashboard-section">

          <h2>
            📈 Sustainability Progress
          </h2>

          <div className="progress-bar">

            <div
              className="progress-fill"
              style={{
                width: `${progress}%`,
                background: progressColor(),
              }}
            ></div>

          </div>

          <p>
            {progress}% Sustainable Lifestyle Score
          </p>

        </div>

        {/* Buttons */}

        <div
          style={{
            marginTop: "40px",
            display: "flex",
            gap: "15px",
            justifyContent: "center",
            flexWrap: "wrap",
          }}
        >

          <button
            className="btn"
            onClick={() => navigate("/questionnaire")}
          >
            New Assessment
          </button>

        </div>

      </div>

      <Footer />
    </>
  );
}

export default Dashboard;

