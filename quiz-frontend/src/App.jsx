import { useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [quizId, setQuizId] = useState(1);
  const [questions, setQuestions] = useState([]);

  const loadQuiz = async () => {
    try {
      const res = await axios.get(`http://localhost:4242/quiz/get/${quizId}`);
      setQuestions(res.data);
    } catch (error) {
      alert("❌ Quiz not found!");
    }
  };

  return (
    <div className="container">
      <h1 className="title">Quiz Application</h1>

      {/* Input Section */}
      <div className="input-section">
        <input
          type="number"
          className="input-box"
          value={quizId}
          onChange={(e) => setQuizId(e.target.value)}
        />
        <button className="load-btn" onClick={loadQuiz}>
          Load Quiz
        </button>
      </div>

      <div className="divider"></div>

      {/* Questions */}
      <div className="questions-container">
        {questions.map((q) => (
          <div key={q.id} className="question-card">
            <h2 className="question-title">{q.questionTitle}</h2>
            <div className="options">
              <p className="option">A: {q.option1}</p>
              <p className="option">B: {q.option2}</p>
              <p className="option">C: {q.option3}</p>
              <p className="option">D: {q.option4}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
