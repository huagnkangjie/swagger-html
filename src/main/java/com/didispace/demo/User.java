package com.didispace.demo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户基本信息")
public class User {

    @ApiModelProperty(value = "姓名", example = "张三")
    @Size(max = 20)
    private String name;

    @ApiModelProperty(value = "年龄", example = "12")
    @Max(150)
    @Min(1)
    private Integer age;

    @ApiModelProperty(value = "地址", example = "重庆市南滨路")
    @NotNull
    private String address;


    @ApiModelProperty(value = "电子邮件", example = "123456789@qq.com")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
    private String email;

}