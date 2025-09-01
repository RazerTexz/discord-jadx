package com.discord.widgets.servers.guild_role_subscription.model;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: PayoutStatusMedia.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0006\u001a\u00020\u00022\b\b\u0003\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/model/PayoutStatusMedia;", "", "", "component1", "()I", "component2", "iconDrawableRes", "statusStringRes", "copy", "(II)Lcom/discord/widgets/servers/guild_role_subscription/model/PayoutStatusMedia;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getStatusStringRes", "getIconDrawableRes", "<init>", "(II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class PayoutStatusMedia {
    private final int iconDrawableRes;
    private final int statusStringRes;

    public PayoutStatusMedia(@DrawableRes int i, @StringRes int i2) {
        this.iconDrawableRes = i;
        this.statusStringRes = i2;
    }

    public static /* synthetic */ PayoutStatusMedia copy$default(PayoutStatusMedia payoutStatusMedia, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = payoutStatusMedia.iconDrawableRes;
        }
        if ((i3 & 2) != 0) {
            i2 = payoutStatusMedia.statusStringRes;
        }
        return payoutStatusMedia.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getIconDrawableRes() {
        return this.iconDrawableRes;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStatusStringRes() {
        return this.statusStringRes;
    }

    public final PayoutStatusMedia copy(@DrawableRes int iconDrawableRes, @StringRes int statusStringRes) {
        return new PayoutStatusMedia(iconDrawableRes, statusStringRes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayoutStatusMedia)) {
            return false;
        }
        PayoutStatusMedia payoutStatusMedia = (PayoutStatusMedia) other;
        return this.iconDrawableRes == payoutStatusMedia.iconDrawableRes && this.statusStringRes == payoutStatusMedia.statusStringRes;
    }

    public final int getIconDrawableRes() {
        return this.iconDrawableRes;
    }

    public final int getStatusStringRes() {
        return this.statusStringRes;
    }

    public int hashCode() {
        return (this.iconDrawableRes * 31) + this.statusStringRes;
    }

    public String toString() {
        StringBuilder sbU = outline.U("PayoutStatusMedia(iconDrawableRes=");
        sbU.append(this.iconDrawableRes);
        sbU.append(", statusStringRes=");
        return outline.B(sbU, this.statusStringRes, ")");
    }
}
