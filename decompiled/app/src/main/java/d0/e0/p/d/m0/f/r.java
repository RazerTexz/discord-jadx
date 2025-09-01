package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.f.q;
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
public final class r extends GeneratedMessageLite.d<r> implements MessageLiteOrBuilder {
    public static final r j;
    public static Parser2<r> k = new a();
    private List<d0.e0.p.d.m0.f.b> annotation_;
    private int bitField0_;
    private int expandedTypeId_;
    private q expandedType_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private List<s> typeParameter_;
    private int underlyingTypeId_;
    private q underlyingType_;
    private final ByteString3 unknownFields;
    private List<Integer> versionRequirement_;

    /* compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<r> {
        @Override // d0.e0.p.d.m0.i.Parser2
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // d0.e0.p.d.m0.i.Parser2
        public r parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new r(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.c<r, b> implements MessageLiteOrBuilder {
        public int m;
        public int o;
        public int r;
        public int t;
        public int n = 6;
        public List<s> p = Collections.emptyList();
        public q q = q.getDefaultInstance();

        /* renamed from: s, reason: collision with root package name */
        public q f3407s = q.getDefaultInstance();
        public List<d0.e0.p.d.m0.f.b> u = Collections.emptyList();
        public List<Integer> v = Collections.emptyList();

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        public r buildPartial() {
            r rVar = new r(this, null);
            int i = this.m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            r.h(rVar, this.n);
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            r.i(rVar, this.o);
            if ((this.m & 4) == 4) {
                this.p = Collections.unmodifiableList(this.p);
                this.m &= -5;
            }
            r.k(rVar, this.p);
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            r.l(rVar, this.q);
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            r.m(rVar, this.r);
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            r.n(rVar, this.f3407s);
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            r.o(rVar, this.t);
            if ((this.m & 128) == 128) {
                this.u = Collections.unmodifiableList(this.u);
                this.m &= -129;
            }
            r.q(rVar, this.u);
            if ((this.m & 256) == 256) {
                this.v = Collections.unmodifiableList(this.v);
                this.m &= -257;
            }
            r.s(rVar, this.v);
            r.t(rVar, i2);
            return rVar;
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
            return clone();
        }

        public b mergeExpandedType(q qVar) {
            if ((this.m & 32) != 32 || this.f3407s == q.getDefaultInstance()) {
                this.f3407s = qVar;
            } else {
                this.f3407s = q.newBuilder(this.f3407s).mergeFrom(qVar).buildPartial();
            }
            this.m |= 32;
            return this;
        }

        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public /* bridge */ /* synthetic */ AbstractMessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeUnderlyingType(q qVar) {
            if ((this.m & 8) != 8 || this.q == q.getDefaultInstance()) {
                this.q = qVar;
            } else {
                this.q = q.newBuilder(this.q).mergeFrom(qVar).buildPartial();
            }
            this.m |= 8;
            return this;
        }

        public b setExpandedTypeId(int i) {
            this.m |= 64;
            this.t = i;
            return this;
        }

        public b setFlags(int i) {
            this.m |= 1;
            this.n = i;
            return this;
        }

        public b setName(int i) {
            this.m |= 2;
            this.o = i;
            return this;
        }

        public b setUnderlyingTypeId(int i) {
            this.m |= 16;
            this.r = i;
            return this;
        }

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public r build() {
            r rVarBuildPartial = buildPartial();
            if (rVarBuildPartial.isInitialized()) {
                return rVarBuildPartial;
            }
            throw new UninitializedMessageException(rVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
            return clone();
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
            return mergeFrom((r) generatedMessageLite);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public b clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public b mergeFrom(r rVar) {
            if (rVar == r.getDefaultInstance()) {
                return this;
            }
            if (rVar.hasFlags()) {
                setFlags(rVar.getFlags());
            }
            if (rVar.hasName()) {
                setName(rVar.getName());
            }
            if (!r.j(rVar).isEmpty()) {
                if (this.p.isEmpty()) {
                    this.p = r.j(rVar);
                    this.m &= -5;
                } else {
                    if ((this.m & 4) != 4) {
                        this.p = new ArrayList(this.p);
                        this.m |= 4;
                    }
                    this.p.addAll(r.j(rVar));
                }
            }
            if (rVar.hasUnderlyingType()) {
                mergeUnderlyingType(rVar.getUnderlyingType());
            }
            if (rVar.hasUnderlyingTypeId()) {
                setUnderlyingTypeId(rVar.getUnderlyingTypeId());
            }
            if (rVar.hasExpandedType()) {
                mergeExpandedType(rVar.getExpandedType());
            }
            if (rVar.hasExpandedTypeId()) {
                setExpandedTypeId(rVar.getExpandedTypeId());
            }
            if (!r.p(rVar).isEmpty()) {
                if (this.u.isEmpty()) {
                    this.u = r.p(rVar);
                    this.m &= -129;
                } else {
                    if ((this.m & 128) != 128) {
                        this.u = new ArrayList(this.u);
                        this.m |= 128;
                    }
                    this.u.addAll(r.p(rVar));
                }
            }
            if (!r.r(rVar).isEmpty()) {
                if (this.v.isEmpty()) {
                    this.v = r.r(rVar);
                    this.m &= -257;
                } else {
                    if ((this.m & 256) != 256) {
                        this.v = new ArrayList(this.v);
                        this.m |= 256;
                    }
                    this.v.addAll(r.r(rVar));
                }
            }
            b(rVar);
            setUnknownFields(getUnknownFields().concat(r.u(rVar)));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            r rVar = null;
            try {
                try {
                    r partialFrom = r.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    r rVar2 = (r) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        rVar = rVar2;
                        if (rVar != null) {
                            mergeFrom(rVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (rVar != null) {
                }
                throw th;
            }
        }
    }

    static {
        r rVar = new r();
        j = rVar;
        rVar.v();
    }

    public r(GeneratedMessageLite.c cVar, d0.e0.p.d.m0.f.a aVar) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static r getDefaultInstance() {
        return j;
    }

    public static /* synthetic */ int h(r rVar, int i) {
        rVar.flags_ = i;
        return i;
    }

    public static /* synthetic */ int i(r rVar, int i) {
        rVar.name_ = i;
        return i;
    }

    public static /* synthetic */ List j(r rVar) {
        return rVar.typeParameter_;
    }

    public static /* synthetic */ List k(r rVar, List list) {
        rVar.typeParameter_ = list;
        return list;
    }

    public static /* synthetic */ q l(r rVar, q qVar) {
        rVar.underlyingType_ = qVar;
        return qVar;
    }

    public static /* synthetic */ int m(r rVar, int i) {
        rVar.underlyingTypeId_ = i;
        return i;
    }

    public static /* synthetic */ q n(r rVar, q qVar) {
        rVar.expandedType_ = qVar;
        return qVar;
    }

    public static b newBuilder(r rVar) {
        return newBuilder().mergeFrom(rVar);
    }

    public static /* synthetic */ int o(r rVar, int i) {
        rVar.expandedTypeId_ = i;
        return i;
    }

    public static /* synthetic */ List p(r rVar) {
        return rVar.annotation_;
    }

    public static r parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (r) ((AbstractParser) k).m89parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static /* synthetic */ List q(r rVar, List list) {
        rVar.annotation_ = list;
        return list;
    }

    public static /* synthetic */ List r(r rVar) {
        return rVar.versionRequirement_;
    }

    public static /* synthetic */ List s(r rVar, List list) {
        rVar.versionRequirement_ = list;
        return list;
    }

    public static /* synthetic */ int t(r rVar, int i) {
        rVar.bitField0_ = i;
        return i;
    }

    public static /* synthetic */ ByteString3 u(r rVar) {
        return rVar.unknownFields;
    }

    public d0.e0.p.d.m0.f.b getAnnotation(int i) {
        return this.annotation_.get(i);
    }

    public int getAnnotationCount() {
        return this.annotation_.size();
    }

    public List<d0.e0.p.d.m0.f.b> getAnnotationList() {
        return this.annotation_;
    }

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public q getExpandedType() {
        return this.expandedType_;
    }

    public int getExpandedTypeId() {
        return this.expandedTypeId_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getName() {
        return this.name_;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(3, this.typeParameter_.get(i2));
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
        }
        for (int i3 = 0; i3 < this.annotation_.size(); i3++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(8, this.annotation_.get(i3));
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i4).intValue());
        }
        int size = this.unknownFields.size() + c() + (getVersionRequirementList().size() * 2) + iComputeInt32Size + iComputeInt32SizeNoTag;
        this.memoizedSerializedSize = size;
        return size;
    }

    public s getTypeParameter(int i) {
        return this.typeParameter_.get(i);
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public List<s> getTypeParameterList() {
        return this.typeParameter_;
    }

    public q getUnderlyingType() {
        return this.underlyingType_;
    }

    public int getUnderlyingTypeId() {
        return this.underlyingTypeId_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasExpandedType() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasExpandedTypeId() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasUnderlyingType() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasUnderlyingTypeId() {
        return (this.bitField0_ & 8) == 8;
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
        if (!hasName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getTypeParameterCount(); i++) {
            if (!getTypeParameter(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasExpandedType() && !getExpandedType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < getAnnotationCount(); i2++) {
            if (!getAnnotation(i2).isInitialized()) {
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

    @Override // d0.e0.p.d.m0.i.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.a toBuilder() {
        return toBuilder();
    }

    public final void v() {
        this.flags_ = 6;
        this.name_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.underlyingType_ = q.getDefaultInstance();
        this.underlyingTypeId_ = 0;
        this.expandedType_ = q.getDefaultInstance();
        this.expandedTypeId_ = 0;
        this.annotation_ = Collections.emptyList();
        this.versionRequirement_ = Collections.emptyList();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.d<MessageType>.a aVarE = e();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        for (int i = 0; i < this.typeParameter_.size(); i++) {
            codedOutputStream.writeMessage(3, this.typeParameter_.get(i));
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(7, this.expandedTypeId_);
        }
        for (int i2 = 0; i2 < this.annotation_.size(); i2++) {
            codedOutputStream.writeMessage(8, this.annotation_.get(i2));
        }
        for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i3).intValue());
        }
        aVarE.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
    public r getDefaultInstanceForType() {
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

    public r() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean] */
    public r(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
        q.c builder;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        v();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (true) {
            ?? F = 4;
            if (!z2) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        switch (tag) {
                            case 0:
                                z2 = true;
                            case 8:
                                this.bitField0_ |= 1;
                                this.flags_ = codedInputStream.readInt32();
                            case 16:
                                this.bitField0_ |= 2;
                                this.name_ = codedInputStream.readInt32();
                            case 26:
                                if ((i & 4) != 4) {
                                    this.typeParameter_ = new ArrayList();
                                    i |= 4;
                                }
                                this.typeParameter_.add(codedInputStream.readMessage(s.k, extensionRegistryLite));
                            case 34:
                                builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : null;
                                q qVar = (q) codedInputStream.readMessage(q.k, extensionRegistryLite);
                                this.underlyingType_ = qVar;
                                if (builder != null) {
                                    builder.mergeFrom(qVar);
                                    this.underlyingType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            case 40:
                                this.bitField0_ |= 8;
                                this.underlyingTypeId_ = codedInputStream.readInt32();
                            case 50:
                                builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : null;
                                q qVar2 = (q) codedInputStream.readMessage(q.k, extensionRegistryLite);
                                this.expandedType_ = qVar2;
                                if (builder != null) {
                                    builder.mergeFrom(qVar2);
                                    this.expandedType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 16;
                            case 56:
                                this.bitField0_ |= 32;
                                this.expandedTypeId_ = codedInputStream.readInt32();
                            case 66:
                                if ((i & 128) != 128) {
                                    this.annotation_ = new ArrayList();
                                    i |= 128;
                                }
                                this.annotation_.add(codedInputStream.readMessage(d0.e0.p.d.m0.f.b.k, extensionRegistryLite));
                            case 248:
                                if ((i & 256) != 256) {
                                    this.versionRequirement_ = new ArrayList();
                                    i |= 256;
                                }
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            case 250:
                                int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if ((i & 256) != 256 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.versionRequirement_ = new ArrayList();
                                    i |= 256;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(iPushLimit);
                                break;
                            default:
                                F = f(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag);
                                if (F == 0) {
                                    z2 = true;
                                }
                        }
                    } catch (Throwable th) {
                        if ((i & 4) == F) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if ((i & 128) == 128) {
                            this.annotation_ = Collections.unmodifiableList(this.annotation_);
                        }
                        if ((i & 256) == 256) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } else {
                if ((i & 4) == 4) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((i & 128) == 128) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                }
                if ((i & 256) == 256) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                return;
            }
        }
    }
}
