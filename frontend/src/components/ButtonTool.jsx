import React from "react";
import { Button, Spinner } from "reactstrap";

const ButtonTool = (props) => {
  const { onClick, disabled, label, spinner } = props;
  return (
    <div>
      <Button type="submit" onClick={onClick} disabled={disabled}>
        {label} {spinner && <Spinner as="span" animation="grow" size="sm" />}
      </Button>
    </div>
  );
};

export { ButtonTool };
