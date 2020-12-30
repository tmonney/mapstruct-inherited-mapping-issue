package org.example.mapstruct;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

@Mapper(config = Config.class)
public interface MyMapper {

    @InheritConfiguration(name = "mapChild_working")
    TargetChild mapChild_working(SourceChild child);

    @InheritConfiguration(name = "mapChild_failing")
    TargetChild mapChild_failing(SourceChild child);

    // Would typically be in a helper class defined as 'uses' in the MapperConfig
    default String parentValue1(SourceParent.Holder holder) {
        return holder.getParentValue1();
    }
}
