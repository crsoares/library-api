package com.crsoares.libraryapi.api.exception;

import com.crsoares.libraryapi.exception.BusinessException;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiErrors {
    private List<String> errors;

    public ApiErrors(BindingResult bindingResult) {
        errors = new ArrayList<>();
        bindingResult.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
    }

    public ApiErrors(BusinessException ex) {
        errors = Arrays.asList(ex.getMessage());
    }

    public List<String> getErrors() {
        return errors;
    }
}
