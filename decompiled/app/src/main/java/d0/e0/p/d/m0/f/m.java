package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.f.l;
import d0.e0.p.d.m0.f.o;
import d0.e0.p.d.m0.f.p;
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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class m extends GeneratedMessageLite.d<m> implements MessageLiteOrBuilder {
    public static final m j;
    public static Parser2<m> k = new a();
    private int bitField0_;
    private List<c> class__;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private l package_;
    private o qualifiedNames_;
    private p strings_;
    private final ByteString3 unknownFields;

    /* compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<m> {
        @Override // d0.e0.p.d.m0.i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // d0.e0.p.d.m0.i.Parser2
        public m parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new m(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.c<m, b> implements MessageLiteOrBuilder {
        public int m;
        public p n = p.getDefaultInstance();
        public o o = o.getDefaultInstance();
        public l p = l.getDefaultInstance();
        public List<c> q = Collections.emptyList();

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public m buildPartial() {
            m mVar = new m(this, null);
            int i = this.m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            m.h(mVar, this.n);
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            m.i(mVar, this.o);
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            m.j(mVar, this.p);
            if ((this.m & 8) == 8) {
                this.q = Collections.unmodifiableList(this.q);
                this.m &= -9;
            }
            m.l(mVar, this.q);
            m.m(mVar, i2);
            return mVar;
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

        public b mergePackage(l lVar) {
            if ((this.m & 4) != 4 || this.p == l.getDefaultInstance()) {
                this.p = lVar;
            } else {
                this.p = l.newBuilder(this.p).mergeFrom(lVar).buildPartial();
            }
            this.m |= 4;
            return this;
        }

        public b mergeQualifiedNames(o oVar) {
            if ((this.m & 2) != 2 || this.o == o.getDefaultInstance()) {
                this.o = oVar;
            } else {
                this.o = o.newBuilder(this.o).mergeFrom(oVar).buildPartial();
            }
            this.m |= 2;
            return this;
        }

        public b mergeStrings(p pVar) {
            if ((this.m & 1) != 1 || this.n == p.getDefaultInstance()) {
                this.n = pVar;
            } else {
                this.n = p.newBuilder(this.n).mergeFrom(pVar).buildPartial();
            }
            this.m |= 1;
            return this;
        }

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public m build() {
            m mVarBuildPartial = buildPartial();
            if (mVarBuildPartial.isInitialized()) {
                return mVarBuildPartial;
            }
            throw new UninitializedMessageException(mVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((m) generatedMessageLite);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(m mVar) {
            if (mVar == m.getDefaultInstance()) {
                return this;
            }
            if (mVar.hasStrings()) {
                mergeStrings(mVar.getStrings());
            }
            if (mVar.hasQualifiedNames()) {
                mergeQualifiedNames(mVar.getQualifiedNames());
            }
            if (mVar.hasPackage()) {
                mergePackage(mVar.getPackage());
            }
            if (!m.k(mVar).isEmpty()) {
                if (this.q.isEmpty()) {
                    this.q = m.k(mVar);
                    this.m &= -9;
                } else {
                    if ((this.m & 8) != 8) {
                        this.q = new ArrayList(this.q);
                        this.m |= 8;
                    }
                    this.q.addAll(m.k(mVar));
                }
            }
            b(mVar);
            setUnknownFields(getUnknownFields().concat(m.n(mVar)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            m mVar = null;
            try {
                try {
                    m partialFrom = m.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    m mVar2 = (m) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        mVar = mVar2;
                        if (mVar != null) {
                            mergeFrom(mVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (mVar != null) {
                }
                throw th;
            }
        }
    }

    static {
        m mVar = new m();
        j = mVar;
        mVar.o();
    }

    public m(GeneratedMessageLite.c cVar, d0.e0.p.d.m0.f.a aVar) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static m getDefaultInstance() {
        return j;
    }

    public static /* synthetic */ p h(m mVar, p pVar) {
        mVar.strings_ = pVar;
        return pVar;
    }

    public static /* synthetic */ o i(m mVar, o oVar) {
        mVar.qualifiedNames_ = oVar;
        return oVar;
    }

    public static /* synthetic */ l j(m mVar, l lVar) {
        mVar.package_ = lVar;
        return lVar;
    }

    public static /* synthetic */ List k(m mVar) {
        return mVar.class__;
    }

    public static /* synthetic */ List l(m mVar, List list) {
        mVar.class__ = list;
        return list;
    }

    public static /* synthetic */ int m(m mVar, int i) {
        mVar.bitField0_ = i;
        return i;
    }

    public static /* synthetic */ ByteString3 n(m mVar) {
        return mVar.unknownFields;
    }

    public static b newBuilder(m mVar) {
        return newBuilder().mergeFrom(mVar);
    }

    public static m parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (m) ((AbstractParser) k).m90parseFrom(inputStream, extensionRegistryLite);
    }

    public c getClass_(int i) {
        return this.class__.get(i);
    }

    public int getClass_Count() {
        return this.class__.size();
    }

    public List<c> getClass_List() {
        return this.class__;
    }

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public l getPackage() {
        return this.package_;
    }

    public o getQualifiedNames() {
        return this.qualifiedNames_;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.strings_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.package_);
        }
        for (int i2 = 0; i2 < this.class__.size(); i2++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(4, this.class__.get(i2));
        }
        int size = this.unknownFields.size() + c() + iComputeMessageSize;
        this.memoizedSerializedSize = size;
        return size;
    }

    public p getStrings() {
        return this.strings_;
    }

    public boolean hasPackage() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasQualifiedNames() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasStrings() {
        return (this.bitField0_ & 1) == 1;
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
        if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasPackage() && !getPackage().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getClass_Count(); i++) {
            if (!getClass_(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (b()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.a newBuilderForType() {
        return newBuilderForType();
    }

    public final void o() {
        this.strings_ = p.getDefaultInstance();
        this.qualifiedNames_ = o.getDefaultInstance();
        this.package_ = l.getDefaultInstance();
        this.class__ = Collections.emptyList();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.a toBuilder() {
        return toBuilder();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.d<MessageType>.a aVarE = e();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeMessage(1, this.strings_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(2, this.qualifiedNames_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.package_);
        }
        for (int i = 0; i < this.class__.size(); i++) {
            codedOutputStream.writeMessage(4, this.class__.get(i));
        }
        aVarE.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
    public m getDefaultInstanceForType() {
        return j;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public m() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        o();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                p.b builder = (this.bitField0_ & 1) == 1 ? this.strings_.toBuilder() : null;
                                p pVar = (p) codedInputStream.readMessage(p.k, extensionRegistryLite);
                                this.strings_ = pVar;
                                if (builder != null) {
                                    builder.mergeFrom(pVar);
                                    this.strings_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                            } else if (tag == 18) {
                                o.b builder2 = (this.bitField0_ & 2) == 2 ? this.qualifiedNames_.toBuilder() : null;
                                o oVar = (o) codedInputStream.readMessage(o.k, extensionRegistryLite);
                                this.qualifiedNames_ = oVar;
                                if (builder2 != null) {
                                    builder2.mergeFrom(oVar);
                                    this.qualifiedNames_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (tag == 26) {
                                l.b builder3 = (this.bitField0_ & 4) == 4 ? this.package_.toBuilder() : null;
                                l lVar = (l) codedInputStream.readMessage(l.k, extensionRegistryLite);
                                this.package_ = lVar;
                                if (builder3 != null) {
                                    builder3.mergeFrom(lVar);
                                    this.package_ = builder3.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            } else if (tag != 34) {
                                if (!f(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                                }
                            } else {
                                if ((i & 8) != 8) {
                                    this.class__ = new ArrayList();
                                    i |= 8;
                                }
                                this.class__.add(codedInputStream.readMessage(c.k, extensionRegistryLite));
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
                if ((i & 8) == 8) {
                    this.class__ = Collections.unmodifiableList(this.class__);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.unknownFields = bVarNewOutput.toByteString();
                    throw th2;
                }
                this.unknownFields = bVarNewOutput.toByteString();
                d();
                throw th;
            }
        }
        if ((i & 8) == 8) {
            this.class__ = Collections.unmodifiableList(this.class__);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.unknownFields = bVarNewOutput.toByteString();
            throw th3;
        }
        this.unknownFields = bVarNewOutput.toByteString();
        d();
    }
}
