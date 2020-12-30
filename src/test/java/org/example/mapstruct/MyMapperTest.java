package org.example.mapstruct;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class MyMapperTest {

    private final MyMapper modelMapper = Mappers.getMapper(MyMapper.class);

    @Test
    void mapModel_working() {
        // given
        var source = new SourceChild();
        source.setHolder(new SourceParent.Holder("From parent", 12));
        source.setValue("From child");

        // when
        var target = modelMapper.mapChild_working(source);

        // then
        assertEquals("From parent", target.getParentValue1());
        assertEquals(12, target.getParentValue2());
        assertEquals("From child", target.getChildValue());
    }

    @Test
    void mapModel_failing() {
        // given
        var source = new SourceChild();
        source.setHolder(new SourceParent.Holder("From parent", 12));
        source.setValue("From child");

        // when
        var target = modelMapper.mapChild_failing(source);

        // then

        // test fails in 1.4.1, field is not mapped
        assertEquals("From parent", target.getParentValue1());
        assertEquals(12, target.getParentValue2());
        assertEquals("From child", target.getChildValue());
    }
}