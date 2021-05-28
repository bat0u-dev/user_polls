package model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum QuestionType {

    TEXTANSWER("textAnswer"),
    UNIANSWER("unianswer"),
    MULTIANSWER("multianswer");

    @JsonValue
    private final String typeName;

}
