package model;

import javax.persistence.Id;

public class User {

    @Id
    private Long id;
    private String fio;
}
