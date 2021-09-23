# datastore
-keepclassmembers class * extends com.google.protobuf.GeneratedMessageLite {
    <fields>;
}

#kotlin x serialization
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt
-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}
-keep,includedescriptorclasses class com.steleot.jetpackcompose.playground.**$$serializer { *; }
-keepclassmembers class com.steleot.jetpackcompose.playground.** {
    *** Companion;
}
-keepclasseswithmembers class com.steleot.jetpackcompose.playground.** {
    kotlinx.serialization.KSerializer serializer(...);
}
# Remove log class
-assumenosideeffects class android.util.Log {
  public static *** v(...);
  public static *** d(...);
  public static *** i(...);
  public static *** w(...);
  public static *** e(...);
}