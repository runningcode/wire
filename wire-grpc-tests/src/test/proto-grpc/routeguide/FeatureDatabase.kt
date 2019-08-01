// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: routeguide/RouteGuideProto.proto
package routeguide

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.WireField
import com.squareup.wire.internal.redactElements
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.jvm.JvmField
import okio.ByteString

/**
 * Not used in the RPC.  Instead, this is here for the form serialized to disk.
 */
class FeatureDatabase(
  @field:WireField(
    tag = 1,
    adapter = "routeguide.Feature#ADAPTER",
    label = WireField.Label.REPEATED
  )
  val feature: List<Feature> = emptyList(),
  unknownFields: ByteString = ByteString.EMPTY
) : Message<FeatureDatabase, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing {
    throw AssertionError()
  }

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is FeatureDatabase) return false
    return unknownFields == other.unknownFields
        && feature == other.feature
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = result * 37 + feature.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (feature.isNotEmpty()) result += """feature=$feature"""
    return result.joinToString(prefix = "FeatureDatabase{", separator = ", ", postfix = "}")
  }

  fun copy(feature: List<Feature> = this.feature, unknownFields: ByteString = this.unknownFields):
      FeatureDatabase = FeatureDatabase(feature, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<FeatureDatabase> = object : ProtoAdapter<FeatureDatabase>(
      FieldEncoding.LENGTH_DELIMITED, 
      FeatureDatabase::class
    ) {
      override fun encodedSize(value: FeatureDatabase): Int = 
        Feature.ADAPTER.asRepeated().encodedSizeWithTag(1, value.feature) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: FeatureDatabase) {
        Feature.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.feature)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): FeatureDatabase {
        val feature = mutableListOf<Feature>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> feature.add(Feature.ADAPTER.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return FeatureDatabase(
          feature = feature,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: FeatureDatabase): FeatureDatabase = value.copy(
        feature = value.feature.redactElements(Feature.ADAPTER),
        unknownFields = ByteString.EMPTY
      )
    }
  }
}
