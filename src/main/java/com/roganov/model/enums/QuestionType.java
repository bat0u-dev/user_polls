package com.roganov.model.enums;

import lombok.Getter;

@Getter
//@AllArgsConstructor
public enum QuestionType {

    TEXTANSWER("textAnswer"),
    UNIANSWER("unianswer"),
    MULTIANSWER("multianswer");

    QuestionType(String typeName) {
        this.typeName = typeName;
    }

    //    @JsonValue
    private final String typeName;

}
