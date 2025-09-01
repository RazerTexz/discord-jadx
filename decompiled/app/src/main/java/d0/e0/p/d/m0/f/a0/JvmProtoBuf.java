package d0.e0.p.d.m0.f.a0;

import d0.e0.p.d.m0.f.i;
import d0.e0.p.d.m0.f.l;
import d0.e0.p.d.m0.f.n;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.s;
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
import d0.e0.p.d.m0.i.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* compiled from: JvmProtoBuf.java */
/* renamed from: d0.e0.p.d.m0.f.a0.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmProtoBuf {
    public static final GeneratedMessageLite.f<d0.e0.p.d.m0.f.d, c> a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageLite.f<i, c> f3384b;
    public static final GeneratedMessageLite.f<i, Integer> c;
    public static final GeneratedMessageLite.f<n, d> d;
    public static final GeneratedMessageLite.f<n, Integer> e;
    public static final GeneratedMessageLite.f<q, List<d0.e0.p.d.m0.f.b>> f;
    public static final GeneratedMessageLite.f<q, Boolean> g;
    public static final GeneratedMessageLite.f<s, List<d0.e0.p.d.m0.f.b>> h;
    public static final GeneratedMessageLite.f<d0.e0.p.d.m0.f.c, Integer> i;
    public static final GeneratedMessageLite.f<d0.e0.p.d.m0.f.c, List<n>> j;
    public static final GeneratedMessageLite.f<d0.e0.p.d.m0.f.c, Integer> k;
    public static final GeneratedMessageLite.f<d0.e0.p.d.m0.f.c, Integer> l;
    public static final GeneratedMessageLite.f<l, Integer> m;
    public static final GeneratedMessageLite.f<l, List<n>> n;

    /* compiled from: JvmProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.a0.a$b */
    public static final class b extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static final b j;
        public static Parser2<b> k = new a();
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString3 unknownFields;

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$b$a */
        public static class a extends AbstractParser<b> {
            @Override // d0.e0.p.d.m0.i.Parser2
            public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return parsePartialFrom(codedInputStream, extensionRegistryLite);
            }

            @Override // d0.e0.p.d.m0.i.Parser2
            public b parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new b(codedInputStream, extensionRegistryLite, null);
            }
        }

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$b$b, reason: collision with other inner class name */
        public static final class C0391b extends GeneratedMessageLite.b<b, C0391b> implements MessageLiteOrBuilder {
            public int k;
            public int l;
            public int m;

            @Override // d0.e0.p.d.m0.i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public b buildPartial() {
                b bVar = new b(this, null);
                int i = this.k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                b.a(bVar, this.l);
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                b.b(bVar, this.m);
                b.c(bVar, i2);
                return bVar;
            }

            @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
            /* renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
            public /* bridge */ /* synthetic */ AbstractMessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public C0391b setDesc(int i) {
                this.k |= 2;
                this.m = i;
                return this;
            }

            public C0391b setName(int i) {
                this.k |= 1;
                this.l = i;
                return this;
            }

            @Override // d0.e0.p.d.m0.i.MessageLite.a
            public b build() {
                b bVarBuildPartial = buildPartial();
                if (bVarBuildPartial.isInitialized()) {
                    return bVarBuildPartial;
                }
                throw new UninitializedMessageException(bVarBuildPartial);
            }

            @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
                return clone();
            }

            @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
                return mergeFrom((b) generatedMessageLite);
            }

            @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
            public C0391b clone() {
                return new C0391b().mergeFrom(buildPartial());
            }

            @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public C0391b mergeFrom(b bVar) {
                if (bVar == b.getDefaultInstance()) {
                    return this;
                }
                if (bVar.hasName()) {
                    setName(bVar.getName());
                }
                if (bVar.hasDesc()) {
                    setDesc(bVar.getDesc());
                }
                setUnknownFields(getUnknownFields().concat(b.d(bVar)));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0391b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                b bVar = null;
                try {
                    try {
                        b partialFrom = b.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (partialFrom != null) {
                            mergeFrom(partialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        b bVar2 = (b) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            bVar = bVar2;
                            if (bVar != null) {
                                mergeFrom(bVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bVar != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            b bVar = new b();
            j = bVar;
            bVar.name_ = 0;
            bVar.desc_ = 0;
        }

        public b(GeneratedMessageLite.b bVar, a aVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        public static /* synthetic */ int a(b bVar, int i) {
            bVar.name_ = i;
            return i;
        }

        public static /* synthetic */ int b(b bVar, int i) {
            bVar.desc_ = i;
            return i;
        }

        public static /* synthetic */ int c(b bVar, int i) {
            bVar.bitField0_ = i;
            return i;
        }

        public static /* synthetic */ ByteString3 d(b bVar) {
            return bVar.unknownFields;
        }

        public static b getDefaultInstance() {
            return j;
        }

        public static C0391b newBuilder(b bVar) {
            return newBuilder().mergeFrom(bVar);
        }

        public int getDesc() {
            return this.desc_;
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
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.desc_);
            }
            int size = this.unknownFields.size() + iComputeInt32Size;
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
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
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.desc_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static C0391b newBuilder() {
            return new C0391b();
        }

        @Override // d0.e0.p.d.m0.i.MessageLite
        public C0391b newBuilderForType() {
            return newBuilder();
        }

        @Override // d0.e0.p.d.m0.i.MessageLite
        public C0391b toBuilder() {
            return newBuilder(this);
        }

        public b() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString3.j;
        }

        public b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            boolean z2 = false;
            this.name_ = 0;
            this.desc_ = 0;
            ByteString3.b bVarNewOutput = ByteString3.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            while (!z2) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = codedInputStream.readInt32();
                            } else if (tag != 16) {
                                if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = codedInputStream.readInt32();
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
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

    /* compiled from: JvmProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.a0.a$c */
    public static final class c extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static final c j;
        public static Parser2<c> k = new a();
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString3 unknownFields;

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$c$a */
        public static class a extends AbstractParser<c> {
            @Override // d0.e0.p.d.m0.i.Parser2
            public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return parsePartialFrom(codedInputStream, extensionRegistryLite);
            }

            @Override // d0.e0.p.d.m0.i.Parser2
            public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new c(codedInputStream, extensionRegistryLite, null);
            }
        }

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$c$b */
        public static final class b extends GeneratedMessageLite.b<c, b> implements MessageLiteOrBuilder {
            public int k;
            public int l;
            public int m;

            @Override // d0.e0.p.d.m0.i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public c buildPartial() {
                c cVar = new c(this, null);
                int i = this.k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                c.a(cVar, this.l);
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                c.b(cVar, this.m);
                c.c(cVar, i2);
                return cVar;
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

            public b setDesc(int i) {
                this.k |= 2;
                this.m = i;
                return this;
            }

            public b setName(int i) {
                this.k |= 1;
                this.l = i;
                return this;
            }

            @Override // d0.e0.p.d.m0.i.MessageLite.a
            public c build() {
                c cVarBuildPartial = buildPartial();
                if (cVarBuildPartial.isInitialized()) {
                    return cVarBuildPartial;
                }
                throw new UninitializedMessageException(cVarBuildPartial);
            }

            @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
                return clone();
            }

            @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
                return mergeFrom((c) generatedMessageLite);
            }

            @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
            public b clone() {
                return new b().mergeFrom(buildPartial());
            }

            @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public b mergeFrom(c cVar) {
                if (cVar == c.getDefaultInstance()) {
                    return this;
                }
                if (cVar.hasName()) {
                    setName(cVar.getName());
                }
                if (cVar.hasDesc()) {
                    setDesc(cVar.getDesc());
                }
                setUnknownFields(getUnknownFields().concat(c.d(cVar)));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                c cVar = null;
                try {
                    try {
                        c partialFrom = c.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (partialFrom != null) {
                            mergeFrom(partialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        c cVar2 = (c) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            cVar = cVar2;
                            if (cVar != null) {
                                mergeFrom(cVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cVar != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            c cVar = new c();
            j = cVar;
            cVar.name_ = 0;
            cVar.desc_ = 0;
        }

        public c(GeneratedMessageLite.b bVar, a aVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        public static /* synthetic */ int a(c cVar, int i) {
            cVar.name_ = i;
            return i;
        }

        public static /* synthetic */ int b(c cVar, int i) {
            cVar.desc_ = i;
            return i;
        }

        public static /* synthetic */ int c(c cVar, int i) {
            cVar.bitField0_ = i;
            return i;
        }

        public static /* synthetic */ ByteString3 d(c cVar) {
            return cVar.unknownFields;
        }

        public static c getDefaultInstance() {
            return j;
        }

        public static b newBuilder(c cVar) {
            return newBuilder().mergeFrom(cVar);
        }

        public int getDesc() {
            return this.desc_;
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
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.desc_);
            }
            int size = this.unknownFields.size() + iComputeInt32Size;
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
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
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.desc_);
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

        public c() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString3.j;
        }

        public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            boolean z2 = false;
            this.name_ = 0;
            this.desc_ = 0;
            ByteString3.b bVarNewOutput = ByteString3.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            while (!z2) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = codedInputStream.readInt32();
                            } else if (tag != 16) {
                                if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = codedInputStream.readInt32();
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
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

    /* compiled from: JvmProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.a0.a$d */
    public static final class d extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static final d j;
        public static Parser2<d> k = new a();
        private int bitField0_;
        private b field_;
        private c getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private c setter_;
        private c syntheticMethod_;
        private final ByteString3 unknownFields;

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$d$a */
        public static class a extends AbstractParser<d> {
            @Override // d0.e0.p.d.m0.i.Parser2
            public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return parsePartialFrom(codedInputStream, extensionRegistryLite);
            }

            @Override // d0.e0.p.d.m0.i.Parser2
            public d parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new d(codedInputStream, extensionRegistryLite, null);
            }
        }

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$d$b */
        public static final class b extends GeneratedMessageLite.b<d, b> implements MessageLiteOrBuilder {
            public int k;
            public b l = b.getDefaultInstance();
            public c m = c.getDefaultInstance();
            public c n = c.getDefaultInstance();
            public c o = c.getDefaultInstance();

            @Override // d0.e0.p.d.m0.i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public d buildPartial() {
                d dVar = new d(this, null);
                int i = this.k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                d.a(dVar, this.l);
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                d.b(dVar, this.m);
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                d.c(dVar, this.n);
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                d.d(dVar, this.o);
                d.e(dVar, i2);
                return dVar;
            }

            @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
            /* renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
                return clone();
            }

            public b mergeField(b bVar) {
                if ((this.k & 1) != 1 || this.l == b.getDefaultInstance()) {
                    this.l = bVar;
                } else {
                    this.l = b.newBuilder(this.l).mergeFrom(bVar).buildPartial();
                }
                this.k |= 1;
                return this;
            }

            @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
            public /* bridge */ /* synthetic */ AbstractMessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public b mergeGetter(c cVar) {
                if ((this.k & 4) != 4 || this.n == c.getDefaultInstance()) {
                    this.n = cVar;
                } else {
                    this.n = c.newBuilder(this.n).mergeFrom(cVar).buildPartial();
                }
                this.k |= 4;
                return this;
            }

            public b mergeSetter(c cVar) {
                if ((this.k & 8) != 8 || this.o == c.getDefaultInstance()) {
                    this.o = cVar;
                } else {
                    this.o = c.newBuilder(this.o).mergeFrom(cVar).buildPartial();
                }
                this.k |= 8;
                return this;
            }

            public b mergeSyntheticMethod(c cVar) {
                if ((this.k & 2) != 2 || this.m == c.getDefaultInstance()) {
                    this.m = cVar;
                } else {
                    this.m = c.newBuilder(this.m).mergeFrom(cVar).buildPartial();
                }
                this.k |= 2;
                return this;
            }

            @Override // d0.e0.p.d.m0.i.MessageLite.a
            public d build() {
                d dVarBuildPartial = buildPartial();
                if (dVarBuildPartial.isInitialized()) {
                    return dVarBuildPartial;
                }
                throw new UninitializedMessageException(dVarBuildPartial);
            }

            @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
                return clone();
            }

            @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
            public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
                return mergeFrom((d) generatedMessageLite);
            }

            @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
            public b clone() {
                return new b().mergeFrom(buildPartial());
            }

            @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
            public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public b mergeFrom(d dVar) {
                if (dVar == d.getDefaultInstance()) {
                    return this;
                }
                if (dVar.hasField()) {
                    mergeField(dVar.getField());
                }
                if (dVar.hasSyntheticMethod()) {
                    mergeSyntheticMethod(dVar.getSyntheticMethod());
                }
                if (dVar.hasGetter()) {
                    mergeGetter(dVar.getGetter());
                }
                if (dVar.hasSetter()) {
                    mergeSetter(dVar.getSetter());
                }
                setUnknownFields(getUnknownFields().concat(d.f(dVar)));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                d dVar = null;
                try {
                    try {
                        d partialFrom = d.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (partialFrom != null) {
                            mergeFrom(partialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        d dVar2 = (d) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            dVar = dVar2;
                            if (dVar != null) {
                                mergeFrom(dVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (dVar != null) {
                    }
                    throw th;
                }
            }
        }

        static {
            d dVar = new d();
            j = dVar;
            dVar.g();
        }

        public d(GeneratedMessageLite.b bVar, a aVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        public static /* synthetic */ b a(d dVar, b bVar) {
            dVar.field_ = bVar;
            return bVar;
        }

        public static /* synthetic */ c b(d dVar, c cVar) {
            dVar.syntheticMethod_ = cVar;
            return cVar;
        }

        public static /* synthetic */ c c(d dVar, c cVar) {
            dVar.getter_ = cVar;
            return cVar;
        }

        public static /* synthetic */ c d(d dVar, c cVar) {
            dVar.setter_ = cVar;
            return cVar;
        }

        public static /* synthetic */ int e(d dVar, int i) {
            dVar.bitField0_ = i;
            return i;
        }

        public static /* synthetic */ ByteString3 f(d dVar) {
            return dVar.unknownFields;
        }

        public static d getDefaultInstance() {
            return j;
        }

        public static b newBuilder(d dVar) {
            return newBuilder().mergeFrom(dVar);
        }

        public final void g() {
            this.field_ = b.getDefaultInstance();
            this.syntheticMethod_ = c.getDefaultInstance();
            this.getter_ = c.getDefaultInstance();
            this.setter_ = c.getDefaultInstance();
        }

        public b getField() {
            return this.field_;
        }

        public c getGetter() {
            return this.getter_;
        }

        @Override // d0.e0.p.d.m0.i.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeMessageSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.field_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(4, this.setter_);
            }
            int size = this.unknownFields.size() + iComputeMessageSize;
            this.memoizedSerializedSize = size;
            return size;
        }

        public c getSetter() {
            return this.setter_;
        }

        public c getSyntheticMethod() {
            return this.syntheticMethod_;
        }

        public boolean hasField() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasGetter() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasSetter() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasSyntheticMethod() {
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
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, this.setter_);
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

        public d() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString3.j;
        }

        public d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            g();
            ByteString3.b bVarNewOutput = ByteString3.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            boolean z2 = false;
            while (!z2) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                b.C0391b builder = (this.bitField0_ & 1) == 1 ? this.field_.toBuilder() : null;
                                b bVar = (b) codedInputStream.readMessage(b.k, extensionRegistryLite);
                                this.field_ = bVar;
                                if (builder != null) {
                                    builder.mergeFrom(bVar);
                                    this.field_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                            } else if (tag == 18) {
                                c.b builder2 = (this.bitField0_ & 2) == 2 ? this.syntheticMethod_.toBuilder() : null;
                                c cVar = (c) codedInputStream.readMessage(c.k, extensionRegistryLite);
                                this.syntheticMethod_ = cVar;
                                if (builder2 != null) {
                                    builder2.mergeFrom(cVar);
                                    this.syntheticMethod_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (tag == 26) {
                                c.b builder3 = (this.bitField0_ & 4) == 4 ? this.getter_.toBuilder() : null;
                                c cVar2 = (c) codedInputStream.readMessage(c.k, extensionRegistryLite);
                                this.getter_ = cVar2;
                                if (builder3 != null) {
                                    builder3.mergeFrom(cVar2);
                                    this.getter_ = builder3.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            } else if (tag != 34) {
                                if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                c.b builder4 = (this.bitField0_ & 8) == 8 ? this.setter_.toBuilder() : null;
                                c cVar3 = (c) codedInputStream.readMessage(c.k, extensionRegistryLite);
                                this.setter_ = cVar3;
                                if (builder4 != null) {
                                    builder4.mergeFrom(cVar3);
                                    this.setter_ = builder4.buildPartial();
                                }
                                this.bitField0_ |= 8;
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
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

    /* compiled from: JvmProtoBuf.java */
    /* renamed from: d0.e0.p.d.m0.f.a0.a$e */
    public static final class e extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static final e j;
        public static Parser2<e> k = new a();
        private int localNameMemoizedSerializedSize;
        private List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<c> record_;
        private final ByteString3 unknownFields;

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$e$a */
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

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$e$b */
        public static final class b extends GeneratedMessageLite.b<e, b> implements MessageLiteOrBuilder {
            public int k;
            public List<c> l = Collections.emptyList();
            public List<Integer> m = Collections.emptyList();

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
                if ((this.k & 2) == 2) {
                    this.m = Collections.unmodifiableList(this.m);
                    this.k &= -3;
                }
                e.d(eVar, this.m);
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
                if (!e.c(eVar).isEmpty()) {
                    if (this.m.isEmpty()) {
                        this.m = e.c(eVar);
                        this.k &= -3;
                    } else {
                        if ((this.k & 2) != 2) {
                            this.m = new ArrayList(this.m);
                            this.k |= 2;
                        }
                        this.m.addAll(e.c(eVar));
                    }
                }
                setUnknownFields(getUnknownFields().concat(e.e(eVar)));
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

        /* compiled from: JvmProtoBuf.java */
        /* renamed from: d0.e0.p.d.m0.f.a0.a$e$c */
        public static final class c extends GeneratedMessageLite implements MessageLiteOrBuilder {
            public static final c j;
            public static Parser2<c> k = new a();
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private EnumC0392c operation_;
            private int predefinedIndex_;
            private int range_;
            private int replaceCharMemoizedSerializedSize;
            private List<Integer> replaceChar_;
            private Object string_;
            private int substringIndexMemoizedSerializedSize;
            private List<Integer> substringIndex_;
            private final ByteString3 unknownFields;

            /* compiled from: JvmProtoBuf.java */
            /* renamed from: d0.e0.p.d.m0.f.a0.a$e$c$a */
            public static class a extends AbstractParser<c> {
                @Override // d0.e0.p.d.m0.i.Parser2
                public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return parsePartialFrom(codedInputStream, extensionRegistryLite);
                }

                @Override // d0.e0.p.d.m0.i.Parser2
                public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new c(codedInputStream, extensionRegistryLite, null);
                }
            }

            /* compiled from: JvmProtoBuf.java */
            /* renamed from: d0.e0.p.d.m0.f.a0.a$e$c$b */
            public static final class b extends GeneratedMessageLite.b<c, b> implements MessageLiteOrBuilder {
                public int k;
                public int m;
                public int l = 1;
                public Object n = "";
                public EnumC0392c o = EnumC0392c.NONE;
                public List<Integer> p = Collections.emptyList();
                public List<Integer> q = Collections.emptyList();

                @Override // d0.e0.p.d.m0.i.MessageLite.a
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                public c buildPartial() {
                    c cVar = new c(this, null);
                    int i = this.k;
                    int i2 = (i & 1) != 1 ? 0 : 1;
                    c.c(cVar, this.l);
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    c.d(cVar, this.m);
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    c.f(cVar, this.n);
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    c.g(cVar, this.o);
                    if ((this.k & 16) == 16) {
                        this.p = Collections.unmodifiableList(this.p);
                        this.k &= -17;
                    }
                    c.i(cVar, this.p);
                    if ((this.k & 32) == 32) {
                        this.q = Collections.unmodifiableList(this.q);
                        this.k &= -33;
                    }
                    c.k(cVar, this.q);
                    c.a(cVar, i2);
                    return cVar;
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

                public b setOperation(EnumC0392c enumC0392c) {
                    Objects.requireNonNull(enumC0392c);
                    this.k |= 8;
                    this.o = enumC0392c;
                    return this;
                }

                public b setPredefinedIndex(int i) {
                    this.k |= 2;
                    this.m = i;
                    return this;
                }

                public b setRange(int i) {
                    this.k |= 1;
                    this.l = i;
                    return this;
                }

                @Override // d0.e0.p.d.m0.i.MessageLite.a
                public c build() {
                    c cVarBuildPartial = buildPartial();
                    if (cVarBuildPartial.isInitialized()) {
                        return cVarBuildPartial;
                    }
                    throw new UninitializedMessageException(cVarBuildPartial);
                }

                @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
                public /* bridge */ /* synthetic */ GeneratedMessageLite.b clone() {
                    return clone();
                }

                @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
                public /* bridge */ /* synthetic */ GeneratedMessageLite.b mergeFrom(GeneratedMessageLite generatedMessageLite) {
                    return mergeFrom((c) generatedMessageLite);
                }

                @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
                public b clone() {
                    return new b().mergeFrom(buildPartial());
                }

                @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
                public /* bridge */ /* synthetic */ MessageLite.a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return mergeFrom(codedInputStream, extensionRegistryLite);
                }

                public b mergeFrom(c cVar) {
                    if (cVar == c.getDefaultInstance()) {
                        return this;
                    }
                    if (cVar.hasRange()) {
                        setRange(cVar.getRange());
                    }
                    if (cVar.hasPredefinedIndex()) {
                        setPredefinedIndex(cVar.getPredefinedIndex());
                    }
                    if (cVar.hasString()) {
                        this.k |= 4;
                        this.n = c.e(cVar);
                    }
                    if (cVar.hasOperation()) {
                        setOperation(cVar.getOperation());
                    }
                    if (!c.h(cVar).isEmpty()) {
                        if (this.p.isEmpty()) {
                            this.p = c.h(cVar);
                            this.k &= -17;
                        } else {
                            if ((this.k & 16) != 16) {
                                this.p = new ArrayList(this.p);
                                this.k |= 16;
                            }
                            this.p.addAll(c.h(cVar));
                        }
                    }
                    if (!c.j(cVar).isEmpty()) {
                        if (this.q.isEmpty()) {
                            this.q = c.j(cVar);
                            this.k &= -33;
                        } else {
                            if ((this.k & 32) != 32) {
                                this.q = new ArrayList(this.q);
                                this.k |= 32;
                            }
                            this.q.addAll(c.j(cVar));
                        }
                    }
                    setUnknownFields(getUnknownFields().concat(c.b(cVar)));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                    c cVar = null;
                    try {
                        try {
                            c partialFrom = c.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (partialFrom != null) {
                                mergeFrom(partialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            c cVar2 = (c) e.getUnfinishedMessage();
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                cVar = cVar2;
                                if (cVar != null) {
                                    mergeFrom(cVar);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cVar != null) {
                        }
                        throw th;
                    }
                }
            }

            /* compiled from: JvmProtoBuf.java */
            /* renamed from: d0.e0.p.d.m0.f.a0.a$e$c$c, reason: collision with other inner class name */
            public enum EnumC0392c implements Internal.a {
                NONE(0),
                INTERNAL_TO_CLASS_ID(1),
                DESC_TO_CLASS_ID(2);

                private final int value;

                EnumC0392c(int i) {
                    this.value = i;
                }

                @Override // d0.e0.p.d.m0.i.Internal.a
                public final int getNumber() {
                    return this.value;
                }

                public static EnumC0392c valueOf(int i) {
                    if (i == 0) {
                        return NONE;
                    }
                    if (i == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }
            }

            static {
                c cVar = new c();
                j = cVar;
                cVar.l();
            }

            public c(GeneratedMessageLite.b bVar, a aVar) {
                super(bVar);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.getUnknownFields();
            }

            public static /* synthetic */ int a(c cVar, int i) {
                cVar.bitField0_ = i;
                return i;
            }

            public static /* synthetic */ ByteString3 b(c cVar) {
                return cVar.unknownFields;
            }

            public static /* synthetic */ int c(c cVar, int i) {
                cVar.range_ = i;
                return i;
            }

            public static /* synthetic */ int d(c cVar, int i) {
                cVar.predefinedIndex_ = i;
                return i;
            }

            public static /* synthetic */ Object e(c cVar) {
                return cVar.string_;
            }

            public static /* synthetic */ Object f(c cVar, Object obj) {
                cVar.string_ = obj;
                return obj;
            }

            public static /* synthetic */ EnumC0392c g(c cVar, EnumC0392c enumC0392c) {
                cVar.operation_ = enumC0392c;
                return enumC0392c;
            }

            public static c getDefaultInstance() {
                return j;
            }

            public static /* synthetic */ List h(c cVar) {
                return cVar.substringIndex_;
            }

            public static /* synthetic */ List i(c cVar, List list) {
                cVar.substringIndex_ = list;
                return list;
            }

            public static /* synthetic */ List j(c cVar) {
                return cVar.replaceChar_;
            }

            public static /* synthetic */ List k(c cVar, List list) {
                cVar.replaceChar_ = list;
                return list;
            }

            public static b newBuilder(c cVar) {
                return newBuilder().mergeFrom(cVar);
            }

            public EnumC0392c getOperation() {
                return this.operation_;
            }

            public int getPredefinedIndex() {
                return this.predefinedIndex_;
            }

            public int getRange() {
                return this.range_;
            }

            public int getReplaceCharCount() {
                return this.replaceChar_.size();
            }

            public List<Integer> getReplaceCharList() {
                return this.replaceChar_;
            }

            @Override // d0.e0.p.d.m0.i.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.range_) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    iComputeInt32Size += CodedOutputStream.computeEnumSize(3, this.operation_.getNumber());
                }
                int iComputeInt32SizeNoTag = 0;
                for (int i2 = 0; i2 < this.substringIndex_.size(); i2++) {
                    iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.substringIndex_.get(i2).intValue());
                }
                int iComputeInt32SizeNoTag2 = iComputeInt32Size + iComputeInt32SizeNoTag;
                if (!getSubstringIndexList().isEmpty()) {
                    iComputeInt32SizeNoTag2 = iComputeInt32SizeNoTag2 + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
                }
                this.substringIndexMemoizedSerializedSize = iComputeInt32SizeNoTag;
                int iComputeInt32SizeNoTag3 = 0;
                for (int i3 = 0; i3 < this.replaceChar_.size(); i3++) {
                    iComputeInt32SizeNoTag3 += CodedOutputStream.computeInt32SizeNoTag(this.replaceChar_.get(i3).intValue());
                }
                int iComputeBytesSize = iComputeInt32SizeNoTag2 + iComputeInt32SizeNoTag3;
                if (!getReplaceCharList().isEmpty()) {
                    iComputeBytesSize = iComputeBytesSize + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag3);
                }
                this.replaceCharMemoizedSerializedSize = iComputeInt32SizeNoTag3;
                if ((this.bitField0_ & 4) == 4) {
                    iComputeBytesSize += CodedOutputStream.computeBytesSize(6, getStringBytes());
                }
                int size = this.unknownFields.size() + iComputeBytesSize;
                this.memoizedSerializedSize = size;
                return size;
            }

            public String getString() {
                Object obj = this.string_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString3 byteString3 = (ByteString3) obj;
                String stringUtf8 = byteString3.toStringUtf8();
                if (byteString3.isValidUtf8()) {
                    this.string_ = stringUtf8;
                }
                return stringUtf8;
            }

            public ByteString3 getStringBytes() {
                Object obj = this.string_;
                if (!(obj instanceof String)) {
                    return (ByteString3) obj;
                }
                ByteString3 byteString3CopyFromUtf8 = ByteString3.copyFromUtf8((String) obj);
                this.string_ = byteString3CopyFromUtf8;
                return byteString3CopyFromUtf8;
            }

            public int getSubstringIndexCount() {
                return this.substringIndex_.size();
            }

            public List<Integer> getSubstringIndexList() {
                return this.substringIndex_;
            }

            public boolean hasOperation() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean hasPredefinedIndex() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasRange() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasString() {
                return (this.bitField0_ & 4) == 4;
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

            public final void l() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = EnumC0392c.NONE;
                this.substringIndex_ = Collections.emptyList();
                this.replaceChar_ = Collections.emptyList();
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
                    codedOutputStream.writeInt32(1, this.range_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.writeEnum(3, this.operation_.getNumber());
                }
                if (getSubstringIndexList().size() > 0) {
                    codedOutputStream.writeRawVarint32(34);
                    codedOutputStream.writeRawVarint32(this.substringIndexMemoizedSerializedSize);
                }
                for (int i = 0; i < this.substringIndex_.size(); i++) {
                    codedOutputStream.writeInt32NoTag(this.substringIndex_.get(i).intValue());
                }
                if (getReplaceCharList().size() > 0) {
                    codedOutputStream.writeRawVarint32(42);
                    codedOutputStream.writeRawVarint32(this.replaceCharMemoizedSerializedSize);
                }
                for (int i2 = 0; i2 < this.replaceChar_.size(); i2++) {
                    codedOutputStream.writeInt32NoTag(this.replaceChar_.get(i2).intValue());
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeBytes(6, getStringBytes());
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

            public c() {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString3.j;
            }

            public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
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
                                    this.range_ = codedInputStream.readInt32();
                                } else if (tag == 16) {
                                    this.bitField0_ |= 2;
                                    this.predefinedIndex_ = codedInputStream.readInt32();
                                } else if (tag == 24) {
                                    int i2 = codedInputStream.readEnum();
                                    EnumC0392c enumC0392cValueOf = EnumC0392c.valueOf(i2);
                                    if (enumC0392cValueOf == null) {
                                        codedOutputStreamNewInstance.writeRawVarint32(tag);
                                        codedOutputStreamNewInstance.writeRawVarint32(i2);
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.operation_ = enumC0392cValueOf;
                                    }
                                } else if (tag == 32) {
                                    if ((i & 16) != 16) {
                                        this.substringIndex_ = new ArrayList();
                                        i |= 16;
                                    }
                                    this.substringIndex_.add(Integer.valueOf(codedInputStream.readInt32()));
                                } else if (tag == 34) {
                                    int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if ((i & 16) != 16 && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.substringIndex_ = new ArrayList();
                                        i |= 16;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.substringIndex_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(iPushLimit);
                                } else if (tag == 40) {
                                    if ((i & 32) != 32) {
                                        this.replaceChar_ = new ArrayList();
                                        i |= 32;
                                    }
                                    this.replaceChar_.add(Integer.valueOf(codedInputStream.readInt32()));
                                } else if (tag == 42) {
                                    int iPushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if ((i & 32) != 32 && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.replaceChar_ = new ArrayList();
                                        i |= 32;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.replaceChar_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    }
                                    codedInputStream.popLimit(iPushLimit2);
                                } else if (tag != 50) {
                                    if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                    }
                                } else {
                                    ByteString3 bytes = codedInputStream.readBytes();
                                    this.bitField0_ |= 4;
                                    this.string_ = bytes;
                                }
                            }
                            z2 = true;
                        } catch (Throwable th) {
                            if ((i & 16) == 16) {
                                this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                            }
                            if ((i & 32) == 32) {
                                this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                }
                if ((i & 16) == 16) {
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                }
                if ((i & 32) == 32) {
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
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

        static {
            e eVar = new e();
            j = eVar;
            eVar.record_ = Collections.emptyList();
            eVar.localName_ = Collections.emptyList();
        }

        public e(GeneratedMessageLite.b bVar, a aVar) {
            super(bVar);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        public static /* synthetic */ List a(e eVar) {
            return eVar.record_;
        }

        public static /* synthetic */ List b(e eVar, List list) {
            eVar.record_ = list;
            return list;
        }

        public static /* synthetic */ List c(e eVar) {
            return eVar.localName_;
        }

        public static /* synthetic */ List d(e eVar, List list) {
            eVar.localName_ = list;
            return list;
        }

        public static /* synthetic */ ByteString3 e(e eVar) {
            return eVar.unknownFields;
        }

        public static e getDefaultInstance() {
            return j;
        }

        public static b newBuilder(e eVar) {
            return newBuilder().mergeFrom(eVar);
        }

        public static e parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (e) ((AbstractParser) k).m89parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public List<Integer> getLocalNameList() {
            return this.localName_;
        }

        public List<c> getRecordList() {
            return this.record_;
        }

        @Override // d0.e0.p.d.m0.i.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeMessageSize = 0;
            for (int i2 = 0; i2 < this.record_.size(); i2++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.record_.get(i2));
            }
            int iComputeInt32SizeNoTag = 0;
            for (int i3 = 0; i3 < this.localName_.size(); i3++) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.localName_.get(i3).intValue());
            }
            int iComputeInt32SizeNoTag2 = iComputeMessageSize + iComputeInt32SizeNoTag;
            if (!getLocalNameList().isEmpty()) {
                iComputeInt32SizeNoTag2 = iComputeInt32SizeNoTag2 + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
            }
            this.localNameMemoizedSerializedSize = iComputeInt32SizeNoTag;
            int size = this.unknownFields.size() + iComputeInt32SizeNoTag2;
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
            for (int i = 0; i < this.record_.size(); i++) {
                codedOutputStream.writeMessage(1, this.record_.get(i));
            }
            if (getLocalNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(42);
                codedOutputStream.writeRawVarint32(this.localNameMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.localName_.size(); i2++) {
                codedOutputStream.writeInt32NoTag(this.localName_.get(i2).intValue());
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
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString3.j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
            ByteString3.b bVarNewOutput = ByteString3.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            boolean z2 = false;
            int i = 0;
            while (!z2) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                if ((i & 1) != 1) {
                                    this.record_ = new ArrayList();
                                    i |= 1;
                                }
                                this.record_.add(codedInputStream.readMessage(c.k, extensionRegistryLite));
                            } else if (tag == 40) {
                                if ((i & 2) != 2) {
                                    this.localName_ = new ArrayList();
                                    i |= 2;
                                }
                                this.localName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            } else if (tag != 42) {
                                if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if ((i & 2) != 2 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localName_ = new ArrayList();
                                    i |= 2;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.localName_.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(iPushLimit);
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if ((i & 1) == 1) {
                        this.record_ = Collections.unmodifiableList(this.record_);
                    }
                    if ((i & 2) == 2) {
                        this.localName_ = Collections.unmodifiableList(this.localName_);
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
            if ((i & 1) == 1) {
                this.record_ = Collections.unmodifiableList(this.record_);
            }
            if ((i & 2) == 2) {
                this.localName_ = Collections.unmodifiableList(this.localName_);
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

    static {
        d0.e0.p.d.m0.f.d defaultInstance = d0.e0.p.d.m0.f.d.getDefaultInstance();
        c defaultInstance2 = c.getDefaultInstance();
        c defaultInstance3 = c.getDefaultInstance();
        WireFormat.b bVar = WireFormat.b.t;
        a = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance, defaultInstance2, defaultInstance3, null, 100, bVar, c.class);
        f3384b = GeneratedMessageLite.newSingularGeneratedExtension(i.getDefaultInstance(), c.getDefaultInstance(), c.getDefaultInstance(), null, 100, bVar, c.class);
        i defaultInstance4 = i.getDefaultInstance();
        WireFormat.b bVar2 = WireFormat.b.n;
        c = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance4, 0, null, null, 101, bVar2, Integer.class);
        d = GeneratedMessageLite.newSingularGeneratedExtension(n.getDefaultInstance(), d.getDefaultInstance(), d.getDefaultInstance(), null, 100, bVar, d.class);
        e = GeneratedMessageLite.newSingularGeneratedExtension(n.getDefaultInstance(), 0, null, null, 101, bVar2, Integer.class);
        f = GeneratedMessageLite.newRepeatedGeneratedExtension(q.getDefaultInstance(), d0.e0.p.d.m0.f.b.getDefaultInstance(), null, 100, bVar, false, d0.e0.p.d.m0.f.b.class);
        g = GeneratedMessageLite.newSingularGeneratedExtension(q.getDefaultInstance(), Boolean.FALSE, null, null, 101, WireFormat.b.q, Boolean.class);
        h = GeneratedMessageLite.newRepeatedGeneratedExtension(s.getDefaultInstance(), d0.e0.p.d.m0.f.b.getDefaultInstance(), null, 100, bVar, false, d0.e0.p.d.m0.f.b.class);
        i = GeneratedMessageLite.newSingularGeneratedExtension(d0.e0.p.d.m0.f.c.getDefaultInstance(), 0, null, null, 101, bVar2, Integer.class);
        j = GeneratedMessageLite.newRepeatedGeneratedExtension(d0.e0.p.d.m0.f.c.getDefaultInstance(), n.getDefaultInstance(), null, 102, bVar, false, n.class);
        k = GeneratedMessageLite.newSingularGeneratedExtension(d0.e0.p.d.m0.f.c.getDefaultInstance(), 0, null, null, 103, bVar2, Integer.class);
        l = GeneratedMessageLite.newSingularGeneratedExtension(d0.e0.p.d.m0.f.c.getDefaultInstance(), 0, null, null, 104, bVar2, Integer.class);
        m = GeneratedMessageLite.newSingularGeneratedExtension(l.getDefaultInstance(), 0, null, null, 101, bVar2, Integer.class);
        n = GeneratedMessageLite.newRepeatedGeneratedExtension(l.getDefaultInstance(), n.getDefaultInstance(), null, 102, bVar, false, n.class);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add(a);
        extensionRegistryLite.add(f3384b);
        extensionRegistryLite.add(c);
        extensionRegistryLite.add(d);
        extensionRegistryLite.add(e);
        extensionRegistryLite.add(f);
        extensionRegistryLite.add(g);
        extensionRegistryLite.add(h);
        extensionRegistryLite.add(i);
        extensionRegistryLite.add(j);
        extensionRegistryLite.add(k);
        extensionRegistryLite.add(l);
        extensionRegistryLite.add(m);
        extensionRegistryLite.add(n);
    }
}
