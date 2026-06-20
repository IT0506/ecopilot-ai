import { Link } from "react-router-dom";

function Hero() {
  return (
    <section className="hero">

      <div className="hero-left">

        <h1>
          Understand Your Carbon Footprint.
        </h1>

        <h2>
          Reduce It With AI.
        </h2>

        <p>
          EcoPilot AI analyzes your lifestyle,
          identifies your biggest emission sources,
          and gives personalized recommendations
          to help you live more sustainably.
        </p>

        <Link to="/questionnaire">
          <button className="btn">
            Start Assessment →
          </button>
        </Link>

      </div>

      <div className="hero-right">

	  <div className="hero-card">
	    <h3>🌍 Sustainability Score</h3>

	    <h1>--</h1>

	    <p>Take the assessment to see your score</p>
	  </div>

      </div>

    </section>
  );
}

export default Hero;