package com.discord.stores;

import kotlin.Metadata;

/* compiled from: StoreChannelsSelected.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/discord/stores/ChannelAnalyticsViewType;", "", "", "analyticsValue", "Ljava/lang/String;", "getAnalyticsValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "FULL_VIEW", "PEEK_VIEW", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.stores.ChannelAnalyticsViewType, reason: use source file name */
/* loaded from: classes2.dex */
public enum StoreChannelsSelected2 {
    FULL_VIEW("Full View"),
    PEEK_VIEW("Peek View");

    private final String analyticsValue;

    StoreChannelsSelected2(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
