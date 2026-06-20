import Navbar from "../components/Navbar";
import Hero from "../components/Hero";
import FeatureCard from "../components/FeatureCard";
import Footer from "../components/Footer";

function Home() {

    return (

        <>

            <Navbar />

            <Hero />

            <section className="features">

                <h2>

                    Why EcoPilot AI?

                </h2>

                <div className="cards">

                    <FeatureCard

                        icon="🌿"

                        title="Carbon Calculator"

                        description="Calculate your annual carbon footprint."

                    />

                    <FeatureCard

                        icon="🤖"

                        title="AI Coach"

                        description="Receive personalized sustainability advice."

                    />

                    <FeatureCard

                        icon="📈"

                        title="Progress Tracking"

                        description="Track improvements every week."

                    />

                    <FeatureCard

                        icon="🎯"

                        title="Smart Goals"

                        description="Complete AI-generated sustainability challenges."

                    />

                </div>

            </section>

            <section className="cta">

                <h2>

                    Start Your Sustainability Journey Today

                </h2>

                <p>

                    Small actions create a greener tomorrow.

                </p>

            </section>

            <Footer />

        </>

    );

}

export default Home;