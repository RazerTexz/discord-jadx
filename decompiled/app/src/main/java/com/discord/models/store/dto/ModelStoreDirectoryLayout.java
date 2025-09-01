package com.discord.models.store.dto;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ModelStoreDirectoryLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u0012\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ2\u0010\f\u001a\u00020\u00002\f\b\u0002\u0010\n\u001a\u00060\u0002j\u0002`\u00032\u0012\b\u0002\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R#\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005¨\u0006\u001e"}, d2 = {"Lcom/discord/models/store/dto/ModelStoreDirectoryLayout;", "", "", "Lcom/discord/primitives/DirectoryLayoutId;", "component1", "()J", "", "Lcom/discord/primitives/SkuId;", "component2", "()Ljava/util/List;", ModelAuditLogEntry.CHANGE_KEY_ID, "allSkus", "copy", "(JLjava/util/List;)Lcom/discord/models/store/dto/ModelStoreDirectoryLayout;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAllSkus", "J", "getId", "<init>", "(JLjava/util/List;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelStoreDirectoryLayout {
    private final List<Long> allSkus;
    private final long id;

    public ModelStoreDirectoryLayout(long j, List<Long> list) {
        Intrinsics3.checkNotNullParameter(list, "allSkus");
        this.id = j;
        this.allSkus = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelStoreDirectoryLayout copy$default(ModelStoreDirectoryLayout modelStoreDirectoryLayout, long j, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelStoreDirectoryLayout.id;
        }
        if ((i & 2) != 0) {
            list = modelStoreDirectoryLayout.allSkus;
        }
        return modelStoreDirectoryLayout.copy(j, list);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<Long> component2() {
        return this.allSkus;
    }

    public final ModelStoreDirectoryLayout copy(long id2, List<Long> allSkus) {
        Intrinsics3.checkNotNullParameter(allSkus, "allSkus");
        return new ModelStoreDirectoryLayout(id2, allSkus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStoreDirectoryLayout)) {
            return false;
        }
        ModelStoreDirectoryLayout modelStoreDirectoryLayout = (ModelStoreDirectoryLayout) other;
        return this.id == modelStoreDirectoryLayout.id && Intrinsics3.areEqual(this.allSkus, modelStoreDirectoryLayout.allSkus);
    }

    public final List<Long> getAllSkus() {
        return this.allSkus;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<Long> list = this.allSkus;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelStoreDirectoryLayout(id=");
        sbU.append(this.id);
        sbU.append(", allSkus=");
        return outline.L(sbU, this.allSkus, ")");
    }
}
