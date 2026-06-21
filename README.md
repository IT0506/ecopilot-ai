# 🌍 EcoPilot AI – Intelligent Carbon Footprint Assessment Platform

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![React](https://img.shields.io/badge/React-Vite-blue)
![PostgreSQL](https://img.shields.io/badge/Database-NeonDB-blueviolet)
![Docker](https://img.shields.io/badge/Container-Docker-2496ED)
![Render](https://img.shields.io/badge/Deployment-Render-success)
![License](https://img.shields.io/badge/License-MIT-yellow)

---

# 🌱 Overview

EcoPilot AI is an AI-powered sustainability platform that analyzes a user's lifestyle, calculates their estimated carbon footprint, identifies the highest emission sources, assigns a sustainability grade, and generates personalized recommendations for reducing environmental impact.

The platform demonstrates how modern cloud-native technologies, AI-driven insights, and scalable microservice-ready architecture can be combined to promote sustainable living.

---

# 🚀 Live Demo

Frontend

```
https://ecopilot-ai-frontend.onrender.com/
```

Backend API

```
https://ecopilot-ai.onrender.com
```

API Health

```
https://ecopilot-ai.onrender.com/api/carbon/health
```

---

# 🎯 Problem Statement

Climate change continues to accelerate due to increasing carbon emissions from transportation, electricity consumption, air travel, diet, and plastic usage.

Most individuals have little understanding of:

* Their personal carbon footprint
* Major emission contributors
* Sustainable alternatives
* Progress toward greener lifestyles

EcoPilot AI bridges this gap through intelligent carbon analysis and actionable recommendations.

---

# ✨ Key Features

## 👤 Lifestyle Assessment

* Personal information collection
* Transportation habits
* Electricity usage
* Dietary habits
* Air travel frequency
* Plastic consumption

---

## 🤖 AI Carbon Analysis

Automatically calculates:

* Carbon Score
* Sustainability Grade
* Major Emission Source
* Trees Required for Offset
* AI Recommendation

---

## 📊 Interactive Dashboard

Displays

* Carbon Footprint
* Sustainability Grade
* Emission Source
* Offset Trees
* AI Recommendation
* Sustainability Progress

---

## 📚 Assessment History

Users can

* View previous assessments
* Track improvements
* Compare carbon scores

---

## ☁ Cloud Database

Powered by

* PostgreSQL
* Neon Serverless Database

Features

* Automatic backups
* Serverless scaling
* Production ready

---

# 🏗 System Architecture

```
                ┌─────────────────────┐
                │      React + Vite   │
                │    Responsive UI    │
                └──────────┬──────────┘
                           │
                    Axios REST API
                           │
                           ▼
               Spring Boot REST Backend
                           │
     ┌──────────────┬──────────────┐
     │              │              │
 Carbon Engine   Recommendation   Dashboard
     │            Engine          Service
     └──────────────┬──────────────┘
                    │
              Spring Data JPA
                    │
                    ▼
           PostgreSQL (NeonDB)
                    │
                    ▼
             Cloud Deployment
                  Render
```

---

# 🧠 AI Recommendation Engine

The recommendation engine evaluates

* Transportation
* Electricity
* Flights
* Diet
* Plastic Usage

and identifies the dominant emission contributor.

Examples

Transportation

> Use public transport or carpool to reduce emissions.

Electricity

> Switch to LED lighting and energy-efficient appliances.

Flights

> Reduce unnecessary air travel.

Plastic

> Use reusable bottles and eco-friendly packaging.

Diet

> Incorporate more plant-based meals.

---

# 📈 Carbon Calculation Model

The carbon score is computed using weighted emission factors.

Transport

```
Car        = Distance × 0.18
Bike       = Distance × 0.02
Bus        = Distance × 0.08
Metro      = Distance × 0.05
Walk       = 0
Bicycle    = 0
```

Electricity

```
Electricity × 0.18
```

Flights

```
Flights × 150
```

Diet

```
Vegan        = 20
Vegetarian   = 40
Mixed        = 70
Heavy Meat   = 120
```

Plastic Usage

```
Low      = 10
Medium   = 30
High     = 60
```

---

# 🏅 Sustainability Grades

| Grade | Carbon Score |
| ----- | ------------ |
| A     | <100         |
| B     | 100–179      |
| C     | 180–259      |
| D     | 260–349      |
| E     | ≥350         |

---

# 🛠 Technology Stack

## Frontend

* React 19
* Vite
* Axios
* React Router
* CSS3

---

## Backend

* Java 21
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate
* Maven
* Lombok
* Bean Validation

---

## Database

* PostgreSQL
* Neon Serverless Database

---

## Deployment

* Docker
* Render

---

# 📂 Project Structure

```
EcoPilot-AI
│
├── frontend
│   ├── components
│   ├── pages
│   ├── services
│   ├── App.jsx
│   └── main.jsx
│
├── backend
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   ├── dto
│   ├── exception
│   └── config
│
└── README.md
```

---

# 📡 REST APIs

## Calculate Carbon

```
POST
/api/carbon/calculate
```

---

## Dashboard

```
GET
/api/carbon/dashboard
```

---

## History

```
GET
/api/carbon/history
```

---

## Assessment by ID

```
GET
/api/carbon/{id}
```

---

## Delete Assessment

```
DELETE
/api/carbon/{id}
```

---

## Health Check

```
GET
/api/carbon/health
```

---

# 🚀 Local Setup

## Clone

```bash
git clone https://github.com/IT0506/EcoPilot-AI.git
```

---

Backend

```bash
cd backend

mvn clean install

mvn spring-boot:run
```

---

Frontend

```bash
cd frontend

npm install

npm run dev
```

---

# ☁ Deployment

Backend

* Docker
* Render
* PostgreSQL (NeonDB)

Frontend

* Vite
* Render Static Site

---

# 🔒 Security

* Bean Validation
* REST API Validation
* Exception Handling
* Layered Architecture
* DTO Pattern
* Repository Pattern

---

# 📊 Scalability

The architecture supports future migration to

* Microservices
* AI/LLM Integration
* Authentication (JWT)
* OAuth
* Kubernetes
* CI/CD
* Redis Cache
* Kafka Event Streaming
* Analytics Dashboard

---

# 🌍 Future Enhancements

* Google Maps integration
* Live carbon tracking
* OCR utility bill analysis
* AI chatbot
* Carbon credit marketplace
* Leaderboards
* Gamification
* ESG reporting
* Smart home IoT integration
* Predictive carbon analytics
* Machine Learning recommendations

---

# 🏆 Highlights

✅ Production-ready architecture

✅ Cloud-native deployment

✅ Serverless PostgreSQL

✅ AI-powered recommendations

✅ Responsive React frontend

✅ Spring Boot REST API

✅ Dockerized deployment

✅ Clean layered architecture

✅ Enterprise coding standards

---

# 👩‍💻 Author

**Ifraah Tabassum**

Full Stack Java Developer | AI Enthusiast | Cloud-Native Application Developer

GitHub

```
https://github.com/IT0506
```

LinkedIn

```
https://www.linkedin.com/in/ifraah-tabassum-006618144/
```

---

# ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.

It helps others discover the project and motivates future improvements.
