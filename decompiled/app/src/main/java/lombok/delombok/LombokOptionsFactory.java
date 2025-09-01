package lombok.delombok;

import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Options;
import lombok.javac.Javac;
import lombok.javac.Javac6BasedLombokOptions;
import lombok.javac.Javac8BasedLombokOptions;
import lombok.javac.Javac9BasedLombokOptions;
import lombok.javac.LombokOptions;

/* loaded from: discord:lombok/delombok/LombokOptionsFactory.SCL.lombok */
public class LombokOptionsFactory {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: discord:lombok/delombok/LombokOptionsFactory$LombokOptionCompilerVersion.SCL.lombok */
    static abstract class LombokOptionCompilerVersion {
        public static final LombokOptionCompilerVersion JDK7_AND_LOWER = new AnonymousClass1("JDK7_AND_LOWER", 0);
        public static final LombokOptionCompilerVersion JDK8 = new AnonymousClass2("JDK8", 1);
        public static final LombokOptionCompilerVersion JDK9 = new AnonymousClass3("JDK9", 2);
        private static final /* synthetic */ LombokOptionCompilerVersion[] ENUM$VALUES = {JDK7_AND_LOWER, JDK8, JDK9};

        abstract LombokOptions createAndRegisterOptions(Context context);

        public static LombokOptionCompilerVersion[] values() {
            LombokOptionCompilerVersion[] lombokOptionCompilerVersionArr = ENUM$VALUES;
            int length = lombokOptionCompilerVersionArr.length;
            LombokOptionCompilerVersion[] lombokOptionCompilerVersionArr2 = new LombokOptionCompilerVersion[length];
            System.arraycopy(lombokOptionCompilerVersionArr, 0, lombokOptionCompilerVersionArr2, 0, length);
            return lombokOptionCompilerVersionArr2;
        }

        public static LombokOptionCompilerVersion valueOf(String str) {
            return (LombokOptionCompilerVersion) Enum.valueOf(LombokOptionCompilerVersion.class, str);
        }

        /* renamed from: lombok.delombok.LombokOptionsFactory$LombokOptionCompilerVersion$1, reason: invalid class name */
        /* loaded from: discord:lombok/delombok/LombokOptionsFactory$LombokOptionCompilerVersion$1.SCL.lombok */
        enum AnonymousClass1 extends LombokOptionCompilerVersion {
            AnonymousClass1(String str, int i) {
                super(str, i, null);
            }

            @Override // lombok.delombok.LombokOptionsFactory.LombokOptionCompilerVersion
            LombokOptions createAndRegisterOptions(Context context) {
                return Javac6BasedLombokOptions.replaceWithDelombokOptions(context);
            }
        }

        private LombokOptionCompilerVersion(String str, int i) {
        }

        /* synthetic */ LombokOptionCompilerVersion(String str, int i, LombokOptionCompilerVersion lombokOptionCompilerVersion) {
            this(str, i);
        }

        /* renamed from: lombok.delombok.LombokOptionsFactory$LombokOptionCompilerVersion$2, reason: invalid class name */
        /* loaded from: discord:lombok/delombok/LombokOptionsFactory$LombokOptionCompilerVersion$2.SCL.lombok */
        enum AnonymousClass2 extends LombokOptionCompilerVersion {
            AnonymousClass2(String str, int i) {
                super(str, i, null);
            }

            @Override // lombok.delombok.LombokOptionsFactory.LombokOptionCompilerVersion
            LombokOptions createAndRegisterOptions(Context context) {
                return Javac8BasedLombokOptions.replaceWithDelombokOptions(context);
            }
        }

        /* renamed from: lombok.delombok.LombokOptionsFactory$LombokOptionCompilerVersion$3, reason: invalid class name */
        /* loaded from: discord:lombok/delombok/LombokOptionsFactory$LombokOptionCompilerVersion$3.SCL.lombok */
        enum AnonymousClass3 extends LombokOptionCompilerVersion {
            AnonymousClass3(String str, int i) {
                super(str, i, null);
            }

            @Override // lombok.delombok.LombokOptionsFactory.LombokOptionCompilerVersion
            LombokOptions createAndRegisterOptions(Context context) {
                return Javac9BasedLombokOptions.replaceWithDelombokOptions(context);
            }
        }
    }

    public static LombokOptions getDelombokOptions(Context context) {
        LombokOptions options;
        Options rawOptions = Options.instance(context);
        if (rawOptions instanceof LombokOptions) {
            return (LombokOptions) rawOptions;
        }
        if (Javac.getJavaCompilerVersion() < 8) {
            options = LombokOptionCompilerVersion.JDK7_AND_LOWER.createAndRegisterOptions(context);
        } else if (Javac.getJavaCompilerVersion() == 8) {
            options = LombokOptionCompilerVersion.JDK8.createAndRegisterOptions(context);
        } else {
            options = LombokOptionCompilerVersion.JDK9.createAndRegisterOptions(context);
        }
        return options;
    }
}
