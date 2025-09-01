package com.discord.utilities.mg_recycler;

import com.discord.utilities.recycler.DiffKeyProvider;
import kotlin.Metadata;

/* compiled from: MGRecyclerDataPayload.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/utilities/recycler/DiffKeyProvider;", "", "getType", "()I", "type", "", "getKey", "()Ljava/lang/String;", "key", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface MGRecyclerDataPayload extends DiffKeyProvider {
    @Override // com.discord.utilities.recycler.DiffKeyProvider
    String getKey();

    int getType();
}
