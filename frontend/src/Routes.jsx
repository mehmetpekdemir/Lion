import React from "react";
import { Route, Switch } from "react-router-dom";

//Home
import { HomeContainer } from "./containers/home";
//Sign Up
import { SignUpContainer } from "./containers/signUp";
//Sign In
import { SignInContainer } from "./containers/signIn";
//NotFound
import { NotFound } from "./shared/NotFound";

const Routes = () => {
  return (
    <div>
      <Switch>
        <Route exact path="/" component={HomeContainer} />
        <Route path="/sign-up" component={SignUpContainer} />
        <Route path="/sign-in" component={SignInContainer} />
        <Route component={NotFound} />
      </Switch>
    </div>
  );
};

export default Routes;
