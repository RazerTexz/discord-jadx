package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.i.AbstractMessageLite;
import d0.e0.p.d.m0.i.AbstractParser;
import d0.e0.p.d.m0.i.ByteString3;
import d0.e0.p.d.m0.i.CodedInputStream;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.i.Internal;
import d0.e0.p.d.m0.i.MessageLite;
import d0.e0.p.d.m0.i.MessageLiteOrBuilder;
import d0.e0.p.d.m0.i.Parser2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class h extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final h j;
    public static Parser2<h> k = new a();
    private List<h> andArgument_;
    private int bitField0_;
    private c constantValue_;
    private int flags_;
    private int isInstanceTypeId_;
    private q isInstanceType_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<h> orArgument_;
    private final ByteString3 unknownFields;
    private int valueParameterReference_;

    /* compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<h> {
        @Override // d0.e0.p.d.m0.i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // d0.e0.p.d.m0.i.Parser2
        public h parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new h(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.b<h, b> implements MessageLiteOrBuilder {
        public int k;
        public int l;
        public int m;
        public int p;
        public c n = c.TRUE;
        public q o = q.getDefaultInstance();
        public List<h> q = Collections.emptyList();
        public List<h> r = Collections.emptyList();

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public h buildPartial() {
            h hVar = new h(this, null);
            int i = this.k;
            int i2 = (i & 1) != 1 ? 0 : 1;
            h.a(hVar, this.l);
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            h.b(hVar, this.m);
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            h.c(hVar, this.n);
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            h.d(hVar, this.o);
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            h.e(hVar, this.p);
            if ((this.k & 32) == 32) {
                this.q = Collections.unmodifiableList(this.q);
                this.k &= -33;
            }
            h.g(hVar, this.q);
            if ((this.k & 64) == 64) {
                this.r = Collections.unmodifiableList(this.r);
                this.k &= -65;
            }
            h.i(hVar, this.r);
            h.j(hVar, i2);
            return hVar;
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

        public b mergeIsInstanceType(q qVar) {
            if ((this.k & 8) != 8 || this.o == q.getDefaultInstance()) {
                this.o = qVar;
            } else {
                this.o = q.newBuilder(this.o).mergeFrom(qVar).buildPartial();
            }
            this.k |= 8;
            return this;
        }

        public b setConstantValue(c cVar) {
            Objects.requireNonNull(cVar);
            this.k |= 4;
            this.n = cVar;
            return this;
        }

        public b setFlags(int i) {
            this.k |= 1;
            this.l = i;
            return this;
        }

        public b setIsInstanceTypeId(int i) {
            this.k |= 16;
            this.p = i;
            return this;
        }

        public b setValueParameterReference(int i) {
            this.k |= 2;
            this.m = i;
            return this;
        }

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public h build() {
            h hVarBuildPartial = buildPartial();
            if (hVarBuildPartial.isInitialized()) {
                return hVarBuildPartial;
            }
            throw new UninitializedMessageException(hVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((h) generatedMessageLite);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(h hVar) {
            if (hVar == h.getDefaultInstance()) {
                return this;
            }
            if (hVar.hasFlags()) {
                setFlags(hVar.getFlags());
            }
            if (hVar.hasValueParameterReference()) {
                setValueParameterReference(hVar.getValueParameterReference());
            }
            if (hVar.hasConstantValue()) {
                setConstantValue(hVar.getConstantValue());
            }
            if (hVar.hasIsInstanceType()) {
                mergeIsInstanceType(hVar.getIsInstanceType());
            }
            if (hVar.hasIsInstanceTypeId()) {
                setIsInstanceTypeId(hVar.getIsInstanceTypeId());
            }
            if (!h.f(hVar).isEmpty()) {
                if (this.q.isEmpty()) {
                    this.q = h.f(hVar);
                    this.k &= -33;
                } else {
                    if ((this.k & 32) != 32) {
                        this.q = new ArrayList(this.q);
                        this.k |= 32;
                    }
                    this.q.addAll(h.f(hVar));
                }
            }
            if (!h.h(hVar).isEmpty()) {
                if (this.r.isEmpty()) {
                    this.r = h.h(hVar);
                    this.k &= -65;
                } else {
                    if ((this.k & 64) != 64) {
                        this.r = new ArrayList(this.r);
                        this.k |= 64;
                    }
                    this.r.addAll(h.h(hVar));
                }
            }
            setUnknownFields(getUnknownFields().concat(h.k(hVar)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            h hVar = null;
            try {
                try {
                    h partialFrom = h.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    h hVar2 = (h) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        hVar = hVar2;
                        if (hVar != null) {
                            mergeFrom(hVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (hVar != null) {
                }
                throw th;
            }
        }
    }

    /* compiled from: ProtoBuf.java */
    public enum c implements Internal.a {
        TRUE(0),
        FALSE(1),
        NULL(2);

        private final int value;

        c(int i) {
            this.value = i;
        }

        @Override // d0.e0.p.d.m0.i.Internal.a
        public final int getNumber() {
            return this.value;
        }

        public static c valueOf(int i) {
            if (i == 0) {
                return TRUE;
            }
            if (i == 1) {
                return FALSE;
            }
            if (i != 2) {
                return null;
            }
            return NULL;
        }
    }

    static {
        h hVar = new h();
        j = hVar;
        hVar.l();
    }

    public h(GeneratedMessageLite.b bVar, d0.e0.p.d.m0.f.a aVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static /* synthetic */ int a(h hVar, int i) {
        hVar.flags_ = i;
        return i;
    }

    public static /* synthetic */ int b(h hVar, int i) {
        hVar.valueParameterReference_ = i;
        return i;
    }

    public static /* synthetic */ c c(h hVar, c cVar) {
        hVar.constantValue_ = cVar;
        return cVar;
    }

    public static /* synthetic */ q d(h hVar, q qVar) {
        hVar.isInstanceType_ = qVar;
        return qVar;
    }

    public static /* synthetic */ int e(h hVar, int i) {
        hVar.isInstanceTypeId_ = i;
        return i;
    }

    public static /* synthetic */ List f(h hVar) {
        return hVar.andArgument_;
    }

    public static /* synthetic */ List g(h hVar, List list) {
        hVar.andArgument_ = list;
        return list;
    }

    public static h getDefaultInstance() {
        return j;
    }

    public static /* synthetic */ List h(h hVar) {
        return hVar.orArgument_;
    }

    public static /* synthetic */ List i(h hVar, List list) {
        hVar.orArgument_ = list;
        return list;
    }

    public static /* synthetic */ int j(h hVar, int i) {
        hVar.bitField0_ = i;
        return i;
    }

    public static /* synthetic */ ByteString3 k(h hVar) {
        return hVar.unknownFields;
    }

    public static b newBuilder(h hVar) {
        return newBuilder().mergeFrom(hVar);
    }

    public h getAndArgument(int i) {
        return this.andArgument_.get(i);
    }

    public int getAndArgumentCount() {
        return this.andArgument_.size();
    }

    public c getConstantValue() {
        return this.constantValue_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public q getIsInstanceType() {
        return this.isInstanceType_;
    }

    public int getIsInstanceTypeId() {
        return this.isInstanceTypeId_;
    }

    public h getOrArgument(int i) {
        return this.orArgument_.get(i);
    }

    public int getOrArgumentCount() {
        return this.orArgument_.size();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
        }
        for (int i2 = 0; i2 < this.andArgument_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.andArgument_.get(i2));
        }
        for (int i3 = 0; i3 < this.orArgument_.size(); i3++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(7, this.orArgument_.get(i3));
        }
        int size = this.unknownFields.size() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getValueParameterReference() {
        return this.valueParameterReference_;
    }

    public boolean hasConstantValue() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasIsInstanceType() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasIsInstanceTypeId() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasValueParameterReference() {
        return (this.bitField0_ & 2) == 2;
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
        if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getAndArgumentCount(); i++) {
            if (!getAndArgument(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < getOrArgumentCount(); i2++) {
            if (!getOrArgument(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    public final void l() {
        this.flags_ = 0;
        this.valueParameterReference_ = 0;
        this.constantValue_ = c.TRUE;
        this.isInstanceType_ = q.getDefaultInstance();
        this.isInstanceTypeId_ = 0;
        this.andArgument_ = Collections.emptyList();
        this.orArgument_ = Collections.emptyList();
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
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(3, this.constantValue_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(5, this.isInstanceTypeId_);
        }
        for (int i = 0; i < this.andArgument_.size(); i++) {
            codedOutputStream.writeMessage(6, this.andArgument_.get(i));
        }
        for (int i2 = 0; i2 < this.orArgument_.size(); i2++) {
            codedOutputStream.writeMessage(7, this.orArgument_.get(i2));
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

    public h() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        l();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    if (tag != 0) {
                        if (tag == 8) {
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                        } else if (tag == 16) {
                            this.bitField0_ |= 2;
                            this.valueParameterReference_ = codedInputStream.readInt32();
                        } else if (tag == 24) {
                            int i2 = codedInputStream.readEnum();
                            c cVarValueOf = c.valueOf(i2);
                            if (cVarValueOf == null) {
                                codedOutputStreamNewInstance.writeRawVarint32(tag);
                                codedOutputStreamNewInstance.writeRawVarint32(i2);
                            } else {
                                this.bitField0_ |= 4;
                                this.constantValue_ = cVarValueOf;
                            }
                        } else if (tag == 34) {
                            q.c builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : null;
                            q qVar = (q) codedInputStream.readMessage(q.k, extensionRegistryLite);
                            this.isInstanceType_ = qVar;
                            if (builder != null) {
                                builder.mergeFrom(qVar);
                                this.isInstanceType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                        } else if (tag == 40) {
                            this.bitField0_ |= 16;
                            this.isInstanceTypeId_ = codedInputStream.readInt32();
                        } else if (tag == 50) {
                            if ((i & 32) != 32) {
                                this.andArgument_ = new ArrayList();
                                i |= 32;
                            }
                            this.andArgument_.add(codedInputStream.readMessage(k, extensionRegistryLite));
                        } else if (tag != 58) {
                            if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            if ((i & 64) != 64) {
                                this.orArgument_ = new ArrayList();
                                i |= 64;
                            }
                            this.orArgument_.add(codedInputStream.readMessage(k, extensionRegistryLite));
                        }
                    }
                    z2 = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if ((i & 32) == 32) {
                    this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                }
                if ((i & 64) == 64) {
                    this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
        if ((i & 32) == 32) {
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        }
        if ((i & 64) == 64) {
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
