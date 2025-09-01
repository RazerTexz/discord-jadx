package d0.z;

/* compiled from: KotlinReflectionNotSupportedError.kt */
/* renamed from: d0.z.b, reason: use source file name */
/* loaded from: classes3.dex */
public class KotlinReflectionNotSupportedError extends Error {
    public KotlinReflectionNotSupportedError() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }
}
