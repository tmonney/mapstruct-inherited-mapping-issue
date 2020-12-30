package org.example.mapstruct;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;

@MapperConfig
public interface Config {

    // using a different getter pointing to the same field works
    // since the path is not a prefix of the inheriting mapping anymore
    @Mapping(target = "parentValue1", source = "holderBis")
    TargetParent mapParent_working(SourceParent parent);

    // In this case the source path is a prefix so this mapping will not
    // be generated at all
    @Mapping(target = "parentValue1", source = "holder")
    TargetParent mapParent_failing(SourceParent parent);

    // Twice the same mappings but inheriting a different configuration

    @InheritConfiguration(name = "mapParent_working")
    @Mapping(target = "childValue", source = "value")
    @Mapping(target = "parentValue2", source = "holder.parentValue2")
    TargetChild mapChild_working(SourceChild child);

    @InheritConfiguration(name = "mapParent_failing")
    @Mapping(target = "childValue", source = "value")
    @Mapping(target = "parentValue2", source = "holder.parentValue2")
    TargetChild mapChild_failing(SourceChild child);
}
