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

/* loaded from: discord:lombok/patcher/scripts/WrapReturnValuesScript.SCL.lombok */
public final class WrapReturnValuesScript extends MethodLevelPatchScript {
    private final Hook wrapper;
    private final Set<StackRequest> requests;
    private final boolean hijackReturnValue;
    private final boolean transplant;
    private final boolean insert;
    private final boolean cast;
    static final /* synthetic */ boolean $assertionsDisabled;

    static /* synthetic */ void access$5(Hook hook, MethodVisitor methodVisitor) {
        insertMethod(hook, methodVisitor);
    }

    static {
        $assertionsDisabled = !WrapReturnValuesScript.class.desiredAssertionStatus();
    }

    static /* synthetic */ Hook access$4(WrapReturnValuesScript wrapReturnValuesScript) {
        return wrapReturnValuesScript.wrapper;
    }

    static /* synthetic */ Set access$1(WrapReturnValuesScript wrapReturnValuesScript) {
        return wrapReturnValuesScript.requests;
    }

    static /* synthetic */ boolean access$2(WrapReturnValuesScript wrapReturnValuesScript) {
        return wrapReturnValuesScript.hijackReturnValue;
    }

    static /* synthetic */ boolean access$3(WrapReturnValuesScript wrapReturnValuesScript) {
        return wrapReturnValuesScript.insert;
    }

    static /* synthetic */ boolean access$6(WrapReturnValuesScript wrapReturnValuesScript) {
        return wrapReturnValuesScript.transplant;
    }

    static /* synthetic */ boolean access$7(WrapReturnValuesScript wrapReturnValuesScript) {
        return wrapReturnValuesScript.cast;
    }

    @Override // lombok.patcher.PatchScript
    public String getPatchScriptName() {
        return "wrap returns with " + this.wrapper.getMethodName() + " in " + describeMatchers();
    }

    WrapReturnValuesScript(List<TargetMatcher> matchers, Hook wrapper, boolean transplant, boolean insert, boolean cast, Set<StackRequest> requests) {
        super(matchers);
        if (wrapper == null) {
            throw new NullPointerException("wrapper");
        }
        this.wrapper = wrapper;
        this.hijackReturnValue = !wrapper.getMethodDescriptor().endsWith(")V");
        this.requests = requests;
        this.transplant = transplant;
        this.insert = insert;
        this.cast = cast && this.hijackReturnValue;
        if (!$assertionsDisabled && insert && transplant) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && cast && insert) {
            throw new AssertionError();
        }
    }

    /* renamed from: lombok.patcher.scripts.WrapReturnValuesScript$1, reason: invalid class name */
    /* loaded from: discord:lombok/patcher/scripts/WrapReturnValuesScript$1.SCL.lombok */
    class AnonymousClass1 implements PatchScript.MethodPatcherFactory {
        private final /* synthetic */ String val$classSpec;

        AnonymousClass1(String str) {
            this.val$classSpec = str;
        }

        @Override // lombok.patcher.PatchScript.MethodPatcherFactory
        public MethodVisitor createMethodVisitor(String name, String desc, MethodVisitor parent, MethodLogistics logistics) {
            return WrapReturnValuesScript.this.new WrapReturnValues(parent, logistics, this.val$classSpec, desc);
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

    static /* synthetic */ String access$0(String str) {
        return extractReturnValueFromDesc(str);
    }

    private static String extractReturnValueFromDesc(String desc) {
        int lastIdx = desc == null ? -1 : desc.lastIndexOf(41);
        if (lastIdx == -1) {
            return null;
        }
        String rd = desc.substring(lastIdx + 1);
        return (rd.startsWith("L") && rd.endsWith(";")) ? rd.substring(1, rd.length() - 1) : rd;
    }

    /* loaded from: discord:lombok/patcher/scripts/WrapReturnValuesScript$WrapReturnValues.SCL.lombok */
    private class WrapReturnValues extends MethodVisitor {
        private final MethodLogistics logistics;
        private final String ownClassSpec;
        private final String returnValueDesc;

        public WrapReturnValues(MethodVisitor mv, MethodLogistics logistics, String ownClassSpec, String desc) {
            super(Opcodes.ASM7, mv);
            this.logistics = logistics;
            this.ownClassSpec = ownClassSpec;
            this.returnValueDesc = WrapReturnValuesScript.access$0(desc);
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitInsn(int opcode) {
            if (opcode != this.logistics.getReturnOpcode()) {
                super.visitInsn(opcode);
                return;
            }
            if (WrapReturnValuesScript.access$1(WrapReturnValuesScript.this).contains(StackRequest.RETURN_VALUE)) {
                if (!WrapReturnValuesScript.access$2(WrapReturnValuesScript.this)) {
                    this.logistics.generateDupForReturn(this.mv);
                }
            } else if (WrapReturnValuesScript.access$2(WrapReturnValuesScript.this)) {
                this.logistics.generatePopForReturn(this.mv);
            }
            if (WrapReturnValuesScript.access$1(WrapReturnValuesScript.this).contains(StackRequest.THIS)) {
                this.logistics.generateLoadOpcodeForThis(this.mv);
            }
            for (StackRequest param : StackRequest.PARAMS_IN_ORDER) {
                if (WrapReturnValuesScript.access$1(WrapReturnValuesScript.this).contains(param)) {
                    this.logistics.generateLoadOpcodeForParam(param.getParamPos(), this.mv);
                }
            }
            if (WrapReturnValuesScript.access$3(WrapReturnValuesScript.this)) {
                WrapReturnValuesScript.access$5(WrapReturnValuesScript.access$4(WrapReturnValuesScript.this), this.mv);
            } else {
                super.visitMethodInsn(Opcodes.INVOKESTATIC, WrapReturnValuesScript.access$6(WrapReturnValuesScript.this) ? this.ownClassSpec : WrapReturnValuesScript.access$4(WrapReturnValuesScript.this).getClassSpec(), WrapReturnValuesScript.access$4(WrapReturnValuesScript.this).getMethodName(), WrapReturnValuesScript.access$4(WrapReturnValuesScript.this).getMethodDescriptor(), false);
            }
            if (WrapReturnValuesScript.access$7(WrapReturnValuesScript.this)) {
                super.visitTypeInsn(Opcodes.CHECKCAST, this.returnValueDesc);
            }
            super.visitInsn(opcode);
        }
    }

    public String toString() {
        return "WrapReturnValues(wrapper: " + this.wrapper + ", hijackReturn: " + this.hijackReturnValue + ", transplant: " + this.transplant + ", insert: " + this.insert + ", requests: " + this.requests + ")";
    }
}
