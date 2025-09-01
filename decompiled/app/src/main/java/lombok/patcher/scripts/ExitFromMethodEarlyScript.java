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
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* loaded from: discord:lombok/patcher/scripts/ExitFromMethodEarlyScript.SCL.lombok */
public class ExitFromMethodEarlyScript extends MethodLevelPatchScript {
    private final Hook decisionWrapper;
    private final Hook valueWrapper;
    private final Set<StackRequest> requests;
    private final boolean transplant;
    private final boolean insert;
    private final boolean insertCallOnly;
    static final /* synthetic */ boolean $assertionsDisabled;

    static /* synthetic */ void access$3(Hook hook, MethodVisitor methodVisitor) {
        insertMethod(hook, methodVisitor);
    }

    static {
        $assertionsDisabled = !ExitFromMethodEarlyScript.class.desiredAssertionStatus();
    }

    static /* synthetic */ Hook access$0(ExitFromMethodEarlyScript exitFromMethodEarlyScript) {
        return exitFromMethodEarlyScript.decisionWrapper;
    }

    static /* synthetic */ Hook access$6(ExitFromMethodEarlyScript exitFromMethodEarlyScript) {
        return exitFromMethodEarlyScript.valueWrapper;
    }

    static /* synthetic */ Set access$1(ExitFromMethodEarlyScript exitFromMethodEarlyScript) {
        return exitFromMethodEarlyScript.requests;
    }

    static /* synthetic */ boolean access$2(ExitFromMethodEarlyScript exitFromMethodEarlyScript) {
        return exitFromMethodEarlyScript.insert;
    }

    static /* synthetic */ boolean access$4(ExitFromMethodEarlyScript exitFromMethodEarlyScript) {
        return exitFromMethodEarlyScript.transplant;
    }

    static /* synthetic */ boolean access$5(ExitFromMethodEarlyScript exitFromMethodEarlyScript) {
        return exitFromMethodEarlyScript.insertCallOnly;
    }

    @Override // lombok.patcher.PatchScript
    public String getPatchScriptName() {
        return "Exit Early from " + describeMatchers();
    }

    ExitFromMethodEarlyScript(List<TargetMatcher> matchers, Hook decisionWrapper, Hook valueWrapper, boolean transplant, boolean insert, Set<StackRequest> requests) {
        super(matchers);
        this.decisionWrapper = decisionWrapper;
        this.valueWrapper = valueWrapper;
        this.requests = requests;
        this.transplant = transplant;
        this.insert = insert;
        this.insertCallOnly = decisionWrapper != null && decisionWrapper.getMethodDescriptor().endsWith(")V");
        if (!this.insertCallOnly && decisionWrapper != null && !decisionWrapper.getMethodDescriptor().endsWith(")Z")) {
            throw new IllegalArgumentException("The decisionWrapper method must either return 'boolean' or return 'void'.");
        }
        if (!$assertionsDisabled && insert && transplant) {
            throw new AssertionError();
        }
    }

    /* renamed from: lombok.patcher.scripts.ExitFromMethodEarlyScript$1, reason: invalid class name */
    /* loaded from: discord:lombok/patcher/scripts/ExitFromMethodEarlyScript$1.SCL.lombok */
    class AnonymousClass1 implements PatchScript.MethodPatcherFactory {
        private final /* synthetic */ String val$classSpec;

        AnonymousClass1(String str) {
            this.val$classSpec = str;
        }

        @Override // lombok.patcher.PatchScript.MethodPatcherFactory
        public MethodVisitor createMethodVisitor(String name, String desc, MethodVisitor parent, MethodLogistics logistics) {
            if (ExitFromMethodEarlyScript.access$6(ExitFromMethodEarlyScript.this) == null && !ExitFromMethodEarlyScript.access$5(ExitFromMethodEarlyScript.this) && logistics.getReturnOpcode() != 177) {
                throw new IllegalStateException("method " + name + desc + " must return something, but you did not provide a value hook method.");
            }
            return ExitFromMethodEarlyScript.this.new ExitEarly(parent, logistics, this.val$classSpec);
        }
    }

    @Override // lombok.patcher.scripts.MethodLevelPatchScript
    protected PatchScript.MethodPatcher createPatcher(ClassWriter writer, String classSpec, TransplantMapper transplantMapper) {
        PatchScript.MethodPatcher patcher = new PatchScript.MethodPatcher(writer, transplantMapper, new AnonymousClass1(classSpec));
        if (this.transplant) {
            patcher.addTransplant(this.decisionWrapper);
            if (this.valueWrapper != null) {
                patcher.addTransplant(this.valueWrapper);
            }
        }
        return patcher;
    }

    /* loaded from: discord:lombok/patcher/scripts/ExitFromMethodEarlyScript$ExitEarly.SCL.lombok */
    private class ExitEarly extends MethodVisitor {
        private final MethodLogistics logistics;
        private final String ownClassSpec;

        public ExitEarly(MethodVisitor mv, MethodLogistics logistics, String ownClassSpec) {
            super(Opcodes.ASM7, mv);
            this.logistics = logistics;
            this.ownClassSpec = ownClassSpec;
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitCode() {
            if (ExitFromMethodEarlyScript.access$0(ExitFromMethodEarlyScript.this) == null) {
                if (this.logistics.getReturnOpcode() == 177) {
                    this.mv.visitInsn(Opcodes.RETURN);
                    return;
                } else {
                    insertValueWrapperCall();
                    return;
                }
            }
            if (ExitFromMethodEarlyScript.access$1(ExitFromMethodEarlyScript.this).contains(StackRequest.THIS)) {
                this.logistics.generateLoadOpcodeForThis(this.mv);
            }
            for (StackRequest param : StackRequest.PARAMS_IN_ORDER) {
                if (ExitFromMethodEarlyScript.access$1(ExitFromMethodEarlyScript.this).contains(param)) {
                    this.logistics.generateLoadOpcodeForParam(param.getParamPos(), this.mv);
                }
            }
            if (ExitFromMethodEarlyScript.access$2(ExitFromMethodEarlyScript.this)) {
                ExitFromMethodEarlyScript.access$3(ExitFromMethodEarlyScript.access$0(ExitFromMethodEarlyScript.this), this.mv);
            } else {
                super.visitMethodInsn(Opcodes.INVOKESTATIC, ExitFromMethodEarlyScript.access$4(ExitFromMethodEarlyScript.this) ? this.ownClassSpec : ExitFromMethodEarlyScript.access$0(ExitFromMethodEarlyScript.this).getClassSpec(), ExitFromMethodEarlyScript.access$0(ExitFromMethodEarlyScript.this).getMethodName(), ExitFromMethodEarlyScript.access$0(ExitFromMethodEarlyScript.this).getMethodDescriptor(), false);
            }
            if (ExitFromMethodEarlyScript.access$5(ExitFromMethodEarlyScript.this)) {
                super.visitCode();
                return;
            }
            Label label0 = new Label();
            this.mv.visitJumpInsn(153, label0);
            if (this.logistics.getReturnOpcode() == 177) {
                this.mv.visitInsn(Opcodes.RETURN);
            } else {
                if (ExitFromMethodEarlyScript.access$1(ExitFromMethodEarlyScript.this).contains(StackRequest.THIS)) {
                    this.logistics.generateLoadOpcodeForThis(this.mv);
                }
                for (StackRequest param2 : StackRequest.PARAMS_IN_ORDER) {
                    if (ExitFromMethodEarlyScript.access$1(ExitFromMethodEarlyScript.this).contains(param2)) {
                        this.logistics.generateLoadOpcodeForParam(param2.getParamPos(), this.mv);
                    }
                }
                if (ExitFromMethodEarlyScript.access$2(ExitFromMethodEarlyScript.this)) {
                    ExitFromMethodEarlyScript.access$3(ExitFromMethodEarlyScript.access$6(ExitFromMethodEarlyScript.this), this.mv);
                } else {
                    super.visitMethodInsn(Opcodes.INVOKESTATIC, ExitFromMethodEarlyScript.access$4(ExitFromMethodEarlyScript.this) ? this.ownClassSpec : ExitFromMethodEarlyScript.access$6(ExitFromMethodEarlyScript.this).getClassSpec(), ExitFromMethodEarlyScript.access$6(ExitFromMethodEarlyScript.this).getMethodName(), ExitFromMethodEarlyScript.access$6(ExitFromMethodEarlyScript.this).getMethodDescriptor(), false);
                }
                this.logistics.generateReturnOpcode(this.mv);
            }
            this.mv.visitLabel(label0);
            this.mv.visitFrame(3, 0, null, 0, null);
            super.visitCode();
        }

        private void insertValueWrapperCall() {
            if (ExitFromMethodEarlyScript.access$1(ExitFromMethodEarlyScript.this).contains(StackRequest.THIS)) {
                this.logistics.generateLoadOpcodeForThis(this.mv);
            }
            for (StackRequest param : StackRequest.PARAMS_IN_ORDER) {
                if (ExitFromMethodEarlyScript.access$1(ExitFromMethodEarlyScript.this).contains(param)) {
                    this.logistics.generateLoadOpcodeForParam(param.getParamPos(), this.mv);
                }
            }
            if (ExitFromMethodEarlyScript.access$2(ExitFromMethodEarlyScript.this)) {
                ExitFromMethodEarlyScript.access$3(ExitFromMethodEarlyScript.access$6(ExitFromMethodEarlyScript.this), this.mv);
            } else {
                super.visitMethodInsn(Opcodes.INVOKESTATIC, ExitFromMethodEarlyScript.access$4(ExitFromMethodEarlyScript.this) ? this.ownClassSpec : ExitFromMethodEarlyScript.access$6(ExitFromMethodEarlyScript.this).getClassSpec(), ExitFromMethodEarlyScript.access$6(ExitFromMethodEarlyScript.this).getMethodName(), ExitFromMethodEarlyScript.access$6(ExitFromMethodEarlyScript.this).getMethodDescriptor(), false);
            }
            this.logistics.generateReturnOpcode(this.mv);
        }
    }
}
