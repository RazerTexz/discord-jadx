package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.AbstractMessageLite;
import d0.e0.p.d.m0.i.AbstractParser;
import d0.e0.p.d.m0.i.ByteString3;
import d0.e0.p.d.m0.i.CodedInputStream;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.i.MessageLite;
import d0.e0.p.d.m0.i.MessageLiteOrBuilder;
import d0.e0.p.d.m0.i.Parser2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class e extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final e j;
    public static Parser2<e> k = new a();
    private List<f> effect_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString3 unknownFields;

    /* compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<e> {
        @Override // d0.e0.p.d.m0.i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // d0.e0.p.d.m0.i.Parser2
        public e parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new e(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.b<e, b> implements MessageLiteOrBuilder {
        public int k;
        public List<f> l = Collections.emptyList();

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public e buildPartial() {
            e eVar = new e(this, null);
            if ((this.k & 1) == 1) {
                this.l = Collections.unmodifiableList(this.l);
                this.k &= -2;
            }
            e.b(eVar, this.l);
            return eVar;
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public /* bridge */ /* synthetic */ AbstractMessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public e build() {
            e eVarBuildPartial = buildPartial();
            if (eVarBuildPartial.isInitialized()) {
                return eVarBuildPartial;
            }
            throw new UninitializedMessageException(eVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((e) generatedMessageLite);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(e eVar) {
            if (eVar == e.getDefaultInstance()) {
                return this;
            }
            if (!e.a(eVar).isEmpty()) {
                if (this.l.isEmpty()) {
                    this.l = e.a(eVar);
                    this.k &= -2;
                } else {
                    if ((this.k & 1) != 1) {
                        this.l = new ArrayList(this.l);
                        this.k |= 1;
                    }
                    this.l.addAll(e.a(eVar));
                }
            }
            setUnknownFields(getUnknownFields().concat(e.c(eVar)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            e eVar = null;
            try {
                try {
                    e partialFrom = e.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    e eVar2 = (e) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        eVar = eVar2;
                        if (eVar != null) {
                            mergeFrom(eVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (eVar != null) {
                }
                throw th;
            }
        }
    }

    static {
        e eVar = new e();
        j = eVar;
        eVar.effect_ = Collections.emptyList();
    }

    public e(GeneratedMessageLite.b bVar, d0.e0.p.d.m0.f.a aVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static /* synthetic */ List a(e eVar) {
        return eVar.effect_;
    }

    public static /* synthetic */ List b(e eVar, List list) {
        eVar.effect_ = list;
        return list;
    }

    public static /* synthetic */ ByteString3 c(e eVar) {
        return eVar.unknownFields;
    }

    public static e getDefaultInstance() {
        return j;
    }

    public static b newBuilder(e eVar) {
        return newBuilder().mergeFrom(eVar);
    }

    public f getEffect(int i) {
        return this.effect_.get(i);
    }

    public int getEffectCount() {
        return this.effect_.size();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = 0;
        for (int i2 = 0; i2 < this.effect_.size(); i2++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.effect_.get(i2));
        }
        int size = this.unknownFields.size() + iComputeMessageSize;
        this.memoizedSerializedSize = size;
        return size;
    }

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i = 0; i < getEffectCount(); i++) {
            if (!getEffect(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.a newBuilderForType() {
        return newBuilderForType();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.a toBuilder() {
        return toBuilder();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i = 0; i < this.effect_.size(); i++) {
            codedOutputStream.writeMessage(1, this.effect_.get(i));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public e() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.effect_ = Collections.emptyList();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    if (tag != 0) {
                        if (tag != 10) {
                            if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            if (!(z3 & true)) {
                                this.effect_ = new ArrayList();
                                z3 |= true;
                            }
                            this.effect_.add(codedInputStream.readMessage(f.k, extensionRegistryLite));
                        }
                    }
                    z2 = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z3 & true) {
                    this.effect_ = Collections.unmodifiableList(this.effect_);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.unknownFields = bVarNewOutput.toByteString();
                    throw th2;
                }
                this.unknownFields = bVarNewOutput.toByteString();
                throw th;
            }
        }
        if (z3 & true) {
            this.effect_ = Collections.unmodifiableList(this.effect_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.unknownFields = bVarNewOutput.toByteString();
            throw th3;
        }
        this.unknownFields = bVarNewOutput.toByteString();
    }
}
