package lombok.core;

/* loaded from: discord:lombok/core/DiagnosticsReceiver.SCL.lombok */
public interface DiagnosticsReceiver {
    public static final DiagnosticsReceiver CONSOLE = new AnonymousClass1();

    void addError(String str);

    void addWarning(String str);

    /* renamed from: lombok.core.DiagnosticsReceiver$1, reason: invalid class name */
    /* loaded from: discord:lombok/core/DiagnosticsReceiver$1.SCL.lombok */
    class AnonymousClass1 implements DiagnosticsReceiver {
        AnonymousClass1() {
        }

        @Override // lombok.core.DiagnosticsReceiver
        public void addError(String message) {
            System.err.println("Error: " + message);
        }

        @Override // lombok.core.DiagnosticsReceiver
        public void addWarning(String message) {
            System.out.println("Warning: " + message);
        }
    }
}
