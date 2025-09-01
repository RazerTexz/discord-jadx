package lombok.patcher;

import java.security.ProtectionDomain;

/* loaded from: discord:lombok/patcher/Filter.SCL.lombok */
public interface Filter {
    public static final Filter ALWAYS = new AnonymousClass1();

    boolean shouldTransform(ClassLoader classLoader, String str, Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr);

    /* renamed from: lombok.patcher.Filter$1, reason: invalid class name */
    /* loaded from: discord:lombok/patcher/Filter$1.SCL.lombok */
    class AnonymousClass1 implements Filter {
        AnonymousClass1() {
        }

        @Override // lombok.patcher.Filter
        public boolean shouldTransform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
            return true;
        }
    }
}
