package com.otus.cucumber.lesson1.config;

import com.otus.cucumber.lesson1.model.Tech;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Locale;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(Tech.class, (TableEntryTransformer<Tech>) entry ->
                new Tech(Integer.valueOf(entry.get("id")), entry.get("name"))
        ));
    }
}