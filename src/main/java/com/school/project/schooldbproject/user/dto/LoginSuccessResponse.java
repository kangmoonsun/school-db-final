package com.school.project.schooldbproject.user.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginSuccessResponse {
    private boolean isLogin;
    private Long branchId;
}
