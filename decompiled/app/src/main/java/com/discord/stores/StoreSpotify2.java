package com.discord.stores;

import com.discord.models.domain.spotify.ModelSpotifyArtist;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreSpotify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/spotify/ModelSpotifyArtist;", "it", "", "invoke", "(Lcom/discord/models/domain/spotify/ModelSpotifyArtist;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreSpotify$publishState$activity$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreSpotify2 extends Lambda implements Function1<ModelSpotifyArtist, CharSequence> {
    public static final StoreSpotify2 INSTANCE = new StoreSpotify2();

    public StoreSpotify2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(ModelSpotifyArtist modelSpotifyArtist) {
        return invoke2(modelSpotifyArtist);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(ModelSpotifyArtist modelSpotifyArtist) {
        Intrinsics3.checkNotNullParameter(modelSpotifyArtist, "it");
        return modelSpotifyArtist.getName();
    }
}
