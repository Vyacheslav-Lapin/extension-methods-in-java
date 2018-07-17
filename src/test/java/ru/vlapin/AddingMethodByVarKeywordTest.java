package ru.vlapin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class AddingMethodByVarKeywordTest {

    @Test
    @DisplayName("\"get\"-method correctly adds to HashSet by var keyword")
    void testAddMethodGetToSetByVarKeyword() {
        // given
        var mySet = new HashSet<Obj>() {
            public Optional<Obj> get(Obj obj) {
                return stream()
                        .filter(t -> t.equals(obj))
                        .findAny();
            }
        };
        mySet.addAll(
                Set.of(new Obj(1, 2),
                        new Obj(2, 3),
                        new Obj(3, 4)));

        // when
        Optional<Obj> stringOptional = mySet.get(new Obj(1, 4));

        // then
        assertThat(stringOptional)
                .isPresent()
                .hasValue(new Obj(1, 2));
    }
}

