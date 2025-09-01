package lombok.core;

/* loaded from: discord:lombok/core/PostCompilerTransformation.SCL.lombok */
public interface PostCompilerTransformation {
    byte[] applyTransformations(byte[] bArr, String str, DiagnosticsReceiver diagnosticsReceiver);
}
