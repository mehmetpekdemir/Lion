import React, { Component } from "react";

import { Header, Fouter } from "./shared";

import Routes from "./Routes";

class App extends Component {
  render() {
    return (
      <div>
        <Header />
        <Routes />
        <Fouter />
      </div>
    );
  }
}
export default App;
