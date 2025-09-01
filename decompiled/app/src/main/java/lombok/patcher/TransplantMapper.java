package lombok.patcher;

/* loaded from: discord:lombok/patcher/TransplantMapper.SCL.lombok */
public interface TransplantMapper {
    public static final TransplantMapper IDENTITY_MAPPER = new AnonymousClass1();

    String mapResourceName(int i, String str);

    /* renamed from: lombok.patcher.TransplantMapper$1, reason: invalid class name */
    /* loaded from: discord:lombok/patcher/TransplantMapper$1.SCL.lombok */
    class AnonymousClass1 implements TransplantMapper {
        AnonymousClass1() {
        }

        @Override // lombok.patcher.TransplantMapper
        public String mapResourceName(int classFileFormatVersion, String resourceName) {
            return resourceName;
        }
    }
}
