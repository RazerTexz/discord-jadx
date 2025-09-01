package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.api.application.Application;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelLibraryApplication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001'B/\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJB\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\rJ\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b \u0010\nR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\r¨\u0006("}, d2 = {"Lcom/discord/models/domain/ModelLibraryApplication;", "", "Lcom/discord/api/application/Application;", "component1", "()Lcom/discord/api/application/Application;", "", "component2", "()Ljava/lang/String;", "", "component3", "()J", "", "component4", "()I", "component5", "application", "createdAt", "skuId", "flags", "branchId", "copy", "(Lcom/discord/api/application/Application;Ljava/lang/String;JIJ)Lcom/discord/models/domain/ModelLibraryApplication;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getBranchId", "Lcom/discord/api/application/Application;", "getApplication", "getSkuId", "Ljava/lang/String;", "getCreatedAt", "I", "getFlags", "<init>", "(Lcom/discord/api/application/Application;Ljava/lang/String;JIJ)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelLibraryApplication {
    private final Application application;
    private final long branchId;
    private final String createdAt;
    private final int flags;
    private final long skuId;

    /* compiled from: ModelLibraryApplication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelLibraryApplication$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelLibraryApplication;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelLibraryApplication;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser implements Model.Parser<ModelLibraryApplication> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelLibraryApplication parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelLibraryApplication parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
            ref$ObjectRef4.element = null;
            reader.nextObject(new ModelLibraryApplication2(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3, ref$ObjectRef4));
            Application application = (Application) ref$ObjectRefC0.element;
            Intrinsics3.checkNotNull(application);
            String str = (String) ref$ObjectRef.element;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            Long l = (Long) ref$ObjectRef2.element;
            long jLongValue = l != null ? l.longValue() : 0L;
            Integer num = (Integer) ref$ObjectRef3.element;
            int iIntValue = num != null ? num.intValue() : 0;
            Long l2 = (Long) ref$ObjectRef4.element;
            return new ModelLibraryApplication(application, str2, jLongValue, iIntValue, l2 != null ? l2.longValue() : 0L);
        }
    }

    public ModelLibraryApplication(Application application, String str, long j, int i, long j2) {
        Intrinsics3.checkNotNullParameter(application, "application");
        Intrinsics3.checkNotNullParameter(str, "createdAt");
        this.application = application;
        this.createdAt = str;
        this.skuId = j;
        this.flags = i;
        this.branchId = j2;
    }

    public static /* synthetic */ ModelLibraryApplication copy$default(ModelLibraryApplication modelLibraryApplication, Application application, String str, long j, int i, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            application = modelLibraryApplication.application;
        }
        if ((i2 & 2) != 0) {
            str = modelLibraryApplication.createdAt;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            j = modelLibraryApplication.skuId;
        }
        long j3 = j;
        if ((i2 & 8) != 0) {
            i = modelLibraryApplication.flags;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            j2 = modelLibraryApplication.branchId;
        }
        return modelLibraryApplication.copy(application, str2, j3, i3, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSkuId() {
        return this.skuId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* renamed from: component5, reason: from getter */
    public final long getBranchId() {
        return this.branchId;
    }

    public final ModelLibraryApplication copy(Application application, String createdAt, long skuId, int flags, long branchId) {
        Intrinsics3.checkNotNullParameter(application, "application");
        Intrinsics3.checkNotNullParameter(createdAt, "createdAt");
        return new ModelLibraryApplication(application, createdAt, skuId, flags, branchId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelLibraryApplication)) {
            return false;
        }
        ModelLibraryApplication modelLibraryApplication = (ModelLibraryApplication) other;
        return Intrinsics3.areEqual(this.application, modelLibraryApplication.application) && Intrinsics3.areEqual(this.createdAt, modelLibraryApplication.createdAt) && this.skuId == modelLibraryApplication.skuId && this.flags == modelLibraryApplication.flags && this.branchId == modelLibraryApplication.branchId;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final long getBranchId() {
        return this.branchId;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public int hashCode() {
        Application application = this.application;
        int iHashCode = (application != null ? application.hashCode() : 0) * 31;
        String str = this.createdAt;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        long j = this.skuId;
        int i = (((iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31) + this.flags) * 31;
        long j2 = this.branchId;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelLibraryApplication(application=");
        sbU.append(this.application);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", branchId=");
        return outline.C(sbU, this.branchId, ")");
    }
}
