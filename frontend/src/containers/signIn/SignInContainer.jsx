import React, { Component } from "react";
import SignInView from "./SignInView";
import * as api from "api/user";
import axios from "axios";

class SignInContainer extends Component {
  state = {
    username: null,
    password: null,
    error: null,
    pendingApiCall: false,
  };

  componentDidMount() {
    axios.interceptors.request.use((request) => {
      this.setState({ pendingApiCall: true });
      return request;
    });

    axios.interceptors.response.use(
      (response) => {
        this.setState({ pendingApiCall: false });
        return response;
      },
      (error) => {
        this.setState({ pendingApiCall: false });
        throw error;
      }
    );
  }

  onChange = (event) => {
    const { name, value } = event.target;
    this.setState({
      [name]: value,
      error: null,
    });
  };

  onClickSignIn = async (event) => {
    event.preventDefault();

    const { username, password } = this.state;
    const body = { username, password };

    this.setState({ error: null });
    try {
      await api.signIn(body);
    } catch (apiError) {
      this.setState({ error: apiError.response.data.message });
    }
  };

  render() {
    const { username, password, error, pendingApiCall } = this.state;
    const buttonEnabled = username && password;
    return (
      <div>
        <SignInView
          onChange={this.onChange}
          onClickSignIn={this.onClickSignIn}
          error={error}
          buttonEnabled={buttonEnabled}
          pendingApiCall={pendingApiCall}
        />
      </div>
    );
  }
}
export { SignInContainer };
