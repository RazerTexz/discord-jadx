package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.AbstractMessageLite;
import d0.e0.p.d.m0.i.AbstractParser;
import d0.e0.p.d.m0.i.ByteString3;
import d0.e0.p.d.m0.i.CodedInputStream;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.i.LazyStringArrayList;
import d0.e0.p.d.m0.i.LazyStringList;
import d0.e0.p.d.m0.i.MessageLite;
import d0.e0.p.d.m0.i.MessageLiteOrBuilder;
import d0.e0.p.d.m0.i.Parser2;
import d0.e0.p.d.m0.i.ProtocolStringList;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class p extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final p j;
    public static Parser2<p> k = new a();
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private LazyStringList string_;
    private final ByteString3 unknownFields;

    /* compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<p> {
        @Override // d0.e0.p.d.m0.i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // d0.e0.p.d.m0.i.Parser2
        public p parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new p(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.b<p, b> implements MessageLiteOrBuilder {
        public int k;
        public LazyStringList l = LazyStringArrayList.j;

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public p buildPartial() {
            p pVar = new p(this, null);
            if ((this.k & 1) == 1) {
                this.l = this.l.getUnmodifiableView();
                this.k &= -2;
            }
            p.b(pVar, this.l);
            return pVar;
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
        public p build() {
            p pVarBuildPartial = buildPartial();
            if (pVarBuildPartial.isInitialized()) {
                return pVarBuildPartial;
            }
            throw new UninitializedMessageException(pVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((p) generatedMessageLite);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(p pVar) {
            if (pVar == p.getDefaultInstance()) {
                return this;
            }
            if (!p.a(pVar).isEmpty()) {
                if (this.l.isEmpty()) {
                    this.l = p.a(pVar);
                    this.k &= -2;
                } else {
                    if ((this.k & 1) != 1) {
                        this.l = new LazyStringArrayList(this.l);
                        this.k |= 1;
                    }
                    this.l.addAll(p.a(pVar));
                }
            }
            setUnknownFields(getUnknownFields().concat(p.c(pVar)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            p pVar = null;
            try {
                try {
                    p partialFrom = p.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    p pVar2 = (p) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        pVar = pVar2;
                        if (pVar != null) {
                            mergeFrom(pVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (pVar != null) {
                }
                throw th;
            }
        }
    }

    static {
        p pVar = new p();
        j = pVar;
        pVar.string_ = LazyStringArrayList.j;
    }

    public p(GeneratedMessageLite.b bVar, d0.e0.p.d.m0.f.a aVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static /* synthetic */ LazyStringList a(p pVar) {
        return pVar.string_;
    }

    public static /* synthetic */ LazyStringList b(p pVar, LazyStringList lazyStringList) {
        pVar.string_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ ByteString3 c(p pVar) {
        return pVar.unknownFields;
    }

    public static p getDefaultInstance() {
        return j;
    }

    public static b newBuilder(p pVar) {
        return newBuilder().mergeFrom(pVar);
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeBytesSizeNoTag = 0;
        for (int i2 = 0; i2 < this.string_.size(); i2++) {
            iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(i2));
        }
        int size = this.unknownFields.size() + (getStringList().size() * 1) + 0 + iComputeBytesSizeNoTag;
        this.memoizedSerializedSize = size;
        return size;
    }

    public String getString(int i) {
        return this.string_.get(i);
    }

    public ProtocolStringList getStringList() {
        return this.string_;
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
        for (int i = 0; i < this.string_.size(); i++) {
            codedOutputStream.writeBytes(1, this.string_.getByteString(i));
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

    public p() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.j;
    }

    public p(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.string_ = LazyStringArrayList.j;
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag != 10) {
                                if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                ByteString3 bytes = codedInputStream.readBytes();
                                if (!(z3 & true)) {
                                    this.string_ = new LazyStringArrayList();
                                    z3 |= true;
                                }
                                this.string_.add(bytes);
                            }
                        }
                        z2 = true;
                    } catch (IOException e) {
                        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z3 & true) {
                    this.string_ = this.string_.getUnmodifiableView();
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
            this.string_ = this.string_.getUnmodifiableView();
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
