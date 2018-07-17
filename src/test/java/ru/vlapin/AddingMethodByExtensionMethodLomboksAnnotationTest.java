package ru.vlapin;

import lombok.experimental.ExtensionMethod;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@UtilityClass
class SetExtensions {
    public <T> Optional<T> get(Set<T> tSet, T t) {
        return tSet.stream()
                .filter(t2 -> t2.equals(t))
                .findAny();
    }
}

@ExtensionMethod(SetExtensions.class)
public class AddingMethodByExtensionMethodLomboksAnnotationTest {

    @Test
    @DisplayName("\"get\"-method correctly adds to HashSet by Lombok`s ExtensionMethod annotation")
    void testAddMethodGetToSetByExtensionMethodLomboksAnnotation() {
        // given
        val mySet = Set.of(new Obj(1, 2), new Obj(2, 3), new Obj(3, 4));

        // when
        Optional<Obj> stringOptional = mySet.get(new Obj(1, 4));

        // then
        assertThat(stringOptional)
                .isPresent()
                .hasValue(new Obj(1, 2));
    }
}
