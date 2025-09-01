package lombok.patcher.scripts;

import java.util.Collection;
import java.util.List;
import lombok.patcher.MethodTarget;
import lombok.patcher.PatchScript;
import lombok.patcher.TransplantMapper;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

/* loaded from: discord:lombok/patcher/scripts/AddFieldScript.SCL.lombok */
public class AddFieldScript extends PatchScript {
    private final int accessFlags;
    private final List<String> targetClasses;
    private final String fieldName;
    private final String fieldType;
    private final Object value;

    static /* synthetic */ int access$1(AddFieldScript addFieldScript) {
        return addFieldScript.accessFlags;
    }

    static /* synthetic */ String access$0(AddFieldScript addFieldScript) {
        return addFieldScript.fieldName;
    }

    static /* synthetic */ String access$2(AddFieldScript addFieldScript) {
        return addFieldScript.fieldType;
    }

    static /* synthetic */ Object access$3(AddFieldScript addFieldScript) {
        return addFieldScript.value;
    }

    @Override // lombok.patcher.PatchScript
    public String getPatchScriptName() {
        return "AddField: " + this.fieldType + " " + this.fieldName + "to " + this.targetClasses;
    }

    AddFieldScript(List<String> targetClasses, int accessFlags, String fieldName, String fieldType, Object value) {
        if (targetClasses == null) {
            throw new NullPointerException("targetClass");
        }
        if (fieldName == null) {
            throw new NullPointerException("fieldName");
        }
        if (fieldType == null) {
            throw new NullPointerException("typeSpec");
        }
        this.accessFlags = accessFlags;
        this.targetClasses = targetClasses;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.value = value;
    }

    @Override // lombok.patcher.PatchScript
    public boolean wouldPatch(String className) {
        for (String tc : this.targetClasses) {
            if (MethodTarget.typeMatches(className, tc)) {
                return true;
            }
        }
        return false;
    }

    @Override // lombok.patcher.PatchScript
    public byte[] patch(String className, byte[] byteCode, TransplantMapper transplantMapper) {
        for (String tc : this.targetClasses) {
            if (MethodTarget.typeMatches(className, tc)) {
                return runASM(byteCode, false, transplantMapper);
            }
        }
        return null;
    }

    /* renamed from: lombok.patcher.scripts.AddFieldScript$1, reason: invalid class name */
    /* loaded from: discord:lombok/patcher/scripts/AddFieldScript$1.SCL.lombok */
    class AnonymousClass1 extends ClassVisitor {
        private boolean alreadyAdded;

        AnonymousClass1(int $anonymous0, ClassVisitor $anonymous1) {
            super($anonymous0, $anonymous1);
            this.alreadyAdded = false;
        }

        @Override // org.objectweb.asm.ClassVisitor
        public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
            if (name != null && name.equals(AddFieldScript.access$0(AddFieldScript.this))) {
                this.alreadyAdded = true;
            }
            return super.visitField(access, name, desc, signature, value);
        }

        @Override // org.objectweb.asm.ClassVisitor
        public void visitEnd() {
            if (!this.alreadyAdded) {
                FieldVisitor fv = this.cv.visitField(AddFieldScript.access$1(AddFieldScript.this), AddFieldScript.access$0(AddFieldScript.this), AddFieldScript.access$2(AddFieldScript.this), null, AddFieldScript.access$3(AddFieldScript.this));
                fv.visitEnd();
            }
            super.visitEnd();
        }
    }

    @Override // lombok.patcher.PatchScript
    protected ClassVisitor createClassVisitor(ClassWriter writer, String classSpec, TransplantMapper transplantMapper) {
        return new AnonymousClass1(Opcodes.ASM7, writer);
    }

    @Override // lombok.patcher.PatchScript
    public Collection<String> getClassesToReload() {
        return this.targetClasses;
    }
}
