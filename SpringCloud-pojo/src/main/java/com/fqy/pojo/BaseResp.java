package com.fqy.pojo;

import lombok.Data;

import java.util.List;


@Data
public class BaseResp<T> {

    private List<T> list;

    private Long total;

    private String message;

    private Long count;
}
