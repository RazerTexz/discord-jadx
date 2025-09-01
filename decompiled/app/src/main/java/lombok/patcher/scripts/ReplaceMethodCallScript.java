package lombok.patcher.scripts;

import java.util.List;
import java.util.Set;
import lombok.patcher.Hook;
import lombok.patcher.MethodLogistics;
import lombok.patcher.PatchScript;
import lombok.patcher.StackRequest;
import lombok.patcher.TargetMatcher;
import lombok.patcher.TransplantMapper;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* loaded from: discord:lombok/patcher/scripts/ReplaceMethodCallScript.SCL.lombok */
public class ReplaceMethodCallScript extends MethodLevelPatchScript {
    private final Hook wrapper;
    private final Hook methodToReplace;
    private final boolean transplant;
    private final boolean insert;
    private final Set<StackRequest> extraRequests;
    static final /* synthetic */ boolean $assertionsDisabled;

    static /* synthetic */ void access$4(Hook hook, MethodVisitor methodVisitor) {
        insertMethod(hook, methodVisitor);
    }

    static {
        $assertionsDisabled = !ReplaceMethodCallScript.class.desiredAssertionStatus();
    }

    static /* synthetic */ Hook access$3(ReplaceMethodCallScript replaceMethodCallScript) {
        return replaceMethodCallScript.wrapper;
    }

    static /* synthetic */ Hook access$0(ReplaceMethodCallScript replaceMethodCallScript) {
        return replaceMethodCallScript.methodToReplace;
    }

    static /* synthetic */ boolean access$2(ReplaceMethodCallScript replaceMethodCallScript) {
        return replaceMethodCallScript.insert;
    }

    static /* synthetic */ boolean access$5(ReplaceMethodCallScript replaceMethodCallScript) {
        return replaceMethodCallScript.transplant;
    }

    static /* synthetic */ Set access$1(ReplaceMethodCallScript replaceMethodCallScript) {
        return replaceMethodCallScript.extraRequests;
    }

    @Override // lombok.patcher.PatchScript
    public String getPatchScriptName() {
        return "replace " + this.methodToReplace.getMethodName() + " with " + this.wrapper.getMethodName() + " in " + describeMatchers();
    }

    ReplaceMethodCallScript(List<TargetMatcher> matchers, Hook callToReplace, Hook wrapper, boolean transplant, boolean insert, Set<StackRequest> extraRequests) {
        super(matchers);
        if (callToReplace == null) {
            throw new NullPointerException("callToReplace");
        }
        if (wrapper == null) {
            throw new NullPointerException("wrapper");
        }
        this.methodToReplace = callToReplace;
        this.wrapper = wrapper;
        this.transplant = transplant;
        this.insert = insert;
        if (!$assertionsDisabled && insert && transplant) {
            throw new AssertionError();
        }
        this.extraRequests = extraRequests;
    }

    /* renamed from: lombok.patcher.scripts.ReplaceMethodCallScript$1, reason: invalid class name */
    /* loaded from: discord:lombok/patcher/scripts/ReplaceMethodCallScript$1.SCL.lombok */
    class AnonymousClass1 implements PatchScript.MethodPatcherFactory {
        private final /* synthetic */ String val$classSpec;

        AnonymousClass1(String str) {
            this.val$classSpec = str;
        }

        @Override // lombok.patcher.PatchScript.MethodPatcherFactory
        public MethodVisitor createMethodVisitor(String name, String desc, MethodVisitor parent, MethodLogistics logistics) {
            return ReplaceMethodCallScript.this.new ReplaceMethodCall(parent, this.val$classSpec, logistics);
        }
    }

    @Override // lombok.patcher.scripts.MethodLevelPatchScript
    protected PatchScript.MethodPatcher createPatcher(ClassWriter writer, String classSpec, TransplantMapper transplantMapper) {
        PatchScript.MethodPatcher patcher = new PatchScript.MethodPatcher(writer, transplantMapper, new AnonymousClass1(classSpec));
        if (this.transplant) {
            patcher.addTransplant(this.wrapper);
        }
        return patcher;
    }

    /* loaded from: discord:lombok/patcher/scripts/ReplaceMethodCallScript$ReplaceMethodCall.SCL.lombok */
    private class ReplaceMethodCall extends MethodVisitor {
        private final String ownClassSpec;
        private final MethodLogistics logistics;

        public ReplaceMethodCall(MethodVisitor mv, String ownClassSpec, MethodLogistics logistics) {
            super(Opcodes.ASM7, mv);
            this.ownClassSpec = ownClassSpec;
            this.logistics = logistics;
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
            if (ReplaceMethodCallScript.access$0(ReplaceMethodCallScript.this).getClassSpec().equals(owner) && ReplaceMethodCallScript.access$0(ReplaceMethodCallScript.this).getMethodName().equals(name) && ReplaceMethodCallScript.access$0(ReplaceMethodCallScript.this).getMethodDescriptor().equals(desc)) {
                if (ReplaceMethodCallScript.access$1(ReplaceMethodCallScript.this).contains(StackRequest.THIS)) {
                    this.logistics.generateLoadOpcodeForThis(this.mv);
                }
                for (StackRequest param : StackRequest.PARAMS_IN_ORDER) {
                    if (ReplaceMethodCallScript.access$1(ReplaceMethodCallScript.this).contains(param)) {
                        this.logistics.generateLoadOpcodeForParam(param.getParamPos(), this.mv);
                    }
                }
                if (!ReplaceMethodCallScript.access$2(ReplaceMethodCallScript.this)) {
                    super.visitMethodInsn(Opcodes.INVOKESTATIC, ReplaceMethodCallScript.access$5(ReplaceMethodCallScript.this) ? this.ownClassSpec : ReplaceMethodCallScript.access$3(ReplaceMethodCallScript.this).getClassSpec(), ReplaceMethodCallScript.access$3(ReplaceMethodCallScript.this).getMethodName(), ReplaceMethodCallScript.access$3(ReplaceMethodCallScript.this).getMethodDescriptor(), itf);
                    return;
                } else {
                    ReplaceMethodCallScript.access$4(ReplaceMethodCallScript.access$3(ReplaceMethodCallScript.this), this.mv);
                    return;
                }
            }
            super.visitMethodInsn(opcode, owner, name, desc, itf);
        }
    }
}
