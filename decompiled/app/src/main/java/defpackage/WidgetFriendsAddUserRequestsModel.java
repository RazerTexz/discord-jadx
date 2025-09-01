package defpackage;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: WidgetFriendsAddUserRequestsModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f\u0012\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR#\u0010\u0013\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0016\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0019"}, d2 = {"LWidgetFriendsAddUserRequestsModel;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "", "Lcom/discord/primitives/UserId;", "b", "Ljava/util/Set;", "getIncomingIds", "()Ljava/util/Set;", "incomingIds", "a", "getOutgoingIds", "outgoingIds", "<init>", "(Ljava/util/Set;Ljava/util/Set;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class WidgetFriendsAddUserRequestsModel {

    /* renamed from: a, reason: from kotlin metadata */
    public final Set<Long> outgoingIds;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Set<Long> incomingIds;

    public WidgetFriendsAddUserRequestsModel(Set<Long> set, Set<Long> set2) {
        Intrinsics3.checkNotNullParameter(set, "outgoingIds");
        Intrinsics3.checkNotNullParameter(set2, "incomingIds");
        this.outgoingIds = set;
        this.incomingIds = set2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetFriendsAddUserRequestsModel)) {
            return false;
        }
        WidgetFriendsAddUserRequestsModel widgetFriendsAddUserRequestsModel = (WidgetFriendsAddUserRequestsModel) other;
        return Intrinsics3.areEqual(this.outgoingIds, widgetFriendsAddUserRequestsModel.outgoingIds) && Intrinsics3.areEqual(this.incomingIds, widgetFriendsAddUserRequestsModel.incomingIds);
    }

    public int hashCode() {
        Set<Long> set = this.outgoingIds;
        int iHashCode = (set != null ? set.hashCode() : 0) * 31;
        Set<Long> set2 = this.incomingIds;
        return iHashCode + (set2 != null ? set2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetFriendsAddUserRequestsModel(outgoingIds=");
        sbU.append(this.outgoingIds);
        sbU.append(", incomingIds=");
        return outline.N(sbU, this.incomingIds, ")");
    }
}
