package com.test.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName: DataInfo
 * @Description: ENTITY
 * @Author: TIEHAN WANG
 * @Date: 2022/3/26 17:01
 * @Version: v1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("信息实体")
public class DataInfo {
    @ApiModelProperty("电话")
    private Integer phone;

    @ApiModelProperty("薪酬")
    private Integer salary;
}
