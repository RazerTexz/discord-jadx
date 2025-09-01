package lombok.patcher.scripts;

import com.adjust.sdk.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.patcher.Hook;
import lombok.patcher.MethodLogistics;
import lombok.patcher.PatchScript;
import lombok.patcher.TargetMatcher;
import lombok.patcher.TransplantMapper;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* loaded from: discord:lombok/patcher/scripts/SetSymbolDuringMethodCallScript.SCL.lombok */
public class SetSymbolDuringMethodCallScript extends MethodLevelPatchScript {
    private final Hook callToWrap;
    private final String symbol;
    private final boolean report;

    static /* synthetic */ Hook access$0(SetSymbolDuringMethodCallScript setSymbolDuringMethodCallScript) {
        return setSymbolDuringMethodCallScript.callToWrap;
    }

    static /* synthetic */ String access$2(SetSymbolDuringMethodCallScript setSymbolDuringMethodCallScript) {
        return setSymbolDuringMethodCallScript.symbol;
    }

    static /* synthetic */ boolean access$1(SetSymbolDuringMethodCallScript setSymbolDuringMethodCallScript) {
        return setSymbolDuringMethodCallScript.report;
    }

    @Override // lombok.patcher.PatchScript
    public String getPatchScriptName() {
        return "set symbol " + this.symbol + " if " + this.callToWrap.getMethodName() + " is invoked in " + describeMatchers();
    }

    SetSymbolDuringMethodCallScript(List<TargetMatcher> matchers, Hook callToWrap, String symbol, boolean report) {
        super(matchers);
        if (callToWrap == null) {
            throw new NullPointerException("callToWrap");
        }
        if (symbol == null) {
            throw new NullPointerException("symbol");
        }
        this.callToWrap = callToWrap;
        this.symbol = symbol;
        this.report = report;
    }

    @Override // lombok.patcher.scripts.MethodLevelPatchScript
    protected PatchScript.MethodPatcher createPatcher(ClassWriter writer, String classSpec, TransplantMapper transplantMapper) {
        List<WrapperMethodDescriptor> descriptors = new ArrayList<>();
        PatchScript.MethodPatcher patcher = new AnonymousClass2(writer, transplantMapper, new AnonymousClass1(classSpec, descriptors), descriptors);
        return patcher;
    }

    /* renamed from: lombok.patcher.scripts.SetSymbolDuringMethodCallScript$1, reason: invalid class name */
    /* loaded from: discord:lombok/patcher/scripts/SetSymbolDuringMethodCallScript$1.SCL.lombok */
    class AnonymousClass1 implements PatchScript.MethodPatcherFactory {
        private final /* synthetic */ String val$classSpec;
        private final /* synthetic */ List val$descriptors;

        AnonymousClass1(String str, List list) {
            this.val$classSpec = str;
            this.val$descriptors = list;
        }

        @Override // lombok.patcher.PatchScript.MethodPatcherFactory
        public MethodVisitor createMethodVisitor(String name, String desc, MethodVisitor parent, MethodLogistics logistics) {
            return SetSymbolDuringMethodCallScript.this.new WrapWithSymbol(name, parent, this.val$classSpec, this.val$descriptors);
        }
    }

    /* renamed from: lombok.patcher.scripts.SetSymbolDuringMethodCallScript$2, reason: invalid class name */
    /* loaded from: discord:lombok/patcher/scripts/SetSymbolDuringMethodCallScript$2.SCL.lombok */
    class AnonymousClass2 extends PatchScript.MethodPatcher {
        private final /* synthetic */ List val$descriptors;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ClassVisitor $anonymous0, TransplantMapper $anonymous1, PatchScript.MethodPatcherFactory $anonymous2, List list) {
            super($anonymous0, $anonymous1, $anonymous2);
            this.val$descriptors = list;
        }

        @Override // lombok.patcher.PatchScript.MethodPatcher, org.objectweb.asm.ClassVisitor
        public void visitEnd() throws IOException {
            for (WrapperMethodDescriptor wmd : this.val$descriptors) {
                SetSymbolDuringMethodCallScript.access$3(SetSymbolDuringMethodCallScript.this, this, wmd);
            }
            super.visitEnd();
        }
    }

    static /* synthetic */ void access$3(SetSymbolDuringMethodCallScript setSymbolDuringMethodCallScript, ClassVisitor classVisitor, WrapperMethodDescriptor wrapperMethodDescriptor) {
        setSymbolDuringMethodCallScript.makeWrapperMethod(classVisitor, wrapperMethodDescriptor);
    }

    private void makeWrapperMethod(ClassVisitor cv, WrapperMethodDescriptor wmd) {
        MethodVisitor mv = cv.visitMethod(4106, wmd.getWrapperName(), wmd.getWrapperDescriptor(), null, null);
        MethodLogistics logistics = new MethodLogistics(8, wmd.getWrapperDescriptor());
        mv.visitCode();
        Label start = new Label();
        Label end = new Label();
        Label handler = new Label();
        mv.visitTryCatchBlock(start, end, handler, null);
        mv.visitLabel(start);
        mv.visitLdcInsn(this.symbol);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "lombok/patcher/Symbols", Constants.PUSH, "(Ljava/lang/String;)V", false);
        for (int i = 0; i < logistics.getParamCount(); i++) {
            logistics.generateLoadOpcodeForParam(i, mv);
        }
        mv.visitMethodInsn(wmd.getOpcode(), wmd.getOwner(), wmd.getName(), wmd.getTargetDescriptor(), wmd.isItf());
        mv.visitLabel(end);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "lombok/patcher/Symbols", "pop", "()V", false);
        logistics.generateReturnOpcode(mv);
        mv.visitLabel(handler);
        mv.visitFrame(0, 0, null, 1, new Object[]{"java/lang/Throwable"});
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "lombok/patcher/Symbols", "pop", "()V", false);
        mv.visitInsn(Opcodes.ATHROW);
        mv.visitMaxs(Math.max(1, logistics.getParamCount()), logistics.getParamCount());
        mv.visitEnd();
    }

    /* loaded from: discord:lombok/patcher/scripts/SetSymbolDuringMethodCallScript$WrapWithSymbol.SCL.lombok */
    private class WrapWithSymbol extends MethodVisitor {
        private final String selfMethodName;
        private final String selfTypeName;
        private final List<WrapperMethodDescriptor> descriptors;

        public WrapWithSymbol(String selfMethodName, MethodVisitor mv, String selfTypeName, List<WrapperMethodDescriptor> descriptors) {
            super(Opcodes.ASM7, mv);
            this.selfMethodName = selfMethodName;
            this.selfTypeName = selfTypeName;
            this.descriptors = descriptors;
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
            boolean addOwner;
            String fixedDesc;
            if (opcode == 185 || opcode == 182) {
                addOwner = true;
            } else {
                if (opcode != 184) {
                    super.visitMethodInsn(opcode, owner, name, desc, itf);
                    return;
                }
                addOwner = false;
            }
            if (!SetSymbolDuringMethodCallScript.access$0(SetSymbolDuringMethodCallScript.this).getClassSpec().equals(owner) || !SetSymbolDuringMethodCallScript.access$0(SetSymbolDuringMethodCallScript.this).getMethodName().equals(name) || !SetSymbolDuringMethodCallScript.access$0(SetSymbolDuringMethodCallScript.this).getMethodDescriptor().equals(desc)) {
                super.visitMethodInsn(opcode, owner, name, desc, itf);
                return;
            }
            if (addOwner) {
                fixedDesc = "(L" + SetSymbolDuringMethodCallScript.access$0(SetSymbolDuringMethodCallScript.this).getClassSpec() + ";" + desc.substring(1);
            } else {
                fixedDesc = desc;
            }
            WrapperMethodDescriptor wmd = new WrapperMethodDescriptor(this.descriptors.size(), opcode, owner, name, fixedDesc, desc, itf);
            if (SetSymbolDuringMethodCallScript.access$1(SetSymbolDuringMethodCallScript.this)) {
                System.out.println("Changing method " + this.selfTypeName + "::" + this.selfMethodName + " wrapping call to " + owner + "::" + name + " to set symbol " + SetSymbolDuringMethodCallScript.access$2(SetSymbolDuringMethodCallScript.this));
            }
            super.visitMethodInsn(Opcodes.INVOKESTATIC, this.selfTypeName, wmd.getWrapperName(), fixedDesc, false);
            this.descriptors.add(wmd);
        }
    }
}
