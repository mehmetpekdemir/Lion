import React from "react";
import { InputTool, ButtonTool } from "components/index";
import { Form, Container, Alert } from "reactstrap";

const SignInView = (props) => {
  return (
    <div className="d-flex justify-content-center">
      <Container style={{ marginTop: 30, width: 600 }}>
        <Form>
          <InputTool
            name="username"
            label="User Name"
            error={false}
            onChange={props.onChange}
            type="text"
            placeholder="User Name"
          />
          <InputTool
            name="password"
            label="Password"
            error={false}
            onChange={props.onChange}
            type="password"
            placeholder="Password"
          />
        </Form>
        <ButtonTool
          onClick={props.onClickSignIn}
          spinner={props.pendingApiCall}
          disabled={!props.buttonEnabled || props.pendingApiCall}
          label="Sign In"
        />
        <br></br>
        {props.error && <Alert color="primary">{props.error}</Alert>}
      </Container>
    </div>
  );
};

export default SignInView;
