package com.backend.modules.entity;

import lombok.Data;

import java.util.List;

@Data
public class AIMessageList {
    private List<AiMsg>messages;
}
