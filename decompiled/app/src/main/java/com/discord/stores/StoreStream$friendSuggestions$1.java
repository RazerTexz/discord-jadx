package com.discord.stores;

import com.discord.api.friendsuggestions.FriendSuggestion;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/api/friendsuggestions/FriendSuggestion;", "p1", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$friendSuggestions$1 extends FunctionReferenceImpl implements Function1<List<? extends FriendSuggestion>, Unit> {
    public StoreStream$friendSuggestions$1(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleFriendSuggestionsFetched", "handleFriendSuggestionsFetched(Ljava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends FriendSuggestion> list) {
        invoke2((List<FriendSuggestion>) list);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<FriendSuggestion> list) {
        Intrinsics3.checkNotNullParameter(list, "p1");
        StoreStream.access$handleFriendSuggestionsFetched((StoreStream) this.receiver, list);
    }
}
