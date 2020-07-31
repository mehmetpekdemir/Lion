import React, { Component } from "react";
import SignUpView from "./SignUpView";
import * as api from "api/user";

class SignUpContainer extends Component {
  state = {
    username: null,
    displayName: null,
    password: null,
    confirmPassword: null,
    pendingApiCall: false,
    errors: {},
  };

  onChange = (event) => {
    const { name, value } = event.target;
    const errors = { ...this.state.errors };
    errors[name] = undefined;
    this.checkPassword(name, value, errors);
    this.setState({
      [name]: value,
      errors,
    });
  };

  onClickSignUp = async (event) => {
    event.preventDefault();
    const { username, displayName, password, confirmPassword } = this.state;
    const body = { username, displayName, password, confirmPassword };

    this.setState({ pendingApiCall: true });

    try {
      await api.signUp(body);
    } catch (error) {
      if (error.response.data.validationErrors) {
        this.setState({ errors: error.response.data.validationErrors });
      }
    }

    setTimeout(() => {
      this.setState({ pendingApiCall: false });
    }, 300);
  };

  checkPassword = (name, value, errors) => {
    if (name === "password" || name === "confirmPassword") {
      if (name === "password" && value !== this.state.confirmPassword) {
        errors.confirmPassword = "Password mismatch";
      } else if (name === "confirmPassword" && value !== this.state.password) {
        errors.confirmPassword = "Password mismatch";
      } else {
        errors.confirmPassword = undefined;
      }
    }
  };

  render() {
    const { pendingApiCall, errors } = this.state;
    return (
      <div>
        <SignUpView
          onChange={this.onChange}
          onClickSignUp={this.onClickSignUp}
          pendingApiCall={pendingApiCall}
          errors={errors}
        />
      </div>
    );
  }
}
export { SignUpContainer };
