# datastore
-keepclassmembers class * extends com.google.protobuf.GeneratedMessageLite {
    <fields>;
}
# Remove log class
-assumenosideeffects class android.util.Log {
  public static *** v(...);
  public static *** d(...);
  public static *** i(...);
  public static *** w(...);
  public static *** e(...);
}