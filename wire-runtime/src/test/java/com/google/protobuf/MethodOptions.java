// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: ../wire-runtime/src/test/proto/google/protobuf/descriptor.proto at 411:1
package com.google.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import java.lang.Object;
import java.lang.Override;
import java.util.Collections;
import java.util.List;

public final class MethodOptions extends Message<MethodOptions> {
  public static final ProtoAdapter<MethodOptions> ADAPTER = ProtoAdapter.forMessage(MethodOptions.class);

  private static final long serialVersionUID = 0L;

  /**
   * Note:  Field numbers 1 through 32 are reserved for Google's internal RPC
   *   framework.  We apologize for hoarding these numbers to ourselves, but
   *   we were already using them long before we decided to release Protocol
   *   Buffers.
   * The parser stores options it doesn't recognize here. See above.
   */
  @WireField(
      tag = 999,
      adapter = "com.google.protobuf.UninterpretedOption#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<UninterpretedOption> uninterpreted_option;

  public MethodOptions(List<UninterpretedOption> uninterpreted_option) {
    this.uninterpreted_option = immutableCopyOf(uninterpreted_option);
  }

  private MethodOptions(Builder builder) {
    this(builder.uninterpreted_option);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof MethodOptions)) return false;
    MethodOptions o = (MethodOptions) other;
    if (!extensionsEqual(o)) return false;
    return equals(uninterpreted_option, o.uninterpreted_option);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = extensionsHashCode();
      result = result * 37 + (uninterpreted_option != null ? uninterpreted_option.hashCode() : 1);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends com.squareup.wire.Message.Builder<MethodOptions, Builder> {
    public List<UninterpretedOption> uninterpreted_option = Collections.emptyList();

    public Builder() {
    }

    public Builder(MethodOptions message) {
      super(message);
      if (message == null) return;
      this.uninterpreted_option = copyOf(message.uninterpreted_option);
    }

    /**
     * Note:  Field numbers 1 through 32 are reserved for Google's internal RPC
     *   framework.  We apologize for hoarding these numbers to ourselves, but
     *   we were already using them long before we decided to release Protocol
     *   Buffers.
     * The parser stores options it doesn't recognize here. See above.
     */
    public Builder uninterpreted_option(List<UninterpretedOption> uninterpreted_option) {
      this.uninterpreted_option = canonicalizeList(uninterpreted_option);
      return this;
    }

    @Override
    public MethodOptions build() {
      return new MethodOptions(this);
    }
  }
}
