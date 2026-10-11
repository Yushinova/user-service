package com.example.userservice.assembler;

import com.example.userservice.controller.UserController;
import com.example.userservice.dto.UserModel;
import com.example.userservice.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<UserResponse, UserModel> {

    public UserModelAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    protected UserModel instantiateModel(UserResponse response) {
        return new UserModel(
                response.id(),
                response.name(),
                response.email(),
                response.age()
        );
    }

    @Override
    public UserModel toModel(UserResponse response) {
        UserModel model = createModelWithId(response.id(), response);
        model.add(
                linkTo(methodOn(UserController.class).getAllUsers()).withRel("all-users"),
                linkTo(methodOn(UserController.class).updateUser(response.id(), null)).withRel("update"),
                linkTo(methodOn(UserController.class).deleteUser(response.id())).withRel("delete")
        );

        return model;
    }
}
