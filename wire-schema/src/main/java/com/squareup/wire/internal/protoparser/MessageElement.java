/*
 * Copyright (C) 2013 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.wire.internal.protoparser;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import com.squareup.wire.schema.Location;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.squareup.wire.internal.Util.appendDocumentation;
import static com.squareup.wire.internal.Util.appendIndented;

@AutoValue
public abstract class MessageElement implements TypeElement {
  public static Builder builder(Location location) {
    return new Builder(location);
  }

  MessageElement() {
  }

  @Override public abstract Location location();
  @Override public abstract String name();
  @Override public abstract String qualifiedName();
  @Override public abstract String documentation();
  public abstract List<FieldElement> fields();
  public abstract List<OneOfElement> oneOfs();
  @Override public abstract List<TypeElement> nestedElements();
  public abstract List<ExtensionsElement> extensions();
  @Override public abstract List<OptionElement> options();

  @Override public final String toSchema() {
    StringBuilder builder = new StringBuilder();
    appendDocumentation(builder, documentation());
    builder.append("message ")
        .append(name())
        .append(" {");
    if (!options().isEmpty()) {
      builder.append('\n');
      for (OptionElement option : options()) {
        appendIndented(builder, option.toSchemaDeclaration());
      }
    }
    if (!fields().isEmpty()) {
      builder.append('\n');
      for (FieldElement field : fields()) {
        appendIndented(builder, field.toSchema());
      }
    }
    if (!oneOfs().isEmpty()) {
      builder.append('\n');
      for (OneOfElement oneOf : oneOfs()) {
        appendIndented(builder, oneOf.toSchema());
      }
    }
    if (!extensions().isEmpty()) {
      builder.append('\n');
      for (ExtensionsElement extension : extensions()) {
        appendIndented(builder, extension.toSchema());
      }
    }
    if (!nestedElements().isEmpty()) {
      builder.append('\n');
      for (TypeElement type : nestedElements()) {
        appendIndented(builder, type.toSchema());
      }
    }
    return builder.append("}\n").toString();
  }

  public static final class Builder {
    private Location location;
    private String name;
    private String qualifiedName;
    private String documentation = "";
    private final List<FieldElement> fields = new ArrayList<>();
    private final List<OneOfElement> oneOfs = new ArrayList<>();
    private final List<TypeElement> nestedElements = new ArrayList<>();
    private final List<ExtensionsElement> extensions = new ArrayList<>();
    private final List<OptionElement> options = new ArrayList<>();

    private Builder(Location location) {
      this.location = checkNotNull(location, "location");
    }

    public Builder name(String name) {
      this.name = checkNotNull(name, "name");
      if (qualifiedName == null) {
        qualifiedName = name;
      }
      return this;
    }

    public Builder qualifiedName(String qualifiedName) {
      this.qualifiedName = checkNotNull(qualifiedName, "qualifiedName");
      return this;
    }

    public Builder documentation(String documentation) {
      this.documentation = checkNotNull(documentation, "documentation");
      return this;
    }

    public Builder addField(FieldElement field) {
      fields.add(checkNotNull(field, "field"));
      return this;
    }

    public Builder addFields(Collection<FieldElement> fields) {
      for (FieldElement field : checkNotNull(fields, "fields")) {
        addField(field);
      }
      return this;
    }

    public Builder addOneOf(OneOfElement oneOf) {
      oneOfs.add(checkNotNull(oneOf, "oneOf"));
      return this;
    }

    public Builder addOneOfs(Collection<OneOfElement> oneOfs) {
      for (OneOfElement oneOf : checkNotNull(oneOfs, "oneOfs")) {
        addOneOf(oneOf);
      }
      return this;
    }

    public Builder addType(TypeElement type) {
      nestedElements.add(checkNotNull(type, "type"));
      return this;
    }

    public Builder addTypes(Collection<TypeElement> types) {
      for (TypeElement type : checkNotNull(types, "types")) {
        addType(type);
      }
      return this;
    }

    public Builder addExtensions(ExtensionsElement extensions) {
      this.extensions.add(checkNotNull(extensions, "extensions"));
      return this;
    }

    public Builder addExtensions(Collection<ExtensionsElement> extensions) {
      for (ExtensionsElement extension : checkNotNull(extensions, "extensions")) {
        addExtensions(extension);
      }
      return this;
    }

    public Builder addOption(OptionElement option) {
      options.add(checkNotNull(option, "option"));
      return this;
    }

    public Builder addOptions(Collection<OptionElement> options) {
      for (OptionElement option : checkNotNull(options, "options")) {
        addOption(option);
      }
      return this;
    }

    public MessageElement build() {
      checkNotNull(name, "name");
      checkNotNull(qualifiedName, "qualifiedName");

      return new AutoValue_MessageElement(location, name, qualifiedName, documentation,
          ImmutableList.copyOf(fields), ImmutableList.copyOf(oneOfs),
          ImmutableList.copyOf(nestedElements),
          ImmutableList.copyOf(extensions), ImmutableList.copyOf(options));
    }
  }
}
