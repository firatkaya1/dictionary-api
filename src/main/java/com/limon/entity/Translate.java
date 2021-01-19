package com.limon.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.limon.dto.TranslateDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "translate")
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "findByWord",
                classes = @ConstructorResult(
                        targetClass = TranslateDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "word_en", type = String.class),
                                @ColumnResult(name = "word_tr", type = String.class),
                                @ColumnResult(name = "category", type = String.class),
                                @ColumnResult(name = "type", type = String.class)})
        ),
        @SqlResultSetMapping(
                name = "findAllPageable",
                classes = @ConstructorResult(
                        targetClass = TranslateDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "word_en", type = String.class),
                                @ColumnResult(name = "word_tr", type = String.class),
                                @ColumnResult(name = "category", type = String.class),
                                @ColumnResult(name = "type", type = String.class)})
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name="findByWord", resultClass = TranslateDTO.class, resultSetMapping ="findByWord",
                query = "SELECT translate.id as id,english.word as word_en,turkish.word as word_tr,type.name as type,category.name as category\n" +
                        "FROM translate \n" +
                        "INNER JOIN english ON translate.english_id = english.id\n" +
                        "INNER JOIN category ON translate.category_id = category.id\n" +
                        "INNER JOIN type ON translate.type_id = type.id\n" +
                        "INNER JOIN turkish ON translate.turkish_id = turkish.id\n" +
                        "WHERE translate.english_id IN (SELECT id FROM english WHERE word LIKE :keyword)"
        ),
        @NamedNativeQuery(
                name="findAllPageable", resultClass = TranslateDTO.class, resultSetMapping ="findAllPageable",
                query = "SELECT translate.id as id,english.word as word_en,turkish.word as word_tr,type.name as type,category.name as category \n" +
                        "FROM translate \n" +
                        "INNER JOIN english ON translate.english_id = english.id\n" +
                        "INNER JOIN category ON translate.category_id = category.id\n" +
                        "INNER JOIN type ON translate.type_id = type.id\n" +
                        "INNER JOIN turkish ON translate.turkish_id = turkish.id")
})
public class Translate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties("translate")
    @OneToOne
    private English english;

    @OneToOne
    @JsonIgnoreProperties("translate")
    private Category category;

    @OneToOne
    @JsonIgnoreProperties("translate")
    private Type type;

    @OneToOne
    @JsonIgnoreProperties("translate")
    private Turkish turkish;

}
