package com.firstcomesystem.interfaces.users;

import com.firstcomesystem.application.users.UserFacade;
import com.firstcomesystem.common.response.CommonResponse;
import com.firstcomesystem.domain.users.dto.UserCommand;
import com.firstcomesystem.domain.users.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserApiController {
    private final UserFacade userFacade;

    @PostMapping
    public CommonResponse registerUser(@RequestBody UserDto.RegisterRequest request) {
        UserCommand command = request.toCommand();
        UserInfo userInfo = userFacade.registerUser(command);
        UserDto.RegisterResponse response = new UserDto.RegisterResponse(userInfo);
        return CommonResponse.success(response);
    }

}
