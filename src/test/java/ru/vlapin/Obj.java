package ru.vlapin;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(exclude = "y")
class Obj {
    int x;
    int y;
}
