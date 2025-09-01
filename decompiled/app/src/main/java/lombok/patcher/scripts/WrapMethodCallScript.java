package lombok.patcher.scripts;

import java.util.List;
import java.util.Set;
import lombok.patcher.Hook;
import lombok.patcher.MethodLogistics;
import lombok.patcher.MethodTarget;
import lombok.patcher.PatchScript;
import lombok.patcher.StackRequest;
import lombok.patcher.TargetMatcher;
import lombok.patcher.TransplantMapper;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* loaded from: discord:lombok/patcher/scripts/WrapMethodCallScript.SCL.lombok */
public class WrapMethodCallScript extends MethodLevelPatchScript {
    private final Hook wrapper;
    private final Hook callToWrap;
    private final boolean transplant;
    private final boolean insert;
    private final boolean leaveReturnValueIntact;
    private final Set<StackRequest> extraRequests;
    static final /* synthetic */ boolean $assertionsDisabled;

    static /* synthetic */ void access$5(Hook hook, MethodVisitor methodVisitor) {
        insertMethod(hook, methodVisitor);
    }

    static {
        $assertionsDisabled = !WrapMethodCallScript.class.desiredAssertionStatus();
    }

    static /* synthetic */ Hook access$4(WrapMethodCallScript wrapMethodCallScript) {
        return wrapMethodCallScript.wrapper;
    }

    static /* synthetic */ Hook access$0(WrapMethodCallScript wrapMethodCallScript) {
        return wrapMethodCallScript.callToWrap;
    }

    static /* synthetic */ boolean access$3(WrapMethodCallScript wrapMethodCallScript) {
        return wrapMethodCallScript.insert;
    }

    static /* synthetic */ boolean access$6(WrapMethodCallScript wrapMethodCallScript) {
        return wrapMethodCallScript.transplant;
    }

    static /* synthetic */ boolean access$1(WrapMethodCallScript wrapMethodCallScript) {
        return wrapMethodCallScript.leaveReturnValueIntact;
    }

    static /* synthetic */ Set access$2(WrapMethodCallScript wrapMethodCallScript) {
        return wrapMethodCallScript.extraRequests;
    }

    @Override // lombok.patcher.PatchScript
    public String getPatchScriptName() {
        return "wrap " + this.callToWrap.getMethodName() + " with " + this.wrapper.getMethodName() + " in " + describeMatchers();
    }

    WrapMethodCallScript(List<TargetMatcher> matchers, Hook callToWrap, Hook wrapper, boolean transplant, boolean insert, Set<StackRequest> extraRequests) {
        super(matchers);
        if (callToWrap == null) {
            throw new NullPointerException("callToWrap");
        }
        if (wrapper == null) {
            throw new NullPointerException("wrapper");
        }
        this.leaveReturnValueIntact = wrapper.getMethodDescriptor().endsWith(")V") && (!callToWrap.getMethodDescriptor().endsWith(")V") || callToWrap.isConstructor());
        this.callToWrap = callToWrap;
        this.wrapper = wrapper;
        this.transplant = transplant;
        this.insert = insert;
        if (!$assertionsDisabled && insert && transplant) {
            throw new AssertionError();
        }
        this.extraRequests = extraRequests;
    }

    /* renamed from: lombok.patcher.scripts.WrapMethodCallScript$1, reason: invalid class name */
    /* loaded from: discord:lombok/patcher/scripts/WrapMethodCallScript$1.SCL.lombok */
    class AnonymousClass1 implements PatchScript.MethodPatcherFactory {
        private final /* synthetic */ String val$classSpec;

        AnonymousClass1(String str) {
            this.val$classSpec = str;
        }

        @Override // lombok.patcher.PatchScript.MethodPatcherFactory
        public MethodVisitor createMethodVisitor(String name, String desc, MethodVisitor parent, MethodLogistics logistics) {
            return WrapMethodCallScript.this.new WrapMethodCall(parent, this.val$classSpec, logistics);
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

    /* loaded from: discord:lombok/patcher/scripts/WrapMethodCallScript$WrapMethodCall.SCL.lombok */
    private class WrapMethodCall extends MethodVisitor {
        private final String ownClassSpec;
        private final MethodLogistics logistics;

        public WrapMethodCall(MethodVisitor mv, String ownClassSpec, MethodLogistics logistics) {
            super(Opcodes.ASM7, mv);
            this.ownClassSpec = ownClassSpec;
            this.logistics = logistics;
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
            super.visitMethodInsn(opcode, owner, name, desc, itf);
            if (WrapMethodCallScript.access$0(WrapMethodCallScript.this).getClassSpec().equals(owner) && WrapMethodCallScript.access$0(WrapMethodCallScript.this).getMethodName().equals(name) && WrapMethodCallScript.access$0(WrapMethodCallScript.this).getMethodDescriptor().equals(desc)) {
                if (WrapMethodCallScript.access$1(WrapMethodCallScript.this)) {
                    if (WrapMethodCallScript.access$0(WrapMethodCallScript.this).isConstructor()) {
                        this.mv.visitInsn(89);
                    } else {
                        MethodLogistics.generateDupForType(MethodTarget.decomposeFullDesc(WrapMethodCallScript.access$0(WrapMethodCallScript.this).getMethodDescriptor()).get(0), this.mv);
                    }
                }
                if (WrapMethodCallScript.access$2(WrapMethodCallScript.this).contains(StackRequest.THIS)) {
                    this.logistics.generateLoadOpcodeForThis(this.mv);
                }
                for (StackRequest param : StackRequest.PARAMS_IN_ORDER) {
                    if (WrapMethodCallScript.access$2(WrapMethodCallScript.this).contains(param)) {
                        this.logistics.generateLoadOpcodeForParam(param.getParamPos(), this.mv);
                    }
                }
                if (WrapMethodCallScript.access$3(WrapMethodCallScript.this)) {
                    WrapMethodCallScript.access$5(WrapMethodCallScript.access$4(WrapMethodCallScript.this), this.mv);
                } else {
                    super.visitMethodInsn(Opcodes.INVOKESTATIC, WrapMethodCallScript.access$6(WrapMethodCallScript.this) ? this.ownClassSpec : WrapMethodCallScript.access$4(WrapMethodCallScript.this).getClassSpec(), WrapMethodCallScript.access$4(WrapMethodCallScript.this).getMethodName(), WrapMethodCallScript.access$4(WrapMethodCallScript.this).getMethodDescriptor(), false);
                }
            }
        }
    }
}
