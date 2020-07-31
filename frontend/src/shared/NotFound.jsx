import React from "react";
import { Alert } from "reactstrap";

const NotFound = (props) => {
  return (
    <div>
      <Alert color="danger">
        <h5>Page Not Found 404 !</h5>
      </Alert>
    </div>
  );
};

export { NotFound };
