import React from "react";
import { Container } from "reactstrap";

const Fouter = () => {
  return (
    <div>
      <footer className="pt-4 my-md-5 pt-md-5 border-top">
        <Container>
          <div className="row">
            <div className="col-12 col-md">
              <img
                className="mb-2"
                src={require("../assets/brand/lion.png")}
                width="75"
                alt="lion"
              />
              <small className="d-block mb-3 text-muted">
                &copy; This is a Lion Project.
              </small>
            </div>
          </div>
        </Container>
      </footer>
    </div>
  );
};
export { Fouter };
