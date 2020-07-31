import React from "react";
import { FormGroup, Label, Input } from "reactstrap";

const InputTool = (props) => {
  const { label, type, placeholder, error, name, onChange } = props;
  const className = error ? "form-control is-invalid" : "form-control";

  return (
    <div>
      <FormGroup>
        <Label for={name}>{label}</Label>
        <Input
          className={className}
          name={name}
          onChange={onChange}
          type={type}
          placeholder={placeholder}
        />
        <div className="invalid-feedback">{error}</div>
      </FormGroup>
    </div>
  );
};

export { InputTool };
