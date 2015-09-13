// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: ../wire-runtime/src/test/proto/roots.proto at 69:1
package com.squareup.wire.protos.roots;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;

public final class I extends Message<I> {
  public static final ProtoAdapter<I> ADAPTER = ProtoAdapter.forMessage(I.class);

  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_I = 0;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer i;

  public I(Integer i) {
    this.i = i;
  }

  private I(Builder builder) {
    this(builder.i);
    setBuilder(builder);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof I)) return false;
    I o = (I) other;
    if (!extensionsEqual(o)) return false;
    return equals(i, o.i);
  }

  @Override
  public int hashCode() {
    int result = hashCode;
    if (result == 0) {
      result = extensionsHashCode();
      result = result * 37 + (i != null ? i.hashCode() : 0);
      hashCode = result;
    }
    return result;
  }

  public static final class Builder extends com.squareup.wire.Message.Builder<I, Builder> {
    public Integer i;

    public Builder() {
    }

    public Builder(I message) {
      super(message);
      if (message == null) return;
      this.i = message.i;
    }

    public Builder i(Integer i) {
      this.i = i;
      return this;
    }

    @Override
    public I build() {
      return new I(this);
    }
  }
}
