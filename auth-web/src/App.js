import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

function App() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleUsername = ({ target: { value } }) => {
    setUsername(value);
  };

  const handlePassword = ({ target: { value } }) => {
    setPassword(value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    
  }

  return (
    <div className="App">
      <form onSubmit={handleSubmit}>
        <label>
          Username
          <input type="text" value={username} onChange={handleUsername} />
        </label>
        <label>
          Password
          <input type="password" value={password} onChange={handlePassword} />
        </label>
        <button type="submit">
          로그인
        </button>
      </form>
    </div>
  );
}

export default App;
