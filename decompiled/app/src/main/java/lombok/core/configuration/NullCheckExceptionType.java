package lombok.core.configuration;

import lombok.core.LombokImmutableList;
import lombok.core.handlers.HandlerUtil;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@ExampleValueString("[NullPointerException | IllegalArgumentException | Assertion | JDK | Guava]")
/* loaded from: discord:lombok/core/configuration/NullCheckExceptionType.SCL.lombok */
public abstract class NullCheckExceptionType {
    public static final NullCheckExceptionType ILLEGAL_ARGUMENT_EXCEPTION = new AnonymousClass1("ILLEGAL_ARGUMENT_EXCEPTION", 0);
    public static final NullCheckExceptionType NULL_POINTER_EXCEPTION = new AnonymousClass2("NULL_POINTER_EXCEPTION", 1);
    public static final NullCheckExceptionType ASSERTION = new AnonymousClass3("ASSERTION", 2);
    public static final NullCheckExceptionType JDK = new AnonymousClass4("JDK", 3);
    public static final NullCheckExceptionType GUAVA = new AnonymousClass5("GUAVA", 4);
    private static final /* synthetic */ NullCheckExceptionType[] ENUM$VALUES = {ILLEGAL_ARGUMENT_EXCEPTION, NULL_POINTER_EXCEPTION, ASSERTION, JDK, GUAVA};
    private static final LombokImmutableList<String> METHOD_JDK = LombokImmutableList.of("java", "util", "Objects", "requireNonNull");
    private static final LombokImmutableList<String> METHOD_GUAVA = LombokImmutableList.of("com", "google", "common", "base", "Preconditions", "checkNotNull", new String[0]);

    public abstract String getExceptionType();

    public abstract LombokImmutableList<String> getMethod();

    public static NullCheckExceptionType[] values() {
        NullCheckExceptionType[] nullCheckExceptionTypeArr = ENUM$VALUES;
        int length = nullCheckExceptionTypeArr.length;
        NullCheckExceptionType[] nullCheckExceptionTypeArr2 = new NullCheckExceptionType[length];
        System.arraycopy(nullCheckExceptionTypeArr, 0, nullCheckExceptionTypeArr2, 0, length);
        return nullCheckExceptionTypeArr2;
    }

    public static NullCheckExceptionType valueOf(String str) {
        return (NullCheckExceptionType) Enum.valueOf(NullCheckExceptionType.class, str);
    }

    /* renamed from: lombok.core.configuration.NullCheckExceptionType$1, reason: invalid class name */
    /* loaded from: discord:lombok/core/configuration/NullCheckExceptionType$1.SCL.lombok */
    enum AnonymousClass1 extends NullCheckExceptionType {
        AnonymousClass1(String str, int i) {
            super(str, i, null);
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return "java.lang.IllegalArgumentException";
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return null;
        }
    }

    private NullCheckExceptionType(String str, int i) {
    }

    /* synthetic */ NullCheckExceptionType(String str, int i, NullCheckExceptionType nullCheckExceptionType) {
        this(str, i);
    }

    /* renamed from: lombok.core.configuration.NullCheckExceptionType$2, reason: invalid class name */
    /* loaded from: discord:lombok/core/configuration/NullCheckExceptionType$2.SCL.lombok */
    enum AnonymousClass2 extends NullCheckExceptionType {
        AnonymousClass2(String str, int i) {
            super(str, i, null);
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return HandlerUtil.DEFAULT_EXCEPTION_FOR_NON_NULL;
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return null;
        }
    }

    /* renamed from: lombok.core.configuration.NullCheckExceptionType$3, reason: invalid class name */
    /* loaded from: discord:lombok/core/configuration/NullCheckExceptionType$3.SCL.lombok */
    enum AnonymousClass3 extends NullCheckExceptionType {
        AnonymousClass3(String str, int i) {
            super(str, i, null);
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return null;
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return null;
        }
    }

    /* renamed from: lombok.core.configuration.NullCheckExceptionType$4, reason: invalid class name */
    /* loaded from: discord:lombok/core/configuration/NullCheckExceptionType$4.SCL.lombok */
    enum AnonymousClass4 extends NullCheckExceptionType {
        AnonymousClass4(String str, int i) {
            super(str, i, null);
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return null;
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return NullCheckExceptionType.access$3();
        }
    }

    /* renamed from: lombok.core.configuration.NullCheckExceptionType$5, reason: invalid class name */
    /* loaded from: discord:lombok/core/configuration/NullCheckExceptionType$5.SCL.lombok */
    enum AnonymousClass5 extends NullCheckExceptionType {
        AnonymousClass5(String str, int i) {
            super(str, i, null);
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public String getExceptionType() {
            return null;
        }

        @Override // lombok.core.configuration.NullCheckExceptionType
        public LombokImmutableList<String> getMethod() {
            return NullCheckExceptionType.access$4();
        }
    }

    static /* synthetic */ LombokImmutableList access$3() {
        return METHOD_JDK;
    }

    static /* synthetic */ LombokImmutableList access$4() {
        return METHOD_GUAVA;
    }

    public String toExceptionMessage(String fieldName, String customMessage) {
        return customMessage == null ? String.valueOf(fieldName) + " is marked non-null but is null" : customMessage.replace("%s", fieldName);
    }
}
