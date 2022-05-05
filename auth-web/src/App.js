import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";
import axios from "axios";

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
    console.log(username, password);

    const formData = new FormData();
    formData.append("username", username);
    formData.append("password", password);

    const URL_LOGIN_PROCESS = "http://localhost:8090/login-process";

    // axios
    //   .post(URL_LOGIN_PROCESS, formData, {
    //     headers: {
    //       "Content-Type": "multipart/form-data",
    //     },
    //   })
    //   .then((response) => {
    //     // debugger;
    //   }).catch(error => {
    //     debugger;
    //   })

    fetch(URL_LOGIN_PROCESS, {
      method: "POST",
      body: formData,
      credentials: "include",
      cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
      referrer: "http://localhost:8080",
      redirect: "follow",
    }).then((res) => {
      console.log(res);
      if (res.redirected) {
        console.log(res.url);
        alert(res.url);
        window.location.href=res.url
      }
      return res.text();
    });
  };

  return (
    <div className="App">
      <form onSubmit={handleSubmit}>
        <label>
          Username
          <input
            type="text"
            autoComplete="username"
            value={username}
            onChange={handleUsername}
          />
        </label>
        <label>
          Password
          <input
            type="password"
            autoComplete="current-password"
            value={password}
            onChange={handlePassword}
          />
        </label>
        <button type="submit">로그인</button>
      </form>
    </div>
  );
}

export default App;
