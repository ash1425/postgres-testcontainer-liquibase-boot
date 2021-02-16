package com.ashay.explore.postgrestc.view;

import lombok.Data;

@Data
public class TodoView {
    private final Long id;
    private final String description;
}
