import React from "react";
import { InputTool, ButtonTool } from "components/index";
import { Form, Container } from "reactstrap";

const SignUpView = (props) => {
  return (
    <div className="d-flex justify-content-center">
      <Container style={{ marginTop: 30, width: 600 }}>
        <Form>
          <InputTool
            name="username"
            label="User Name"
            error={props.errors.username}
            onChange={props.onChange}
            type="text"
            placeholder="User Name"
          />
          <InputTool
            name="displayName"
            label="Display Name"
            error={props.errors.displayName}
            onChange={props.onChange}
            type="text"
            placeholder="Display Name"
          />
          <InputTool
            name="password"
            label="Password"
            error={props.errors.password}
            onChange={props.onChange}
            type="password"
            placeholder="Password"
          />
          <InputTool
            name="confirmPassword"
            label="Confirm Password"
            error={props.errors.confirmPassword}
            onChange={props.onChange}
            type="password"
            placeholder="Confirm Password"
          />
        </Form>
        <ButtonTool
          onClick={props.onClickSignUp}
          spinner={props.pendingApiCall}
          disabled={
            props.pendingApiCall || props.errors.confirmPassword !== undefined
          }
          label="Sign Up"
        />
      </Container>
    </div>
  );
};

export default SignUpView;
